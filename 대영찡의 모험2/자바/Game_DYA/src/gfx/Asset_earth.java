package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_earth {


	public static BufferedImage[] enemy_earth_idleL;
	public static BufferedImage[] enemy_earth_idleR;
	public static BufferedImage[] enemy_earth_moveL;
	public static BufferedImage[] enemy_earth_moveR;
	public static BufferedImage[] enemy_earth_attackL;
	public static BufferedImage[] enemy_earth_attackR;
	public static BufferedImage[] enemy_earth_deadL;
	public static BufferedImage[] enemy_earth_deadR;
	public static BufferedImage[] enemy_earth_hurtL;
	public static BufferedImage[] enemy_earth_hurtR;
	public static BufferedImage[] enemy_earth_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {earth();}
	public static void earth() {
		earth_idleL();
		earth_idleR();
		earth_moveL();
		earth_moveR();
		earth_attackL();
		earth_attackR();
		earth_deadL();
		earth_deadR();
		earth_hurtL();
		earth_hurtR();
		earth_icon();
	}
	private static void earth_idleL() {
		enemy_earth_idleL=new BufferedImage[4];
		SpriteSheet earth_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_earth_idleL[i]=earth_idleL.crop(125*col,87*row ,125 ,87);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void earth_idleR() {
		enemy_earth_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_earth_idleR[i]=IF.horizontalflip(enemy_earth_idleL[i]);
		}
	}
	private static void earth_moveL() {
		enemy_earth_moveL=new BufferedImage[1];
		SpriteSheet earth_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_move.png"));
		enemy_earth_moveL[0]=earth_moveL.crop(0,0 ,102 ,90);	
		col=0;row=0;
	}
	private static void earth_moveR() {
		enemy_earth_moveR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_earth_moveR[0]=IF.horizontalflip(enemy_earth_moveL[0]);
		
	}
	private static void earth_attackL() {
		enemy_earth_attackL=new BufferedImage[20];
		SpriteSheet earth_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_attack.png"));
		for(int i=0;i<3;i++) {
			enemy_earth_attackL[i]=earth_attackL.crop(230*col,138*row ,230 ,138);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=3;i<7;i++) {
			enemy_earth_attackL[i]=enemy_earth_attackL[2];
		}
		for(int i=7;i<20;i++) {
			enemy_earth_attackL[i]=earth_attackL.crop(230*col,138*row ,230 ,138);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void earth_attackR() {
		enemy_earth_attackR=new BufferedImage[20];
		IF=new ImageFlip();
		for(int i=0;i<20;i++) {
			enemy_earth_attackR[i]=IF.horizontalflip(enemy_earth_attackL[i]);
		}
	}
	private static void earth_deadL() {
		enemy_earth_deadL=new BufferedImage[1];
		SpriteSheet earth_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_dead.png"));
		enemy_earth_deadL[0]=earth_deadL.crop(0,0 ,89 ,46);
	}
	private static void earth_deadR() {
		enemy_earth_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_earth_deadR[0]=IF.horizontalflip(enemy_earth_deadL[0]);
	}
	private static void earth_hurtL() {
		enemy_earth_hurtL=new BufferedImage[1];
		SpriteSheet earth_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_hurt.png"));
		enemy_earth_hurtL[0]=earth_hurtL.crop(0,0 ,82 ,66);	
		col=0;row=0;
	}
	private static void earth_hurtR() {
		enemy_earth_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_earth_hurtR[0]=IF.horizontalflip(enemy_earth_hurtL[0]);
	}
	private static void earth_icon() {
		enemy_earth_icon=new BufferedImage[1];
		SpriteSheet earth_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/earth/earth_icon.png"));
		enemy_earth_icon[0]=earth_icon.crop(0,0 ,56 ,38);
	}
}
