package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import StaticEntites.StaticEntity;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_effect;
import sound.Sounds;

public abstract class Entity {

	protected float x,y;
	protected double v_Y;
	protected double r_Y;
	protected int health;//체력
	protected int MAX_health;//최대체력
	protected double speed;//속도
	protected double xMove;//x방향 변화
	protected double yMove;//y방향 변화
	protected double powerJ=0;//점프 높이
	protected double deltaJ=0;//z축 변화
	protected boolean isJump=false;// 점프 여부
	public boolean damage_sound=false;//피격 소리 출력 여부
	public boolean damage_effect=false;//피격 이펙트 출력 여부
	protected Handler handler;
	protected int width,height;//크기
	public Rectangle bounds;//캐릭터 충동 경계 범위
	protected Rectangle hitBox;//히트박스 범위
	protected boolean active=true;//생존 여부
	protected Sounds sound;//피격 소리 저장 변수
	public Animation D_effect;//피격 이펙트 저장 변수
	protected boolean isplayer;//플레이어 여부
	public int dead_ticker=0;//사망 후 이미지 출력 시간 결정 변수
	
	public Entity(Handler handler,float x,float y,int width, int height) {
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		D_effect=new Animation(60,Asset_effect.D_effect);//60의 속도로 프레임 변경
		bounds=new Rectangle(0,0,width,height);
		sound=new Sounds();
	}
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {//캐릭터 현 위치에 따른 bounds 범위 리턴
		return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
	}
	public boolean checkEntityCollision(float xOffset,float yOffset) {// staticEntity와 충돌판정
		for(StaticEntity e:handler.getWorld_checker().getEM().getSobjects()) {//e에 Sobjects 대입 
			if(e.equals(this)) {//동일 시 continue
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))) {// 충돌 시 true 리턴
				return true;
			}
		}
		return false;
	}
	
	public void hurt(int damage) {// 피격 함수
		health-=damage;
		if(health<=0) {active=false;}// 체력이 0 이하일 시 사망판정
	}
	public void damage_sound() {//소리 출력
		if(damage_sound) {
			sound.damaged();
			damage_sound=false;
		}
	}
	public void D_effect(Graphics g) {//피격 이펙트 출력
		if(damage_effect) {// 이펙트 출력여부가 true일떄 
			D_effect.tick();//시간에 따라 인덱스를 갱신
			g.drawImage(D_effect.getCurrentFrame(),//실제 출력
		    		(int)(x+width/3-handler.getGameCamera().getxOffset()),
					(int)(y+height/2.3-handler.getGameCamera().getyOffset()), null);
			if(D_effect.getIndex()==4) {//인덱스가 4일 경우
				D_effect.setIndex(0);//인덱스 번호를 0으로 맞춤 
				damage_effect=false;// 더 이상 출력하지 않도록 한다
			}
		}
		else {D_effect.setIndex(0);}//미 피격시 인덱스 번호를 0으로 고정
	}	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	public int getMAX_health() {
		return MAX_health;
	}
	public void setMAX_health(int mAX_health) {
		MAX_health = mAX_health;
	}
	public float getX() {
		return x;
	}
	public double getv_Y() {
		return v_Y;
	}
	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
}
