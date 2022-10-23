package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_light {

	public static BufferedImage[] enemy_light_idleL;
	public static BufferedImage[] enemy_light_idleR;
	public static BufferedImage[] enemy_light_moveL;
	public static BufferedImage[] enemy_light_moveR;
	public static BufferedImage[] enemy_light_attackL;
	public static BufferedImage[] enemy_light_attackR;
	public static BufferedImage[] enemy_light_deadL;
	public static BufferedImage[] enemy_light_deadR;
	public static BufferedImage[] enemy_light_hurtL;
	public static BufferedImage[] enemy_light_hurtR;
	public static BufferedImage[] enemy_light_icon;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {light();}
	public static void light() {
		light_idleL();
		light_idleR();
		light_moveL();
		light_moveR();
		light_attackL();
		light_attackR();
		light_deadL();
		light_deadR();
		light_hurtL();
		light_hurtR();
		light_icon();
	}
	private static void light_idleL() {
		enemy_light_idleL=new BufferedImage[4];
		SpriteSheet light_idleL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_idle.png"));
		for(int i=0;i<4;i++) {
			enemy_light_idleL[i]=light_idleL.crop(86*col,95*row ,86 ,95);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void light_idleR() {
		enemy_light_idleR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_light_idleR[i]=IF.horizontalflip(enemy_light_idleL[i]);
		}
	}
	private static void light_moveL() {
		enemy_light_moveL=new BufferedImage[4];
		SpriteSheet light_moveL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_move.png"));
		for(int i=0;i<4;i++) {
		enemy_light_moveL[i]=light_moveL.crop(86*col,88*row ,86 ,88);	
		if(col==2) {col=0;row++;}
		else {col++;}
		}
		col=0;row=0;
	}
	private static void light_moveR() {
		enemy_light_moveR=new BufferedImage[4];
		IF=new ImageFlip();
		for(int i=0;i<4;i++) {
			enemy_light_moveR[i]=IF.horizontalflip(enemy_light_moveL[i]);}
		
	}
	private static void light_attackL() {
		enemy_light_attackL=new BufferedImage[26];
		SpriteSheet light_attackL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_attack.png"));
		for(int i=0;i<2;i++) {
			enemy_light_attackL[i]=light_attackL.crop(368*col,187*row ,368 ,187);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		for(int i=2;i<6;i++) {
			enemy_light_attackL[i]=enemy_light_attackL[1];
		}
		for(int i=6;i<25;i++) {
			enemy_light_attackL[i]=light_attackL.crop(368*col,187*row ,368 ,187);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		enemy_light_attackL[25]=enemy_light_attackL[24];
		col=0;row=0;
	}
	private static void light_attackR() {
		enemy_light_attackR=new BufferedImage[26];
		IF=new ImageFlip();
		for(int i=0;i<26;i++) {
			enemy_light_attackR[i]=IF.horizontalflip(enemy_light_attackL[i]);
		}
	}
	private static void light_deadL() {
		enemy_light_deadL=new BufferedImage[1];
		SpriteSheet light_deadL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_dead.png"));
		enemy_light_deadL[0]=light_deadL.crop(0,0 ,83 ,58);
	}
	private static void light_deadR() {
		enemy_light_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_light_deadR[0]=IF.horizontalflip(enemy_light_deadL[0]);
	}
	private static void light_hurtL() {
		enemy_light_hurtL=new BufferedImage[1];
		SpriteSheet light_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_hurt.png"));
		enemy_light_hurtL[0]=light_hurtL.crop(0,0 ,71 ,68);	
		col=0;row=0;
	}
	private static void light_hurtR() {
		enemy_light_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_light_hurtR[0]=IF.horizontalflip(enemy_light_hurtL[0]);
	}
	private static void light_icon() {
		enemy_light_icon=new BufferedImage[1];
		SpriteSheet light_icon=new SpriteSheet(ImageLoader.loadImage("textures/enemy/light/light_icon.png"));
		enemy_light_icon[0]=light_icon.crop(0,0 ,56 ,38);
	}
}
