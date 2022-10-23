package Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset;


public class Player extends Creature {

	private Animation aniIdleL;
	private Animation aniIdleR;
	private Animation aniLeft;
	private Animation aniRight;
	private Animation aniJumpL;
	private Animation aniJumpR;
	private Animation aniAttack;
	private Animation aniAttack2;
	private Animation aniAttackR;
	private Animation aniAttack2R;
	private Animation aniSattackL;
	private Animation aniSattackR;
	private Animation aniS2attackL;
	private Animation aniS2attackR;
	private Animation aniS3attackL;
	private Animation aniS3attackR;
	private Animation aniHurtL;
	private Animation aniHurtR;
	private Animation aniDeadL;
	private Animation aniDeadR;
	private boolean LOR = false;// 왼쪽=true 오른쪽= false
	private boolean AON = false;// 기본 공격
	private boolean SAC = false;// 올려 베기
	private boolean S1 = false;// 특수공격 1
	private boolean S2 = false;// 특수공격 2
	private boolean S3 = false;// 특수공격 3

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		health=650;
		MAX_health=650;
		bounds.x = 25;
		bounds.y = bounds.height -22;
		bounds.width = 35;
		bounds.height = 10;
		aniIdleL = new Animation(100, Asset.player_rainS2_idleL);
		aniLeft = new Animation(100, Asset.player_rainS2_left);
		aniRight = new Animation(100, Asset.player_rainS2_right);
		aniIdleR = new Animation(100, Asset.player_rainS2_idleR);
		aniAttack = new Animation(70, Asset.player_rainS2_attack);
		aniAttack2 = new Animation(70, Asset.player_rainS2_attack2);
		aniAttackR = new Animation(70, Asset.player_rainS2_attackR);
		aniAttack2R = new Animation(70, Asset.player_rainS2_attack2R);
		aniJumpL = new Animation(0, Asset.player_rainS2_jumpL);
		aniJumpR = new Animation(0, Asset.player_rainS2_jumpR);
		aniSattackL = new Animation(85, Asset.player_rainS2_SattackL);
		aniSattackR = new Animation(85, Asset.player_rainS2_SattackR);
		aniS2attackL = new Animation(85, Asset.player_rainS2_S2attackL);
		aniS2attackR = new Animation(85, Asset.player_rainS2_S2attackR);
		aniS3attackL = new Animation(60, Asset.player_rainS2_S3attackL);
		aniS3attackR = new Animation(60, Asset.player_rainS2_S3attackR);
		aniHurtL=new Animation(0,Asset.player_rainS2_hurtL);
		aniHurtR=new Animation(0,Asset.player_rainS2_hurtR);
		aniDeadL=new Animation(0,Asset.player_rainS2_deadL);
		aniDeadR=new Animation(0,Asset.player_rainS2_deadR);
	}

	public void tick() {
		if(active) {
		getInput();
		aniIdleL.tick();
		aniIdleR.tick();
		aniLeft.tick();
		aniRight.tick();
		damage_sound();
		move();
		handler.getGameCamera().centerOnEntity(this);
		if(A_cooldown) {A_cooldown(20);AON=false;}
		if(A2_cooldown) {A2_cooldown(40);SAC=false;}
		if(S_cooldown) {S_cooldown(300);S1=false;}
		if(S2_cooldown) {S2_cooldown(350);S2=false;}
		if(S3_cooldown) {S3_cooldown(240);S3=false;}
		hurtDelay();
		}
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(!isHurt) {
		if (handler.getKeyManager().left) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				xMove = -speed;
				LOR = true;
			}
		}
		if (handler.getKeyManager().right) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				xMove = +speed;
				LOR = false;
			}
		}
		if (handler.getKeyManager().up) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				yMove = -(speed - 0.9);
			}
		}
		if (handler.getKeyManager().down) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				yMove = +(speed - 0.9);
			}
		}
		if (handler.getKeyManager().attack) {
			if (!SAC && !isJump && !S1 && !S2 && !S3) {
				if (!AON) {
					if (aniAttack.getIndex() != 0) {
						aniAttack.setIndex(0);
					}
					if (aniAttackR.getIndex() != 0) {
						aniAttackR.setIndex(0);
					}
					AON = true;
				}
			}
		}
		if (handler.getKeyManager().attack2) {
			if (!AON && !S1 && !S2 && !S3) {
				if (!SAC) {
					if (aniAttack2.getIndex() != 0) {
						aniAttack2.setIndex(0);
					}
					if (aniAttack2R.getIndex() != 0) {
						aniAttack2R.setIndex(0);
					}
					SAC = true;
				}
			}
		}
		if (handler.getKeyManager().jump) {
			if (!AON && !SAC && !S1 && !S2 && !S3) {
				if(!isJump) {
					isJump = true;sound.jump();}
				}
		}
		if (handler.getKeyManager().Sattack) {
			if (!AON && !SAC && !S2 && !S3 && !isJump) {
				S1 = true;
			}
		}
		if (handler.getKeyManager().S2attack) {
			if (!AON && !SAC && !S1 && !S3 && !isJump) {
				S2 = true;
			}
		}
		if (handler.getKeyManager().S3attack) {
			if (!AON && !SAC && !S1 && !S2 && !isJump) {
				S3 = true;
			}
		}}
	}
	protected void checkHitbox() {
		hitBox=new Rectangle();
		if(aniAttack.getIndex()==4||aniAttack.getIndex()==5) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2-120;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=80;
			hitBox.height=20;
			checkEne(70);
		}
		else if(aniAttackR.getIndex()==4||aniAttackR.getIndex()==5) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2+30;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=80;
			hitBox.height=20;
			checkEne(70);
		}
		else if(aniAttack2.getIndex()==1||aniAttack2.getIndex()==2) {
			sound.wide_slash();
			hitBox.x=bounds.x+bounds.width/2-100;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=75;
			hitBox.height=10;
			checkEne(85);
		}
		else if(aniAttack2R.getIndex()==1||aniAttack2R.getIndex()==2) {
			sound.wide_slash();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=75;
			hitBox.height=10;
			checkEne(85);
		}
		
		else if(aniSattackL.getIndex()==2) {
			sound.brutal_slash();
			hitBox.x=bounds.x+bounds.width/2-340;
			hitBox.y=bounds.y+bounds.height/2-20;
			hitBox.width=250;
			hitBox.height=40;
			checkEne(80);
		}
		else if(aniSattackL.getIndex()==8) {
			sound.strong_slash();
			hitBox.x=bounds.x+bounds.width/2-110;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=80;
			hitBox.height=30;
			checkEne(120);
		}
		else if(aniSattackL.getIndex()>=17&&aniSattackL.getIndex()<=19) {
			sound.strong_woosh();
			if(aniSattackL.getIndex()==19) {
				hitBox.x=bounds.x+bounds.width/2-350;
				hitBox.y=bounds.y+bounds.height/2-20;
				hitBox.width=250;
				hitBox.height=40;}
			else {
				hitBox.x=bounds.x+bounds.width/2-230;
				hitBox.y=bounds.y+bounds.height/2-20;
				hitBox.width=150;
				hitBox.height=40;
			}
			checkEne(280);
		}
		else if(aniSattackR.getIndex()==2) {
			sound.brutal_slash();
			hitBox.x=bounds.x+bounds.width/2+90;
			hitBox.y=bounds.y+bounds.height/2-20;
			hitBox.width=250;
			hitBox.height=40;
			checkEne(80);
		}
		else if(aniSattackR.getIndex()==8) {
			sound.strong_slash();
			hitBox.x=bounds.x+bounds.width/2+30;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=80;
			hitBox.height=30;
			checkEne(120);
		}
		else if(aniSattackR.getIndex()>=17&&aniSattackR.getIndex()<=19) {
			sound.strong_woosh();
				if(aniSattackR.getIndex()==19) {
					hitBox.x=bounds.x+bounds.width/2+100;
					hitBox.y=bounds.y+bounds.height/2-20;
					hitBox.width=250;
					hitBox.height=40;}
				else {
					hitBox.x=bounds.x+bounds.width/2+80;
					hitBox.y=bounds.y+bounds.height/2-20;
					hitBox.width=150;
					hitBox.height=40;
				}
				checkEne(280);
		}
		else if(aniS2attackL.getIndex()>=1&&aniS2attackL.getIndex()<=9) {
			sound.summon();
			hitBox.x=bounds.x+bounds.width/2-200;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=50;
			hitBox.height=30;
			checkEne(140);
		}
		else if(aniS2attackL.getIndex()==12) {
			sound.slash();
			hitBox.x=bounds.x+bounds.width/2-210;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=80;
			hitBox.height=20;
			checkEne(70);
		}
		else if(aniS2attackL.getIndex()>=17&&aniS2attackL.getIndex()<=19) {
			sound.laser();
			hitBox.x=bounds.x+bounds.width/2-600;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=500;
			hitBox.height=20;
			checkEne(150);
		}
		else if(aniS2attackR.getIndex()>=1&&aniS2attackR.getIndex()<=9) {
			sound.summon();
			hitBox.x=bounds.x+bounds.width/2+140;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=50;
			hitBox.height=30;
			checkEne(140);
		}
		else if(aniS2attackR.getIndex()==12) {
			sound.slash();
			hitBox.x=bounds.x+bounds.width/2+140;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=80;
			hitBox.height=30;
			checkEne(70);
		}
		else if(aniS2attackR.getIndex()>=17&&aniS2attackR.getIndex()<=19) {
			sound.laser();
			hitBox.x=bounds.x+bounds.width/2+100;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=500;
			hitBox.height=30;
			checkEne(150);
		}
		else if(aniS3attackL.getIndex()>=13&&aniS3attackL.getIndex()<=15) {
			sound.strong_slash();
			hitBox.x=bounds.x+bounds.width/2-180;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=80;
			hitBox.height=30;
			checkEne(200);
		}
		else if(aniS3attackR.getIndex()>=13&&aniS3attackR.getIndex()<=15) {
			sound.strong_slash();
			hitBox.x=bounds.x+bounds.width/2+100;
			hitBox.y=bounds.y+bounds.height/2-15;
			hitBox.width=80;
			hitBox.height=30;
			checkEne(200);
		}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;check_eD();sound.isPlayed=false;}
	}

	public void render(Graphics g) {
		if(active) {
		checkHitbox();
		if(!isHurt) {
		if (AON && LOR && !isJump&&!A2_cooldown) {
			aniAttack2.tick();
			g.drawImage(aniAttack2.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 80,
					(int) (y - handler.getGameCamera().getyOffset()) - 45, null);

			if (aniAttack2.getIndex() == 7) {
				aniAttack2.tick();
				aniAttack2.setIndex(0);
				AON = false;
				A2_cooldown=true;
			}
		} else if (S1 && LOR && !isJump&&!S_cooldown) {
			aniSattackL.tick();
			setInvincibility(true);
			g.drawImage(aniSattackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 680,
					(int) (y - handler.getGameCamera().getyOffset()) - 145, null);
			if (aniSattackL.getIndex() == 29) {
				aniSattackL.tick();
				aniSattackL.setIndex(0);
				S1 = false;
				setInvincibility(false);
				S_cooldown=true;
			}
		} else if (S1 && !LOR && !isJump&&!S_cooldown) {
			aniSattackR.tick();
			setInvincibility(true);
			g.drawImage(aniSattackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 75),
					(int) (y - handler.getGameCamera().getyOffset() - 147), null);
			if (aniSattackR.getIndex() == 29) {
				aniSattackR.tick();
				aniSattackR.setIndex(0);
				S1 = false;
				setInvincibility(false);
				S_cooldown=true;
			}
		} else if (S2 && LOR && !isJump&&!S2_cooldown) {
			aniS2attackL.tick();
			g.drawImage(aniS2attackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 680,
					(int) (y - handler.getGameCamera().getyOffset()) - 145, null);
			if (aniS2attackL.getIndex() == 23) {
				aniS2attackL.tick();
				aniS2attackL.setIndex(0);
				S2 = false;
				S2_cooldown=true;
			}
		} else if (S2 && !LOR && !isJump&&!S2_cooldown) {
			aniS2attackR.tick();
			g.drawImage(aniS2attackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 75),
					(int) (y - handler.getGameCamera().getyOffset() - 147), null);
			if (aniS2attackR.getIndex() == 23) {
				aniS2attackR.tick();
				aniS2attackR.setIndex(0);
				S2 = false;
				S2_cooldown=true;
			}
		} else if (S3 && LOR && !isJump&&!S3_cooldown) {
			setInvincibility(true);
			aniS3attackL.tick();
			g.drawImage(aniS3attackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 680,
					(int) (y - handler.getGameCamera().getyOffset()) - 145, null);
			if (aniS3attackL.getIndex() == 15) {
				aniS3attackL.tick();
				aniS3attackL.setIndex(0);
				S3 = false;
				S3_cooldown=true;
				setInvincibility(false);
			}
		} else if (S3 && !LOR && !isJump&&!S3_cooldown) {
			setInvincibility(true);
			aniS3attackR.tick();
			g.drawImage(aniS3attackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 75),
					(int) (y - handler.getGameCamera().getyOffset() - 147), null);
			if (aniS3attackR.getIndex() == 15) {
				aniS3attackR.tick();
				aniS3attackR.setIndex(0);
				S3 = false;
				S3_cooldown=true;
				setInvincibility(false);
			}
		} else if (AON && !LOR && !isJump&&!A2_cooldown) {
			aniAttack2R.tick();
			g.drawImage(aniAttack2R.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset())+5,
					(int) (y - handler.getGameCamera().getyOffset()) - 45, null);
			if (aniAttack2R.getIndex() == 7) {
				aniAttack2R.tick();
				aniAttack2R.setIndex(0);
				AON = false;
				A2_cooldown=true;
			}
		} else if (SAC && !LOR&&!A_cooldown) {
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
					(int) (y - handler.getGameCamera().getyOffset()) - (int) (45 + deltaJ), null);
			if (isJump) {
				jump();
			}
			if (aniAttackR.getIndex() == 6) {
				aniAttackR.tick();
				aniAttackR.setIndex(0);
				SAC = false;
				A_cooldown=true;
			}
		} else if (SAC && LOR&&!A_cooldown) {
			aniAttack.tick();
			g.drawImage(aniAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 85,
					(int) (y - handler.getGameCamera().getyOffset()) - (int) (45 + deltaJ), null);
			if (isJump) {
				jump();
			}
			if (aniAttack.getIndex() == 6) {
				aniAttack.tick();
				aniAttack.setIndex(0);
				SAC = false;
				A_cooldown=true;
			}
		} else if (isJump) {
			if (LOR) {
				jump();
				g.drawImage(aniJumpL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);
			} else {
				jump();
				g.drawImage(aniJumpR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);
			}
		} else if (xMove < 0||(LOR&&yMove!=0)) {
			g.drawImage(aniLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 15,
					(int) (y - handler.getGameCamera().getyOffset()), null);
		} else if (xMove > 0||(!LOR&&yMove!=0)) {
			g.drawImage(aniRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 5,
					(int) (y - handler.getGameCamera().getyOffset()), null);
		} else {
			if (LOR) {
				g.drawImage(aniIdleL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
						(int) (y - handler.getGameCamera().getyOffset()), null);
			} else {
				g.drawImage(aniIdleR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 15,
						(int) (y - handler.getGameCamera().getyOffset()), null);
			}
		}
	}
		else {
			AON=false;SAC=false;S1=false;S2=false;isJump=false;S3=false;
			powerJ=0;deltaJ=0;
			aniAttack.setIndex(0);aniAttackR.setIndex(0);aniAttack2.setIndex(0);aniAttack2R.setIndex(0);
			aniSattackL.setIndex(0);aniSattackR.setIndex(0);aniS2attackL.setIndex(0);aniS2attackR.setIndex(0);
			aniS3attackL.setIndex(0);aniS3attackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+10,
					(int)(y-handler.getGameCamera().getyOffset())-4, null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+10,
					 (int)(y-handler.getGameCamera().getyOffset())-4, null);}
		}
		D_effect(g);
		}
		else {if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
				(int)(x-handler.getGameCamera().getxOffset()),
				(int)(y-handler.getGameCamera().getyOffset())+5, null);}
				else{g.drawImage(aniDeadR.getCurrentFrame(), 
						(int)(x-handler.getGameCamera().getxOffset()),
						(int)(y-handler.getGameCamera().getyOffset())+5, null);}}
	}
}
