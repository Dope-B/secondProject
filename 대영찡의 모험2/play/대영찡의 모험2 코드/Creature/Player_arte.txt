package Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_arte;


public class Player_arte extends Creature{

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
	private Animation aniHurtL;
	private Animation aniHurtR;
	private Animation aniDeadL;
	private Animation aniDeadR;

	private boolean LOR=false;// 왼쪽=true 오른쪽= false
	private boolean AON=false;//기본 공격
	private boolean SAC=false;
	private boolean S1=false;// 특수공격 1
	public Player_arte(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		health=500;
		MAX_health=500;
		bounds.x=25;
		bounds.y=bounds.height-18;
		bounds.width=35;
		bounds.height=10;
		aniIdleL=new Animation(100,Asset_arte.player_arte_idleL);
		aniIdleR=new Animation(100,Asset_arte.player_arte_idleR);
		aniMoveL=new Animation(100,Asset_arte.player_arte_moveL);
		aniMoveR=new Animation(100,Asset_arte.player_arte_moveR);
		aniAttackL=new Animation(90,Asset_arte.player_arte_attackL);
		aniAttackR=new Animation(90,Asset_arte.player_arte_attackR);
		aniSattackL=new Animation(90,Asset_arte.player_arte_SattackL);
		aniSattackR=new Animation(90,Asset_arte.player_arte_SattackR);
		aniJumpL=new Animation(0,Asset_arte.player_arte_jumpL);
		aniJumpR=new Animation(0,Asset_arte.player_arte_jumpR);
		aniAttack2L=new Animation(60,Asset_arte.player_arte_attack2L);
		aniAttack2R=new Animation(60,Asset_arte.player_arte_attack2R);
		aniHurtL=new Animation(0,Asset_arte.player_arte_hurtL);
		aniHurtR=new Animation(0,Asset_arte.player_arte_hurtR);
		aniDeadL=new Animation(0,Asset_arte.player_arte_deadL);
		aniDeadR=new Animation(0,Asset_arte.player_arte_deadR);
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
		if(A_cooldown) {A_cooldown(20);AON=false;}
		if(A2_cooldown) {A2_cooldown(90);SAC=false;}
		if(S_cooldown) {S_cooldown(250);S1=false;}
		hurtDelay();}
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(!isHurt) {
		if(handler.getKeyManager().left) {	if((!AON&&!S1&&!SAC)||isJump) {xMove=-speed;LOR=true;}}
		if(handler.getKeyManager().right) {	if((!AON&&!S1&&!SAC)||isJump) {xMove=+speed;LOR=false;}}
		if(handler.getKeyManager().up) {	if((!AON&&!S1&&!SAC)||isJump) {yMove=-(speed-0.9);}}
		if(handler.getKeyManager().down) {	if((!AON&&!S1&&!SAC)||isJump) {yMove=+(speed-0.9);}}
		if(handler.getKeyManager().attack) {if(!isJump&&!S1&&!SAC) {if(!AON) {
											if(aniAttackL.getIndex()!=0) {aniAttackL.setIndex(0);}
											if(aniAttackR.getIndex()!=0) {aniAttackR.setIndex(0);}
											AON=true;
											}}}
		if(handler.getKeyManager().attack2) {if(!AON&&!S1) {if(!SAC) {
											if(aniAttack2L.getIndex()!=0) {aniAttack2L.setIndex(0);}
											if(aniAttack2R.getIndex()!=0) {aniAttack2R.setIndex(0);}
											SAC=true;
											}}}
		if(handler.getKeyManager().jump) {if(!AON&&!S1&&!SAC) {if(!isJump) {isJump = true;sound.jump();}}}
		if(handler.getKeyManager().Sattack) {if(!AON&&!isJump&&!SAC) {S1=true;}}}
	}
	protected void checkHitbox() {
		
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==4) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(120);
		}
		else if(aniAttackR.getIndex()==4) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(120);
			
		}
		else if(aniAttack2L.getIndex()==4) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(100);
			
		}
		else if(aniAttack2L.getIndex()==8) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(100);
			
		}
		else if(aniAttack2L.getIndex()==12) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-140;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(150);
			
		}
		else if(aniAttack2R.getIndex()==4) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(100);
			
		}
		else if(aniAttack2R.getIndex()==8) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(120);
			
		}
		else if(aniAttack2R.getIndex()==12) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=140;
			hitBox.height=10;
			checkEne(150);
			
		}
		else if(aniSattackL.getIndex()==7) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(60);
			
		}
		else if(aniSattackL.getIndex()==11) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(70);
			
		}
		else if(aniSattackL.getIndex()==16) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(80);
			
		}
		else if(aniSattackL.getIndex()==22) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(90);
			
		}
		else if(aniSattackL.getIndex()==29) {
			sound.explosion();
			hitBox.x=bounds.x+bounds.width/2-90;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(400);
			
		}
		else if(aniSattackR.getIndex()==7) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2+40;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(60);
			
		}
		else if(aniSattackR.getIndex()==11) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2+40;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(70);
		
		}
		else if(aniSattackR.getIndex()==16) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2+40;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(80);
		
		}
		else if(aniSattackR.getIndex()==22) {
			sound.arrow();
			hitBox.x=bounds.x+bounds.width/2+40;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(90);
			
		}
		else if(aniSattackR.getIndex()==29) {
			sound.explosion();
			hitBox.x=bounds.x+bounds.width/2+40;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(400);
		
		}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;check_eD();sound.isPlayed=false;}
		}
	public void render(Graphics g) {
		if(active) {
		checkHitbox();
		
		if(!isHurt) {
		   if(AON&&LOR&&!isJump&&!A_cooldown) {aniAttackL.tick();g.drawImage(aniAttackL.getCurrentFrame(),
	    			  (int)(x-handler.getGameCamera().getxOffset())-110,
	    			  (int)(y-handler.getGameCamera().getyOffset())-20, null);
	    				
	    				if(aniAttackL.getIndex()==6) {
			    			aniAttackL.tick();
			    			aniAttackL.setIndex(0);AON=false;A_cooldown=true;}
	    }
		   else if(AON&&!LOR&&!isJump&&!A_cooldown) {aniAttackR.tick();g.drawImage(aniAttackR.getCurrentFrame(),
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())-20, null);
					if(aniAttackR.getIndex()==6) {
		    			aniAttackR.tick();
		    			aniAttackR.setIndex(0);AON=false;A_cooldown=true;}
		   }
		   else if(SAC&&!LOR&&!isJump&&!A2_cooldown) {aniAttack2R.tick();g.drawImage(aniAttack2R.getCurrentFrame(),
					(int)(x-handler.getGameCamera().getxOffset())+15,
					(int)(y-handler.getGameCamera().getyOffset())-20, null);
					if(aniAttack2R.getIndex()==14) {
		    			aniAttack2R.tick();
		    			aniAttack2R.setIndex(0);SAC=false;A2_cooldown=true;}
			}
			else if(SAC&&LOR&&!isJump&&!A2_cooldown) {aniAttack2L.tick();g.drawImage(aniAttack2L.getCurrentFrame(),
						(int)(x-handler.getGameCamera().getxOffset())-110,
						(int)(y-handler.getGameCamera().getyOffset())-20, null);
						if(aniAttack2L.getIndex()==14) {
		   				aniAttack2L.tick();			   				
		   				aniAttack2L.setIndex(0);SAC=false;A2_cooldown=true;}
			}
	    else if (S1&&LOR&&!isJump&&!S_cooldown) {setInvincibility(true);aniSattackL.tick();g.drawImage(aniSattackL.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset())-135,
							(int)(y-handler.getGameCamera().getyOffset())-90, null);  
	    						
						       if(aniSattackL.getIndex()==32) {
				    			   aniSattackL.tick();
				    			   aniSattackL.setIndex(0);S1=false;
				    			   S_cooldown=true;
				    			   setInvincibility(false);
						       }
	    			}
	    else if (S1&&!LOR&&!isJump&&!S_cooldown) {setInvincibility(true);aniSattackR.tick();g.drawImage(aniSattackR.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset()-20),
							(int)(y-handler.getGameCamera().getyOffset()-90), null);
	    							
						       if(aniSattackR.getIndex()==32) {
				    			   aniSattackR.tick();
				    			   aniSattackR.setIndex(0);S1=false;
				    			   S_cooldown=true;
				    			   setInvincibility(false);}
		}
	    else if(isJump) {
	    		if(LOR) {jump();g.drawImage(aniJumpL.getCurrentFrame(), 
	    				(int)(x-handler.getGameCamera().getxOffset()),
	    				(int)(y-handler.getGameCamera().getyOffset()-deltaJ), null);}
	    		else 	{jump();g.drawImage(aniJumpR.getCurrentFrame(), 
		    			(int)(x-handler.getGameCamera().getxOffset())+15,
		    			(int)(y-handler.getGameCamera().getyOffset()-deltaJ), null);}
	    				}
	    else if(xMove<0||(LOR&&yMove!=0)) {g.drawImage(aniMoveL.getCurrentFrame(),
				    		(int)(x-handler.getGameCamera().getxOffset()),
				    		(int)(y-handler.getGameCamera().getyOffset())+15, null);}
		else if(xMove>0||(!LOR&&yMove!=0)) {g.drawImage(aniMoveR.getCurrentFrame(),
							(int)(x-handler.getGameCamera().getxOffset())+10,
							(int)(y-handler.getGameCamera().getyOffset())+15, null);}
		else {
			if(LOR) {g.drawImage(aniIdleL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+7,
					(int)(y-handler.getGameCamera().getyOffset())-5, null);}
			else {g.drawImage(aniIdleR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset())-5, null);}}
	}
		else {
			AON=false;SAC=false;S1=false;isJump=false;
			powerJ=0;deltaJ=0;
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);aniAttack2L.setIndex(0);aniAttack2R.setIndex(0);
			aniSattackL.setIndex(0);aniSattackR.setIndex(0);
		if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset())+7,
				(int)(y-handler.getGameCamera().getyOffset())+20, null);}
		else {g.drawImage(aniHurtR.getCurrentFrame(), 
				 (int)(x-handler.getGameCamera().getxOffset())+5,
				 (int)(y-handler.getGameCamera().getyOffset())+20, null);}}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+5,
					(int)(y-handler.getGameCamera().getyOffset())+28, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+5,
					(int)(y-handler.getGameCamera().getyOffset())+28, null);}
		}	
	}
	
}
