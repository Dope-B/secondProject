package State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Creature.Player;
import Creature.Player_arte;
import Creature.Player_eve;
import Creature.Player_heltich;
import Creature.Player_lasswell;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset;
import gfx.Asset_Lasswell;
import gfx.Asset_arte;
import gfx.Asset_eve;
import gfx.Asset_heltich;
import gfx.ImageLoader;
import sound.Sounds;
import world.World_checker;

public class MenuState extends State{
	
	private BufferedImage[] MainImage;
	private BufferedImage[] Select;
	private BufferedImage[] Title;
	public World_checker world_checker;
	private Animation rain;
	private Animation lasswell;
	private Animation arte;
	private Animation heltich;
	private Animation eve;
	private Sounds sound;
	private int sel=0;//메뉴 선택
	public int Csel=0;//케릭터 선택
	private boolean isPressed=false;//키 입력 여부
	public int section=0;//화면 순서
	private int dead_ticker=0;//케릭터 사망시 쿨타임
	
	public MenuState(Handler handler) {
		super(handler);
		sound=new Sounds();
		rain=new Animation(100,Asset.player_rainS2_idleL);
		lasswell=new Animation(100,Asset_Lasswell.player_lasswell_idleL);
		arte=new Animation(100,Asset_arte.player_arte_idleL);
		heltich=new Animation(70,Asset_heltich.player_heltich_idleL);
		eve=new Animation(100,Asset_eve.player_eve_idleL);
		sound.BGM();
		main();
		select();
		title();
		
	}
	
	private void main() {//메인 이미지 저장 함수
		MainImage=new BufferedImage[1];
		MainImage[0]=ImageLoader.loadImage("menu/BG.png");
	}
	private void select() {// 메뉴 선택 이미지 저장 함수
		Select=new BufferedImage[3];
		Select[0]=ImageLoader.loadImage("menu/1.png");
		Select[1]=ImageLoader.loadImage("menu/2.png");
		Select[2]=ImageLoader.loadImage("menu/3.png");
	}
	
	private void title() {//제목 이미지 저장 함수
		Title=new BufferedImage[1];
		Title[0]=ImageLoader.loadImage("menu/Title.png");
	}

	private void back() {// esc를 누를시 이전 화면으로 전환
		if(!isPressed) {
		if(handler.getKeyManager().esc) {
			section--;
			isPressed=false;
			sound.menu_back();
		}}
	}
	
	private void back2() {
		if(!isPressed) {
		if(handler.getKeyManager().esc) {
			section--;
			isPressed=false;
			sound.menu_back();
		}}check();
	}
	
	
	public void tick() {
	
		switch(section) {//섹션에 따른 tick
		case 0:
			mainSelect();
			break;
		case 1:
			back();
			charSelect();
			
			break;
		default:
			back2();
			revive();
			break;
		}
	}
	private void revive() {//캐릭터 사망 시 부활 함수
		if(!world_checker.player.isActive()) {
			if(dead_ticker==20) {sound.over();}
			if(dead_ticker>150) {
			choose_character();
			dead_ticker=0;}
			else {dead_ticker++;}
		}
	}

	private void choose_character() {// Csel에 따른 캐릭터 선택 함수
		switch(Csel) {
		case 0:
			world_checker=new World_checker(handler,new Player(handler,500,300));
			handler.setWorld_checker(world_checker);
			break;
		case 1:
			world_checker=new World_checker(handler,new Player_lasswell(handler,500,300));
			handler.setWorld_checker(world_checker);
			break;
		case 2:
			world_checker=new World_checker(handler,new Player_arte(handler,500,300));
			handler.setWorld_checker(world_checker);
			break;
		case 3:
			world_checker=new World_checker(handler,new Player_heltich(handler,500,300));
			handler.setWorld_checker(world_checker);
			break;
		case 4:
			world_checker=new World_checker(handler,new Player_eve(handler,500,300));
			handler.setWorld_checker(world_checker);
			break;
		}
	}
	
