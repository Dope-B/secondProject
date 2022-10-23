package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_glauca;

public class Ene_glauca extends Ene_Creature {

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
	
	public Ene_glauca(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=800;
		MAX_health=800;
		attackRange=new Rectangle(-45,85,195,1);
		bounds.x=30;
		bounds.y=bounds.height-28;
		bounds.width=40;
		bounds.height=20;
		this.target=target;
		H_delay=60;
		attackTerm=90;
		if(A_cooldown) {A_cooldown(200); AC_L=false;AC_R=false;}
		aniIdleL=new Animation(100,Asset_glauca.enemy_glauca_idleL);
		aniIdleR=new Animation(100,Asset_glauca.enemy_glauca_idleR);
		aniMoveR=new Animation(100,Asset_glauca.enemy_glauca_moveR);
		aniMoveL=new Animation(100,Asset_glauca.enemy_glauca_moveL);
		aniAttackL=new Animation(100,Asset_glauca.enemy_glauca_attackL);
		aniAttackR=new Animation(100,Asset_glauca.enemy_glauca_attackR);
		aniDeadL=new Animation(100,Asset_glauca.enemy_glauca_deadL);
		aniDeadR=new Animation(100,Asset_glauca.enemy_glauca_deadR);
		aniHurtL=new Animation(100,Asset_glauca.enemy_glauca_hurtL);
		aniHurtR=new Animation(100,Asset_glauca.enemy_glauca_hurtR);
		icon=new Animation(0,Asset_glauca.enemy_glauca_icon);
		aniDeadL=new Animation(0,Asset_glauca.enemy_glauca_deadL);
		aniDeadR=new Animation(0,Asset_glauca.enemy_glauca_deadR);
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
		if(A_cooldown) {A_cooldown(80); AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==8) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-120;
			hitBox.y=bounds.y+bounds.height/2-26;
			hitBox.width=120;
			hitBox.height=52;
			if(colli(target,hitBox)) {
				target.hurt(50);
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==8) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-26;
			hitBox.width=120;
			hitBox.height=52;
			if(colli(target,hitBox)) {
				target.hurt(60);
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==12||aniAttackL.getIndex()==13) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-130;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=130;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(90);
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==12||aniAttackR.getIndex()==13) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=130;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(40);
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==19) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-160;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=160;
			hitBox.height=20;
			if(colli(target,hitBox)) {
				target.hurt(50);
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==19) {
			sound.wide_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=160;
			hitBox.height=20;
			if(colli(target,hitBox)) {
				target.hurt(50);
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
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+6,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-15,
					(int)(y-handler.getGameCamera().getyOffset())+22, null);
			
		}
		else if(AC_L&&!A_cooldown) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-115,
					(int)(y-handler.getGameCamera().getyOffset())-55, null);
			if(aniAttackL.getIndex()==26) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R&&!A_cooldown) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-60,
					(int)(y-handler.getGameCamera().getyOffset())-55, null);
			if(aniAttackR.getIndex()==26) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-35,
				(int)(y-handler.getGameCamera().getyOffset())-10, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+10,
				(int)(y-handler.getGameCamera().getyOffset())-5, null);}
		}
		}
		else{
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset())-25,
				(int)(y-handler.getGameCamera().getyOffset())+36, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
				 (int)(x-handler.getGameCamera().getxOffset())+10,
				 (int)(y-handler.getGameCamera().getyOffset())+37, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())+55, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())+55, null);}
		}	
	}
}
