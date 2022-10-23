package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_shadow {

	public static BufferedImage[] enemy_shadow_idleL;
	public static BufferedImage[] enemy_shadow_idleR;
	public static BufferedImage[] enemy_shadow_moveL;
	public static BufferedImage[] enemy_shadow_moveR;
	public static BufferedImage[] enemy_shadow_attackL;
	public static BufferedImage[] enemy_shadow_attackR;
	public static BufferedImage[] enemy_shadow_deadL;
	public static BufferedImage[] enemy_shadow_deadR;
	public static BufferedImage[] enemy_shadow_hurtL;
	public static BufferedImage[] enemy_shadow_hurtR;
	public static BufferedImage[] enemy_shadow_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {shadow();}
	public static void shadow() {
		shadow_idleL();
		shadow_idleR();
		shadow_moveL();
		shadow_moveR();
		shadow_attackL();
		shadow_attackR();
		shadow_deadL();
		shadow_deadR();
		shadow_hurtL();
		shadow_hurtR();
		shadow_icon();
	}
	private static void shadow_idleL() {
		enemy_shadow_idleL=new BufferedImage[8];
		SpriteSheet shadow_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_idle.png"));
		for(int i=0;i<8;i++) {
			enemy_shadow_idleL[i]=shadow_idleL.crop(91*col,76*row ,91 ,76);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void shadow_idleR() {
		enemy_shadow_idleR=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {
			enemy_shadow_idleR[i]=IF.horizontalflip(enemy_shadow_idleL[i]);
		}
	}
	private static void shadow_moveL() {
		enemy_shadow_moveL=new BufferedImage[1];
		SpriteSheet shadow_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_move.png"));
		enemy_shadow_moveL[0]=shadow_moveL.crop(0,0 ,110 ,64);	
		col=0;row=0;
	}
	private static void shadow_moveR() {
		enemy_shadow_moveR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_shadow_moveR[0]=IF.horizontalflip(enemy_shadow_moveL[0]);
		
	}
	private static void shadow_attackL() {
		enemy_shadow_attackL=new BufferedImage[11];
		SpriteSheet shadow_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_attack.png"));
		for(int i=0;i<11;i++) {
			enemy_shadow_attackL[i]=shadow_attackL.crop(171*col,90*row ,171 ,90);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void shadow_attackR() {
		enemy_shadow_attackR=new BufferedImage[11];
		IF=new ImageFlip();
		for(int i=0;i<11;i++) {
			enemy_shadow_attackR[i]=IF.horizontalflip(enemy_shadow_attackL[i]);
		}
	}
	private static void shadow_deadL() {
		enemy_shadow_deadL=new BufferedImage[1];
		SpriteSheet shadow_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_dead.png"));
		enemy_shadow_deadL[0]=shadow_deadL.crop(0,0 ,93 ,52);
	}
	private static void shadow_deadR() {
		enemy_shadow_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_shadow_deadR[0]=IF.horizontalflip(enemy_shadow_deadL[0]);
	}
	private static void shadow_hurtL() {
		enemy_shadow_hurtL=new BufferedImage[1];
		SpriteSheet shadow_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_hurt.png"));
		enemy_shadow_hurtL[0]=shadow_hurtL.crop(0,0 ,88 ,51);	
		col=0;row=0;
	}
	private static void shadow_hurtR() {
		enemy_shadow_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_shadow_hurtR[0]=IF.horizontalflip(enemy_shadow_hurtL[0]);
	}
	private static void shadow_icon() {
		enemy_shadow_icon=new BufferedImage[1];
		SpriteSheet shadow_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/shadow/shadow_icon.png"));
		enemy_shadow_icon[0]=shadow_icon.crop(0,0 ,56 ,38);
	}
}
