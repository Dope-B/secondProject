package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_kain {

	public static BufferedImage[] enemy_kain_idleL;
	public static BufferedImage[] enemy_kain_idleR;
	public static BufferedImage[] enemy_kain_moveL;
	public static BufferedImage[] enemy_kain_moveR;
	public static BufferedImage[] enemy_kain_attackL;
	public static BufferedImage[] enemy_kain_attackR;
	public static BufferedImage[] enemy_kain_deadL;
	public static BufferedImage[] enemy_kain_deadR;
	public static BufferedImage[] enemy_kain_hurtL;
	public static BufferedImage[] enemy_kain_hurtR;
	public static BufferedImage[] enemy_kain_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {kain();}
	public static void kain() {
		kain_idleL();
		kain_idleR();
		kain_moveL();
		kain_moveR();
		kain_attackL();
		kain_attackR();
		kain_deadL();
		kain_deadR();
		kain_hurtL();
		kain_hurtR();
		kain_icon();
	}
	private static void kain_idleL() {
		enemy_kain_idleL=new BufferedImage[4];
		SpriteSheet kain_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_kain_idleL[i]=kain_idleL.crop(130*col,102*row ,130 ,102);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void kain_idleR() {
		enemy_kain_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_kain_idleR[i]=IF.horizontalflip(enemy_kain_idleL[i]);
		}
	}
	private static void kain_moveL() {
		enemy_kain_moveL=new BufferedImage[4];
		SpriteSheet kain_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_move.png"));
		for(int i=0;i<4;i++) {
		enemy_kain_moveL[i]=kain_moveL.crop(141*col,100*row ,141 ,100);	
		if(col==2) {col=0;row++;}
		else {col++;}
		}
		col=0;row=0;
	}
	private static void kain_moveR() {
		enemy_kain_moveR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_kain_moveR[i]=IF.horizontalflip(enemy_kain_moveL[i]);
		}
		
	}
	private static void kain_attackL() {
		enemy_kain_attackL=new BufferedImage[16];
		SpriteSheet kain_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_attack.png"));
		for(int i=4;i<16;i++) {
			enemy_kain_attackL[i]=kain_attackL.crop(367*col,83*row ,367 ,83);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=0;i<4;i++) {
			enemy_kain_attackL[i]=enemy_kain_attackL[7];
		}
		col=0;row=0;
	}
	private static void kain_attackR() {
		enemy_kain_attackR=new BufferedImage[16];
		IF=new ImageFlip();
		for(int i=0;i<16;i++) {
			enemy_kain_attackR[i]=IF.horizontalflip(enemy_kain_attackL[i]);
		}
	}
	private static void kain_deadL() {
		enemy_kain_deadL=new BufferedImage[1];
		SpriteSheet kain_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_dead.png"));
		enemy_kain_deadL[0]=kain_deadL.crop(0,0 ,113 ,40);
	}
	private static void kain_deadR() {
		enemy_kain_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_kain_deadR[0]=IF.horizontalflip(enemy_kain_deadL[0]);
	}
	private static void kain_hurtL() {
		enemy_kain_hurtL=new BufferedImage[1];
		SpriteSheet kain_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_hurt.png"));
		enemy_kain_hurtL[0]=kain_hurtL.crop(0,0 ,109 ,54);	
		col=0;row=0;
	}
	private static void kain_hurtR() {
		enemy_kain_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_kain_hurtR[0]=IF.horizontalflip(enemy_kain_hurtL[0]);
	}
	private static void kain_icon() {
		enemy_kain_icon=new BufferedImage[1];
		SpriteSheet kain_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/kain/kain_icon.png"));
		enemy_kain_icon[0]=kain_icon.crop(0,0 ,56 ,38);
	}
}
