package Creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_effect;
import gfx.Asset_heltich;

public class Player_heltich extends Creature {

	private Animation aniIdleL;
	private Animation aniIdleR;
	private Animation aniMoveL;
	private Animation aniMoveR;
	private Animation aniJumpL;
	private Animation aniJumpR;
	private Animation aniAttackL;
	private Animation aniAttack2L;
	private Animation aniAttackR;
	private Animation aniAttack2R;
	private Animation aniSattackL;
	private Animation aniSattackR;
	private Animation aniS2attackL;
	private Animation aniS2attackR;
	private Animation aniS3attackL;
	private Animation aniS3attackR;
	private Animation[] aniS3_bolt;
	private Animation aniS2_fire;
	private Animation aniS_iceL;
	private Animation aniS_iceR;
	private Animation aniHurtL;
	private Animation aniHurtR;
	private Animation aniDeadL;
	private Animation aniDeadR;
	private boolean LOR = false;// ����=true ������= false
	private boolean AON = false;// �⺻ ����
	private boolean SAC = false;// �÷� ����
	private boolean S1 = false;// Ư������ 1
	private boolean S2 = false;// Ư������ 2
	private boolean S3 = false;// Ư������ 3
	private boolean act_S1L = false;// ��ų ����Ʈ ��� ����
	private boolean act_S1R = false;
	private boolean act_S2L = false;
	private boolean act_S2R = false;
	private boolean act_S3L = false;
	private boolean act_S3R = false;
	private boolean resetloc=false;// ��ų ����Ʈ ��� ��ǥ ���� ����
	private float s_x;// ��ų ����Ʈ ��� ��ǥ
	private float s_y;
	private float s2_x;
	private float s2_y;
	private float s3_x;
	private float s3_y;
	private int del_x[];//���� ��ų ��ǥ
	private int del_y[];
	private int S1_repeat = 0;//1�� ��ų �ݺ� Ƚ��

	public Player_heltich(Handler handler, float x, float y) {
		super(handler, x, y, 64, 64);
		health=450;
		MAX_health=450;
		bounds.x = 25;
		bounds.y = bounds.height - 18;
		bounds.width = 35;
		bounds.height = 10;
		aniIdleL = new Animation(100, Asset_heltich.player_heltich_idleL);//�ൿ �� �̹��� ����
		aniMoveL = new Animation(100, Asset_heltich.player_heltich_moveL);
		aniMoveR = new Animation(100, Asset_heltich.player_heltich_moveR);
		aniIdleR = new Animation(100, Asset_heltich.player_heltich_idleR);
		aniAttackL = new Animation(100, Asset_heltich.player_heltich_attackL);
		aniAttack2L = new Animation(100, Asset_heltich.player_heltich_attack2L);
		aniAttackR = new Animation(100, Asset_heltich.player_heltich_attackR);
		aniAttack2R = new Animation(100, Asset_heltich.player_heltich_attack2R);
		aniJumpL = new Animation(0, Asset_heltich.player_heltich_jumpL);
		aniJumpR = new Animation(0, Asset_heltich.player_heltich_jumpR);
		aniSattackL = new Animation(100, Asset_heltich.player_heltich_SattackL);
		aniSattackR = new Animation(100, Asset_heltich.player_heltich_SattackR);
		aniS2attackL = new Animation(100, Asset_heltich.player_heltich_S2attackL);
		aniS2attackR = new Animation(100, Asset_heltich.player_heltich_S2attackR);
		aniS3attackL = new Animation(90, Asset_heltich.player_heltich_S3attackL);
		aniS3attackR = new Animation(90, Asset_heltich.player_heltich_S3attackR);
		aniHurtL=new Animation(0,Asset_heltich.player_heltich_hurtL);
		aniHurtR=new Animation(0,Asset_heltich.player_heltich_hurtR);
		aniDeadL=new Animation(0,Asset_heltich.player_heltich_deadL);
		aniDeadR=new Animation(0,Asset_heltich.player_heltich_deadR);
		aniS3_bolt = new Animation[15];//���� ��ų �̹��� �迭�� ����
		del_x=new int[15];
		del_y=new int[15];
		for (int i = 0; i < 15; i++) {
			aniS3_bolt[i] = new Animation(60, Asset_effect.bolt);
			del_x[i]=(int) ((Math.random() * 200) - 120);//������ ��ǥ ����
			del_y[i]=(int) ((Math.random() * 150) - 40);
		}
		aniS2_fire = new Animation(60, Asset_effect.fire);
		aniS_iceL = new Animation(80, Asset_effect.iceDragonL);
		aniS_iceR = new Animation(80, Asset_effect.iceDragonR);
	}

