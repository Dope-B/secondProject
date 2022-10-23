package Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_Lasswell;


public class Player_lasswell extends Creature {

	private Animation aniIdleL;
	private Animation aniIdleR;
	private Animation aniMoveL;
	private Animation aniMoveR;
	private Animation aniJumpL;
	private Animation aniJumpR;
	private Animation aniAttackL;
	private Animation aniAttackR;
	private Animation aniAttack2L;
	private Animation aniAttack2R;
	private Animation aniSattackL;
	private Animation aniSattackR;
	private Animation aniS2attackL;
	private Animation aniS2attackR;
	private Animation aniHurtL;
	private Animation aniHurtR;
	private Animation aniDeadL;
	private Animation aniDeadR;
	private boolean LOR=false;// 왼쪽=true 오른쪽= false
	private boolean AON=false;//기본 공격
	private boolean SAC=false;
	private boolean S1=false;// 특수공격 1
	private boolean S2=false;//특수공격 2
	public Player_lasswell(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		health=500;
		MAX_health=500;
		bounds.x=25;
		bounds.y=bounds.height-18;
		bounds.width=35;
		bounds.height=10;
		aniIdleL=new Animation(100,Asset_Lasswell.player_lasswell_idleL);
		aniMoveR=new Animation(100,Asset_Lasswell.player_lasswell_moveR);
		aniMoveL=new Animation(100,Asset_Lasswell.player_lasswell_moveL);
		aniIdleR=new Animation(100,Asset_Lasswell.player_lasswell_idleR);
		aniAttackL=new Animation(100,Asset_Lasswell.player_lasswell_attackL);
		aniSattackL=new Animation(100,Asset_Lasswell.player_lasswell_SattackL);
		aniAttackR=new Animation(100,Asset_Lasswell.player_lasswell_attackR);
		aniSattackR=new Animation(100,Asset_Lasswell.player_lasswell_SattackR);
		aniJumpL=new Animation(0,Asset_Lasswell.player_lasswell_jumpL);
		aniJumpR=new Animation(0,Asset_Lasswell.player_lasswell_jumpR);
		aniS2attackL=new Animation(100,Asset_Lasswell.player_lasswell_S2attackL);
		aniS2attackR=new Animation(100,Asset_Lasswell.player_lasswell_S2attackR);
		aniAttack2L=new Animation(100,Asset_Lasswell.player_lasswell_attack2L);
		aniAttack2R=new Animation(100,Asset_Lasswell.player_lasswell_attack2R);
		aniHurtL=new Animation(0,Asset_Lasswell.player_lasswell_hurtL);
		aniHurtR=new Animation(0,Asset_Lasswell.player_lasswell_hurtR);
		aniDeadL=new Animation(0,Asset_Lasswell.player_lasswell_deadL);
		aniDeadR=new Animation(0,Asset_Lasswell.player_lasswell_deadR);
	}
	
	public void tick() {
		if(active) {
		getInput();
		aniIdleL.tick();
		aniIdleR.tick();
		aniMoveR.tick();
		aniMoveL.tick();
		damage_sound();
		move();
		handler.getGameCamera().centerOnEntity(this);
		if(A_cooldown) {A_cooldown(25);AON=false;}
		if(A2_cooldown) {A2_cooldown(15);SAC=false;}
		if(S_cooldown) {S_cooldown(300);S1=false;}
		if(S2_cooldown) {S2_cooldown(350);S2=false;}
		hurtDelay();}
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(!isHurt) {
		if(handler.getKeyManager().left) {	if((!AON&&!S1&&!S2&&!SAC)||isJump) {xMove=-speed;LOR=true;}}
		if(handler.getKeyManager().right) {	if((!AON&&!S1&&!S2&&!SAC)||isJump) {xMove=+speed;LOR=false;}}
		if(handler.getKeyManager().up) {	if((!AON&&!S1&&!S2&&!SAC)||isJump) {yMove=-(speed-0.9);}}
		if(handler.getKeyManager().down) {	if((!AON&&!S1&&!S2&&!SAC)||isJump) {yMove=+(speed-0.9);}}
		if(handler.getKeyManager().attack) {if(!isJump&&!S1&&!S2&&!SAC) {if(!AON) {
											if(aniAttackL.getIndex()!=0) {aniAttackL.setIndex(0);}
											if(aniAttackR.getIndex()!=0) {aniAttackR.setIndex(0);}
											AON=true;
											}}}
		if(handler.getKeyManager().attack2) {if(!AON&&!S1&&!S2&&!isJump) {if(!SAC) {
											if(aniAttack2L.getIndex()!=0) {aniAttack2L.setIndex(0);}
											if(aniAttack2R.getIndex()!=0) {aniAttack2R.setIndex(0);}
											SAC=true;
											}}}
		if(handler.getKeyManager().jump) {if(!AON&&!S1&&!S2&&!SAC) {
			if(!isJump) {isJump = true;sound.jump();}}}
		if(handler.getKeyManager().Sattack) {if(!AON&&!S2&&!isJump&&!SAC) {S1=true;}}
		if(handler.getKeyManager().S2attack) {if(!AON&&!S1&&!isJump&&!SAC) {S2=true;}}}
	}

