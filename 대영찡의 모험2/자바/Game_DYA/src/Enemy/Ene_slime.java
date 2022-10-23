package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_slime;

public class Ene_slime extends Ene_Creature{

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
	
	public Ene_slime(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=400;
		MAX_health=400;
		attackRange=new Rectangle(0,80,76,1);
		bounds.x=20;
		bounds.y=bounds.height-28;
		bounds.width=30;
		bounds.height=17;
		this.target=target;
		H_delay=60;
		attackTerm=40;
		aniIdleL=new Animation(100,Asset_slime.enemy_slime_idleL);
		aniIdleR=new Animation(100,Asset_slime.enemy_slime_idleR);
		aniMoveR=new Animation(100,Asset_slime.enemy_slime_moveR);
		aniMoveL=new Animation(100,Asset_slime.enemy_slime_moveL);
		aniAttackL=new Animation(100,Asset_slime.enemy_slime_attackL);
		aniAttackR=new Animation(100,Asset_slime.enemy_slime_attackR);
		aniDeadL=new Animation(100,Asset_slime.enemy_slime_deadL);
		aniDeadR=new Animation(100,Asset_slime.enemy_slime_deadR);
		aniHurtL=new Animation(100,Asset_slime.enemy_slime_hurtL);
		aniHurtR=new Animation(100,Asset_slime.enemy_slime_hurtR);
		icon=new Animation(0,Asset_slime.enemy_slime_icon);
		aniDeadL=new Animation(0,Asset_slime.enemy_slime_deadL);
		aniDeadR=new Animation(0,Asset_slime.enemy_slime_deadR);
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
		if(A_cooldown) {A_cooldown(40); AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==13) {
			sound.slime();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x-55;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=35;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(30);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			
		}
		else if(aniAttackR.getIndex()==13) {
			sound.slime();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+55;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=25;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(30);
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
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+12,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+12,
					(int)(y-handler.getGameCamera().getyOffset())+50, null);
			
		}
		else if(AC_L) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-40,
					(int)(y-handler.getGameCamera().getyOffset())+32, null);
			if(aniAttackL.getIndex()==18) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+8,
					(int)(y-handler.getGameCamera().getyOffset())+32, null);
			if(aniAttackR.getIndex()==18) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+12,
				(int)(y-handler.getGameCamera().getyOffset())+55, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+12,
				(int)(y-handler.getGameCamera().getyOffset())+55, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+65, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+8,
					 (int)(y-handler.getGameCamera().getyOffset())+65, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+60, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+60, null);}
		}	
	}
}
