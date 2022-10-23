package gfx;

import java.awt.image.BufferedImage;
import utils.ImageFlip;

public class Asset_dark {

	public static BufferedImage[] enemy_dark_icon;
	public static BufferedImage[] enemy_dark_idleL;
	public static BufferedImage[] enemy_dark_idleR;
	public static BufferedImage[] enemy_dark_moveL;
	public static BufferedImage[] enemy_dark_moveR;
	public static BufferedImage[] enemy_dark_attackL;
	public static BufferedImage[] enemy_dark_attackR;
	public static BufferedImage[] enemy_dark_hurtL;
	public static BufferedImage[] enemy_dark_hurtR;
	public static BufferedImage[] enemy_dark_deadL;
	public static BufferedImage[] enemy_dark_deadR;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {dark();}
	public static void dark() {
		dark_idleL();
		dark_idleR();
		dark_moveL();
		dark_moveR();
		dark_attackL();
		dark_attackR();
		dark_hurtL();
		dark_hurtR();
		dark_deadL();
		dark_deadR();
		dark_icon();
	}
	private static void dark_idleL() {
		enemy_dark_idleL=new BufferedImage[4];
		SpriteSheet dark_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_dark_idleL[i]=dark_idleL.crop(125*col,96*row ,125 ,96);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void dark_idleR() {
		enemy_dark_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_dark_idleR[i]=IF.horizontalflip(enemy_dark_idleL[i]);
		}
	}
	private static void dark_moveL() {
		enemy_dark_moveL=new BufferedImage[1];
		SpriteSheet dark_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_move.png"));
		enemy_dark_moveL[0]=dark_moveL.crop(0,0 ,132 ,90);	
		col=0;row=0;
	}
	private static void dark_moveR() {
		enemy_dark_moveR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_dark_moveR[0]=IF.horizontalflip(enemy_dark_moveL[0]);
		
	}
	
	private static void dark_attackL() {
		enemy_dark_attackL=new BufferedImage[20];
		SpriteSheet dark_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_attack.png"));
		for(int i=0;i<2;i++) {
			enemy_dark_attackL[i]=dark_attackL.crop(266*col,170*row ,266 ,170);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=2;i<6;i++) {
			enemy_dark_attackL[i]=enemy_dark_attackL[1];
		}
		for(int i=6;i<20;i++) {
			enemy_dark_attackL[i]=dark_attackL.crop(266*col,170*row ,266 ,170);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void dark_attackR() {
		enemy_dark_attackR=new BufferedImage[20];
		IF=new ImageFlip();
		for(int i=0;i<20;i++) {
			enemy_dark_attackR[i]=IF.horizontalflip(enemy_dark_attackL[i]);
		}
	}
	private static void dark_hurtL() {
		enemy_dark_hurtL=new BufferedImage[1];
		SpriteSheet dark_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_hurt.png"));
		enemy_dark_hurtL[0]=dark_hurtL.crop(0,0 ,92 ,73);	
		col=0;row=0;
	}
	private static void dark_hurtR() {
		enemy_dark_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_dark_hurtR[0]=IF.horizontalflip(enemy_dark_hurtL[0]);
		
	}
	private static void dark_deadL() {
		enemy_dark_deadL=new BufferedImage[1];
		SpriteSheet dark_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_dead.png"));
		enemy_dark_deadL[0]=dark_deadL.crop(0,0 ,100 ,74);
	}
	private static void dark_deadR() {
		enemy_dark_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_dark_deadR[0]=IF.horizontalflip(enemy_dark_deadL[0]);
	}
	private static void dark_icon() {
		enemy_dark_icon=new BufferedImage[1];
		SpriteSheet dark_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/dark/dark_icon.png"));
		enemy_dark_icon[0]=dark_icon.crop(0,0 ,56 ,38);
	}
}
