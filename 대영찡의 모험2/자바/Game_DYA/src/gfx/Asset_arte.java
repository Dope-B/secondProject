package gfx;

import java.awt.image.BufferedImage;
import utils.ImageFlip;

public class Asset_arte {
	public static BufferedImage [] player_arte;
	public static BufferedImage [] player_arte_icon;
	public static BufferedImage [] player_arte_idleL;
	public static BufferedImage [] player_arte_idleR;
	public static BufferedImage [] player_arte_attackL;	
	public static BufferedImage [] player_arte_attackR;
	public static BufferedImage [] player_arte_attack2L;	
	public static BufferedImage [] player_arte_attack2R;	
	public static BufferedImage [] player_arte_jumpL;
	public static BufferedImage [] player_arte_jumpR;
	public static BufferedImage [] player_arte_moveL;
	public static BufferedImage [] player_arte_moveR;
	public static BufferedImage [] player_arte_SattackL;
	public static BufferedImage [] player_arte_SattackR;
	public static BufferedImage [] player_arte_hurtL;
	public static BufferedImage [] player_arte_hurtR;
	public static BufferedImage [] player_arte_deadL;
	public static BufferedImage [] player_arte_deadR;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {arte();}
	private static void arte() {
		player_arte();
		arte_icon();
		arte_idleL();
		arte_idleR();
		arte_moveL();
		arte_moveR();
		arte_jumpL();
		arte_jumpR();
		arte_hurtL();
		arte_hurtR();
		arte_deadL();
		arte_deadR();
		arte_attackL();
		arte_attackR();
		arte_attack2L();
		arte_attack2R();
		arte_SattackL();
		arte_SattackR();
	}
	private static void player_arte() {
		player_arte=new BufferedImage[1];
		SpriteSheet arte=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte.png"));
			player_arte[0]=arte.crop(0,0 ,81 ,72);
	}
	private static void arte_icon() {
		player_arte_icon=new BufferedImage[1];
		SpriteSheet arte_icon=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_icon.png"));
			player_arte_icon[0]=arte_icon.crop(0,0 ,56 ,38);
	}
	private static void arte_idleL() {
		player_arte_idleL=new BufferedImage[4];
		SpriteSheet arte_idleL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_idle.png"));
		for(int i=0;i<4;i++) {
			player_arte_idleL[i]=arte_idleL.crop(72*col,66*row ,72 ,66);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void arte_idleR() {
		player_arte_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			player_arte_idleR[i]=IF.horizontalflip(player_arte_idleL[i]);
		}
	}
	private static void arte_moveL() {
		player_arte_moveL=new BufferedImage[1];
		SpriteSheet arte_moveL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_move.png"));
			player_arte_moveL[0]=arte_moveL.crop(0,0 ,78 ,53);
		
	}
	private static void arte_moveR() {
		player_arte_moveR=new BufferedImage[1];
		IF=new ImageFlip();
		player_arte_moveR[0]=IF.horizontalflip(player_arte_moveL[0]);
		
	}
	private static void arte_hurtL() {
		player_arte_hurtL=new BufferedImage[1];
		SpriteSheet arte_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_hurt.png"));
			player_arte_hurtL[0]=arte_hurtL.crop(0,0 ,71 ,51);
		
	}
	private static void arte_hurtR() {
		player_arte_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		player_arte_hurtR[0]=IF.horizontalflip(player_arte_hurtL[0]);
		
	}
	private static void arte_deadL() {
		player_arte_deadL=new BufferedImage[1];
		SpriteSheet arte_deadL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_dead.png"));
			player_arte_deadL[0]=arte_deadL.crop(0,0 ,60 ,36);
		
	}
	private static void arte_deadR() {
		player_arte_deadR=new BufferedImage[1];
		IF=new ImageFlip();
		player_arte_deadR[0]=IF.horizontalflip(player_arte_deadL[0]);
		
	}
	private static void arte_jumpL() {
		player_arte_jumpL=new BufferedImage[1];
		SpriteSheet arte_jumpL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_jump.png"));
			player_arte_jumpL[0]=arte_jumpL.crop(0,0 ,71 ,53);
	}
	private static void arte_jumpR() {
		player_arte_jumpR=new BufferedImage[1];
		IF=new ImageFlip();
		player_arte_jumpR[0]=IF.horizontalflip(player_arte_jumpL[0]);
	}
	private static void arte_attackL() {
		player_arte_attackL=new BufferedImage[7];
		SpriteSheet arte_attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_attack.png"));
		for(int i=0;i<7;i++) {
			player_arte_attackL[i]=arte_attackL.crop(183*col,82*row ,183 ,82);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void arte_attackR() {
		player_arte_attackR=new BufferedImage[7];
		IF=new ImageFlip();
		for(int i=0;i<7;i++) {
			player_arte_attackR[i]=IF.horizontalflip(player_arte_attackL[i]);
		}
	}
	private static void arte_attack2L() {
		player_arte_attack2L=new BufferedImage[15];
		SpriteSheet arte_attack2L=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_attack.png"));
		for(int i=0;i<15;i++) {
			player_arte_attack2L[i]=arte_attack2L.crop(183*col,82*row ,183 ,82);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void arte_attack2R() {
		player_arte_attack2R=new BufferedImage[15];
		IF=new ImageFlip();
		for(int i=0;i<15;i++) {
			player_arte_attack2R[i]=IF.horizontalflip(player_arte_attack2L[i]);
		}
	}
	private static void arte_SattackL() {
		player_arte_SattackL=new BufferedImage[33];
		SpriteSheet arte_SattackL=new SpriteSheet(ImageLoader.loadImage("textures/player/arte/arte_Sattack.png"));
		for(int i=0;i<33;i++) {
			player_arte_SattackL[i]=arte_SattackL.crop(240*col,166*row ,240 ,166);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void arte_SattackR() {
		player_arte_SattackR=new BufferedImage[33];
		IF=new ImageFlip();
		for(int i=0;i<33;i++) {
			player_arte_SattackR[i]=IF.horizontalflip(player_arte_SattackL[i]);
		}
	}
}
