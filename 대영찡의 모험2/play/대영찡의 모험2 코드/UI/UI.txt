package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Enemy.Ene_Creature;
import State.MenuState;
import basic_one.Handler;
import gfx.Asset;
import gfx.Asset_Lasswell;
import gfx.Asset_arte;
import gfx.Asset_eve;
import gfx.Asset_heltich;
import gfx.ImageLoader;


public class UI {

	
	public BufferedImage[] skill_bar;
	public BufferedImage[] player_state;
	public BufferedImage[] HP;
	public BufferedImage[] ex_hp;
	public BufferedImage[] ene_state;
	private Handler handler;
	private MenuState menu;
	private double HP_width=0;// 플래이어 hp 가로
	private double E_HP_width=0;// 적 hp 가로
	private double E_HP_x=0;// 적 hp x좌표
	
	public UI(Handler handler,MenuState menu) {
		this.handler=handler;
		this.menu=menu;
		HP_width=231;
		E_HP_width=265;
		E_HP_x=408;
		init();	
	}
	
	
	public void init() {
		Player_state();//플레이어 hp 
		Ene_state();//적 hp
		Skill_state();//플레이어 스킬 쿨타임
	}
	
	private void Player_state() {//픞레이어 hp 이미지 저장 
		player_state=new BufferedImage[1];
		player_state[0]=ImageLoader.loadImage("UI/HP_bar.png");
		HP=new BufferedImage[1];
		HP[0]=ImageLoader.loadImage("UI/HP.png");
		ex_hp=new BufferedImage[1];
		ex_hp[0]=ImageLoader.loadImage("UI/ex_hp.png");
	}
	
	private void Ene_state() {//적  hp 이미지 저장 
		ene_state=new BufferedImage[1];
		ene_state[0]=ImageLoader.loadImage("UI/E_HP_bar.png");
	}
	
