package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_glauca {


	public static BufferedImage[] enemy_glauca_idleL;
	public static BufferedImage[] enemy_glauca_idleR;
	public static BufferedImage[] enemy_glauca_moveL;
	public static BufferedImage[] enemy_glauca_moveR;
	public static BufferedImage[] enemy_glauca_attackL;
	public static BufferedImage[] enemy_glauca_attackR;
	public static BufferedImage[] enemy_glauca_deadL;
	public static BufferedImage[] enemy_glauca_deadR;
	public static BufferedImage[] enemy_glauca_hurtL;
	public static BufferedImage[] enemy_glauca_hurtR;
	public static BufferedImage[] enemy_glauca_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {glauca();}
	public static void glauca() {
		glauca_idleL();
		glauca_idleR();
		glauca_moveL();
		glauca_moveR();
		glauca_attackL();
		glauca_attackR();
		glauca_deadL();
		glauca_deadR();
		glauca_hurtL();
		glauca_hurtR();
		glauca_icon();
	}
	private static void glauca_idleL() {
		enemy_glauca_idleL=new BufferedImage[4];
		SpriteSheet glauca_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_glauca_idleL[i]=glauca_idleL.crop(130*col,109*row ,130 ,109);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void glauca_idleR() {
		enemy_glauca_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_glauca_idleR[i]=IF.horizontalflip(enemy_glauca_idleL[i]);
		}
	}
	private static void glauca_moveL() {
		enemy_glauca_moveL=new BufferedImage[1];
		SpriteSheet glauca_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_move.png"));
		enemy_glauca_moveL[0]=glauca_moveL.crop(0,0 ,112 ,82);	
		col=0;row=0;
	}
	private static void glauca_moveR() {
		enemy_glauca_moveR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_glauca_moveR[0]=IF.horizontalflip(enemy_glauca_moveL[0]);
		
	}
	private static void glauca_attackL() {
		enemy_glauca_attackL=new BufferedImage[27];
		SpriteSheet glauca_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_attack.png"));
		for(int i=0;i<3;i++) {
			enemy_glauca_attackL[i]=glauca_attackL.crop(277*col,179*row ,277 ,179);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=3;i<7;i++) {
			enemy_glauca_attackL[i]=enemy_glauca_attackL[2];
		}
		for(int i=7;i<27;i++) {
			enemy_glauca_attackL[i]=glauca_attackL.crop(277*col,179*row ,277 ,179);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void glauca_attackR() {
		enemy_glauca_attackR=new BufferedImage[27];
		IF=new ImageFlip();
		for(int i=0;i<27;i++) {
			enemy_glauca_attackR[i]=IF.horizontalflip(enemy_glauca_attackL[i]);
		}
	}
	private static void glauca_deadL() {
		enemy_glauca_deadL=new BufferedImage[1];
		SpriteSheet glauca_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_dead.png"));
		enemy_glauca_deadL[0]=glauca_deadL.crop(0,0 ,91 ,50);
	}
	private static void glauca_deadR() {
		enemy_glauca_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_glauca_deadR[0]=IF.horizontalflip(enemy_glauca_deadL[0]);
	}
	private static void glauca_hurtL() {
		enemy_glauca_hurtL=new BufferedImage[1];
		SpriteSheet glauca_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_hurt.png"));
		enemy_glauca_hurtL[0]=glauca_hurtL.crop(0,0 ,119 ,64);	
		col=0;row=0;
	}
	private static void glauca_hurtR() {
		enemy_glauca_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_glauca_hurtR[0]=IF.horizontalflip(enemy_glauca_hurtL[0]);
	}
	private static void glauca_icon() {
		enemy_glauca_icon=new BufferedImage[1];
		SpriteSheet glauca_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/glauca/glauca_icon.png"));
		enemy_glauca_icon[0]=glauca_icon.crop(0,0 ,56 ,38);
	}
}
