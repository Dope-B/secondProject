package input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys;
	public boolean up,down,left,right,attack,attack2,jump,Sattack,S2attack,S3attack,enter,esc;
	public KeyManager() {
		keys=new boolean[256];
	}
	public void tick() {// 키 입렉
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
		attack=keys[KeyEvent.VK_X];
		attack2=keys[KeyEvent.VK_Z];
		jump=keys[KeyEvent.VK_C];
		Sattack=keys[KeyEvent.VK_A];
		S2attack=keys[KeyEvent.VK_S];
		S3attack=keys[KeyEvent.VK_D];
		enter=keys[KeyEvent.VK_SPACE];
		esc=keys[KeyEvent.VK_ESCAPE];
	}
	public void keyPressed(KeyEvent e) {// 눌렀을 시 true
		keys[e.getKeyCode()]=true;
	}

	public void keyReleased(KeyEvent e) {// 비 입력 시 false
		keys[e.getKeyCode()]=false;
	}

	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()]=true;
	}
	
}
