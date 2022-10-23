package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_heltich {

	public static BufferedImage[] player_heltich;
	public static BufferedImage[] player_heltich_icon;
	public static BufferedImage[] player_heltich_hurtL;
	public static BufferedImage[] player_heltich_hurtR;
	public static BufferedImage[] player_heltich_deadL;
	public static BufferedImage[] player_heltich_deadR;
	public static BufferedImage[] player_heltich_idleL;
	public static BufferedImage[] player_heltich_idleR;
	public static BufferedImage[] player_heltich_attackL;
	public static BufferedImage[] player_heltich_attackR;
	public static BufferedImage[] player_heltich_attack2L;
	public static BufferedImage[] player_heltich_attack2R;
	public static BufferedImage[] player_heltich_jumpL;
	public static BufferedImage[] player_heltich_jumpR;
	public static BufferedImage[] player_heltich_moveL;
	public static BufferedImage[] player_heltich_moveR;
	public static BufferedImage[] player_heltich_SattackL;
	public static BufferedImage[] player_heltich_SattackR;
	public static BufferedImage[] player_heltich_S2attackL;
	public static BufferedImage[] player_heltich_S2attackR;
	public static BufferedImage[] player_heltich_S3attackL;
	public static BufferedImage[] player_heltich_S3attackR;
	private static int col = 0;
	private static int row = 0;
	private static ImageFlip IF;

	public static void init() {
		heltich();

	}

	private static void heltich() {
		player_heltich();
		heltich_icon();
		heltich_hurtL();
		heltich_hurtR();
		heltich_deadL();
		heltich_deadR();
		heltich_idleL();
		heltich_idleR();
		heltich_attackL();
		heltich_attackR();
		heltich_SattackL();
		heltich_SattackR();
		heltich_S2attackL();
		heltich_S2attackR();
		heltich_attack2L();
		heltich_attack2R();
		heltich_jumpL();
		heltich_jumpR();
		heltich_moveL();
		heltich_moveR();
		heltich_S3attackL();
		heltich_S3attackR();
	}

	public static void player_heltich() {
		player_heltich=new BufferedImage[1];
		SpriteSheet heltich=new SpriteSheet(ImageLoader.loadImage("textures/player/heltich/heltich.png"));
		player_heltich[0]=heltich.crop(0,0,85 ,86);
	}
	public static void heltich_icon() {
		player_heltich_icon=new BufferedImage[1];
		SpriteSheet heltich_icon=new SpriteSheet(ImageLoader.loadImage("textures/player/heltich/heltich_icon.png"));
		player_heltich_icon[0]=heltich_icon.crop(0,0,56,38);
	}
	public static void heltich_hurtL() {
		player_heltich_hurtL=new BufferedImage[1];
		SpriteSheet heltich_hurtL=new SpriteSheet(ImageLoader.loadImage("textures/player/heltich/heltich_hurt.png"));
		player_heltich_hurtL[0]=heltich_hurtL.crop(0,0,91,65);
	}
	public static void heltich_hurtR() {
		player_heltich_hurtR=new BufferedImage[1];
		IF=new ImageFlip();
		player_heltich_hurtR[0]=IF.horizontalflip(player_heltich_hurtL[0]);
	}
	public static void heltich_deadL() {
		player_heltich_deadL=new BufferedImage[1];
		SpriteSheet heltich_deadL=new SpriteSheet(ImageLoader.loadImage("textures/player/heltich/heltich_dead.png"));
		player_heltich_deadL[0]=heltich_deadL.crop(0,0,98,58);
	}
	public static void heltich_deadR() {
		player_heltich_deadR=new BufferedImage[1];
		IF=new ImageFlip();
		player_heltich_deadR[0]=IF.horizontalflip(player_heltich_deadL[0]);
	}
	
	public static void heltich_idleL() {
		player_heltich_idleL = new BufferedImage[8];
		SpriteSheet heltich_idleL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_idle.png"));
		for (int i = 0; i < 8; i++) {
			player_heltich_idleL[i] = heltich_idleL.crop(75 * col, 79 * row, 75, 79);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_idleR() {
		player_heltich_idleR = new BufferedImage[8];
		IF = new ImageFlip();
		for (int i = 0; i < 8; i++) {
			player_heltich_idleR[i] = IF.horizontalflip(player_heltich_idleL[i]);
		}
	}

	public static void heltich_moveL() {
		player_heltich_moveL = new BufferedImage[1];
		SpriteSheet heltich_moveL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_move.png"));
		player_heltich_moveL[0] = heltich_moveL.crop(0, 0, 91, 73);
	}

	public static void heltich_moveR() {
		player_heltich_moveR = new BufferedImage[1];
		IF = new ImageFlip();
		player_heltich_moveR[0] = IF.horizontalflip(player_heltich_moveL[0]);
	}

	public static void heltich_jumpL() {
		player_heltich_jumpL = new BufferedImage[1];
		SpriteSheet heltich_jumpL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_jump.png"));
		player_heltich_jumpL[0] = heltich_jumpL.crop(0, 0, 75, 77);
	}

	public static void heltich_jumpR() {
		player_heltich_jumpR = new BufferedImage[1];
		IF = new ImageFlip();
		player_heltich_jumpR[0] = IF.horizontalflip(player_heltich_jumpL[0]);
	}

	public static void heltich_attackL() {
		player_heltich_attackL = new BufferedImage[7];
		SpriteSheet heltich_attackL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_attack.png"));
		for (int i = 0; i < 7; i++) {
			player_heltich_attackL[i] = heltich_attackL.crop(193 * col, 112 * row, 193, 112);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_attackR() {
		player_heltich_attackR = new BufferedImage[7];
		IF = new ImageFlip();
		for (int i = 0; i < 7; i++) {
			player_heltich_attackR[i] = IF.horizontalflip(player_heltich_attackL[i]);
		}
	}

	public static void heltich_attack2L() {
		row = 2;
		col = 1;
		player_heltich_attack2L = new BufferedImage[9];
		SpriteSheet heltich_attack2L = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_attack.png"));
		for (int i = 0; i < 9; i++) {
			player_heltich_attack2L[i] = heltich_attack2L.crop(193 * col, 112 * row, 193, 112);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_attack2R() {
		player_heltich_attack2R = new BufferedImage[9];
		IF = new ImageFlip();
		for (int i = 0; i < 9; i++) {
			player_heltich_attack2R[i] = IF.horizontalflip(player_heltich_attack2L[i]);
		}
	}

	public static void heltich_SattackL() {
		player_heltich_SattackL = new BufferedImage[4];
		SpriteSheet heltich_SattackL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_S2attack.png"));
		for (int i = 0; i < 4; i++) {
			player_heltich_SattackL[i] = heltich_SattackL.crop(96 * col, 77 * row, 96, 77);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_SattackR() {
		player_heltich_SattackR = new BufferedImage[4];
		IF = new ImageFlip();
		for (int i = 0; i < 4; i++) {
			player_heltich_SattackR[i] = IF.horizontalflip(player_heltich_SattackL[i]);
		}
	}

	public static void heltich_S2attackL() {
		player_heltich_S2attackL = new BufferedImage[4];
		SpriteSheet heltich_S2attackL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_S3attack.png"));
		for (int i = 0; i < 4; i++) {
			player_heltich_S2attackL[i] = heltich_S2attackL.crop(64 * col, 96 * row, 64, 96);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_S2attackR() {
		player_heltich_S2attackR = new BufferedImage[4];
		IF = new ImageFlip();
		for (int i = 0; i < 4; i++) {
			player_heltich_S2attackR[i] = IF.horizontalflip(player_heltich_S2attackL[i]);
		}
	}

	public static void heltich_S3attackL() {
		player_heltich_S3attackL = new BufferedImage[29];
		SpriteSheet heltich_S3attackL = new SpriteSheet(
				ImageLoader.loadImage("textures/player/heltich/heltich_Sattack.png"));
		for (int i = 0; i < 29; i++) {
			player_heltich_S3attackL[i] = heltich_S3attackL.crop(173 * col, 158 * row, 173, 158);
			if (col == 2) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void heltich_S3attackR() {
		player_heltich_S3attackR = new BufferedImage[29];
		IF = new ImageFlip();
		for (int i = 0; i < 29; i++) {
			player_heltich_S3attackR[i] = IF.horizontalflip(player_heltich_S3attackL[i]);
		}
	}
}
