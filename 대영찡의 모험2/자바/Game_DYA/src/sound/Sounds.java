package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sounds {
	
	public boolean isPlayed=false;
	public boolean isPlayed_magic1=false;
	public boolean isPlayed_magic2=false;
	public boolean isPlayed_FC=false;
	
	private void setVol(double d, Clip clip) {//볼륨 조절 함수
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float dB=(float) (Math.log(d)/Math.log(10)*20);
		gainControl.setValue(dB);
	}
	
	public void menu_sel() {
			try {
				 AudioInputStream click = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/menu/click.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(click);
				 setVol(0.08, clip);
				 clip.start();
			}catch(Exception e) {e.printStackTrace();}
	}
	public void menu_move() {
			try {
				 AudioInputStream m_move = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/menu/m_move.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(m_move);
				 setVol(0.12, clip);
				 clip.start();
			}catch(Exception e) {e.printStackTrace();}
	}
	public void menu_back() {
			try {
				 AudioInputStream back = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/menu/back.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(back);
				 setVol(0.08, clip);
				 clip.start();
			}catch(Exception e) {e.printStackTrace();}
	}
	public void teleport() {
		try {
			 AudioInputStream teleport = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/teleport.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(teleport);
			 setVol(0.08, clip);
			 clip.start();
		}catch(Exception e) {e.printStackTrace();}
}
	public void E_die() {
			try {
				 AudioInputStream E_die = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/E_die.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(E_die);
				 setVol(0.08, clip);
				 clip.start();
			}catch(Exception e) {e.printStackTrace();}
	}
	public void over() {
	
			try {
				 AudioInputStream over = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/over.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(over);
				 setVol(0.12, clip);
				 clip.start();
			}catch(Exception e) {e.printStackTrace();}
	}
	public void BGM() {
		
			try {
				 AudioInputStream BGM = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/menu/BGM.wav"));
				 Clip clip = AudioSystem.getClip();
				 clip.open(BGM);
				 setVol(0.04, clip);
				 clip.start();
				 clip.loop(Clip.LOOP_CONTINUOUSLY);
			}catch(Exception e) {e.printStackTrace();}
	}
	
	public void slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/slash.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(slash);
			 clip.start();
			 isPlayed=true;

		}catch(Exception e) {e.printStackTrace();}}
	}	

	public void sharp_slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream sharp_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/sword_2.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(sharp_slash);
			 setVol(0.1,clip);
				 clip.start();
				 isPlayed=true;
				 
		}catch(Exception e) {e.printStackTrace();}}
	}

	public void wide_slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream wide_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/sword.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(wide_slash);
			 setVol(0.1,clip);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void strong_slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream strong_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/bash.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(strong_slash);
			 setVol(0.04,clip);
			 clip.start(); 
			 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void arrow() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream arrow = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/arrow.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(arrow);
				 clip.start(); 
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}

	public void brutal_slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream brutal_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/deep_slash.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(brutal_slash);
			 setVol(0.12,clip);
				 clip.start(); 
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void cast_fire() {//ok
		if(!isPlayed_magic2) {
		try {
			 AudioInputStream fire = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/fire.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(fire);
			 setVol(0.1,clip);
				 clip.start(); 
				 isPlayed_magic2=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void FC() {//ok
		if(!isPlayed_FC) {
		try {
			 AudioInputStream fire_col = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/fire_col.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(fire_col);
			 setVol(0.25,clip);
				 clip.start(); 
				 isPlayed_FC=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void laser() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream laser = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/laser.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(laser);
			 setVol(0.04,clip);
				 clip.start();
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void missile() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream missile = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/missile.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(missile);
			 setVol(0.04,clip);
				 clip.start(); 	
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void move() {//x
		if(!isPlayed) {
		try {
			 AudioInputStream move = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/move.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(move);
				 clip.start();
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void dash_slash() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream dash_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/move_slash.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(dash_slash);
			 setVol(0.12,clip);
				 clip.start(); 
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void wave() {//ok
		if(!isPlayed_magic1) {
		try {
			 AudioInputStream wave = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/wave.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(wave);
			 setVol(0.12,clip);
				 clip.start(); 
				 isPlayed_magic1=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	
	public void stomp() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream stomp = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/stomp.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(stomp);
			 setVol(0.04,clip);
				 clip.start(); 
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void summon() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream summon = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/summon.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(summon);
				 clip.start(); 
				 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void rifle() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream rifle = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/rifle.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(rifle);
			 setVol(0.02,clip);
			 clip.start(); 
			 isPlayed=true;
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void smash() {//x
		if(!isPlayed) {
		try {
			 AudioInputStream smash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/smash.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(smash);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void woosh() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream woosh = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/woosh.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(woosh);
			 setVol(0.25,clip);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void strong_woosh() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream strong_woosh = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/strong_woosh.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(strong_woosh);
			 setVol(0.06,clip);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	
	public void explosion() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream wide_slash = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/explosion.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(wide_slash);
			 setVol(0.05,clip);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void sweep() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream sweep = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/sweep.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(sweep);
			 setVol(0.06,clip);
			 clip.start(); 
			 isPlayed=true;
			 
		}catch(Exception e) {e.printStackTrace();}}
	}
	public void damaged() {//ok
		try {
			 AudioInputStream damaged = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/damaged.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(damaged);
			 setVol(0.03,clip);
			 clip.start(); 
		}catch(Exception e) {e.printStackTrace();}
	}
	public void slime() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream slime = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/slime.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(slime);
			 setVol(0.1,clip);
			 clip.start();
			 isPlayed=true;

		}catch(Exception e) {e.printStackTrace();}}
	}	
	public void thunder() {//ok
		if(!isPlayed) {
		try {
			 AudioInputStream thunder = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/thunder.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(thunder);
			 setVol(0.2,clip);
			 clip.start();
			 isPlayed=true;

		}catch(Exception e) {e.printStackTrace();}}
	}	
	public void jump() {//ok
		try {
			 AudioInputStream jump = AudioSystem.getAudioInputStream(Sounds.class.getClassLoader().getResource("sound/play/jump.wav"));
			 Clip clip = AudioSystem.getClip();
			 clip.open(jump);
			 setVol(0.03,clip);
			 clip.start(); 
		}catch(Exception e) {e.printStackTrace();}
	}
	}

