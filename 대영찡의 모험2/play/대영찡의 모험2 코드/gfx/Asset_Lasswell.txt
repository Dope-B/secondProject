package gfx;
import java.awt.image.BufferedImage;
import utils.ImageFlip;

public class Asset_Lasswell {

	public static BufferedImage[] player_lasswell;
	public static BufferedImage[] player_lasswell_icon;
	public static BufferedImage[] player_lasswell_hurtL;
	public static BufferedImage[] player_lasswell_hurtR;
	public static BufferedImage[] player_lasswell_deadL;
	public static BufferedImage[] player_lasswell_deadR;
	public static BufferedImage [] player_lasswell_idleL;
	public static BufferedImage [] player_lasswell_idleR;
	public static BufferedImage [] player_lasswell_attackL;	
	public static BufferedImage [] player_lasswell_attackR;
	public static BufferedImage [] player_lasswell_attack2L;	
	public static BufferedImage [] player_lasswell_attack2R;	
	public static BufferedImage [] player_lasswell_jumpL;
	public static BufferedImage [] player_lasswell_jumpR;
	public static BufferedImage [] player_lasswell_moveL;
	public static BufferedImage [] player_lasswell_moveR;
	public static BufferedImage [] player_lasswell_SattackL;
	public static BufferedImage [] player_lasswell_SattackR;
	public static BufferedImage [] player_lasswell_S2attackL;
	public static BufferedImage [] player_lasswell_S2attackR;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {
		lasswell();
		
	}
	private static void lasswell() {
		player_lasswell();
		lasswell_icon();
		lasswell_hurtL();
		lasswell_hurtR();
		lasswell_deadL();
		lasswell_deadR();
		lasswell_idleL();
		lasswell_idleR();
		lasswell_attackL();
		lasswell_attackR();
		lasswell_SattackL();
		lasswell_SattackR();
		lasswell_S2attackL();
		lasswell_S2attackR();
		lasswell_attack2L();
		lasswell_attack2R();
		lasswell_jumpL();
		lasswell_jumpR();
		lasswell_moveR();
		lasswell_moveL();
	}
	public static void player_lasswell() {
		player_lasswell=new BufferedImage[1];
		SpriteSheet lasswell=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell.png"));
		player_lasswell[0]=lasswell.crop(0,0,54 ,51);
	}
	public static void lasswell_icon() {
		player_lasswell_icon=new BufferedImage[1];
		SpriteSheet lasswell_icon=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_icon.png"));
		player_lasswell_icon[0]=lasswell_icon.crop(0,0,56,38);
	}
	public static void lasswell_hurtL() {
		player_lasswell_hurtL=new BufferedImage[1];
		SpriteSheet lasswell_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_hurt.png"));
		player_lasswell_hurtL[0]=lasswell_hurtL.crop(0,0,67,54);
	}
	public static void lasswell_hurtR() {
		player_lasswell_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		player_lasswell_hurtR[0]=IF.horizontalflip(player_lasswell_hurtL[0]);
	}
	public static void lasswell_deadL() {
		player_lasswell_deadL=new BufferedImage[1];
		SpriteSheet heltich_deadL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_dead.png"));
		player_lasswell_deadL[0]=heltich_deadL.crop(0,0,94,35);
	}
	public static void lasswell_deadR() {
		player_lasswell_deadR=new BufferedImage[1];
		IF=new ImageFlip();
		player_lasswell_deadR[0]=IF.horizontalflip(player_lasswell_deadL[0]);
	}
	private static void lasswell_idleL() {
		player_lasswell_idleL=new BufferedImage[4];
		SpriteSheet lasswell_idleL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_idle.png"));
		for(int i=0;i<4;i++) {
			player_lasswell_idleL[i]=lasswell_idleL.crop(63*col,65*row ,63 ,65);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void lasswell_idleR() {
		player_lasswell_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			player_lasswell_idleR[i]=IF.horizontalflip(player_lasswell_idleL[i]);
		}
	}
	private static void lasswell_attackL() {
		player_lasswell_attackL=new BufferedImage[6];
		SpriteSheet lasswell_attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_attack.png"));
		for(int i=0;i<6;i++) {
			player_lasswell_attackL[i]=lasswell_attackL.crop(226*col,68*row ,226 ,68);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void lasswell_attackR() {
		player_lasswell_attackR=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<6;i++) {
			player_lasswell_attackR[i]=IF.horizontalflip(player_lasswell_attackL[i]);
		}
	}
	private static void lasswell_attack2L() {
		player_lasswell_attack2L=new BufferedImage[6];
		SpriteSheet lasswell_attack2L=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_S2attack.png"));
		for(int i=0;i<6;i++) {
			player_lasswell_attack2L[i]=lasswell_attack2L.crop(116*col,87*row ,116 ,87);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void lasswell_attack2R() {
		player_lasswell_attack2R=new BufferedImage[6];
		IF=new ImageFlip();
		for(int i=0;i<6;i++) {
			player_lasswell_attack2R[i]=IF.horizontalflip(player_lasswell_attack2L[i]);
		}
	}
	private static void lasswell_SattackL() {
		player_lasswell_SattackL=new BufferedImage[7];
		SpriteSheet lasswell_SattackL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_attack2.png"));
		for(int i=0;i<7;i++) {
			if(i<=2) {
			player_lasswell_SattackL[i]=lasswell_SattackL.crop(358*col,85*row ,358 ,85);}
			else {player_lasswell_SattackL[i]=lasswell_SattackL.crop(358*col,85*row-5 ,358 ,85);}
			if(col==2) {col=0;row++;}
			else{col++;}
		}

		col=0;row=0;
	}
	private static void lasswell_SattackR() {
		player_lasswell_SattackR=new BufferedImage[7];
		IF=new ImageFlip();
		for(int i=0;i<7;i++) {
			player_lasswell_SattackR[i]=IF.horizontalflip(player_lasswell_SattackL[i]);
		}
	}
	private static void lasswell_S2attackL() {
		player_lasswell_S2attackL=new BufferedImage[9];
		SpriteSheet lasswell_S2attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_Sattack.png"));
		for(int i=0;i<9;i++) {
			player_lasswell_S2attackL[i]=lasswell_S2attackL.crop(442*col,188*row ,442 ,188);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void lasswell_S2attackR() {
		player_lasswell_S2attackR=new BufferedImage[9];
		IF=new ImageFlip();
		for(int i=0;i<9;i++) {
			player_lasswell_S2attackR[i]=IF.horizontalflip(player_lasswell_S2attackL[i]);
		}
	}
	private static void lasswell_jumpL() {
		player_lasswell_jumpL=new BufferedImage[1];
		SpriteSheet lasswell_jumpL=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_jump.png"));
		player_lasswell_jumpL[0]=lasswell_jumpL.crop(0, 0, 65, 59);
	}
	private static void lasswell_jumpR() {
		player_lasswell_jumpR=new BufferedImage[1];
		IF=new ImageFlip();
		player_lasswell_jumpR[0]=IF.horizontalflip(player_lasswell_jumpL[0]);
	}
	private static void lasswell_moveL() {
		player_lasswell_moveL=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			player_lasswell_moveL[i]=IF.horizontalflip(player_lasswell_moveR[i]);
		}
	}
	private static void lasswell_moveR() {
		player_lasswell_moveR=new BufferedImage[4];
		SpriteSheet lasswell_moveR=new SpriteSheet(ImageLoader.loadImage("textures/player/lasswell/lasswell_move.png"));
		for(int i=0;i<4;i++) {
			player_lasswell_moveR[i]=lasswell_moveR.crop(65*col,64*row ,65 ,64);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
}
