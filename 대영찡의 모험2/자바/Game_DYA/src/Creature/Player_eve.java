package Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_effect;
import gfx.Asset_eve;

public class Player_eve extends Creature {

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
	private Animation[] aniExplosion;
	private Animation aniHurtL;
	private Animation aniHurtR;
	private Animation aniDeadL;
	private Animation aniDeadR;
	
	private boolean LOR = false;// 왼쪽=true 오른쪽= false
	private boolean AON = false;// 기본 공격
	private boolean SAC = false;
	private boolean S1 = false;// 특수공격 1
	private boolean S2 = false;// 특수공격 2
	private boolean resetloc=false;
	private boolean act_S2 = false;
	private int del_x[];
	private int del_y[];

	public Player_eve(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		health=700;
		MAX_health=700;
		bounds.x = 25;
		bounds.y = bounds.height - 20;
		bounds.width = 35;
		bounds.height = 10;
		aniIdleL = new Animation(100, Asset_eve.player_eve_idleL);
		aniMoveR = new Animation(100, Asset_eve.player_eve_moveR);
		aniMoveL = new Animation(100, Asset_eve.player_eve_moveL);
		aniIdleR = new Animation(100, Asset_eve.player_eve_idleR);
		aniAttackL = new Animation(80, Asset_eve.player_eve_attackL);
		aniSattackL = new Animation(100, Asset_eve.player_eve_SattackL);
		aniAttackR = new Animation(80, Asset_eve.player_eve_attackR);
		aniSattackR = new Animation(100, Asset_eve.player_eve_SattackR);
		aniJumpL = new Animation(0, Asset_eve.player_eve_jumpL);
		aniJumpR = new Animation(0, Asset_eve.player_eve_jumpR);
		aniS2attackL = new Animation(100, Asset_eve.player_eve_S2attackL);
		aniS2attackR = new Animation(100, Asset_eve.player_eve_S2attackR);
		aniAttack2L = new Animation(40, Asset_eve.player_eve_attack2L);
		aniAttack2R = new Animation(40, Asset_eve.player_eve_attack2R);
		aniHurtL=new Animation(0,Asset_eve.player_eve_hurtL);
		aniHurtR=new Animation(0,Asset_eve.player_eve_hurtR);
		aniDeadL=new Animation(0,Asset_eve.player_eve_deadL);
		aniDeadR=new Animation(0,Asset_eve.player_eve_deadR);
		aniExplosion = new Animation[20];
		del_x = new int[20];
		del_y = new int[20];
		for (int i = 0; i < 20; i++) {
			aniExplosion[i] = new Animation(60, Asset_effect.explosion);
			del_x[i] = (int) ((Math.random() * 350) - 350);
			del_y[i] = (int) ((Math.random() * 150) - 150);
		}
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
		if(A_cooldown) {A_cooldown(45);AON=false;}
		if(A2_cooldown) {A2_cooldown(35);SAC=false;}
		if(S_cooldown) {S_cooldown(150);S1=false;}
		if(S2_cooldown) {S2_cooldown(400);S2=false;}
		hurtDelay();}
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(!isHurt) {
		if (handler.getKeyManager().left) {
			if ((!AON && !S1 && !S2 && !SAC) || isJump) {
				xMove = -speed;
				LOR = true;
			}
		}
		if (handler.getKeyManager().right) {
			if ((!AON && !S1 && !S2 && !SAC) || isJump) {
				xMove = +speed;
				LOR = false;
			}
		}
		if (handler.getKeyManager().up) {
			if ((!AON && !S1 && !S2 && !SAC) || isJump) {
				yMove = -(speed - 0.9);
			}
		}
		if (handler.getKeyManager().down) {
			if ((!AON && !S1 && !S2 && !SAC) || isJump) {
				yMove = +(speed - 0.9);
			}
		}
		if (handler.getKeyManager().attack) {
			if (!S1 && !S2 && !SAC) {
				if (!AON) {
					if (aniAttackL.getIndex() != 0) {
						aniAttackL.setIndex(0);
					}
					if (aniAttackR.getIndex() != 0) {
						aniAttackR.setIndex(0);
					}
					AON = true;
				}
			}
		}
		if (handler.getKeyManager().attack2) {
			if (!AON && !S1 && !S2 && !isJump) {
				if (!SAC) {
					if (aniAttack2L.getIndex() != 0) {
						aniAttack2L.setIndex(0);
					}
					if (aniAttack2R.getIndex() != 0) {
						aniAttack2R.setIndex(0);
					}
					SAC = true;
				}
			}
		}
		if (handler.getKeyManager().jump) {
			if (!AON && !S1 && !S2 && !SAC) {
				if(!isJump) {
				isJump = true;sound.jump();}
			}
		}
		if (handler.getKeyManager().Sattack) {
			if (!AON && !S2 && !isJump && !SAC) {
				S1 = true;
			}
		}
		if (handler.getKeyManager().S2attack) {
			if (!AON && !S1 && !isJump && !SAC) {
				S2 = true;
			}
		}}
	}
	protected void checkHitbox() {
		
		hitBox=new Rectangle();
		if(aniAttackL.getIndex()==2||aniAttackL.getIndex()==3) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2-70;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(90);
			
		}
		else if(aniAttackR.getIndex()==2||aniAttackR.getIndex()==3) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(90);
			
		}
		else if(aniAttack2L.getIndex()==3||aniAttack2L.getIndex()==4) {
			sound.sweep();
			hitBox.x=bounds.x+bounds.width/2-100;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=80;
			hitBox.height=10;
			checkEne(60);
			
		}
		else if(aniAttack2R.getIndex()==3||aniAttack2R.getIndex()==4) {
			sound.sweep();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=80;
			hitBox.height=10;
			checkEne(60);
			
		}
		
		else if(aniSattackL.getIndex()==1) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2-60;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=50;
			hitBox.height=20;
			checkEne(80);
			
		}
		else if(aniSattackL.getIndex()==3||aniSattackL.getIndex()==4) {
			sound.stomp();
			hitBox.x=bounds.x+bounds.width/2-80;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=50;
			hitBox.height=30;
			checkEne(150);
			
		}
		else if(aniSattackR.getIndex()==1) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2+10;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=50;
			hitBox.height=30;
			checkEne(150);
			
		}
		else if(aniSattackR.getIndex()==3||aniSattackR.getIndex()==4) {
			sound.stomp();
			hitBox.x=bounds.x+bounds.width/2+30;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=50;
			hitBox.height=30;
			checkEne(150);
			
		}
		
		else if(act_S2) {
			for(int i=0;i<20;i++) {
			sound.explosion();
			hitBox.x=del_x[i]+150;
			hitBox.y=del_y[i]+100;
			hitBox.width=50;
			hitBox.height=50;
			checkEne(200);
			}}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;check_eD();sound.isPlayed=false;}
		}

	public void render(Graphics g) {
		if(active) {
		checkHitbox();
		
		if (act_S2) {
			if(resetloc) {
				for(int i=0;i<20;i++) {
				del_x[i] = (int) ((Math.random() * 350) - 350);
				del_y[i] = (int) ((Math.random() * 150) - 150);
				}
				resetloc=false;
			}
			for (int i = 0; i < 20; i++) {
				aniExplosion[i].tick();
				g.drawImage(aniExplosion[i].getCurrentFrame(),
						(int) (x - handler.getGameCamera().getxOffset()) + del_x[i] + 150,
						(int) (y - handler.getGameCamera().getyOffset()) + del_y[i], null);

				if (aniExplosion[i].getIndex() == 17) {
					aniExplosion[i].tick();
					aniExplosion[i].setIndex(0);
					act_S2 = false;
					resetloc=true;
				}
			}
		} else {
			for (int i = 0; i < 20; i++)
				aniExplosion[i].setIndex(0);
		}
		if(!isHurt) {
		if (AON && LOR&&!A_cooldown) {
			aniAttackL.tick();
			aniAttackR.setIndex(0);
			g.drawImage(aniAttackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 175,
					(int) (y - handler.getGameCamera().getyOffset()) - 108 - (int) deltaJ, null);
			if (isJump) {
				jump();
			}
			if(aniAttackL.getIndex()>=4&&aniAttackL.getIndex()<=6) {
				aniAttackR.setIndex(aniAttackL.getIndex());
			if (aniAttackL.getIndex() == 6) {
				aniAttackL.tick();
				aniAttackL.setIndex(0);
				aniAttackR.setIndex(0);
				AON = false;
				A_cooldown=true;
			}
			}
		} else if (AON && !LOR&&!A_cooldown) {
			aniAttackR.tick();
			aniAttackL.setIndex(0);
			g.drawImage(aniAttackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 40,
					(int) (y - handler.getGameCamera().getyOffset()) - 105 - (int) deltaJ, null);
			if (isJump) {
				jump();
			}
			if(aniAttackR.getIndex()>=4&&aniAttackR.getIndex()<=6) {
				aniAttackL.setIndex(aniAttackR.getIndex());
			if (aniAttackR.getIndex() == 6) {
				aniAttackR.tick();
				aniAttackR.setIndex(0);
				aniAttackL.setIndex(0);
				AON = false;
				A_cooldown=true;
			}
			}
		} else if (SAC && !LOR && !isJump&&!A2_cooldown) {
			aniAttack2R.tick();
			g.drawImage(aniAttack2R.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 50,
					(int) (y - handler.getGameCamera().getyOffset()) - 105, null);
			if (aniAttack2R.getIndex() == 7) {
				aniAttack2R.tick();
				aniAttack2R.setIndex(0);
				SAC = false;
				A2_cooldown=true;
			}
		} else if (SAC && LOR && !isJump&&!A2_cooldown) {
			aniAttack2L.tick();
			g.drawImage(aniAttack2L.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 170,
					(int) (y - handler.getGameCamera().getyOffset()) - 105, null);
			if (aniAttack2L.getIndex() == 7) {
				aniAttack2L.tick();
				aniAttack2L.setIndex(0);
				SAC = false;
				A2_cooldown=true;
			}
		} else if (S1 && LOR && !isJump&&!S_cooldown) {
			aniSattackL.tick();
			g.drawImage(aniSattackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 160),
					(int) (y - handler.getGameCamera().getyOffset() - 108), null);
			if (aniSattackL.getIndex() == 7) {
				aniSattackL.tick();
				aniSattackL.setIndex(0);
				S1 = false;
				S_cooldown=true;
			}
		} else if (S1 && !LOR && !isJump&&!S_cooldown) {
			aniSattackR.tick();
			g.drawImage(aniSattackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 60),
					(int) (y - handler.getGameCamera().getyOffset() - 108), null);
			if (aniSattackR.getIndex() == 7) {
				aniSattackR.tick();
				aniSattackR.setIndex(0);
				S1 = false;
				S_cooldown=true;
			}
		} else if (S2 && LOR && !isJump&&!S2_cooldown) {
			setInvincibility(true);
			aniS2attackL.tick();
			g.drawImage(aniS2attackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 50),
					(int) (y - handler.getGameCamera().getyOffset() - 150), null);
			if (aniS2attackL.getIndex() == 25) {
				act_S2 = true;
			}
			if (aniS2attackL.getIndex() == 35) {
				aniS2attackL.tick();
				aniS2attackL.setIndex(0);
				S2 = false;
				S2_cooldown=true;
				setInvincibility(false);
			}
		} else if (S2 && !LOR && !isJump&&!S2_cooldown) {
			setInvincibility(true);
			aniS2attackR.tick();
			g.drawImage(aniS2attackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 45),
					(int) (y - handler.getGameCamera().getyOffset() - 152), null);
			if (aniS2attackR.getIndex() == 25) {
				act_S2 = true;
			}
			if (aniS2attackR.getIndex() == 35) {
				aniS2attackR.tick();
				aniS2attackR.setIndex(0);
				S2 = false;
				S2_cooldown=true;
				setInvincibility(false);
			}
		} else if (isJump) {
			if (LOR) {
				jump();
				g.drawImage(aniJumpL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 17,
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);
			} else {
				jump();
				g.drawImage(aniJumpR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 22,
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);
			}
		} else if (xMove < 0||(LOR&&yMove!=0)) {
			g.drawImage(aniMoveL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 10,
					(int) (y - handler.getGameCamera().getyOffset()), null);
		} else if (xMove > 0||(!LOR&&yMove!=0)) {
			g.drawImage(aniMoveR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 20,
					(int) (y - handler.getGameCamera().getyOffset()), null);
		} else {
			if (LOR) {
				g.drawImage(aniIdleL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 7,
						(int) (y - handler.getGameCamera().getyOffset()) - 15, null);
			} else {
				g.drawImage(aniIdleR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 14,
						(int) (y - handler.getGameCamera().getyOffset()) - 15, null);
			}
		}
		
	}
		else {
			AON=false;SAC=false;S1=false;S2=false;isJump=false;
			powerJ=0;deltaJ=0;
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);aniAttack2L.setIndex(0);aniAttack2R.setIndex(0);
			aniSattackL.setIndex(0);aniSattackR.setIndex(0);aniS2attackL.setIndex(0);aniS2attackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+10,
					 (int)(y-handler.getGameCamera().getyOffset())+20, null);}
		}
		D_effect(g);
	}
		else {
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())+30, null);}
		}	
	}
}
