package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_kain;

public class Ene_kain extends Ene_Creature {

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
	
	public Ene_kain(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=500;
		MAX_health=500;
		attackRange=new Rectangle(-20,85,145,1);
		bounds.x=20;
		bounds.y=bounds.height-23;
		bounds.width=60;
		bounds.height=15;
		this.target=target;
		attackTerm=70;
		H_delay=60;
		aniIdleL=new Animation(100,Asset_kain.enemy_kain_idleL);
		aniIdleR=new Animation(100,Asset_kain.enemy_kain_idleR);
		aniMoveR=new Animation(100,Asset_kain.enemy_kain_moveR);
		aniMoveL=new Animation(100,Asset_kain.enemy_kain_moveL);
		aniAttackL=new Animation(80,Asset_kain.enemy_kain_attackL);
		aniAttackR=new Animation(80,Asset_kain.enemy_kain_attackR);
		aniDeadL=new Animation(100,Asset_kain.enemy_kain_deadL);
		aniDeadR=new Animation(100,Asset_kain.enemy_kain_deadR);
		aniHurtL=new Animation(100,Asset_kain.enemy_kain_hurtL);
		aniHurtR=new Animation(100,Asset_kain.enemy_kain_hurtR);
		icon=new Animation(0,Asset_kain.enemy_kain_icon);
		aniDeadL=new Animation(0,Asset_kain.enemy_kain_deadL);
		aniDeadR=new Animation(0,Asset_kain.enemy_kain_deadR);
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
		if(A_cooldown) {A_cooldown(100); AC_L=false;AC_R=false;}}
	}

	protected void checkHitBox() {
		
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==4) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(20);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==4) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(30);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==8) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(40);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==8) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(40);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackL.getIndex()==12) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-120;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=120;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(50);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}
			}
		}
		else if(aniAttackR.getIndex()==12) {
			sound.sharp_slash();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=120;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(50);
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
			
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-30,
					(int)(y-handler.getGameCamera().getyOffset())-8, null);
		}
		
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-15,
					(int)(y-handler.getGameCamera().getyOffset()), null);
			
		}
		else if(AC_L) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-90,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);
			if(aniAttackL.getIndex()==15) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-175,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);
			if(aniAttackR.getIndex()==15) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;   
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-24,
				(int)(y-handler.getGameCamera().getyOffset())-5, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-8,
				(int)(y-handler.getGameCamera().getyOffset())-2, null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())-20,
					(int)(y-handler.getGameCamera().getyOffset())+40, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+10,
					 (int)(y-handler.getGameCamera().getyOffset())+40, null);}
		}
		D_effect(g);
	}
		else {if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset())+10,
				(int)(y-handler.getGameCamera().getyOffset())+55, null);}
		else{g.drawImage(aniDeadR.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset())+10,
				(int)(y-handler.getGameCamera().getyOffset())+55, null);}}
}
}
