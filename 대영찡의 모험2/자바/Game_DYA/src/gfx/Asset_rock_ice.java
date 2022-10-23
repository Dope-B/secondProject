package gfx;

import java.awt.image.BufferedImage;

public class Asset_rock_ice {
public static BufferedImage[] rock_ice;
	
	
	private static void rock_ice() {
		rock_ice=new BufferedImage[1];
		SpriteSheet rock_ice_s=new SpriteSheet(ImageLoader.loadImage("textures/object/object.png"));
		rock_ice[0]=rock_ice_s.crop(702, 180, 62 , 65);
	}
	public static void init() {rock_ice();}

}
