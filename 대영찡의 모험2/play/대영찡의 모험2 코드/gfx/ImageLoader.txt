package gfx;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path));//해당 경로에 존재하는 이미지 리턴
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
