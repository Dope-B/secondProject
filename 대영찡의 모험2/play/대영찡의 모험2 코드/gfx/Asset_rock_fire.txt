package gfx;

import java.awt.image.BufferedImage;

public class Asset_rock_fire {

public static BufferedImage[] rock_fire;
	
	
	private static void rock_fire() {
		rock_fire=new BufferedImage[5];
		SpriteSheet rock_fire_s=new SpriteSheet(ImageLoader.loadImage("textures/object/object.png"));
		rock_fire[0]=rock_fire_s.crop(149,0,48 ,55);
		rock_fire[1]=rock_fire_s.crop(197,0,48 ,55);
		rock_fire[2]=rock_fire_s.crop(245,0,48 ,55);
		rock_fire[3]=rock_fire_s.crop(293,0,48 ,55);
		rock_fire[4]=rock_fire_s.crop(341,0,48 ,55);
	}
	public static void init() {rock_fire();}
}
