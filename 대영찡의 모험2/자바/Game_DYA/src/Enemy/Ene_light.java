package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_light;

public class Ene_light extends Ene_Creature {

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
	
	public Ene_light(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=700;
		MAX_health=700;
		attackRange=new Rectangle(-50,85,200,1);
		bounds.x=20;
		bounds.y=bounds.height-28;
		bounds.width=60;
		bounds.height=20;
		this.target=target;
		attackTerm=70;
		H_delay=60;
		aniIdleL=new Animation(100,Asset_light.enemy_light_idleL);
		aniIdleR=new Animation(100,Asset_light.enemy_light_idleR);
		aniMoveR=new Animation(100,Asset_light.enemy_light_moveR);
		aniMoveL=new Animation(100,Asset_light.enemy_light_moveL);
		aniAttackL=new Animation(90,Asset_light.enemy_light_attackL);
		aniAttackR=new Animation(90,Asset_light.enemy_light_attackR);
		aniDeadL=new Animation(100,Asset_light.enemy_light_deadL);
		aniDeadR=new Animation(100,Asset_light.enemy_light_deadR);
		aniHurtL=new Animation(100,Asset_light.enemy_light_hurtL);
		aniHurtR=new Animation(100,Asset_light.enemy_light_hurtR);
		icon=new Animation(0,Asset_light.enemy_light_icon);
		aniDeadL=new Animation(0,Asset_light.enemy_light_deadL);
		aniDeadR=new Animation(0,Asset_light.enemy_light_deadR);
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
		if(A_cooldown) {A_cooldown(80);AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		if(target.isActive()&&!target.isInvincibility()) {
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==7) {
			sound.rifle();
			hitBox.x=bounds.x+bounds.width/2-100;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackR.getIndex()==7) {
			sound.rifle();
			hitBox.x=bounds.x+bounds.width/2+60;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackL.getIndex()==8) {
			
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;}
			
		}
		else if(aniAttackR.getIndex()==8) {
			
			hitBox.x=bounds.x+bounds.width/2+100;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackL.getIndex()==9) {
			
			hitBox.x=bounds.x+bounds.width/2-180;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackR.getIndex()==9) {
			
			hitBox.x=bounds.x+bounds.width/2+140;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=70;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(2);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackL.getIndex()>=13&&aniAttackL.getIndex()<=19) {
			sound.missile();
			hitBox.x=bounds.x+bounds.width/2-130;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=60;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(1);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			
		}
		else if(aniAttackR.getIndex()>=13&&aniAttackR.getIndex()<=19) {
			sound.missile();
			hitBox.x=bounds.x+bounds.width/2+70;
			hitBox.y=bounds.y+bounds.height/2-30;
			hitBox.width=60;
			hitBox.height=60;
			if(colli(target,hitBox)) {
				target.hurt(1);
				target.damage_effect=true;
				target.isHurt=true;target.damage_sound=true;}
			}
		
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;sound.isPlayed=false;}
		}
	}
	
	public void render(Graphics g) {
		if(active) {
		checkHitBox();
		if(!isDamaged) {
		if(isMove&&LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+8,
					(int)(y-handler.getGameCamera().getyOffset())+9, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+3,
					(int)(y-handler.getGameCamera().getyOffset())+5, null);
			
		}
		else if(AC_L&&!A_cooldown) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-180,
					(int)(y-handler.getGameCamera().getyOffset())-60, null);
			if(aniAttackL.getIndex()==25) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R&&!A_cooldown) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-85,
					(int)(y-handler.getGameCamera().getyOffset())-60, null);
			if(aniAttackR.getIndex()==25) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+7,
				(int)(y-handler.getGameCamera().getyOffset())+2, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())+5,
				(int)(y-handler.getGameCamera().getyOffset())-2, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+10,
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
