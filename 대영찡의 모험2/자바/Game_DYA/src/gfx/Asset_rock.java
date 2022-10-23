package gfx;

import java.awt.image.BufferedImage;


public class Asset_rock {

	public static BufferedImage[] rock;
	
	
	private static void rock() {
		rock=new BufferedImage[1];
		SpriteSheet rock_s=new SpriteSheet(ImageLoader.loadImage("textures/object/object.png"));
		rock[0]=rock_s.crop(700, 417,60, 67);
	}
	public static void init() {rock();}
}
