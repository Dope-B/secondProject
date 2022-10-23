package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_slime {

	public static BufferedImage[] enemy_slime_idleL;
	public static BufferedImage[] enemy_slime_idleR;
	public static BufferedImage[] enemy_slime_moveL;
	public static BufferedImage[] enemy_slime_moveR;
	public static BufferedImage[] enemy_slime_attackL;
	public static BufferedImage[] enemy_slime_attackR;
	public static BufferedImage[] enemy_slime_deadL;
	public static BufferedImage[] enemy_slime_deadR;
	public static BufferedImage[] enemy_slime_hurtL;
	public static BufferedImage[] enemy_slime_hurtR;
	public static BufferedImage[] enemy_slime_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {slime();}
	public static void slime() {
		slime_idleL();
		slime_idleR();
		slime_moveL();
		slime_moveR();
		slime_attackL();
		slime_attackR();
		slime_deadL();
		slime_deadR();
		slime_hurtL();
		slime_hurtR();
		slime_icon();
	}
	private static void slime_idleL() {
		enemy_slime_idleL=new BufferedImage[4];
		SpriteSheet slime_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_slime_idleL[i]=slime_idleL.crop(47*col,38*row ,47 ,38);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void slime_idleR() {
		enemy_slime_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_slime_idleR[i]=IF.horizontalflip(enemy_slime_idleL[i]);
		}
	}
	private static void slime_moveL() {
		enemy_slime_moveL=new BufferedImage[4];
		SpriteSheet slime_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_move.png"));
		for(int i=0;i<4;i++) {
		enemy_slime_moveL[i]=slime_moveL.crop(47*col,43*row ,47 ,43);	
		if(col==2) {col=0;row++;}
		else {col++;}
		}
		col=0;row=0;
	}
	private static void slime_moveR() {
		enemy_slime_moveR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_slime_moveR[i]=IF.horizontalflip(enemy_slime_moveL[i]);}
		
	}
	private static void slime_attackL() {
		enemy_slime_attackL=new BufferedImage[19];
		SpriteSheet slime_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_attack.png"));
		for(int i=4;i<19;i++) {
			enemy_slime_attackL[i]=slime_attackL.crop(97*col,61*row ,97 ,61);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=0;i<4;i++) {
			enemy_slime_attackL[i]=enemy_slime_attackL[4];
		}
		col=0;row=0;
	}
	private static void slime_attackR() {
		enemy_slime_attackR=new BufferedImage[19];
		IF=new ImageFlip();
		for(int i=0;i<19;i++) {
			enemy_slime_attackR[i]=IF.horizontalflip(enemy_slime_attackL[i]);
		}
	}
	private static void slime_deadL() {
		enemy_slime_deadL=new BufferedImage[1];
		SpriteSheet slime_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_dead.png"));
		enemy_slime_deadL[0]=slime_deadL.crop(0,0 ,47 ,31);
	}
	private static void slime_deadR() {
		enemy_slime_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_slime_deadR[0]=IF.horizontalflip(enemy_slime_deadL[0]);
	}
	private static void slime_hurtL() {
		enemy_slime_hurtL=new BufferedImage[1];
		SpriteSheet slime_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_dead.png"));
		enemy_slime_hurtL[0]=slime_hurtL.crop(0,0 ,47 ,31);	
		col=0;row=0;
	}
	private static void slime_hurtR() {
		enemy_slime_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_slime_hurtR[0]=IF.horizontalflip(enemy_slime_hurtL[0]);
	}
	private static void slime_icon() {
		enemy_slime_icon=new BufferedImage[1];
		SpriteSheet slime_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/slime/slime_icon.png"));
		enemy_slime_icon[0]=slime_icon.crop(0,0 ,56 ,38);
	}
}
