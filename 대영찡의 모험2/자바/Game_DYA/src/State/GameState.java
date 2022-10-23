package State;
import java.awt.Graphics;

import UI.UI;
import basic_one.Handler;

public class GameState extends State {

	private MenuState menu;
	private UI ui;
	
	public GameState(Handler handler) {
		super(handler);
		menu=new MenuState(handler);
		ui=new UI(handler,menu);
	}
	public void tick() {//섹션에 따라 다른 함수가 실행
		if(menu.section<=1) {
		menu.tick();}
		else {menu.tick();ui.tick();menu.world_checker.tick();}
		
	}
	public void render(Graphics g) {//section에 따른 다른 함수 실행 
		if(menu.section<=1) {
		menu.render(g);}
		else {menu.world_checker.render(g);ui.render(g);}
		
	}
	
}
