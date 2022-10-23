package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_effect {

	public static BufferedImage[] fire;
	public static BufferedImage[] fire_col;
	public static BufferedImage[] iceDragonL;
	public static BufferedImage[] blueFire;
	public static BufferedImage[] bolt;
	public static BufferedImage[] iceDragonR;
	public static BufferedImage[] explosion;
	public static BufferedImage[] D_effect;
	public static BufferedImage[] D_number;
	private static int col = 0;
	private static int row = 0;
	private static ImageFlip IF;

	public static void init() {
		fire();
		fire_col();
		iceDragonR();
		iceDragonL();
		bolt();
		blueFire();
		explosion();
		E_damage();
	}
	
	public static void E_damage() {
		D_effect=new BufferedImage[5];
		SpriteSheet D_effect_s=new SpriteSheet(ImageLoader.loadImage("textures/effect/hit_effect.png"));
		for(int i=0;i<5;i++) {
			D_effect[i]=D_effect_s.crop(50*col, 0, 50, 50);
			col++;
		}
		col=0;row=0;
	}


	public static void blueFire() {
		blueFire = new BufferedImage[10];
		SpriteSheet blueFire_s = new SpriteSheet(ImageLoader.loadImage("textures/effect/fire.png"));
		for (int i = 0; i < 10; i++) {
			blueFire[i] = blueFire_s.crop(217 * col, 224 * row, 217, 224);
			if (col == 3) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}

	public static void fire_col() {
		fire_col = new BufferedImage[11];
		SpriteSheet fire_col_s = new SpriteSheet(ImageLoader.loadImage("textures/effect/fire_col.png"));
		fire_col[0] = fire_col_s.crop(0,0, 64, 219);
		for (int i = 1; i < 11; i++) {
			fire_col[i] = fire_col_s.crop(112*(i-1)+64,0, 112, 219);
			}
		col = 0;
		row = 0;
	}

	public static void iceDragonR() {
		row=1;
		iceDragonR = new BufferedImage[10];
		SpriteSheet iceDragonR_s = new SpriteSheet(ImageLoader.loadImage("textures/effect/ice.png"));
		iceDragonR[0] = iceDragonR_s.crop(0, 10, 212, 162);
		for (int i = 1; i < 10; i++) {
			iceDragonR[i] = iceDragonR_s.crop(0, 5+163*row, 212, 162);
			row++;
		}
		col=0;row=0;
	}

	public static void iceDragonL() {
		iceDragonL = new BufferedImage[10];
		IF = new ImageFlip();
		for (int i = 0; i < 10; i++) {
			iceDragonL[i] = IF.horizontalflip(iceDragonR[i]);
		}
	}

	public static void bolt() {
		bolt=new BufferedImage[8];
		SpriteSheet bolt_s=new SpriteSheet(ImageLoader.loadImage("textures/effect/bolt.png"));
		for(int i=0;i<8;i++) {
			bolt[i]=bolt_s.crop(col*160, 0, 160,300 );
			col++;
		}
		col=0;row=0;
	}

	public static void fire() {
		fire = new BufferedImage[19];
		SpriteSheet fire_s = new SpriteSheet(ImageLoader.loadImage("textures/effect/fire2.png"));
		for (int i = 0; i < 19; i++) {
			fire[i] = fire_s.crop(149 * col, 157 * row, 149, 157);
			if (col == 6) {
				col = 0;
				row++;
			} else {
				col++;
			}
		}
		col = 0;
		row = 0;
	}
	public static void explosion() {
		explosion=new BufferedImage[18];
		SpriteSheet explosion_s=new SpriteSheet(ImageLoader.loadImage("textures/effect/explosion.png"));
		for(int i=0;i<18;i++) {
			explosion[i]=explosion_s.crop(50*col, 0, 50, 128);
			col++;
		}
		col=0;row=0;
	}
}
