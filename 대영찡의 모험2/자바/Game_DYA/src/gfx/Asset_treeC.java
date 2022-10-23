package gfx;

import java.awt.image.BufferedImage;

public class Asset_treeC {

public static BufferedImage[] treeC;
	
	private static void treeC() {
		treeC=new BufferedImage[1];
		SpriteSheet treeC_s=new SpriteSheet(ImageLoader.loadImage("textures/object/object.png"));
			treeC[0]=treeC_s.crop(95, 255, 80, 90);
	}
	public static void init() {treeC();}
}
