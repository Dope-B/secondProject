package gfx;

import java.awt.image.BufferedImage;
import utils.ImageFlip;

public class Asset_kyo {

	public static BufferedImage[] enemy_kyo_idleL;
	public static BufferedImage[] enemy_kyo_idleR;
	public static BufferedImage[] enemy_kyo_moveL;
	public static BufferedImage[] enemy_kyo_moveR;
	public static BufferedImage[] enemy_kyo_attackL;
	public static BufferedImage[] enemy_kyo_attackR;
	public static BufferedImage[] enemy_kyo_hurtL;
	public static BufferedImage[] enemy_kyo_hurtR;
	public static BufferedImage[] enemy_kyo_deadL;
	public static BufferedImage[] enemy_kyo_deadR;
	public static BufferedImage[] enemy_kyo_icon;
	private static ImageFlip IF;
	
	public static void init() {kyo();}
	public static void kyo() {
		kyo_idleL();
		kyo_idleR();
		kyo_moveL();
		kyo_moveR();
		kyo_attackL();
		kyo_attackR();
		kyo_hurtL();
		kyo_hurtR();
		kyo_deadL();
		kyo_deadR();
		kyo_icon();
	}
	private static void kyo_idleL() {
		enemy_kyo_idleL=new BufferedImage[17];
			enemy_kyo_idleL[0]=ImageLoader.loadImage("textures/enemy/kyo/idle/1.png");
			enemy_kyo_idleL[1]=ImageLoader.loadImage("textures/enemy/kyo/idle/2.png");
			enemy_kyo_idleL[2]=ImageLoader.loadImage("textures/enemy/kyo/idle/3.png");
			enemy_kyo_idleL[3]=ImageLoader.loadImage("textures/enemy/kyo/idle/4.png");
			enemy_kyo_idleL[4]=ImageLoader.loadImage("textures/enemy/kyo/idle/5.png");
			enemy_kyo_idleL[5]=ImageLoader.loadImage("textures/enemy/kyo/idle/6.png");
			enemy_kyo_idleL[6]=ImageLoader.loadImage("textures/enemy/kyo/idle/7.png");
			enemy_kyo_idleL[7]=ImageLoader.loadImage("textures/enemy/kyo/idle/8.png");
			enemy_kyo_idleL[8]=ImageLoader.loadImage("textures/enemy/kyo/idle/9.png");
			enemy_kyo_idleL[9]=ImageLoader.loadImage("textures/enemy/kyo/idle/10.png");
			enemy_kyo_idleL[10]=ImageLoader.loadImage("textures/enemy/kyo/idle/11.png");
			enemy_kyo_idleL[11]=ImageLoader.loadImage("textures/enemy/kyo/idle/12.png");
			enemy_kyo_idleL[12]=ImageLoader.loadImage("textures/enemy/kyo/idle/13.png");
			enemy_kyo_idleL[13]=ImageLoader.loadImage("textures/enemy/kyo/idle/14.png");
			enemy_kyo_idleL[14]=ImageLoader.loadImage("textures/enemy/kyo/idle/15.png");
			enemy_kyo_idleL[15]=ImageLoader.loadImage("textures/enemy/kyo/idle/16.png");
			enemy_kyo_idleL[16]=ImageLoader.loadImage("textures/enemy/kyo/idle/17.png");
	}
	private static void kyo_idleR() {
		enemy_kyo_idleR=new BufferedImage[17];
		enemy_kyo_idleR[0]=ImageLoader.loadImage("textures/enemy/kyo/idle/1R.png");
		enemy_kyo_idleR[1]=ImageLoader.loadImage("textures/enemy/kyo/idle/2R.png");
		enemy_kyo_idleR[2]=ImageLoader.loadImage("textures/enemy/kyo/idle/3R.png");
		enemy_kyo_idleR[3]=ImageLoader.loadImage("textures/enemy/kyo/idle/4R.png");
		enemy_kyo_idleR[4]=ImageLoader.loadImage("textures/enemy/kyo/idle/5R.png");
		enemy_kyo_idleR[5]=ImageLoader.loadImage("textures/enemy/kyo/idle/6R.png");
		enemy_kyo_idleR[6]=ImageLoader.loadImage("textures/enemy/kyo/idle/7R.png");
		enemy_kyo_idleR[7]=ImageLoader.loadImage("textures/enemy/kyo/idle/8R.png");
		enemy_kyo_idleR[8]=ImageLoader.loadImage("textures/enemy/kyo/idle/9R.png");
		enemy_kyo_idleR[9]=ImageLoader.loadImage("textures/enemy/kyo/idle/10R.png");
		enemy_kyo_idleR[10]=ImageLoader.loadImage("textures/enemy/kyo/idle/11R.png");
		enemy_kyo_idleR[11]=ImageLoader.loadImage("textures/enemy/kyo/idle/12R.png");
		enemy_kyo_idleR[12]=ImageLoader.loadImage("textures/enemy/kyo/idle/13R.png");
		enemy_kyo_idleR[13]=ImageLoader.loadImage("textures/enemy/kyo/idle/14R.png");
		enemy_kyo_idleR[14]=ImageLoader.loadImage("textures/enemy/kyo/idle/15R.png");
		enemy_kyo_idleR[15]=ImageLoader.loadImage("textures/enemy/kyo/idle/16R.png");
		enemy_kyo_idleR[16]=ImageLoader.loadImage("textures/enemy/kyo/idle/17R.png");
		}
	private static void kyo_moveL() {
		enemy_kyo_moveL=new BufferedImage[2];
			enemy_kyo_moveL[0]=ImageLoader.loadImage("textures/enemy/kyo/move/1.png");
			enemy_kyo_moveL[1]=ImageLoader.loadImage("textures/enemy/kyo/move/2.png");
	}
	private static void kyo_moveR() {
		enemy_kyo_moveR=new BufferedImage[2];
		enemy_kyo_moveR[0]=ImageLoader.loadImage("textures/enemy/kyo/move/1R.png");
		enemy_kyo_moveR[1]=ImageLoader.loadImage("textures/enemy/kyo/move/2R.png");
	}
	private static void kyo_attackL() {
		enemy_kyo_attackL=new BufferedImage[20];
		
			enemy_kyo_attackL[0]=ImageLoader.loadImage("textures/enemy/kyo/attack/17.png");
			enemy_kyo_attackL[1]=ImageLoader.loadImage("textures/enemy/kyo/attack/18.png");
			enemy_kyo_attackL[2]=ImageLoader.loadImage("textures/enemy/kyo/attack/19.png");
			enemy_kyo_attackL[3]=ImageLoader.loadImage("textures/enemy/kyo/attack/20.png");
			enemy_kyo_attackL[4]=ImageLoader.loadImage("textures/enemy/kyo/attack/21.png");
			enemy_kyo_attackL[5]=ImageLoader.loadImage("textures/enemy/kyo/attack/22.png");
			enemy_kyo_attackL[6]=ImageLoader.loadImage("textures/enemy/kyo/attack/23.png");
			enemy_kyo_attackL[7]=ImageLoader.loadImage("textures/enemy/kyo/attack/24.png");
			enemy_kyo_attackL[8]=ImageLoader.loadImage("textures/enemy/kyo/attack/25.png");
			enemy_kyo_attackL[9]=ImageLoader.loadImage("textures/enemy/kyo/attack/26.png");
			enemy_kyo_attackL[10]=ImageLoader.loadImage("textures/enemy/kyo/attack/27.png");
			enemy_kyo_attackL[11]=ImageLoader.loadImage("textures/enemy/kyo/attack/28.png");
			enemy_kyo_attackL[12]=ImageLoader.loadImage("textures/enemy/kyo/attack/29.png");
			enemy_kyo_attackL[13]=ImageLoader.loadImage("textures/enemy/kyo/attack/30.png");
			enemy_kyo_attackL[14]=ImageLoader.loadImage("textures/enemy/kyo/attack/31.png");
			enemy_kyo_attackL[15]=ImageLoader.loadImage("textures/enemy/kyo/attack/32.png");
			enemy_kyo_attackL[16]=ImageLoader.loadImage("textures/enemy/kyo/attack/33.png");
			enemy_kyo_attackL[17]=ImageLoader.loadImage("textures/enemy/kyo/attack/34.png");
			enemy_kyo_attackL[18]=ImageLoader.loadImage("textures/enemy/kyo/attack/35.png");
			enemy_kyo_attackL[19]=ImageLoader.loadImage("textures/enemy/kyo/attack/36.png");
	}
	private static void kyo_attackR() {
		enemy_kyo_attackR=new BufferedImage[20];
		enemy_kyo_attackR[0]=ImageLoader.loadImage("textures/enemy/kyo/attack/17R.png");
		enemy_kyo_attackR[1]=ImageLoader.loadImage("textures/enemy/kyo/attack/18R.png");
		enemy_kyo_attackR[2]=ImageLoader.loadImage("textures/enemy/kyo/attack/19R.png");
		enemy_kyo_attackR[3]=ImageLoader.loadImage("textures/enemy/kyo/attack/20R.png");
		enemy_kyo_attackR[4]=ImageLoader.loadImage("textures/enemy/kyo/attack/21R.png");
		enemy_kyo_attackR[5]=ImageLoader.loadImage("textures/enemy/kyo/attack/22R.png");
		enemy_kyo_attackR[6]=ImageLoader.loadImage("textures/enemy/kyo/attack/23R.png");
		enemy_kyo_attackR[7]=ImageLoader.loadImage("textures/enemy/kyo/attack/24R.png");
		enemy_kyo_attackR[8]=ImageLoader.loadImage("textures/enemy/kyo/attack/25R.png");
		enemy_kyo_attackR[9]=ImageLoader.loadImage("textures/enemy/kyo/attack/26R.png");
		enemy_kyo_attackR[10]=ImageLoader.loadImage("textures/enemy/kyo/attack/27R.png");
		enemy_kyo_attackR[11]=ImageLoader.loadImage("textures/enemy/kyo/attack/28R.png");
		enemy_kyo_attackR[12]=ImageLoader.loadImage("textures/enemy/kyo/attack/29R.png");
		enemy_kyo_attackR[13]=ImageLoader.loadImage("textures/enemy/kyo/attack/30R.png");
		enemy_kyo_attackR[14]=ImageLoader.loadImage("textures/enemy/kyo/attack/31R.png");
		enemy_kyo_attackR[15]=ImageLoader.loadImage("textures/enemy/kyo/attack/32R.png");
		enemy_kyo_attackR[16]=ImageLoader.loadImage("textures/enemy/kyo/attack/33R.png");
		enemy_kyo_attackR[17]=ImageLoader.loadImage("textures/enemy/kyo/attack/34R.png");
		enemy_kyo_attackR[18]=ImageLoader.loadImage("textures/enemy/kyo/attack/35R.png");
		enemy_kyo_attackR[19]=ImageLoader.loadImage("textures/enemy/kyo/attack/36R.png");
	}
	private static void kyo_hurtL() {
		enemy_kyo_hurtL=new BufferedImage[1];
		enemy_kyo_hurtL[0]=ImageLoader.loadImage("textures/enemy/kyo/kyo_hurt.png");
	}
	private static void kyo_hurtR() {
		enemy_kyo_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		enemy_kyo_hurtR[0]=IF.horizontalflip(enemy_kyo_hurtL[0]);
	}
	private static void kyo_deadL() {
		enemy_kyo_deadL=new BufferedImage[1];
		enemy_kyo_deadL[0]=ImageLoader.loadImage("textures/enemy/kyo/kyo_dead.png");
	}
	private static void kyo_deadR() {
		enemy_kyo_deadR=new BufferedImage[1];
		IF=new ImageFlip();
			enemy_kyo_deadR[0]=IF.horizontalflip(enemy_kyo_deadL[0]);
	}
	private static void kyo_icon() {
		enemy_kyo_icon=new BufferedImage[1];
		enemy_kyo_icon[0]=ImageLoader.loadImage("textures/enemy/kyo/kyo_icon.png");
	}
}
