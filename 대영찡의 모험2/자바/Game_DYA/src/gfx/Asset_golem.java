package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_golem {


	public static BufferedImage[] enemy_golem_idleL;
	public static BufferedImage[] enemy_golem_idleR;
	public static BufferedImage[] enemy_golem_moveL;
	public static BufferedImage[] enemy_golem_moveR;
	public static BufferedImage[] enemy_golem_attackL;
	public static BufferedImage[] enemy_golem_attackR;
	public static BufferedImage[] enemy_golem_hurtL;
	public static BufferedImage[] enemy_golem_hurtR;
	public static BufferedImage[] enemy_golem_deadL;
	public static BufferedImage[] enemy_golem_deadR;
	public static BufferedImage[] enemy_golem_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {golem();}
	public static void golem() {
		golem_idleL();
		golem_idleR();
		golem_moveL();
		golem_moveR();
		golem_attackL();
		golem_attackR();
		golem_hurtL();
		golem_hurtR();
		golem_deadL();
		golem_deadR();
		golem_icon();
	}
	private static void golem_idleL() {
		enemy_golem_idleL=new BufferedImage[4];
		SpriteSheet golem_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_golem_idleL[i]=golem_idleL.crop(85*col,85*row ,85 ,85);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void golem_idleR() {
		enemy_golem_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_golem_idleR[i]=IF.horizontalflip(enemy_golem_idleL[i]);
		}
	}
	private static void golem_moveL() {
		enemy_golem_moveL=new BufferedImage[1];
		SpriteSheet golem_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_move.png"));
		enemy_golem_moveL[0]=golem_moveL.crop(0,0 ,85 ,82);	
		col=0;row=0;
	}
	private static void golem_moveR() {
		enemy_golem_moveR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_golem_moveR[0]=IF.horizontalflip(enemy_golem_moveL[0]);
		
	}
	private static void golem_attackL() {
		enemy_golem_attackL=new BufferedImage[14];
		SpriteSheet golem_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_attack.png"));
		for(int i=0;i<3;i++) {
			enemy_golem_attackL[i]=golem_attackL.crop(99*col,98*row ,99 ,98);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=3;i<7;i++) {
			enemy_golem_attackL[i]=enemy_golem_attackL[2];
		}
		for(int i=7;i<14;i++) {
			enemy_golem_attackL[i]=golem_attackL.crop(99*col,98*row ,99 ,98);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void golem_attackR() {
		enemy_golem_attackR=new BufferedImage[14];
		IF=new ImageFlip();
		for(int i=0;i<14;i++) {
			enemy_golem_attackR[i]=IF.horizontalflip(enemy_golem_attackL[i]);
		}
	}
	private static void golem_deadL() {
		enemy_golem_deadL=new BufferedImage[1];
		SpriteSheet golem_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_dead.png"));
		enemy_golem_deadL[0]=golem_deadL.crop(0,0 ,91 ,53);
	}
	private static void golem_deadR() {
		enemy_golem_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_golem_deadR[0]=IF.horizontalflip(enemy_golem_deadL[0]);
	}
	private static void golem_hurtL() {
		enemy_golem_hurtL=new BufferedImage[1];
		SpriteSheet golem_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_hurt.png"));
		enemy_golem_hurtL[0]=golem_hurtL.crop(0,0 ,85 ,69);	
		col=0;row=0;
	}
	private static void golem_hurtR() {
		enemy_golem_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_golem_hurtR[0]=IF.horizontalflip(enemy_golem_hurtL[0]);
	}
	private static void golem_icon() {
		enemy_golem_icon=new BufferedImage[1];
		SpriteSheet golem_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/golem/golem_icon.png"));
		enemy_golem_icon[0]=golem_icon.crop(0,0 ,56 ,38);
	}
}
