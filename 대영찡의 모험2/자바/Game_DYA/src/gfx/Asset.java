package gfx;
import java.awt.image.BufferedImage;
import utils.ImageFlip;

public class Asset {
	public static BufferedImage[] player_rainS2;// 행동 별 이미지 저장 공간배열
	public static BufferedImage[] player_rainS2_icon;
	public static BufferedImage[] player_rainS2_hurtL;
	public static BufferedImage[] player_rainS2_hurtR;
	public static BufferedImage[] player_rainS2_deadL;
	public static BufferedImage[] player_rainS2_deadR;
	public static BufferedImage[] player_rainS2_idleL;
	public static BufferedImage[] player_rainS2_idleR;
	public static BufferedImage[] player_rainS2_left;
	public static BufferedImage[] player_rainS2_right;
	public static BufferedImage[] player_rainS2_attack;
	public static BufferedImage[] player_rainS2_attack2;
	public static BufferedImage[] player_rainS2_attackR;
	public static BufferedImage[] player_rainS2_attack2R;
	public static BufferedImage[] player_rainS2_jumpL;
	public static BufferedImage[] player_rainS2_jumpR;
	public static BufferedImage[] player_rainS2_SattackL;
	public static BufferedImage[] player_rainS2_SattackR;
	public static BufferedImage[] player_rainS2_S2attackL;
	public static BufferedImage[] player_rainS2_S2attackR;
	public static BufferedImage[] player_rainS2_S3attackL;
	public static BufferedImage[] player_rainS2_S3attackR;
	private static int col=0;//서브이미지 저장 좌표 갱신 변수
	private static int row=0;
	private static ImageFlip IF;
	public static void init() {
		rainS2();
		
}

	private static void rainS2() {
		player_rainS2();
		rainS2_icon();
		rainS2_hurtL();
		rainS2_hurtR();
		rainS2_deadL();
		rainS2_deadR();
		rainS2_idleL();
		rainS2_idleR();
		rainS2_left();
		rainS2_right();
		rainS2_attack();
		rainS2_attack2();
		rainS2_attackR();
		rainS2_attack2R();
		rainS2_jumpL();
		rainS2_jumpR();
		rainS2_SattackL();
		rainS2_SattackR();
		rainS2_S2attackL();
		rainS2_S2attackR();
		rainS2_S3attackL();
		rainS2_S3attackR();
	}

	//이미지 저장 함수 
	
