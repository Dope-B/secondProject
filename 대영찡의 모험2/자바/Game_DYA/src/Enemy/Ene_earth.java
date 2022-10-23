package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_earth;

public class Ene_earth extends Ene_Creature {

	private Animation aniIdleL;
	private Animation aniIdleR;
	private Animation aniMoveL;
	private Animation aniMoveR;
	private Animation aniAttackL;
	private Animation aniAttackR;
	private Animation aniDeadL;
	private Animation aniDeadR;
	private Animation aniHurtL;
	private Animation aniHurtR;
	
	public Ene_earth(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=800;
		MAX_health=800;
		attackRange=new Rectangle(-60,85,220,1);
		bounds.x=20;
		bounds.y=bounds.height-28;
		bounds.width=60;
		bounds.height=20;
		this.target=target;
		attackTerm=100;
		H_delay=60;
		aniIdleL=new Animation(100,Asset_earth.enemy_earth_idleL);
		aniIdleR=new Animation(100,Asset_earth.enemy_earth_idleR);
		aniMoveR=new Animation(100,Asset_earth.enemy_earth_moveR);
		aniMoveL=new Animation(100,Asset_earth.enemy_earth_moveL);
		aniAttackL=new Animation(100,Asset_earth.enemy_earth_attackL);
		aniAttackR=new Animation(100,Asset_earth.enemy_earth_attackR);
		aniDeadL=new Animation(100,Asset_earth.enemy_earth_deadL);
		aniDeadR=new Animation(100,Asset_earth.enemy_earth_deadR);
		aniHurtL=new Animation(100,Asset_earth.enemy_earth_hurtL);
		aniHurtR=new Animation(100,Asset_earth.enemy_earth_hurtR);
		icon=new Animation(0,Asset_earth.enemy_earth_icon);
		aniDeadL=new Animation(0,Asset_earth.enemy_earth_deadL);
		aniDeadR=new Animation(0,Asset_earth.enemy_earth_deadR);
	}
	

	public void tick() {
	if(active) {
		aniIdleL.tick();
		aniIdleR.tick();
		aniMoveL.tick();
		aniMoveR.tick();
		damage_sound();
		if(!isDamaged) {
			move();
			AI();}
			else {hurtDelay();xMove=0;yMove=0;ready=false;AC_L=false;AC_R=false;}
		if(A_cooldown) {A_cooldown(50); AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==8) {
			sound.woosh();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(40);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==8) {
			sound.woosh();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(40);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==15) {
			sound.sweep();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x-10;
			hitBox.y=bounds.y;
			hitBox.width=bounds.width+10;
			hitBox.height=bounds.height;
			if(colli(target,hitBox)) {
				target.hurt(150);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==15) {
			sound.sweep();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
				hitBox.x=bounds.x+10;
				hitBox.y=bounds.y;
				hitBox.width=bounds.width-10;
				hitBox.height=bounds.height;
			if(colli(target,hitBox)) {
				target.hurt(150);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;isAttacked=false;sound.isPlayed=false;}
		}
	
	public void render(Graphics g) {
		if(active) {
		checkHitBox();
		if(!isDamaged) {
		if(isMove&&LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-15,
					(int)(y-handler.getGameCamera().getyOffset())+8, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+10, null);
			
		}
		else if(AC_L&&!A_cooldown) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-100,
					(int)(y-handler.getGameCamera().getyOffset())-40, null);
			if(aniAttackL.getIndex()==15) {xMove-=10;isMove=true;move();}
			if(aniAttackL.getIndex()==19) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R&&!A_cooldown) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-25,
					(int)(y-handler.getGameCamera().getyOffset())-40, null);
			if(aniAttackR.getIndex()==15) {xMove+=10;isMove=true;move();}
			if(aniAttackR.getIndex()==19) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-24,
				(int)(y-handler.getGameCamera().getyOffset())+15, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
				(int)(y-handler.getGameCamera().getyOffset())+12, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+7,
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset())+30, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);}
		}	
	}
}