	private void Skill_state() {//플레이어 스킬 쿨타임 UI 이미지 저장
		skill_bar=new BufferedImage[5];
		skill_bar[0]=ImageLoader.loadImage("UI/frame_rain.png");
		skill_bar[1]=ImageLoader.loadImage("UI/frame_lasswell.png");
		skill_bar[2]=ImageLoader.loadImage("UI/frame_arte.png");
		skill_bar[3]=ImageLoader.loadImage("UI/frame_heltich.png");
		skill_bar[4]=ImageLoader.loadImage("UI/frame_eve.png");
	}
	private void HP() {
		if(HP_width<=0) {HP_width=0.001;}
		else {HP_width=((double)menu.world_checker.player.getHealth()/(double)menu.world_checker.player.getMAX_health())*231;}//hp 가로 갱신
	}
	private void E_HP() {
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(e.isDamaged) {		
				E_HP_width=((double)e.getHealth()/(double)e.getMAX_health())*265;//적  hp 가로 갱신
				E_HP_x=408+(265-E_HP_width);
				if(E_HP_width<=0) {E_HP_width=0;}
		}
		}
	}
	
	private void print_E_HP(Graphics g) {// 적 피격 시 적 hp UI 출력(일정 시간동안)
		for(Ene_Creature e:handler.getWorld_checker().getEM().getEobjects()) {
			if(e.isDamaged) {
				e.print_E_HP=true;
				e.E_HP_ticker=0;
				for(Ene_Creature k:handler.getWorld_checker().getEM().getEobjects()) {
					if(!(k==e)) {k.print_E_HP=false;}
				}
			}
			if(e.print_E_HP) {
				if(e.E_HP_ticker<=250) {
				g.drawImage(ene_state[0], 380, 12,350,65, null);
				g.drawImage(ex_hp[0],408,25,265,16,null );
				g.drawImage(e.icon.getCurrentFrame(),675, 15,35,35, null);//적 아이콘 출력
				g.drawImage(HP[0],(int)E_HP_x,25,(int)E_HP_width,16,null );
				e.E_HP_ticker++;
				}
				else {e.E_HP_ticker=0;e.print_E_HP=false;}
			}
			if(menu.world_checker.changeMap) {e.E_HP_ticker=0;e.print_E_HP=false;}
		}
	}
	
	

	private void frame(Graphics g) {// 플레이어 아이콘  및 스킬 UI 출력
		switch(menu.Csel) {
		case 0:
			g.drawImage(Asset.player_rainS2_icon[0],25,25,45,45,null );
			g.drawImage(skill_bar[0],0,440,null );
			g.setColor(new Color(0,0,0,150));
			if(menu.world_checker.player.isA_cooldown()) {
			g.fillRect(122, 457, 31,32-(int)(((double)menu.world_checker.player.getA_timer()/20)*32));}
			if(menu.world_checker.player.isA2_cooldown()) {
			g.fillRect(182, 457, 31,32-(int)(((double)menu.world_checker.player.getA2_timer()/40)*32));}
			if(menu.world_checker.player.isS_cooldown()) {
			g.fillRect(242, 457, 31,32-(int)(((double)menu.world_checker.player.getS_timer()/300)*32));}
			if(menu.world_checker.player.isS2_cooldown()) {
			g.fillRect(302, 457, 31,32-(int)(((double)menu.world_checker.player.getS2_timer()/350)*32));}
			if(menu.world_checker.player.isS3_cooldown()) {
			g.fillRect(362, 457, 31,32-(int)(((double)menu.world_checker.player.getS3_timer()/240)*32));}
			break;
		case 1:
			g.drawImage(Asset_Lasswell.player_lasswell_icon[0],25,25,45,45,null );
			g.drawImage(skill_bar[1],0,440,null );
			g.setColor(new Color(0,0,0,150));
			if(menu.world_checker.player.isA_cooldown()) {
			g.fillRect(122, 457, 31,32-(int)(((double)menu.world_checker.player.getA_timer()/20)*32));}
			if(menu.world_checker.player.isA2_cooldown()) {
			g.fillRect(182, 457, 31,32-(int)(((double)menu.world_checker.player.getA2_timer()/15)*32));}
			if(menu.world_checker.player.isS_cooldown()) {
			g.fillRect(242, 457, 31,32-(int)(((double)menu.world_checker.player.getS_timer()/300)*32));}
			if(menu.world_checker.player.isS2_cooldown()) {
			g.fillRect(302, 457, 31,32-(int)(((double)menu.world_checker.player.getS2_timer()/350)*32));}
			break;
		case 2:
			g.drawImage(Asset_arte.player_arte_icon[0],25,25,45,45,null );
			g.drawImage(skill_bar[2],0,440,null );
			g.setColor(new Color(0,0,0,150));
			if(menu.world_checker.player.isA_cooldown()) {
			g.fillRect(122, 457, 31,32-(int)(((double)menu.world_checker.player.getA_timer()/20)*32));}
			if(menu.world_checker.player.isA2_cooldown()) {
			g.fillRect(182, 457, 31,32-(int)(((double)menu.world_checker.player.getA2_timer()/90)*32));}
			if(menu.world_checker.player.isS_cooldown()) {
			g.fillRect(242, 457, 31,32-(int)(((double)menu.world_checker.player.getS_timer()/250)*32));}
			break;
		case 3:
			g.drawImage(Asset_heltich.player_heltich_icon[0],25,25,45,45,null );
			g.drawImage(skill_bar[3],0,440,null );
			g.setColor(new Color(0,0,0,150));
			if(menu.world_checker.player.isA_cooldown()) {
			g.fillRect(122, 457, 31,32-(int)(((double)menu.world_checker.player.getA_timer()/8)*32));}
			if(menu.world_checker.player.isA2_cooldown()) {
			g.fillRect(182, 457, 31,32-(int)(((double)menu.world_checker.player.getA2_timer()/15)*32));}
			if(menu.world_checker.player.isS_cooldown()) {
			g.fillRect(242, 457, 31,32-(int)(((double)menu.world_checker.player.getS_timer()/600)*32));}
			if(menu.world_checker.player.isS2_cooldown()) {
			g.fillRect(302, 457, 31,32-(int)(((double)menu.world_checker.player.getS2_timer()/250)*32));}
			if(menu.world_checker.player.isS3_cooldown()) {
			g.fillRect(362, 457, 31,32-(int)(((double)menu.world_checker.player.getS3_timer()/350)*32));}
			break;
		case 4:
			g.drawImage(Asset_eve.player_eve_icon[0],25,25,45,45,null );
			g.drawImage(skill_bar[4],0,440,null );
			g.setColor(new Color(0,0,0,150));
			if(menu.world_checker.player.isA_cooldown()) {
			g.fillRect(122, 457, 31,32-(int)(((double)menu.world_checker.player.getA_timer()/30)*32));}
			if(menu.world_checker.player.isA2_cooldown()) {
			g.fillRect(182, 457, 31,32-(int)(((double)menu.world_checker.player.getA2_timer()/15)*32));}
			if(menu.world_checker.player.isS_cooldown()) {
			g.fillRect(242, 457, 31,32-(int)(((double)menu.world_checker.player.getS_timer()/150)*32));}
			if(menu.world_checker.player.isS2_cooldown()) {
			g.fillRect(302, 457, 31,32-(int)(((double)menu.world_checker.player.getS2_timer()/400)*32));}
			break;
		}
	}
	
	public void tick() {HP();E_HP();}
	public void render(Graphics g) {
		g.drawImage(ex_hp[0],88,20,231,22,null );
		g.drawImage(HP[0],88,20,(int)HP_width,22,null );
		g.drawImage(player_state[0],5,10,337,80,null );
		frame(g);
		print_E_HP(g);
	}
}
