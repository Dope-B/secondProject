package gfx;

import java.awt.image.BufferedImage;

public class Asset_tile {
	public static BufferedImage grass_tile;
	public static BufferedImage rock_tile;
	public static BufferedImage ice_tile;
	public static BufferedImage fire_tile;
	
	public static void init() {tile();}
	
	private static void tile() {
		SpriteSheet tile=new SpriteSheet(ImageLoader.loadImage("textures/Tile.png"));
		grass_tile=tile.crop(398, 788, 45, 45);
		rock_tile=tile.crop(385, 875, 52, 55);
		ice_tile=tile.crop(200, 1040, 45, 45);
		fire_tile=tile.crop(390, 1040, 45, 45);
	}
}
