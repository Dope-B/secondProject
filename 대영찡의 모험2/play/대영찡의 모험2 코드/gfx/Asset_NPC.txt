package gfx;

import java.awt.image.BufferedImage;


public class Asset_NPC {

	public static BufferedImage[] G_NPC_1;
	public static BufferedImage[] G_NPC_2;
	public static BufferedImage[] G_NPC_3;
	public static BufferedImage[] G_NPC_4;
	public static BufferedImage[] G_NPC_5;
	public static BufferedImage[] I_NPC_1;
	public static BufferedImage[] I_NPC_2;
	public static BufferedImage[] I_NPC_3;
	public static BufferedImage[] I_NPC_4;
	public static BufferedImage[] I_NPC_5;
	public static BufferedImage[] F_NPC_1;
	public static BufferedImage[] F_NPC_2;
	public static BufferedImage[] F_NPC_3;
	public static BufferedImage[] F_NPC_4;
	public static BufferedImage[] F_NPC_5;
	private static int col=0;
	private static int row=0;
	
	public static void init() {
		G_NPC_1();
		G_NPC_2();
		G_NPC_3();
		G_NPC_4();
		G_NPC_5();
		I_NPC_1();
		I_NPC_2();
		I_NPC_3();
		I_NPC_4();
		I_NPC_5();
		F_NPC_1();
		F_NPC_2();
		F_NPC_3();
		F_NPC_4();
		F_NPC_5();
	}
	
	public static void G_NPC_1() {
		G_NPC_1=new BufferedImage[4];
		SpriteSheet G_NPC_1S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/G_NPC_1.png"));
		for(int i=0;i<4;i++) {
			G_NPC_1[i]=G_NPC_1S.crop(89*col,73*row ,89 ,73);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void G_NPC_2() {
		G_NPC_2=new BufferedImage[4];
		SpriteSheet G_NPC_2S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/G_NPC_2.png"));
		for(int i=0;i<4;i++) {
			G_NPC_2[i]=G_NPC_2S.crop(103*col,78*row ,103 ,78);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void G_NPC_3() {
		G_NPC_3=new BufferedImage[8];
		SpriteSheet G_NPC_3S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/G_NPC_3.png"));
		for(int i=0;i<8;i++) {
			G_NPC_3[i]=G_NPC_3S.crop(57*col,67*row ,57 ,67);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void G_NPC_4() {
		G_NPC_4=new BufferedImage[8];
		SpriteSheet G_NPC_4S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/G_NPC_4.png"));
		for(int i=0;i<8;i++) {
			G_NPC_4[i]=G_NPC_4S.crop(96*col,142*row ,96 ,142);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void G_NPC_5() {
		G_NPC_5=new BufferedImage[4];
		SpriteSheet G_NPC_5S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/G_NPC_5.png"));
		for(int i=0;i<4;i++) {
			G_NPC_5[i]=G_NPC_5S.crop(50*col,64*row ,50 ,64);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void I_NPC_1() {
		I_NPC_1=new BufferedImage[4];
		SpriteSheet I_NPC_1S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/I_NPC_1.png"));
		for(int i=0;i<4;i++) {
			I_NPC_1[i]=I_NPC_1S.crop(57*col,71*row ,57 ,71);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void I_NPC_2() {
		I_NPC_2=new BufferedImage[4];
		SpriteSheet I_NPC_2S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/I_NPC_2.png"));
		for(int i=0;i<4;i++) {
			I_NPC_2[i]=I_NPC_2S.crop(61*col,74*row ,61 ,74);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void I_NPC_3() {
		I_NPC_3=new BufferedImage[4];
		SpriteSheet I_NPC_3S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/I_NPC_3.png"));
		for(int i=0;i<4;i++) {
			I_NPC_3[i]=I_NPC_3S.crop(93*col,94*row ,93 ,94);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void I_NPC_4() {
		I_NPC_4=new BufferedImage[4];
		SpriteSheet I_NPC_4S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/I_NPC_4.png"));
		for(int i=0;i<4;i++) {
			I_NPC_4[i]=I_NPC_4S.crop(73*col,98*row ,73 ,98);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void I_NPC_5() {
		I_NPC_5=new BufferedImage[4];
		SpriteSheet I_NPC_5S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/I_NPC_5.png"));
		for(int i=0;i<4;i++) {
			I_NPC_5[i]=I_NPC_5S.crop(59*col,87*row ,59 ,87);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void F_NPC_1() {
		F_NPC_1=new BufferedImage[4];
		SpriteSheet F_NPC_1S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/F_NPC_1.png"));
		for(int i=0;i<4;i++) {
			F_NPC_1[i]=F_NPC_1S.crop(124*col,81*row ,124 ,81);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void F_NPC_2() {
		F_NPC_2=new BufferedImage[4];
		SpriteSheet F_NPC_2S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/F_NPC_2.png"));
		for(int i=0;i<4;i++) {
			F_NPC_2[i]=F_NPC_2S.crop(72*col,84*row ,72 ,84);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void F_NPC_3() {
		F_NPC_3=new BufferedImage[4];
		SpriteSheet F_NPC_3S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/F_NPC_3.png"));
		for(int i=0;i<4;i++) {
			F_NPC_3[i]=F_NPC_3S.crop(90*col,81*row,90 ,81);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void F_NPC_4() {
		F_NPC_4=new BufferedImage[4];
		SpriteSheet F_NPC_4S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/F_NPC_4.png"));
		for(int i=0;i<4;i++) {
			F_NPC_4[i]=F_NPC_4S.crop(72*col,77*row ,72 ,77);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	
	public static void F_NPC_5() {
		F_NPC_5=new BufferedImage[8];
		SpriteSheet F_NPC_5S=new SpriteSheet(ImageLoader.loadImage("textures/NPC/F_NPC_5.png"));
		for(int i=0;i<8;i++) {
			F_NPC_5[i]=F_NPC_5S.crop(108*col,98*row ,108 ,98);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
}
