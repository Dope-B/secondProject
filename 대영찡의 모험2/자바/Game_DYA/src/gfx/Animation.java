package gfx;
import java.awt.image.BufferedImage;

public class Animation {
	private int speed,index;//프레임 갱신 속도, 안덱스 번호
	private long lastTime,timer;//시간 저장
	private BufferedImage[] frames;
	public Animation(int speed, BufferedImage[] frames) {
		this.speed=speed;
		this.frames=frames;
		index=0;
		timer=0;
		lastTime=System.currentTimeMillis();
	}
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	public void tick() {
		timer+=System.currentTimeMillis()-lastTime;
		lastTime=System.currentTimeMillis();
		if(timer>speed) {index++;timer=0;}//timer가 speed보다 높다면 인덱스번호 증가
		if(index>=frames.length) {index=0;}//프레임이 한바퀴를 돈다면 인덱스 번호를 0으로 저장
		}
	
	public int getIndex() {return index;}
	public void setIndex(int x) {this.index=x;}
}
