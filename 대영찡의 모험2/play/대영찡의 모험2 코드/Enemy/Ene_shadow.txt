package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_shadow;

public class Ene_shadow extends Ene_Creature {

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
	
	public Ene_shadow(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=600;
		MAX_health=600;
		attackRange=new Rectangle(-30,85,170,1);
		bounds.x=20;
		bounds.y=bounds.height-20;
		bounds.width=60;
		bounds.height=10;
		this.target=target;
		attackTerm=80;
		H_delay=60;
		aniIdleL=new Animation(100,Asset_shadow.enemy_shadow_idleL);
		aniIdleR=new Animation(100,Asset_shadow.enemy_shadow_idleR);
		aniMoveR=new Animation(100,Asset_shadow.enemy_shadow_moveR);
		aniMoveL=new Animation(100,Asset_shadow.enemy_shadow_moveL);
		aniAttackL=new Animation(100,Asset_shadow.enemy_shadow_attackL);
		aniAttackR=new Animation(100,Asset_shadow.enemy_shadow_attackR);
		aniDeadL=new Animation(100,Asset_shadow.enemy_shadow_deadL);
		aniDeadR=new Animation(100,Asset_shadow.enemy_shadow_deadR);
		aniHurtL=new Animation(100,Asset_shadow.enemy_shadow_hurtL);
		aniHurtR=new Animation(100,Asset_shadow.enemy_shadow_hurtR);
		icon=new Animation(0,Asset_shadow.enemy_shadow_icon);
		aniDeadL=new Animation(0,Asset_shadow.enemy_shadow_deadL);
		aniDeadR=new Animation(0,Asset_shadow.enemy_shadow_deadR);
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
		if(A_cooldown) {A_cooldown(120); AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==1) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-80;
			hitBox.y=bounds.y+bounds.height/2-3;
			hitBox.width=80;
			hitBox.height=6;
			if(colli(target,hitBox)) {
				target.hurt(50);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==1) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-3;
			hitBox.width=80;
			hitBox.height=6;
			if(colli(target,hitBox)) {
				target.hurt(50);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==3) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-130;
			hitBox.y=bounds.y+bounds.height/2-3;
			hitBox.width=100;
			hitBox.height=6;
			if(colli(target,hitBox)) {
				target.hurt(40);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==3) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-3;
			hitBox.width=130;
			hitBox.height=6;
			if(colli(target,hitBox)) {
				target.hurt(40);
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
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-4,
					(int)(y-handler.getGameCamera().getyOffset())+32, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset())+34, null);
			
		}
		else if(AC_L) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-80,
					(int)(y-handler.getGameCamera().getyOffset())+7, null);
			if(aniAttackL.getIndex()==10) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset())+7, null);
			if(aniAttackR.getIndex()==10) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;   
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+5,
				(int)(y-handler.getGameCamera().getyOffset())+20, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+5,
				(int)(y-handler.getGameCamera().getyOffset())+20, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+7,
					(int)(y-handler.getGameCamera().getyOffset())+47, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset())+47, null);}
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
