package gfx;
import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	public SpriteSheet(BufferedImage sheet) {
		this.sheet=sheet;
	}
	public BufferedImage crop(int x,int y,int width,int height) {//이미지의 해당 좌표의 서브이미지 리턴
		return sheet.getSubimage(x, y, width, height);
	}
}
