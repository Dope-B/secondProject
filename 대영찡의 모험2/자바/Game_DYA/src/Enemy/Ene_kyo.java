package Enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_effect;
import gfx.Asset_kyo;

public class Ene_kyo extends Ene_Creature {
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
	private Animation[] aniFire;
	private float s_x;
	private float s_y;
	private boolean act_fireL1=false;
	private boolean act_fireR1=false;
	private boolean act_fireL2=false;
	private boolean act_fireR2=false;
	private boolean act_fireL3=false;
	private boolean act_fireR3=false;
	private boolean act_fireL4=false;
	private boolean act_fireR4=false;
	private boolean act_fireL5=false;
	private boolean act_fireR5=false;
	private boolean act_fireL6=false;
	private boolean act_fireR6=false;
	private boolean resetloc=true;
	
	
	public Ene_kyo(Handler handler, float x, float y,Creature target) {
		super(handler, x, y, 100, 100);
		health=4000;
		MAX_health=4000;
		attackRange=new Rectangle(-50,70,180,1);
		bounds.x=20;
		bounds.y=bounds.height-40;
		bounds.width=40;
		bounds.height=20;
		speed=3;
		H_delay=17;
		this.target=target;
		attackTerm=60;
		aniIdleL=new Animation(100,Asset_kyo.enemy_kyo_idleL);
		aniIdleR=new Animation(100,Asset_kyo.enemy_kyo_idleR);
		aniMoveL=new Animation(100,Asset_kyo.enemy_kyo_moveL);
		aniMoveR=new Animation(100,Asset_kyo.enemy_kyo_moveR);
		aniAttackL=new Animation(65,Asset_kyo.enemy_kyo_attackL);
		aniAttackR=new Animation(65,Asset_kyo.enemy_kyo_attackR);
		aniHurtL=new Animation(0,Asset_kyo.enemy_kyo_hurtL);
		aniHurtR=new Animation(0,Asset_kyo.enemy_kyo_hurtR);
		icon=new Animation(0,Asset_kyo.enemy_kyo_icon);
		aniDeadL=new Animation(0,Asset_kyo.enemy_kyo_deadL);
		aniDeadR=new Animation(0,Asset_kyo.enemy_kyo_deadR);
		aniFire=new Animation[6];
		for(int i=0;i<6;i++) {
		aniFire[i]=new Animation(45,Asset_effect.fire_col);}
	}
	private void setloc() {
		if(resetloc) {
			s_x=x;
			s_y=y;
			resetloc=false;
		}
	}
	
	
	private void act_fireL(Graphics g) {
		if(act_fireL1) {//연쇄적으로 출력
			aniFire[0].tick();
			if(aniFire[0].getIndex()==1) {sound.FC();}
			if(aniFire[0].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[0].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-80,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[0].getIndex()==3) {act_fireL2=true;}
			if(aniFire[0].getIndex()==10) {act_fireL1=false;}
		}
		if(act_fireL2) {
			aniFire[1].tick();
			if(aniFire[1].getIndex()==1) {sound.FC();}
			if(aniFire[1].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[1].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-150,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[1].getIndex()==3) {act_fireL3=true;}
			if(aniFire[1].getIndex()==10) {act_fireL2=false;}
		}	
		if(act_fireL3) {
			aniFire[2].tick();
			if(aniFire[2].getIndex()==1) {sound.FC();}
			if(aniFire[2].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[2].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-240,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[2].getIndex()==3) {act_fireL4=true;}
			if(aniFire[2].getIndex()==10) {act_fireL3=false;}
		}	
		if(act_fireL4) {
			aniFire[3].tick();
			if(aniFire[3].getIndex()==1) {sound.FC();}
			if(aniFire[3].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[3].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-300,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[3].getIndex()==3) {act_fireL5=true;}
			if(aniFire[3].getIndex()==10) {act_fireL4=false;}
		}	
		if(act_fireL5) {
			aniFire[4].tick();
			if(aniFire[4].getIndex()==1) {sound.FC();}
			if(aniFire[4].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[4].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-360,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[4].getIndex()==3) {act_fireL6=true;}
			if(aniFire[4].getIndex()==10) {act_fireL5=false;}
		}	
		if(act_fireL6) {
			aniFire[5].tick();
			if(aniFire[5].getIndex()==1) {sound.FC();}
			if(aniFire[5].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[5].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())-420,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[5].getIndex()==10) {act_fireL6=false;}
		}	
	}
	private void act_fireR(Graphics g) {
		if(act_fireR1) {
			aniFire[0].tick();
			if(aniFire[0].getIndex()==1) {sound.FC();}
			if(aniFire[0].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[0].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+80,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[0].getIndex()==3) {act_fireR2=true;}
			if(aniFire[0].getIndex()==10) {act_fireR1=false;}
		}
		if(act_fireR2) {
			aniFire[1].tick();
			if(aniFire[1].getIndex()==1) {sound.FC();}
			if(aniFire[1].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[1].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+150,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[1].getIndex()==3) {act_fireR3=true;}
			if(aniFire[1].getIndex()==10) {act_fireR2=false;}
		}	
		if(act_fireR3) {
			aniFire[2].tick();
			if(aniFire[2].getIndex()==1) {sound.FC();}
			if(aniFire[2].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[2].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+240,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[2].getIndex()==3) {act_fireR4=true;}
			if(aniFire[2].getIndex()==10) {act_fireR3=false;}
		}	
		if(act_fireR4) {
			aniFire[3].tick();
			if(aniFire[3].getIndex()==1) {sound.FC();}
			if(aniFire[3].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[3].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+300,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[3].getIndex()==3) {act_fireR5=true;}
			if(aniFire[3].getIndex()==10) {act_fireR4=false;}
		}	
		if(act_fireR5) {
			aniFire[4].tick();
			if(aniFire[4].getIndex()==1) {sound.FC();}
			if(aniFire[4].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[4].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+360,
					(int)(s_y-handler.getGameCamera().getyOffset())-90,80,160, null);
			if(aniFire[4].getIndex()==3) {act_fireR6=true;}
			if(aniFire[4].getIndex()==10) {act_fireR5=false;}
		}	
		if(act_fireR6) {
			aniFire[5].tick();
			if(aniFire[5].getIndex()==1) {sound.FC();}
			if(aniFire[5].getIndex()==2) {sound.isPlayed_FC=false;}
			g.drawImage(aniFire[5].getCurrentFrame(),(int)(s_x-handler.getGameCamera().getxOffset())+420,
					(int)(s_y-handler.getGameCamera().getyOffset())-70,80,160, null);
			if(aniFire[5].getIndex()==10) {act_fireR6=false;}
		}		
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
			if(A_cooldown) {A_cooldown(70); AC_L=false;AC_R=false;}}
		}

		protected void checkHitBox() {
			hitBox=new Rectangle();
			if(act_fireL1) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-100);
					hitBox.y=(int)(s_y+50);
					hitBox.width=50;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireL2) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-165);
					hitBox.y=(int)(s_y+70);
					hitBox.width=80;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireL3) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-245);
					hitBox.y=(int)(s_y+50);
					hitBox.width=65;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireL4) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-305);
					hitBox.y=(int)(s_y+70);
					hitBox.width=70;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireL5) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-365);
					hitBox.y=(int)(s_y+50);
					hitBox.width=80;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireL6) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x-425);
					hitBox.y=(int)(s_y+70);
					hitBox.width=80;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			if(act_fireR1) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+95);
					hitBox.y=(int)(s_y+50);
					hitBox.width=50;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
		
			if(act_fireR2) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+160);
					hitBox.y=(int)(s_y+70);
					hitBox.width=60;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
		
			if(act_fireR3) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+245);
					hitBox.y=(int)(s_y+50);
					hitBox.width=65;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			
			if(act_fireR4) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+305);
					hitBox.y=(int)(s_y+70);
					hitBox.width=70;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			
			if(act_fireR5) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+365);
					hitBox.y=(int)(s_y+50);
					hitBox.width=80;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
			
			if(act_fireR6) {
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
					hitBox.x=(int) (s_x+425);
					hitBox.y=(int)(s_y+70);
					hitBox.width=80;
					hitBox.height=30;
					if(colli_M(target,hitBox)) {
						target.hurt(2);
						target.damage_effect=true;
						isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
			}
		
			if(aniAttackL.getIndex()>=8&&aniAttackL.getIndex()<=15) {
				sound.cast_fire();
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
				hitBox.x=bounds.x-100;
				hitBox.y=bounds.y+bounds.height/2-50;
				hitBox.width=190;
				hitBox.height=100;
				if(colli(target,hitBox)) {
					target.hurt(160);
					target.damage_effect=true;
					isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
				
			}
			else if(aniAttackR.getIndex()>=8&&aniAttackR.getIndex()<=15) {
				sound.cast_fire();
				if(!isAttacked&&target.isActive()&&!target.isInvincibility()) {
				hitBox.x=bounds.x-55;
				hitBox.y=bounds.y+bounds.height/2-50;
				hitBox.width=190;
				hitBox.height=100;
				if(colli(target,hitBox)) {
					target.hurt(160);
					target.damage_effect=true;
					isAttacked=true;target.isHurt=true;target.damage_sound=true;}}
				}
			else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;isAttacked=false;sound.isPlayed_magic2=false;}
		}
		
		public void render(Graphics g) {
			if(active) {
			checkHitBox();
			if(!isDamaged) {
			if(isMove&&LOR&&!AC_L&&!AC_R) {
				g.drawImage(aniMoveL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
						(int)(y-handler.getGameCamera().getyOffset())+20, null);
			}
			else if (isMove&&!LOR&&!AC_L&&!AC_R) {
				g.drawImage(aniMoveR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
						(int)(y-handler.getGameCamera().getyOffset())+20, null);
				
			}
			else if(AC_L) {
				isMove=false;	
				aniAttackL.tick();
				aniAttackR.setIndex(0);
				g.drawImage(aniAttackL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-95,
						(int)(y-handler.getGameCamera().getyOffset())-70, null);
				if(aniAttackL.getIndex()==13) {act_fireL1=true;setloc();}
				if(aniAttackL.getIndex()==19) {
					 aniAttackL.tick();
					 resetloc=true;
	  			   aniAttackL.setIndex(0);AC_L=false;A_cooldown=true;
				}
				
			}
			else if(AC_R) {
				isMove=false;
				aniAttackR.tick();
				aniAttackL.setIndex(0);
				g.drawImage(aniAttackR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-205,
						(int)(y-handler.getGameCamera().getyOffset())-70, null);
				if(aniAttackR.getIndex()==13) {act_fireR1=true;setloc();}
				if(aniAttackR.getIndex()==19) {
					 aniAttackR.tick();
					 resetloc=true;
	 			   aniAttackR.setIndex(0);AC_R=false;A_cooldown=true;
				}
				
			}
			else {
			if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset()), null);}
			else {g.drawImage(aniIdleR.getCurrentFrame(),(int)(x-handler.getGameCamera().getxOffset())-8,
					(int)(y-handler.getGameCamera().getyOffset()), null);}
			}
			}
			else {
				aniAttackL.setIndex(0);aniAttackR.setIndex(0);
				if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
						(int)(x-handler.getGameCamera().getxOffset())+12,
						(int)(y-handler.getGameCamera().getyOffset())+25, null);}
				else {g.drawImage(aniHurtR.getCurrentFrame(), 
						 (int)(x-handler.getGameCamera().getxOffset())+12,
						 (int)(y-handler.getGameCamera().getyOffset())+25, null);}
			}
			D_effect(g);
		}
			else {
				if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
						(int)(x-handler.getGameCamera().getxOffset())+10,
						(int)(y-handler.getGameCamera().getyOffset())+42, null);}
				else{g.drawImage(aniDeadR.getCurrentFrame(), 
						(int)(x-handler.getGameCamera().getxOffset())+10,
						(int)(y-handler.getGameCamera().getyOffset())+42, null);}
			}	
			act_fireL(g);
			act_fireR(g);
		}
		
}
