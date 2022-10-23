package gfx;

import java.awt.image.BufferedImage;

import utils.ImageFlip;

public class Asset_portal {

	public static BufferedImage[] portal_L;
	public static BufferedImage[] portal_R;
	private static int col=0;
	private static int row=0;
	private static ImageFlip IF;
	
	public static void init() {portal_R();portal_L();}
	private static void portal_R() {
		portal_R=new BufferedImage[15];
		SpriteSheet portal_R_s=new SpriteSheet(ImageLoader.loadImage("textures/object/portal.png"));
		for(int i=0;i<15;i++) {
			portal_R[i]=portal_R_s.crop(1+94*col, 200*row, 94, 200);
			if(col==4) {
				row++;
				col=0;
			}
			else {col++;}
		}
		col=0;row=0;
	}
	private static void portal_L() {
		portal_L=new BufferedImage[15];
		IF=new ImageFlip();
		for(int i=0;i<15;i++) {
			portal_L[i]=IF.horizontalflip(portal_R[i]);
		}
	}
}