	public void render(Graphics g) {
		switch(section) {
		case 0://처음 화면
				g.drawImage(MainImage[0],0,0,null);
				g.drawImage(Title[0],0,0,null);
				g.drawImage(Select[sel], 0, 0,null);
				break;
		case 1:
				g.drawImage(MainImage[0],0,0,null);
				switch(Csel) {// 케릭터 선택에 따른 효과(Csel에 해당하는 캐릭터의 배경 투명도가 낮아지고 tick함수가 실행된다)
				case 0:
					rain.tick();
					lasswell.setIndex(0);
					arte.setIndex(0);
					heltich.setIndex(0);
					eve.setIndex(0);
					g.setColor(new Color(255,255,255,200));
					g.fillRect(30, 200, 150, 150);
					g.drawImage(rain.getCurrentFrame(),60,245,70,65,null);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(190, 200, 150, 150);
					g.drawImage(lasswell.getCurrentFrame(), 220, 240,80,80, null);
					g.fillRect(350, 200, 150, 150);
					g.drawImage(arte.getCurrentFrame(), 380, 240,80,80, null);
					g.fillRect(510, 200, 150, 150);
					g.drawImage(heltich.getCurrentFrame(), 540, 240,80,80, null);
					g.fillRect(670, 200, 150, 150);
					g.drawImage(eve.getCurrentFrame(), 700, 240,80,80, null);
					break;
				case 1:
					lasswell.tick();
					rain.setIndex(0);
					arte.setIndex(0);
					heltich.setIndex(0);
					eve.setIndex(0);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(30, 200, 150, 150);
					g.drawImage(rain.getCurrentFrame(),60,245,70,65,null);
					g.setColor(new Color(255,255,255,200));
					g.fillRect(190, 200, 150, 150);
					g.drawImage(lasswell.getCurrentFrame(), 220, 240,80,80,null);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(350, 200, 150, 150);
					g.drawImage(arte.getCurrentFrame(), 380, 240,80,80, null);
					g.fillRect(510, 200, 150, 150);
					g.drawImage(heltich.getCurrentFrame(), 540, 240,80,80, null);
					g.fillRect(670, 200, 150, 150);
					g.drawImage(eve.getCurrentFrame(), 700, 240,80,80, null);
					break;
				case 2:
					arte.tick();
					lasswell.setIndex(0);
					rain.setIndex(0);
					heltich.setIndex(0);
					eve.setIndex(0);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(30, 200, 150, 150);
					g.drawImage(rain.getCurrentFrame(),60,245,70,65,null);
					g.fillRect(190, 200, 150, 150);
					g.drawImage(lasswell.getCurrentFrame(), 220, 240,80,80, null);
					g.setColor(new Color(255,255,255,200));
					g.fillRect(350, 200, 150, 150);
					g.drawImage(arte.getCurrentFrame(), 380, 240,80,80, null);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(510, 200, 150, 150);
					g.drawImage(heltich.getCurrentFrame(), 540, 240,80,80, null);
					g.fillRect(670, 200, 150, 150);
					g.drawImage(eve.getCurrentFrame(), 700, 240,80,80, null);
					break;
				case 3:
					heltich.tick();
					lasswell.setIndex(0);
					arte.setIndex(0);
					rain.setIndex(0);
					eve.setIndex(0);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(30, 200, 150, 150);
					g.drawImage(rain.getCurrentFrame(),60,245,70,65,null);
					g.fillRect(190, 200, 150, 150);
					g.drawImage(lasswell.getCurrentFrame(), 220, 240,80,80, null);
					g.fillRect(350, 200, 150, 150);
					g.drawImage(arte.getCurrentFrame(), 380, 240,80,80, null);
					g.setColor(new Color(255,255,255,200));
					g.fillRect(510, 200, 150, 150);
					g.drawImage(heltich.getCurrentFrame(), 540, 240,80,80, null);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(670, 200, 150, 150);
					g.drawImage(eve.getCurrentFrame(), 700, 240,80,80, null);
					break;
				case 4:
					eve.tick();
					lasswell.setIndex(0);
					arte.setIndex(0);
					heltich.setIndex(0);
					rain.setIndex(0);
					g.setColor(new Color(255,255,255,100));
					g.fillRect(30, 200, 150, 150);
					g.drawImage(rain.getCurrentFrame(),60,245,70,65,null);
					g.fillRect(190, 200, 150, 150);
					g.drawImage(lasswell.getCurrentFrame(), 220, 240,80,80, null);
					g.fillRect(350, 200, 150, 150);
					g.drawImage(arte.getCurrentFrame(), 380, 240,80,80, null);
					g.fillRect(510, 200, 150, 150);
					g.drawImage(heltich.getCurrentFrame(), 540, 240,80,80, null);
					g.setColor(new Color(255,255,255,200));
					g.fillRect(670, 200, 150, 150);
					g.drawImage(eve.getCurrentFrame(), 700, 240,80,80, null);
					g.setColor(new Color(255,255,255,100));
					break;
				}
				break;
		default:
				break;
		}
	}
	
	private void check() {//키를 1번만 적용시키도록 제어하는 함수
		if(handler.getKeyManager().up||
				handler.getKeyManager().down||
				handler.getKeyManager().enter||
				handler.getKeyManager().left||
				handler.getKeyManager().right||
				handler.getKeyManager().esc) {isPressed=true;}
		else {isPressed=false;}
	}
	private void mainSelect() {//키 입력에 따른 메뉴 선택 ㅎ마수
		
		if(!isPressed) {
			if(handler.getKeyManager().up) {
				--sel;
				sound.menu_move();
				if(sel<0) {sel=2;}
				isPressed=false;
				}
			if(handler.getKeyManager().down) {
				++sel;
				sound.menu_move();
				if(sel>2) {sel=0;}
				isPressed=false;
				}
			if(handler.getKeyManager().enter) {
				switch (sel) {
				case 0:
					sound.menu_sel();
					++section;
					isPressed=false;
				case 1:
					break;
				case 2:
					System.exit(0);
					break;
				}
			}
			}
			check();
	}
	private void charSelect() {//키 입력에 따른 캐릭터 선택 함수
		if(!isPressed) {
			if(handler.getKeyManager().left) {
				--Csel;
				sound.menu_move();
				if(Csel<0) {Csel=4;}
				isPressed=false;
				}
			if(handler.getKeyManager().right) {
				++Csel;
				sound.menu_move();
				if(Csel>4) {Csel=0;}
				isPressed=false;
				}
			if(handler.getKeyManager().enter) {
				++section;
				isPressed=false; 
				sound.menu_sel();
				choose_character();
				
			}
			}
			check();
	}

	
}
