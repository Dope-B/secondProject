package Creature;

import Enemy.Ene_Creature;
import Entities.Entity;
import basic_one.Handler;
import tiles.Tile;

public abstract class Creature extends Entity {
	
	protected int H_timer=0;
	protected int A_timer=0;//스킬 쿨타임
	protected int A2_timer=0;
	protected int S_timer=0;
	protected int S2_timer=0;
	protected int S3_timer=0;
	protected boolean A_cooldown=false;//스킬 쿨타임 실행 여부
	protected boolean A2_cooldown=false;
	protected boolean S_cooldown=false;
	protected boolean S2_cooldown=false;
	protected boolean S3_cooldown=false;
	public boolean isHurt=false;//피격 여부
	private boolean invincibility=false;//무적 여부
	public static final int DEFAULT_HEALTH=600;//기본 체력
	public static final double DEFAULT_SPEED=1.8;//기본 속도
	protected boolean collisionWithTile(int x,int y) {//타일과 충돌 여부
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public Creature(Handler handler,float x, float y,int width,int height) {
		super(handler,x, y,width,height);
		health=DEFAULT_HEALTH;
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		isplayer=true;
	}
	
	public void jump() {
		if(isJump) {//점프 함수
			r_Y=y+(height/2);//실제 y값
			deltaJ= -Math.pow(powerJ-7,2)+60;//이차함수 사용
			v_Y=r_Y+deltaJ;//출력용 y값
			powerJ+=0.32;//deltaJ의 독립변수
			if(v_Y<=r_Y) {r_Y=y;powerJ=0;deltaJ=0;isJump=false;}//땅에 닿을 시	
		}
	}
	
	public boolean isInvincibility() {
		return invincibility;
	}

	public void setInvincibility(boolean invincibility) {
		this.invincibility = invincibility;
	}

	
	protected void checkEne(int damage) {//적이 미 피격시 충돌판정 확인
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(!e.Damaged) {colli_HB(e,damage);}
		}
	}
	protected void checkEne_m(int damage) {//적이 미 피격시 이펙트와 충돌판정 확인
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(!e.Damaged) {colli_HB_M(e,damage);}
		}
	}
	protected void check_eD(){//적 피격 판정 false
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			e.Damaged=false;
		}
	}
	
	protected abstract void checkHitbox(); //추상 함수
	protected void colli_HB(Ene_Creature e, int damage) {//적과 히트박스 피격 판정
			if ((x+hitBox.x>e.getX()+e.bounds.x+e.bounds.width||x+hitBox.x+hitBox.width<e.getX()+e.bounds.x)||
					(y+hitBox.y>e.getY()+e.bounds.y+e.bounds.height||y+hitBox.y+hitBox.height<e.getY()+e.bounds.y)) {
				e.isDamaged=false;e.Damaged=false;}
			else {e.isDamaged=true;e.Damaged=true;e.hurt(damage);e.damage_sound=true;e.damage_effect=true;}	
	}	
	protected void colli_HB_M(Ene_Creature e, int damage) {//적과 이펙트 피격판정(이펙트는 플레이어의 좌표와 무관 하기때문에 따로 함수를 만듦)
		if ((hitBox.x>e.getX()+e.bounds.x+e.bounds.width||hitBox.x+hitBox.width<e.getX()+e.bounds.x)||
				(hitBox.y>e.getY()+e.bounds.y+e.bounds.height||hitBox.y+hitBox.height<e.getY()+e.bounds.y)) {
			e.isDamaged=false;e.Damaged=false;}
		else {e.isDamaged=true;e.Damaged=true;e.hurt(damage);e.damage_sound=true;e.damage_effect=true;}	
	}
	protected void hurtDelay() {//피격 딜레이
		if(isHurt) {
		H_timer++;
		if(H_timer>=30) {isHurt=false;H_timer=0;}
		else {isHurt=true;}}
	}

	public void moveX() {//움직임
		if(xMove>0) {
			int tx=(int)(x+xMove+bounds.x+bounds.width)/Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)&&!collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
				x+=xMove;
			}
			else {x=tx*Tile.TILEWIDTH-bounds.x-bounds.width-1;}//벽 타일과 충돌 시 안 움직임
		}
		else if(xMove<0) {
			int tx=(int)(x+xMove+bounds.x)/Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)&&!collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
				x+=xMove;}
			else {x=tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bounds.x+1;}
			}
		
	}
	public void moveY() {
		if(yMove<0) {
		int ty=(int)(y+yMove+bounds.y)/Tile.TILEHEIGHT;
		if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)) {y+=yMove;}
		else {y=ty*Tile.TILEHEIGHT+Tile.TILEHEIGHT-bounds.y;}
		}
		else if (yMove>0) {
			int ty=(int)(y+yMove+bounds.y+bounds.height)/Tile.TILEHEIGHT;
			if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty)) {y+=yMove;}
			else {y=ty*Tile.TILEHEIGHT+-bounds.y-bounds.height-1;}
			}
		
		}
	
	public void move() {// staticEntity와 미 충돌 시 움직임
		if(!checkEntityCollision((float)xMove,0f)) {
		moveX();}
		if(!checkEntityCollision(0f,(float)yMove)) {
		moveY();}
	}
	protected void A_cooldown(int speed){//스킬 쿨타임
		A_timer++;
		if(A_timer>=speed) {A_cooldown=false;A_timer=0;}
		else {A_cooldown=true;}
		}
	protected void A2_cooldown(int speed){
		A2_timer++;
		if(A2_timer>=speed) {A2_cooldown=false;A2_timer=0;}
		else {A2_cooldown=true;}
		}
	protected void S_cooldown(int speed){
		S_timer++;
		if(S_timer>=speed) {S_cooldown=false;S_timer=0;}
		else {S_cooldown=true;}
		}
	protected void S2_cooldown(int speed){
		S2_timer++;
		if(S2_timer>=speed) {S2_cooldown=false;S2_timer=0;}
		else {S2_cooldown=true;}
		}
	protected void S3_cooldown(int speed){
		S3_timer++;
		if(S3_timer>=speed) {S3_cooldown=false;S3_timer=0;}
		else {S3_cooldown=true;}
		}

	public double getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public double getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getA_timer() {
		return A_timer;
	}

	public boolean isA_cooldown() {
		return A_cooldown;
	}

	public boolean isA2_cooldown() {
		return A2_cooldown;
	}

	public boolean isS_cooldown() {
		return S_cooldown;
	}

	public boolean isS2_cooldown() {
		return S2_cooldown;
	}

	public boolean isS3_cooldown() {
		return S3_cooldown;
	}

	public int getA2_timer() {
		return A2_timer;
	}

	public int getS_timer() {
		return S_timer;
	}

	public int getS2_timer() {
		return S2_timer;
	}

	public int getS3_timer() {
		return S3_timer;
	}

}
