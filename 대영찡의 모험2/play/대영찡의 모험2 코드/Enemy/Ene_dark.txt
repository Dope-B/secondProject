package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_dark;


public class Ene_dark extends Ene_Creature {//전체적으로 플레이어 알고리즘과 동일 

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
	
	public Ene_dark(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=1000;
		MAX_health=1000;
		attackRange=new Rectangle(-90,85,280,1);
		bounds.x=20;
		bounds.y=bounds.height-28;
		bounds.width=60;
		bounds.height=20;
		H_delay=60;
		this.target=target;
		attackTerm=100;
		aniIdleL=new Animation(100,Asset_dark.enemy_dark_idleL);
		aniIdleR=new Animation(100,Asset_dark.enemy_dark_idleR);
		aniMoveR=new Animation(100,Asset_dark.enemy_dark_moveR);
		aniMoveL=new Animation(100,Asset_dark.enemy_dark_moveL);
		aniAttackL=new Animation(100,Asset_dark.enemy_dark_attackL);
		aniAttackR=new Animation(100,Asset_dark.enemy_dark_attackR);
		aniDeadL=new Animation(100,Asset_dark.enemy_dark_deadL);
		aniDeadR=new Animation(100,Asset_dark.enemy_dark_deadR);
		aniHurtL=new Animation(100,Asset_dark.enemy_dark_hurtL);
		aniHurtR=new Animation(100,Asset_dark.enemy_dark_hurtR);
		icon=new Animation(0,Asset_dark.enemy_dark_icon);
		aniDeadL=new Animation(0,Asset_dark.enemy_dark_deadL);
		aniDeadR=new Animation(0,Asset_dark.enemy_dark_deadR);
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
		if(A_cooldown) {A_cooldown(50); AC_L=false;AC_R=false;}
		}
	}
	
	protected void checkHitBox() {
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==12) {
			sound.woosh();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2-160;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=160;
			hitBox.height=10;
			if(colli(target,hitBox)) {
				target.hurt(80);
				target.damage_effect=true;
				isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			
		}
		else if(aniAttackR.getIndex()==12) {
			sound.woosh();
			if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=160;
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
			g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset())+15, null);
		}
		else if (isMove&&!LOR&&!AC_L&&!AC_R) {
			g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-30,
					(int)(y-handler.getGameCamera().getyOffset())+10, null);
			
		}
		else if(AC_L&&!A_cooldown) {
			isMove=false;	
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-130,
					(int)(y-handler.getGameCamera().getyOffset())-40, null);
			if(aniAttackL.getIndex()==19) {
				 aniAttackL.tick();
  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
			}
			
		}
		else if(AC_R&&!A_cooldown) {
			isMove=false;
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-35,
					(int)(y-handler.getGameCamera().getyOffset())-40, null);
			if(aniAttackR.getIndex()==19) {
				 aniAttackR.tick();
 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;   
			}
			
		}
		else {
		if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-24,
				(int)(y-handler.getGameCamera().getyOffset())+5, null);}
		else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
				(int)(y-handler.getGameCamera().getyOffset()), null);}
		}
		}
		else {
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+7,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset())+20, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+3,
					(int)(y-handler.getGameCamera().getyOffset())+25, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+3,
					(int)(y-handler.getGameCamera().getyOffset())+25, null);}
		}
		}
}