	protected void checkHitbox() {
		
		hitBox=new Rectangle();
		if(AON&&LOR) {
			if(aniAttackL.getIndex()==0||aniAttackL.getIndex()==1) {
				sound.slash();
			
			hitBox.x=bounds.x+bounds.width/2-95;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=75;
			hitBox.height=20;
			checkEne(70);
		
			}
		}
		else if(AON&&!LOR) {
			if(aniAttackR.getIndex()==0||aniAttackR.getIndex()==1) {
				sound.slash();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=75;
			hitBox.height=20;
			checkEne(70);
			}
		}
		else if(SAC&&LOR) {
			if(aniAttack2L.getIndex()==0||aniAttack2L.getIndex()==1) {
				sound.sharp_slash();
			hitBox.x=bounds.x+bounds.width/2-50;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=30;
			hitBox.height=20;
			checkEne(90);
			}
		}
		else if(SAC&&!LOR) {
			if(aniAttack2R.getIndex()==0||aniAttack2R.getIndex()==1) {
				sound.sharp_slash();
			
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=30;
			hitBox.height=20;
			checkEne(90);
			}
		}
		else if(S1&&LOR) {
			sound.dash_slash();
			hitBox.x=bounds.x+bounds.width/2-120;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=240;
			hitBox.height=20;
			checkEne(190);
			
		}
		else if(S1&&!LOR) {
			sound.dash_slash();
			hitBox.x=bounds.x+bounds.width/2-120;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=240;
			hitBox.height=30;
			checkEne(190);
			
		}
		else if(S2&&LOR) {
			sound.brutal_slash();
			hitBox.x=bounds.x+bounds.width/2-150;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=150;
			hitBox.height=30;
			checkEne(250);
		
		}
		else if(S2&&!LOR) {
			sound.brutal_slash();
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=150;
			hitBox.height=30;
			checkEne(250);
			
		}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;check_eD();sound.isPlayed=false;}
	}
	public void render(Graphics g) {
		if(active) {
		checkHitbox();
		if(!isHurt) {
		   if(AON&&LOR&&!isJump&&!A_cooldown) {aniAttackL.tick();g.drawImage(aniAttackL.getCurrentFrame(),
	    			  (int)(x-handler.getGameCamera().getxOffset())-66,
	    			  (int)(y-handler.getGameCamera().getyOffset())-3, null);
	    				if(aniAttackL.getIndex()==5) {
			    			aniAttackL.tick();
			    			aniAttackL.setIndex(0);AON=false;A_cooldown=true;}
	    }
		   else if(AON&&!LOR&&!isJump&&!A_cooldown) {aniAttackR.tick();g.drawImage(aniAttackR.getCurrentFrame(),
					(int)(x-handler.getGameCamera().getxOffset())-66,
					(int)(y-handler.getGameCamera().getyOffset())-3, null);
					if(aniAttackR.getIndex()==5) {
		    			aniAttackR.tick();
		    			aniAttackR.setIndex(0);AON=false;A_cooldown=true;}
		   }
		   else if(SAC&&!LOR&&!isJump&&!A2_cooldown) {aniAttack2R.tick();g.drawImage(aniAttack2R.getCurrentFrame(),
					(int)(x-handler.getGameCamera().getxOffset())-17,
					(int)(y-handler.getGameCamera().getyOffset())-25, null);
					if(aniAttack2R.getIndex()==5) {
		    			aniAttack2R.tick();
		    			aniAttack2R.setIndex(0);SAC=false;A2_cooldown=true;}
			}
			else if(SAC&&LOR&&!isJump&&!A2_cooldown) {aniAttack2L.tick();g.drawImage(aniAttack2L.getCurrentFrame(),
						(int)(x-handler.getGameCamera().getxOffset())-17,
						(int)(y-handler.getGameCamera().getyOffset())-25, null);
						if(aniAttack2L.getIndex()==5) {
		   				aniAttack2L.tick();			   				
		   				aniAttack2L.setIndex(0);SAC=false;A2_cooldown=true;}
			}
	    else if (S1&&LOR&&!isJump&&!S_cooldown) {aniSattackL.tick();g.drawImage(aniSattackL.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset()-110),
							(int)(y-handler.getGameCamera().getyOffset()-15), null);  
	    						if(aniSattackL.getIndex()==0||aniSattackL.getIndex()==1) {xMove-=10;move();}
						       if(aniSattackL.getIndex()==6) {
				    			   aniSattackL.tick();
				    			   aniSattackL.setIndex(0);S1=false;S_cooldown=true;
						       }
	    			}
	    else if (S1&&!LOR&&!isJump&&!S_cooldown) {aniSattackR.tick();g.drawImage(aniSattackR.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset()-170),
							(int)(y-handler.getGameCamera().getyOffset()-20), null);
	    							if(aniSattackR.getIndex()==0||aniSattackR.getIndex()==1) {xMove+=10;move();}
						       if(aniSattackR.getIndex()==6) {
				    			   aniSattackR.tick();
				    			   aniSattackR.setIndex(0);S1=false;S_cooldown=true;}
		}
	    else if (S2&&LOR&&!isJump&&!S2_cooldown) {aniS2attackL.tick();g.drawImage(aniS2attackL.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset()-200),
							(int)(y-handler.getGameCamera().getyOffset()-60), null);
	    							if(aniS2attackL.getIndex()==1) {xMove-=2;move();}
						       if(aniS2attackL.getIndex()==8) {
				    			   aniS2attackL.tick();
				    			   aniS2attackL.setIndex(0);S2=false;S2_cooldown=true;
						       }
		}
		else if (S2&&!LOR&&!isJump&&!S2_cooldown) {aniS2attackR.tick();g.drawImage(aniS2attackR.getCurrentFrame(),
							(int)(x-handler.getGameCamera().getxOffset()-150),
							(int)(y-handler.getGameCamera().getyOffset()-60), null);
										if(aniS2attackR.getIndex()==1) {xMove+=2;move();}
						       if(aniS2attackR.getIndex()==8) {
								   aniS2attackR.tick();
								   aniS2attackR.setIndex(0);S2=false;S2_cooldown=true;}
		}
	    else if(isJump) {
	    		if(LOR) {jump();g.drawImage(aniJumpL.getCurrentFrame(), 
	    				(int)(x-handler.getGameCamera().getxOffset())+17,
	    				(int)(y-handler.getGameCamera().getyOffset()-deltaJ), null);}
	    		else 	{jump();g.drawImage(aniJumpR.getCurrentFrame(), 
		    			(int)(x-handler.getGameCamera().getxOffset())+5,
		    			(int)(y-handler.getGameCamera().getyOffset()-deltaJ), null);}
	    				}
	    else if(xMove<0||(LOR&&yMove!=0)) {g.drawImage(aniMoveL.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset())+10,
				    		(int)(y-handler.getGameCamera().getyOffset()), null);}
		else if(xMove>0||(!LOR&&yMove!=0)) {g.drawImage(aniMoveR.getCurrentFrame(),
							(int)(x-handler.getGameCamera().getxOffset())+10,
							(int)(y-handler.getGameCamera().getyOffset()), null);}
		else 
		{
			if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(), 
							(int)(x-handler.getGameCamera().getxOffset())+17
							,
							(int)(y-handler.getGameCamera().getyOffset()), null);}
			 else {g.drawImage(aniIdleR.getCurrentFrame(), 
							 (int)(x-handler.getGameCamera().getxOffset())+5,
							 (int)(y-handler.getGameCamera().getyOffset()), null);}
		 }

	}
	else {
		AON=false;SAC=false;S1=false;S2=false;isJump=false;
		powerJ=0;deltaJ=0;
		aniAttackL.setIndex(0);aniAttackR.setIndex(0);aniAttack2L.setIndex(0);aniAttack2R.setIndex(0);
		aniSattackL.setIndex(0);aniSattackR.setIndex(0);aniS2attackL.setIndex(0);aniS2attackR.setIndex(0);
		if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset())+10,
				(int)(y-handler.getGameCamera().getyOffset())+10, null);}
		else {g.drawImage(aniHurtR.getCurrentFrame(), 
				 (int)(x-handler.getGameCamera().getxOffset())+5,
				 (int)(y-handler.getGameCamera().getyOffset())+10, null);}}
		D_effect(g);
	}
		else{
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset()),
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
		}}
}