	public static void player_rainS2() {
		player_rainS2=new BufferedImage[1];
		SpriteSheet rainS2=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2.png"));
		player_rainS2[0]=rainS2.crop(0,0,93 ,69);
	}
	public static void rainS2_icon() {
		player_rainS2_icon=new BufferedImage[1];
		SpriteSheet rainS2_icon=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_icon.png"));
		player_rainS2_icon[0]=rainS2_icon.crop(0,0,56,38);
	}
	public static void rainS2_hurtL() {
		player_rainS2_hurtL=new BufferedImage[1];
		SpriteSheet rainS2_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_hurt.png"));
		player_rainS2_hurtL[0]=rainS2_hurtL.crop(0,0,65,64);
	}
	public static void rainS2_hurtR() {
		player_rainS2_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		player_rainS2_hurtR[0]=IF.horizontalflip(player_rainS2_hurtL[0]);
	}
	public static void rainS2_deadL() {
		player_rainS2_deadL=new BufferedImage[1];
		SpriteSheet rainS2_deadL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_dead.png"));
		player_rainS2_deadL[0]=rainS2_deadL.crop(0,0,90,57);
	}
	public static void rainS2_deadR() {
		player_rainS2_deadR=new BufferedImage[1];
		IF=new ImageFlip();
		player_rainS2_deadR[0]=IF.horizontalflip(player_rainS2_deadL[0]);
	}
	private static void rainS2_jumpL() {
		player_rainS2_jumpL=new BufferedImage[1];
		SpriteSheet rainS2_jumpL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_jump.png"));
		player_rainS2_jumpL[0]=rainS2_jumpL.crop(0, 0, 78, 57);
	}
	private static void rainS2_jumpR() {
		player_rainS2_jumpR=new BufferedImage[1];
		IF=new ImageFlip();
		player_rainS2_jumpR[0]=IF.horizontalflip(player_rainS2_jumpL[0]);
	}
	private static void rainS2_S2attackL() {
		row=17;
		player_rainS2_S2attackL=new BufferedImage[24];
		SpriteSheet rainS2_S2attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_limit.png"));
		for(int i=0;i<24;i++) {
			player_rainS2_S2attackL[i]=rainS2_S2attackL.crop(829*col,281*row ,829 ,281);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
	}
	private static void rainS2_S2attackR() {
		player_rainS2_S2attackR=new BufferedImage[24];
		IF=new ImageFlip();
		for(int i=0;i<24;i++) {
			player_rainS2_S2attackR[i]=IF.horizontalflip(player_rainS2_S2attackL[i]);
		}
	}
	private static void rainS2_S3attackL() {
		row=0;
		player_rainS2_S3attackL=new BufferedImage[16];
		SpriteSheet rainS2_S3attackL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_limit.png"));
		for(int i=0;i<16;i++) {
			player_rainS2_S3attackL[i]=rainS2_S3attackL.crop(829*col,281*row ,829 ,281);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
	}
	private static void rainS2_S3attackR() {
		player_rainS2_S3attackR=new BufferedImage[16];
		IF=new ImageFlip();
		for(int i=0;i<16;i++) {
			player_rainS2_S3attackR[i]=IF.horizontalflip(player_rainS2_S3attackL[i]);
		}
	}
	private static void rainS2_SattackL() {
		row=29;
		player_rainS2_SattackL=new BufferedImage[30];
		SpriteSheet rainS2_SattackL=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_limit.png"));
		for(int i=0;i<30;i++) {
			player_rainS2_SattackL[i]=rainS2_SattackL.crop(829*col,281*row ,829 ,281);
			if(col==2) {col=0;row++;}
			else{col++;}
		}
		col=0;row=0;
	}
	private static void rainS2_SattackR() {
		player_rainS2_SattackR=new BufferedImage[30];
		IF=new ImageFlip();
		for(int i=0;i<30;i++) {
			player_rainS2_SattackR[i]=IF.horizontalflip(player_rainS2_SattackL[i]);	}
	}
	private static void rainS2_idleL() {
		player_rainS2_idleL=new BufferedImage[8];
		SpriteSheet rainS2_idleL = new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_idle.png"));
		player_rainS2_idleL[0]=rainS2_idleL.crop(6,26,70,50);
		player_rainS2_idleL[1]=rainS2_idleL.crop(96,26,70,50);
		player_rainS2_idleL[2]=rainS2_idleL.crop(186,26,70,50);
		player_rainS2_idleL[3]=rainS2_idleL.crop(6,112,70,50);
		player_rainS2_idleL[4]=rainS2_idleL.crop(96,112,70,50);
		player_rainS2_idleL[5]=rainS2_idleL.crop(186,112,70,50);
		player_rainS2_idleL[6]=rainS2_idleL.crop(6,198,70,50);
		player_rainS2_idleL[7]=rainS2_idleL.crop(96,198,70,50);
	}
	private static void rainS2_idleR() {
		player_rainS2_idleR=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {player_rainS2_idleR[i]=IF.horizontalflip(player_rainS2_idleL[i]);}
	}
	private static void rainS2_left() {
		player_rainS2_left=new BufferedImage[4];
		SpriteSheet rainS2_left = new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_left.png"));
		player_rainS2_left[0]=rainS2_left.crop(5,6,70,50);
		player_rainS2_left[1]=rainS2_left.crop(85,6,70,50);
		player_rainS2_left[2]=rainS2_left.crop(160,6,70,50);
		player_rainS2_left[3]=rainS2_left.crop(5,68,70,50);
	}
	private static void rainS2_right() {
		player_rainS2_right=new BufferedImage[4];
		SpriteSheet rainS2_right = new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_right.png"));
		player_rainS2_right[0]=rainS2_right.crop(10,6,70,50);
		player_rainS2_right[1]=rainS2_right.crop(90,6,70,50);
		player_rainS2_right[2]=rainS2_right.crop(165,6,70,50);
		player_rainS2_right[3]=rainS2_right.crop(165,68,70,50);
	}
	private static void rainS2_attack() {
		player_rainS2_attack=new BufferedImage[7];
		SpriteSheet rainS2_attack=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_attack.png"));
		player_rainS2_attack[0]=rainS2_attack.crop(48, 0, 173, 100);
		player_rainS2_attack[1]=rainS2_attack.crop(273, 0, 173, 100);
		player_rainS2_attack[2]=rainS2_attack.crop(495, 0, 173, 100);
		player_rainS2_attack[3]=rainS2_attack.crop(48, 115, 173, 115);
		player_rainS2_attack[4]=rainS2_attack.crop(267, 120, 153, 120);
		player_rainS2_attack[5]=rainS2_attack.crop(494, 120, 153, 120);
		player_rainS2_attack[6]=rainS2_attack.crop(45, 246, 153, 120);
	}
	private static void rainS2_attack2() {
		player_rainS2_attack2=new BufferedImage[8];
		SpriteSheet rainS2_attack2=new SpriteSheet(ImageLoader.loadImage("textures/player/rainS2/rainS2_attack.png"));
		player_rainS2_attack2[0]=rainS2_attack2.crop(280, 234, 155, 120);
		player_rainS2_attack2[1]=rainS2_attack2.crop(465, 234, 155, 100);
		player_rainS2_attack2[2]=rainS2_attack2.crop(17, 352, 155, 100);
		player_rainS2_attack2[3]=rainS2_attack2.crop(241, 352, 155, 100);
		player_rainS2_attack2[4]=rainS2_attack2.crop(465, 352, 155, 100);
		player_rainS2_attack2[5]=rainS2_attack2.crop(17, 470, 155, 100);
		player_rainS2_attack2[6]=rainS2_attack2.crop(241, 470, 155, 100);
		player_rainS2_attack2[7]=rainS2_attack2.crop(465, 470, 155, 100);
	}
	private static void rainS2_attackR() {
		player_rainS2_attackR=new BufferedImage[7];
		IF=new ImageFlip();
		for(int i=0;i<7;i++) {player_rainS2_attackR[i]=IF.horizontalflip(player_rainS2_attack[i]);}
	}
	private static void rainS2_attack2R() {
		player_rainS2_attack2R=new BufferedImage[8];
		IF=new ImageFlip();
		for(int i=0;i<8;i++) {player_rainS2_attack2R[i]=IF.horizontalflip(player_rainS2_attack2[i]);}
	}
}
