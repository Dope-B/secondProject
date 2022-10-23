package gfx;

import java.awt.image.BufferedImage;

public class Asset_tree {

	public static BufferedImage[] tree;
	
	private static void tree() {
		tree=new BufferedImage[1];
		SpriteSheet tree_s=new SpriteSheet(ImageLoader.loadImage("textures/object/object.png"));
			tree[0]=tree_s.crop(0, 165, 82, 90);
	}
	public static void init() {tree();}
	
}