	public void tick() {
		if(active) {// ���� �� ���
		getInput();//Ű�� �Է¹���
		aniIdleL.tick();//������ ���
		aniIdleR.tick();
		aniMoveL.tick();
		aniMoveR.tick();
		damage_sound();//�ǰ� �� �Ҹ�
		move();//Ű �Է¿����� ������
		handler.getGameCamera().centerOnEntity(this);//ī�޶� ������
		if(A_cooldown) {A_cooldown(20);AON=false;}//��ų ��뿡���� ��Ÿ��
		if(A2_cooldown) {A2_cooldown(20);SAC=false;}
		if(S_cooldown) {S_cooldown(600);S1=false;}
		if(S2_cooldown) {S2_cooldown(250);S2=false;}
		if(S3_cooldown) {S3_cooldown(350);S3=false;}
		hurtDelay();}//�ǰ� �� ������
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(!isHurt) {//�ǰ� �� �Է��� ���� �ʴ´� 
		if (handler.getKeyManager().left) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				xMove = -speed;//x��ǥ�� -
				LOR = true;//������ �ٶ�
			}
		}
		if (handler.getKeyManager().right) {
			if ((!AON && !SAC && !S1 && !S2 && !S3) || (isJump && SAC)) {
				xMove = +speed;//x��ǥ�� +
				LOR = false;//������ �ٶ�
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
		if (handler.getKeyManager().attack) {//���� Ű �Է½� 
			if (!SAC && !isJump && !S1 && !S2 && !S3) {
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
			if (!AON && !S1 && !S2 && !S3&&!isJump) {
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
		if (handler.getKeyManager().jump) {//���� �Է� �� 
			if (!AON && !SAC && !S1 && !S2 && !S3) {
				if(!isJump) {
				isJump = true;sound.jump();}
			}
		}
		if (handler.getKeyManager().Sattack) {
			if (!AON && !SAC && !S2 && !S3 && !isJump && !act_S1L && !act_S1R) {
				S1 = true;
			}
		}
		if (handler.getKeyManager().S2attack) {
			if (!AON && !SAC && !S1 && !S3 && !isJump && !act_S2L && !act_S2R) {
				S2 = true;
			}
		}
		if (handler.getKeyManager().S3attack) {
			if (!AON && !SAC && !S1 && !S2 && !isJump && !act_S3L && !act_S3R) {
				S3 = true;
			}
		}}

	}
	
	protected void checkHitbox() {//��Ʈ�ڽ� üũ
		
		hitBox=new Rectangle();//��Ʈ�ڽ� ���� ����
		if(aniAttackL.getIndex()==4) {//�ε��� ��ȣ�� ���� �������� ���� ����
			sound.woosh();//ȿ����
			hitBox.x=bounds.x+bounds.width/2-100;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=80;
			hitBox.height=20;
			checkEne(40);//������
			
		}
		else if(aniAttackR.getIndex()==4) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-10;
			hitBox.width=80;
			hitBox.height=20;
			checkEne(40);
			
		}
		else if(aniAttack2L.getIndex()==4) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2-110;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			checkEne(50);
		
		}
		else if(aniAttack2R.getIndex()==4) {
			sound.woosh();
			hitBox.x=bounds.x+bounds.width/2+20;
			hitBox.y=bounds.y+bounds.height/2-5;
			hitBox.width=90;
			hitBox.height=10;
			checkEne(50);
			
		}
		
		else if(aniS_iceL.getIndex()>=2&&aniS_iceL.getIndex()<=6) {
			sound.wave();
			hitBox.x=(int)s_x-230;
			hitBox.y=(int)s_y+10;
			hitBox.width=230;
			hitBox.height=60;
			checkEne_m(180);
			
		}
		
		else if(aniS_iceR.getIndex()>=2&&aniS_iceR.getIndex()<=6) {
			sound.wave();
			hitBox.x=(int)s_x+80;
			hitBox.y=(int)s_y+10;
			hitBox.width=230;
			hitBox.height=60;
			checkEne_m(180);
			
		}
		
		else if(aniS2_fire.getIndex()>=8&&aniS2_fire.getIndex()<=15) {
			sound.cast_fire();
				if(act_S2L) {
					hitBox.x=(int)s2_x-140;
					hitBox.y=(int)s2_y+40;
					hitBox.width=115;
					hitBox.height=45;
					checkEne_m(250);
					}
				else {
					hitBox.x=(int)s2_x+120;
					hitBox.y=(int)s2_y+40;
					hitBox.width=115;
					hitBox.height=45;
					checkEne_m(250);
					
				}
		}
		else if(act_S3L) {
			for(int i=0;i<15;i++) {
				sound.thunder();
			hitBox.x=(int)s3_x+del_x[i]-200;
			hitBox.y=(int)s3_y+del_y[i];
			hitBox.width=40;
			hitBox.height=30;
			checkEne_m(350);
			}
		}
		else if(act_S3R) {
			for(int i=0;i<15;i++) {
				sound.thunder();
			hitBox.x=(int)s3_x+del_x[i]+250;
			hitBox.y=(int)s3_y+del_y[i];
			hitBox.width=40;
			hitBox.height=30;
			checkEne_m(350);
			}
			}
		else {hitBox.x=0;hitBox.width=0;hitBox.y=0;hitBox.height=0;
		check_eD();sound.isPlayed=false;sound.isPlayed_magic1=false;sound.isPlayed_magic2=false;}//üũ�ڽ� �� ������ �Ҹ� ��� ���� false, �� �ǰ����� false
	}

	public void render(Graphics g) {
		if(active) {//���� �� ���
		checkHitbox();//��Ʈ�ڽ� üũ
		if(!isHurt) {//�� �ǰ� �� ���
		if (SAC && LOR && !isJump&&!A_cooldown) {//���� ��� ���
			aniAttackL.tick();
			g.drawImage(aniAttackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 80,
					(int) (y - handler.getGameCamera().getyOffset()) - 35, null);
			if (aniAttackL.getIndex() == 6) {//�ε��� ��ȣ�� 6���̸� ����
				aniAttackL.tick();
				aniAttackL.setIndex(0);
				SAC = false;//���� ���θ� false�� �ٲ�
				A_cooldown=true;//��Ÿ�� ����
			}
		} else if (SAC && !LOR && !isJump&&!A_cooldown) {
			aniAttackR.tick();
			g.drawImage(aniAttackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 25,
					(int) (y - handler.getGameCamera().getyOffset()) - 35, null);
			if (aniAttackR.getIndex() == 6) {
				aniAttackR.tick();
				aniAttackR.setIndex(0);
				SAC = false;
				A_cooldown=true;
			}
		} else if (AON && LOR && !isJump&&!A2_cooldown) {
			aniAttack2L.tick();
			g.drawImage(aniAttack2L.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 80,
					(int) (y - handler.getGameCamera().getyOffset()) - 35, null);

			if (aniAttack2L.getIndex() == 8) {
				aniAttack2L.tick();
				aniAttack2L.setIndex(0);
				AON = false;
				A2_cooldown=true;
			}
		} else if (AON && !LOR && !isJump&&!A2_cooldown) {
			aniAttack2R.tick();
			g.drawImage(aniAttack2R.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 25,
					(int) (y - handler.getGameCamera().getyOffset()) - 35, null);
			if (aniAttack2R.getIndex() == 8) {
				aniAttack2R.tick();
				aniAttack2R.setIndex(0);
				AON = false;
				A2_cooldown=true;
			}
		} else if (S1 && LOR && !isJump&&!S_cooldown) {
			aniSattackL.tick();
			g.drawImage(aniSattackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 25,
					(int) (y - handler.getGameCamera().getyOffset()) - 12, null);
			if (aniSattackL.getIndex() == 3) {
				aniSattackL.tick();
				aniSattackL.setIndex(0);
				S1 = false;
				s_x = x;//��ų ����Ʈ ��ġ ����
				s_y = y;
				act_S1L = true;//��ų ����Ʈ ��� 
				S_cooldown=true;
			}

		} else if (S1 && !LOR && !isJump&&!S_cooldown) {
			aniSattackR.tick();
			g.drawImage(aniSattackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 15,
					(int) (y - handler.getGameCamera().getyOffset()) - 15, null);
			if (aniSattackR.getIndex() == 3) {
				aniSattackR.tick();
				aniSattackR.setIndex(0);
				S1 = false;
				s_x = x;
				s_y = y;
				act_S1R = true;
				S_cooldown=true;
			}
		} else if (S2 && LOR && !isJump&&!S2_cooldown) {
			aniS2attackL.tick();
			g.drawImage(aniS2attackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 14,
					(int) (y - handler.getGameCamera().getyOffset()) - 30, null);
			if (aniS2attackL.getIndex() == 3) {
				aniS2attackL.tick();
				aniS2attackL.setIndex(0);
				S2 = false;
				s2_x = x;
				s2_y = y;
				act_S2L = true;
				S2_cooldown=true;
			}
		} else if (S2 && !LOR && !isJump&&!S2_cooldown) {
			aniS2attackR.tick();
			g.drawImage(aniS2attackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 15,
					(int) (y - handler.getGameCamera().getyOffset()) - 30, null);
			if (aniS2attackR.getIndex() == 3) {
				aniS2attackR.tick();
				aniS2attackR.setIndex(0);
				S2 = false;
				s2_x = x;
				s2_y = y;
				act_S2R = true;
				S2_cooldown=true;
			}
		} else if (S3 && LOR && !isJump&&!S3_cooldown) {
			setInvincibility(true);//����
			aniS3attackL.tick();
			g.drawImage(aniS3attackL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 55,
					(int) (y - handler.getGameCamera().getyOffset()) - 95, null);
			if (aniS3attackL.getIndex() == 20) {
				s3_x = x;
				s3_y = y;
				act_S3L = true;
			}
			if (aniS3attackL.getIndex() == 28) {
				aniS3attackL.tick();
				aniS3attackL.setIndex(0);
				S3 = false;
				S3_cooldown=true;
				setInvincibility(false);
			}
		} else if (S3 && !LOR && !isJump&&!S3_cooldown) {
			setInvincibility(true);
			aniS3attackR.tick();
			g.drawImage(aniS3attackR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 35,
					(int) (y - handler.getGameCamera().getyOffset()) - 95, null);
			if (aniS3attackR.getIndex() == 20) {
				s3_x = x;
				s3_y = y;
				act_S3R = true;
			}
			if (aniS3attackR.getIndex() == 28) {
				aniS3attackR.tick();
				aniS3attackR.setIndex(0);
				S3 = false;
				S3_cooldown=true;
				setInvincibility(false);
			}
		}

		else if (isJump) {
			if (LOR) {
				jump();
				g.drawImage(aniJumpL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 5,
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);//���� �� deltaJ��ŭ y�� ��ȭ
			} else {
				jump();
				g.drawImage(aniJumpR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 15,
						(int) (y - handler.getGameCamera().getyOffset() - deltaJ), null);
			}
		} else if (xMove < 0||(LOR&&yMove!=0)) {
			g.drawImage(aniMoveL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) - 5,
					(int) (y - handler.getGameCamera().getyOffset()) - 10, null);
		} else if (xMove > 0||(!LOR&&yMove!=0)) {
			g.drawImage(aniMoveR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 5,
					(int) (y - handler.getGameCamera().getyOffset()) - 10, null);
		} else {
			if (LOR) {//������ �� 
				g.drawImage(aniIdleL.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 5,
						(int) (y - handler.getGameCamera().getyOffset()) - 15, null);
			} else {//�������� ��
				g.drawImage(aniIdleR.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()) + 5,
						(int) (y - handler.getGameCamera().getyOffset()) - 15, null);
			}
		}
		}
		else {//�ǰ� ��
			AON=false;SAC=false;S1=false;S2=false;S3=false;isJump=false;//���� ���� false 
			powerJ=0;deltaJ=0;//���� ���
			aniAttackL.setIndex(0);aniAttackR.setIndex(0);aniAttack2L.setIndex(0);aniAttack2R.setIndex(0);//���� �ε��� 0
			aniSattackL.setIndex(0);aniSattackR.setIndex(0);aniS2attackL.setIndex(0);aniS2attackR.setIndex(0);
			aniS3attackL.setIndex(0);aniS3attackR.setIndex(0);
			if(LOR) {g.drawImage(aniHurtL.getCurrentFrame(), //�ǰ� �̹��� ���
					(int)(x-handler.getGameCamera().getxOffset())+5,
					(int)(y-handler.getGameCamera().getyOffset()), null);}
			else {g.drawImage(aniHurtR.getCurrentFrame(), 
					 (int)(x-handler.getGameCamera().getxOffset())+5,
					 (int)(y-handler.getGameCamera().getyOffset()), null);}
		}
		}
		else {//��� ��
			if(LOR) {g.drawImage(aniDeadL.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())+5,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);}
			else{g.drawImage(aniDeadR.getCurrentFrame(), 
					(int)(x-handler.getGameCamera().getxOffset())-5,
					(int)(y-handler.getGameCamera().getyOffset())+20, null);}
		}
		if (act_S1L) {//��ų ����Ʈ ���

			aniS_iceL.tick();
			g.drawImage(aniS_iceL.getCurrentFrame(),
					(int) (s_x - handler.getGameCamera().getxOffset()) - 220,
					(int) (s_y - handler.getGameCamera().getyOffset()) - 100, null);
			if (aniS_iceL.getIndex() == 9) {
				aniS_iceL.tick();
				aniS_iceL.setIndex(0);
				S1_repeat++;
				s_x-=120;//��ġ ����
				if (S1_repeat == 3) {//�� 3�� �ݺ�
					act_S1L = false;
					S1_repeat = 0;
				}
			}

		} else if (act_S1R) {
			aniS_iceR.tick();
			g.drawImage(aniS_iceR.getCurrentFrame(),
					(int) (s_x - handler.getGameCamera().getxOffset()) + 95,
					(int) (s_y - handler.getGameCamera().getyOffset()) - 100, null);
			if (aniS_iceR.getIndex() == 9) {
				aniS_iceR.tick();
				aniS_iceR.setIndex(0);
				S1_repeat++;
				s_x+=120;
				if (S1_repeat == 3) {
					act_S1R = false;
					S1_repeat = 0;
				}
			}
		} else {
			aniS_iceL.setIndex(0);
			aniS_iceR.setIndex(0);
		}
		if (act_S2L) {
			aniS2_fire.tick();
			g.drawImage(aniS2_fire.getCurrentFrame(), (int) (s2_x - handler.getGameCamera().getxOffset()) + 14 - 180,
					(int) (s2_y - handler.getGameCamera().getyOffset()) - 30, null);
			if (aniS2_fire.getIndex() == 18) {
				aniS2_fire.tick();
				aniS2_fire.setIndex(0);
				act_S2L = false;
			}
		} else if (act_S2R) {
			aniS2_fire.tick();
			g.drawImage(aniS2_fire.getCurrentFrame(), (int) (s2_x - handler.getGameCamera().getxOffset()) + 15 + 80,
					(int) (s2_y - handler.getGameCamera().getyOffset()) - 30, null);
			if (aniS2_fire.getIndex() == 18) {
				aniS2_fire.tick();
				aniS2_fire.setIndex(0);
				act_S2R = false;
			}
		} else {
			aniS2_fire.setIndex(0);
		}
		if (act_S3L) {
			if(resetloc) {//�������� ��ġ ����
				for(int i=0;i<15;i++) {
				del_x[i]=(int)((Math.random() * 200) -120);
				del_y[i]=(int)((Math.random() * 150) - 40);}
				resetloc=false;
			}
			for (int i = 0; i < 15; i++) {
				aniS3_bolt[i].tick();
				g.drawImage(aniS3_bolt[i].getCurrentFrame(),
						(int) (s3_x - handler.getGameCamera().getxOffset()) - 240 - del_x[i],
						(int) (s3_y - handler.getGameCamera().getyOffset()) - 250 + del_y[i], null);
				if (aniS3_bolt[i].getIndex() == 7) {
					aniS3_bolt[i].tick();
					aniS3_bolt[i].setIndex(0);
					act_S3L = false;
					resetloc=true;
				}
			}
		} else if (act_S3R) {
			if(resetloc) {
				for(int i=0;i<15;i++) {
				del_x[i]=(int)((Math.random() * 200) -120);
				del_y[i]=(int)((Math.random() * 150) -40);}
				resetloc=false;
			}
			for (int i = 0; i < 15; i++) {
				aniS3_bolt[i].tick();
				g.drawImage(aniS3_bolt[i].getCurrentFrame(),
						(int) (s3_x - handler.getGameCamera().getxOffset()) +240 + del_x[i],
						(int) (s3_y - handler.getGameCamera().getyOffset()) - 250 + del_y[i], null);
				if (aniS3_bolt[i].getIndex() == 7) {
					aniS3_bolt[i].tick();
					aniS3_bolt[i].setIndex(0);
					act_S3R = false;
					resetloc=true;
				}
			}
		} else {
			for (int i = 0; i < 15; i++) {
				aniS3_bolt[i].setIndex(0);
			}
		}
		D_effect(g);//�ǰ� ����Ʈ
	}

}
