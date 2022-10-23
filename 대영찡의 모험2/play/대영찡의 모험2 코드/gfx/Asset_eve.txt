package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_eve {

	public static BufferedImage [] player_eve;
	public static BufferedImage [] player_eve_icon;
	public static BufferedImage [] player_eve_idleL;
	public static BufferedImage [] player_eve_idleR;
	public static BufferedImage [] player_eve_hurtL;
	public static BufferedImage [] player_eve_hurtR;
	public static BufferedImage [] player_eve_deadL;
	public static BufferedImage [] player_eve_deadR;
	public static BufferedImage [] player_eve_attackL;	
	public static BufferedImage [] player_eve_attackR;
	public static BufferedImage [] player_eve_attack2L;	
	public static BufferedImage [] player_eve_attack2R;	
	public static BufferedImage [] player_eve_jumpL;
	public static BufferedImage [] player_eve_jumpR;
	public static BufferedImage [] player_eve_moveL;
	public static BufferedImage [] player_eve_moveR;
	public static BufferedImage [] player_eve_SattackL;
	public static BufferedImage [] player_eve_SattackR;
	public static BufferedImage [] player_eve_S2attackL;
	public static BufferedImage [] player_eve_S2attackR;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {eve();}
	public static void eve() {
		player_eve();
		eve_icon();
		eve_hurtL();
		eve_hurtR();
		eve_deadL();
		eve_deadR();
		eve_idleL();
		eve_idleR();
		eve_moveL();
		eve_moveR();
		eve_jumpL();
		eve_jumpR();
		eve_attackL();
		eve_attackR();
		eve_attack2L();
		eve_attack2R();
		eve_SattackL();
		eve_SattackR();
		eve_S2attackL();
		eve_S2attackR();
	}
	public static void player_eve() {
		player_eve=new BufferedImage[1];
		SpriteSheet eve=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve.png"));
		player_eve[0]=eve.crop(0,0,23 ,60);
	}
	public static void eve_icon() {
		player_eve_icon=new BufferedImage[1];
		SpriteSheet eve_icon=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_icon.png"));
		player_eve_icon[0]=eve_icon.crop(0,0,56,38);
	}
	public static void eve_hurtL() {
		player_eve_hurtL=new BufferedImage[1];
		SpriteSheet eve_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_hurt.png"));
		player_eve_hurtL[0]=eve_hurtL.crop(0,0,56,42);
	}
	public static void eve_hurtR() {
		player_eve_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		player_eve_hurtR[0]=IF.horizontalflip(player_eve_hurtL[0]);
	}
	public static void eve_deadL() {
		player_eve_deadL=new BufferedImage[1];
		SpriteSheet eve_deadL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_dead.png"));
		player_eve_deadL[0]=eve_deadL.crop(0,0,70,34);
	}
	public static void eve_deadR() {
		player_eve_deadR=new BufferedImage[1];
		IF=new ImageFlip();
		player_eve_deadR[0]=IF.horizontalflip(player_eve_deadL[0]);
	}
	public static void eve_idleL() {
		player_eve_idleL=new BufferedImage[8];
		SpriteSheet eve_idleL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_idle.png"));
		for(int i=0;i<8;i++) {
			player_eve_idleL[i]=eve_idleL.crop(65*col,77*row ,65 ,77);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	public static void eve_idleR() {
		player_eve_idleR=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {
			player_eve_idleR[i]=IF.horizontalflip(player_eve_idleL[i]);
	}
	}
	public static void eve_moveL() {	
		player_eve_moveL=new BufferedImage[1];
		SpriteSheet eve_moveL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_move.png"));
		player_eve_moveL[0]=eve_moveL.crop(0,0,57 ,62);
		col=0;row=0;
		}
	public static void eve_moveR() {
		player_eve_moveR=new BufferedImage[1];
		IF=new ImageFlip();
		player_eve_moveR[0]=IF.horizontalflip(player_eve_moveL[0]);
	}
	public static void eve_jumpL() {
		player_eve_jumpL=new BufferedImage[1];
		SpriteSheet eve_jumpL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_jump.png"));
		player_eve_jumpL[0]=eve_jumpL.crop(0,0,40 ,63);
		col=0;row=0;
	}
	public static void eve_jumpR() {
		player_eve_jumpR=new BufferedImage[1];
		IF=new ImageFlip();
		player_eve_jumpR[0]=IF.horizontalflip(player_eve_jumpL[0]);
	}
	public static void eve_attackL() {
		player_eve_attackL=new BufferedImage[7];
		SpriteSheet eve_attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_attack.png"));
		for(int i=0;i<7;i++) {
			player_eve_attackL[i]=eve_attackL.crop(306*col,236*row ,306 ,236);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	public static void eve_attackR() {
		player_eve_attackR=new BufferedImage[7];
		IF=new ImageFlip();
		for(int i=0;i<7;i++) {
			player_eve_attackR[i]=IF.horizontalflip(player_eve_attackL[i]);
	}
	}
	public static void eve_attack2L() {
		col=1;row=2;
		player_eve_attack2L=new BufferedImage[8];
		SpriteSheet eve_attack2L=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_attack.png"));
		for(int i=0;i<8;i++) {
			player_eve_attack2L[i]=eve_attack2L.crop(306*col,236*row ,306 ,236);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	public static void eve_attack2R() {
		player_eve_attack2R=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {
			player_eve_attack2R[i]=IF.horizontalflip(player_eve_attack2L[i]);
	}
	}
	public static void eve_SattackL() {
		row=5;
		player_eve_SattackL=new BufferedImage[8];
		SpriteSheet eve_SattackL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_attack.png"));
		for(int i=0;i<8;i++) {
			player_eve_SattackL[i]=eve_SattackL.crop(306*col,236*row ,306 ,236);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	public static void eve_SattackR() {
		player_eve_SattackR=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {
			player_eve_SattackR[i]=IF.horizontalflip(player_eve_SattackL[i]);
	}
	}
	public static void eve_S2attackL() {
		player_eve_S2attackL=new BufferedImage[36];
		SpriteSheet eve_S2attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/eve/eve_Sattack.png"));
		for(int i=0;i<36;i++) {
			player_eve_S2attackL[i]=eve_S2attackL.crop(180*col,216*row ,180 ,216);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	public static void eve_S2attackR() {
		player_eve_S2attackR=new BufferedImage[36];
		IF=new ImageFlip();
		for(int i=0;i<36;i++) {
			player_eve_S2attackR[i]=IF.horizontalflip(player_eve_S2attackL[i]);
	}
	}
	
}
