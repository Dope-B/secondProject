package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_golem;

public class Ene_golem extends Ene_Creature {

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
	
	public Ene_golem(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=550;
		MAX_health=550;
		attackRange=new Rectangle(5,85,90,1);
		bounds.x=20;
		bounds.y=bounds.height-28;
		bounds.width=60;
		bounds.height=20;
		this.target=target;
		attackTerm=20;
		H_delay=60;
		aniIdleL=new Animation(100,Asset_golem.enemy_golem_idleL);
		aniIdleR=new Animation(100,Asset_golem.enemy_golem_idleR);
		aniMoveR=new Animation(100,Asset_golem.enemy_golem_moveR);
		aniMoveL=new Animation(100,Asset_golem.enemy_golem_moveL);
		aniAttackL=new Animation(100,Asset_golem.enemy_golem_attackL);
		aniAttackR=new Animation(100,Asset_golem.enemy_golem_attackR);
		aniDeadL=new Animation(100,Asset_golem.enemy_golem_deadL);
		aniDeadR=new Animation(100,Asset_golem.enemy_golem_deadR);
		aniHurtL=new Animation(100,Asset_golem.enemy_golem_hurtL);
		aniHurtR=new Animation(100,Asset_golem.enemy_golem_hurtR);
		icon=new Animation(0,Asset_golem.enemy_golem_icon);
		aniDeadL=new Animation(0,Asset_golem.enemy_golem_deadL);
		aniDeadR=new Animation(0,Asset_golem.enemy_golem_deadR);
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
			hitBox.x=bounds.x-18;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=15;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(80);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			
		}
		else if(aniAttackR.getIndex()==8) {
			sound.woosh();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=46;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(80);
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
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+8,
					(int)(y-handler.getGameCamera().getyOffset())+15, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+8,
					(int)(y-handler.getGameCamera().getyOffset())+15, null);
			
		}
		else if(AC_L) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-5,
					(int)(y-handler.getGameCamera().getyOffset()), null);
			if(aniAttackL.getIndex()==13) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+5,
					(int)(y-handler.getGameCamera().getyOffset()), null);
			if(aniAttackR.getIndex()==13) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;   
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+10,
				(int)(y-handler.getGameCamera().getyOffset())+15, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+5,
				(int)(y-handler.getGameCamera().getyOffset())+15, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+7,
					(int)(y-handler.getGameCamera().getyOffset())+31, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset())+31, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);}
		}	
	}
}
