package Creature;

import Enemy.Ene_Creature;
import Entities.Entity;
import basic_one.Handler;
import tiles.Tile;

public abstract class Creature extends Entity {
	
	protected int H_timer=0;
	protected int A_timer=0;//��ų ��Ÿ��
	protected int A2_timer=0;
	protected int S_timer=0;
	protected int S2_timer=0;
	protected int S3_timer=0;
	protected boolean A_cooldown=false;//��ų ��Ÿ�� ���� ����
	protected boolean A2_cooldown=false;
	protected boolean S_cooldown=false;
	protected boolean S2_cooldown=false;
	protected boolean S3_cooldown=false;
	public boolean isHurt=false;//�ǰ� ����
	private boolean invincibility=false;//���� ����
	public static final int DEFAULT_HEALTH=600;//�⺻ ü��
	public static final double DEFAULT_SPEED=1.8;//�⺻ �ӵ�
	protected boolean collisionWithTile(int x,int y) {//Ÿ�ϰ� �浹 ����
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
		if(isJump) {//���� �Լ�
			r_Y=y+(height/2);//���� y��
			deltaJ= -Math.pow(powerJ-7,2)+60;//�����Լ� ���
			v_Y=r_Y+deltaJ;//��¿� y��
			powerJ+=0.32;//deltaJ�� ��������
			if(v_Y<=r_Y) {r_Y=y;powerJ=0;deltaJ=0;isJump=false;}//���� ���� ��	
		}
	}
	
	public boolean isInvincibility() {
		return invincibility;
	}

	public void setInvincibility(boolean invincibility) {
		this.invincibility = invincibility;
	}

	
	protected void checkEne(int damage) {//���� �� �ǰݽ� �浹���� Ȯ��
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(!e.Damaged) {colli_HB(e,damage);}
		}
	}
	protected void checkEne_m(int damage) {//���� �� �ǰݽ� ����Ʈ�� �浹���� Ȯ��
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(!e.Damaged) {colli_HB_M(e,damage);}
		}
	}
	protected void check_eD(){//�� �ǰ� ���� false
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			e.Damaged=false;
		}
	}
	
	protected abstract void checkHitbox(); //�߻� �Լ�
	protected void colli_HB(Ene_Creature e, int damage) {//���� ��Ʈ�ڽ� �ǰ� ����
			if ((x+hitBox.x>e.getX()+e.bounds.x+e.bounds.width||x+hitBox.x+hitBox.width<e.getX()+e.bounds.x)||
					(y+hitBox.y>e.getY()+e.bounds.y+e.bounds.height||y+hitBox.y+hitBox.height<e.getY()+e.bounds.y)) {
				e.isDamaged=false;e.Damaged=false;}
			else {e.isDamaged=true;e.Damaged=true;e.hurt(damage);e.damage_sound=true;e.damage_effect=true;}	
	}	
	protected void colli_HB_M(Ene_Creature e, int damage) {//���� ����Ʈ �ǰ�����(����Ʈ�� �÷��̾��� ��ǥ�� ���� �ϱ⶧���� ���� �Լ��� ����)
		if ((hitBox.x>e.getX()+e.bounds.x+e.bounds.width||hitBox.x+hitBox.width<e.getX()+e.bounds.x)||
				(hitBox.y>e.getY()+e.bounds.y+e.bounds.height||hitBox.y+hitBox.height<e.getY()+e.bounds.y)) {
			e.isDamaged=false;e.Damaged=false;}
		else {e.isDamaged=true;e.Damaged=true;e.hurt(damage);e.damage_sound=true;e.damage_effect=true;}	
	}
	protected void hurtDelay() {//�ǰ� ������
		if(isHurt) {
		H_timer++;
		if(H_timer>=30) {isHurt=false;H_timer=0;}
		else {isHurt=true;}}
	}

	public void moveX() {//������
		if(xMove>0) {
			int tx=(int)(x+xMove+bounds.x+bounds.width)/Tile.TILEWIDTH;
			if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)&&!collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT)) {
				x+=xMove;
			}
			else {x=tx*Tile.TILEWIDTH-bounds.x-bounds.width-1;}//�� Ÿ�ϰ� �浹 �� �� ������
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
	
	public void move() {// staticEntity�� �� �浹 �� ������
		if(!checkEntityCollision((float)xMove,0f)) {
		moveX();}
		if(!checkEntityCollision(0f,(float)yMove)) {
		moveY();}
	}
	protected void A_cooldown(int speed){//��ų ��Ÿ��
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
