package window;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class window {
	private JFrame frame;
	private Canvas canvas;
	private int width,height;
	private String title;
	public window(String title, int width, int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		createWindow();
	}
	private void createWindow() {
		frame=new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// 크기 변경 불가
		frame.setLocationRelativeTo(null);// 창을 화면 가운데에 띄움
		frame.setVisible(true);
		canvas=new Canvas();// 캔버스(크기 고정)
		canvas.setPreferredSize(new Dimension(width,height));//캔버스 크기
		canvas.setMaximumSize(new Dimension(width,height));//캔버스 최대 크기
		canvas.setMinimumSize(new Dimension(width,height));//캔버스 최소 크기
		canvas.setFocusable(false);// 포커스 지정 x
		frame.add(canvas);//프레임에 캔버스 추가
		frame.pack();//캔버스를 완전하게 출력
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
