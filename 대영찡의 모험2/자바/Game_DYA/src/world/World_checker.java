package world;

import java.awt.Graphics;
import Creature.Creature;
import Enemy.Ene_dark;
import Enemy.Ene_earth;
import Enemy.Ene_glauca;
import Enemy.Ene_golem;
import Enemy.Ene_kain;
import Enemy.Ene_kyo;
import Enemy.Ene_light;
import Enemy.Ene_shadow;
import Enemy.Ene_slime;
import Entities.EntityManager;
import StaticEntites.f_npc_1;
import StaticEntites.f_npc_2;
import StaticEntites.f_npc_3;
import StaticEntites.f_npc_4;
import StaticEntites.f_npc_5;
import StaticEntites.g_npc_1;
import StaticEntites.g_npc_2;
import StaticEntites.g_npc_3;
import StaticEntites.g_npc_4;
import StaticEntites.g_npc_5;
import StaticEntites.i_npc_1;
import StaticEntites.i_npc_2;
import StaticEntites.i_npc_3;
import StaticEntites.i_npc_4;
import StaticEntites.i_npc_5;
import StaticEntites.portal_L;
import StaticEntites.portal_R;
import StaticEntites.rock;
import StaticEntites.rock_fire;
import StaticEntites.rock_ice;
import StaticEntites.tree;
import StaticEntites.tree_C;
import basic_one.Handler;
import sound.Sounds;
import tiles.Tile;

public class World_checker {
	
	private World world[];
	private portal_L portal_L;
	private portal_R portal_R;
	private int world_checker=0;//맵 체크 
	private Handler handler;
	private EntityManager EM;
	private Sounds sound;
	public Creature player;
	public boolean changeMap=false;//맵 이동 여부
	
	public World_checker(Handler handler,Creature player) {
		this.handler=handler;
		this.player=player;
		sound=new Sounds();
		world=new World[10];
		world[0]=new World(handler,"world/world_grass_town.txt");//맵 저장
		world[1]=new World(handler,"world/world_grass1.txt");
		world[2]=new World(handler,"world/world_grass2.txt");
		world[3]=new World(handler,"world/world_grass3.txt");
		world[4]=new World(handler,"world/world_ice_town.txt");
		world[5]=new World(handler,"world/world_ice1.txt");
		world[6]=new World(handler,"world/world_ice2.txt");
		world[7]=new World(handler,"world/world_fire_town.txt");
		world[8]=new World(handler,"world/world_fire1.txt");
		world[9]=new World(handler,"world/world_fire2.txt");
		handler.setWorld(world[0]);
		portal_R=new portal_R(handler,((world[world_checker].getWidth()-1)*Tile.TILEWIDTH-100),((world[world_checker].getHeight()/2-1)*Tile.TILEHEIGHT));//포탈 생성
		portal_L=new portal_L(handler,100,((world[world_checker].getHeight()/2-1)*Tile.TILEHEIGHT));
		EM=new EntityManager(handler,player);
		EM.addEntity_ob(portal_L);//포탈 및 플레이어를 관리 배열에 넣음
		EM.addEntity_ob(portal_R);
		EM.addEntity_ob(player);
		world_summ();
	}
	
	public void tick() {
		world_return();//맵 변화 갱신
		check();//맵 이동 감지
		EM.tick();//EM에 들어있는 요소들의 tick함수를 실행
		}
	
	public void render(Graphics g) {	
		world[world_checker].render(g);
		EM.render(g);
		}
	
	public int get_world_checker() {
		return world_checker;
	}
	public void set_world_checker(int k) {
		world_checker=k;
	}
	
	public void setPortalLoc() {//포탈 위치 리셋
		portal_L.setX(100);
		portal_L.setY(((world[world_checker].getHeight()/2-1)*Tile.TILEHEIGHT));
		portal_R.setX((world[world_checker].getWidth()-1)*Tile.TILEWIDTH-100);
		portal_R.setY(((world[world_checker].getHeight()/2-1)*Tile.TILEHEIGHT));
		
	}
	
	public EntityManager getEM() {
		return EM;
	}
	
	public void world_return() {//맵 변화 시 
		if(!changeMap) {
		if(portal_L.Colli(player)) {
			if(world_checker>=1) {//0 스테이지에는 왼쪽 방향 포탈 사용 불가
			changeMap=false;
			sound.teleport();
			world_checker-=1;//1 이상일 시 맵 번호 1 낮춤
			EM.Delete();//기존 맵에 있던 EM요소 삭제
			handler.setWorld(world[world_checker]);//현 번호에 해당하는 맵 세팅
			world_summ();//현 맵에 해당하는 EM 불러오기
			player.setX((int)portal_R.getX()+portal_R.bounds.x+portal_R.bounds.width/2);//케릭터 위치 리셋
			player.setY((int)portal_R.getY()+portal_R.bounds.y+portal_R.bounds.height/2-50);
			
			}
		}
		else if(portal_R.Colli(player)) {
			if(world_checker<=8) {//9스테이지에는 오른쪽 포탈 사용 불가
			changeMap=false;
			sound.teleport();
			world_checker+=1;
			EM.Delete();
			handler.setWorld(world[world_checker]);
			world_summ();
			player.setX((int)portal_L.getX()+portal_L.bounds.x+portal_L.bounds.width/2);
			player.setY((int)portal_L.getY()+portal_L.bounds.y+portal_L.bounds.height/2-50);
			}
		}}
	}
	
	private void check() {//맵 이동 감지
		if(portal_R.Colli(player)||portal_L.Colli(player)) {changeMap=true;}
		else {changeMap=false;}
	}
	
	public void world_summ() {//맵 변화에 따른 EM추가 
		switch(world_checker) {
		case 0:
			player.setHealth(player.getMAX_health());
			EM.addSum(new g_npc_1(handler,200,100));
			EM.addSum(new g_npc_2(handler,400,100));
			EM.addSum(new g_npc_3(handler,600,100));
			EM.addSum(new g_npc_4(handler,750,50));
			EM.addSum(new g_npc_5(handler,900,100));
			EM.addSum(new tree(handler,100,60));
			EM.addSum(new tree(handler,250,200));
			EM.addSum(new tree(handler,320,320));
			EM.addSum(new tree(handler,650,430));
			EM.addSum(new tree(handler,480,150));
			EM.addSum(new tree(handler,150,270));
			EM.addSum(new tree(handler,890,390));
			EM.addSum(new tree(handler,950,160));
			EM.addSum(new rock(handler,300,400));
			EM.addSum(new rock(handler,1000,90));
			setPortalLoc();
			break;
		case 1:
			EM.addEne(new Ene_golem(handler, 600,370,player));
			EM.addEne(new Ene_slime(handler, 240,270,player));
			EM.addEne(new Ene_slime(handler, 150,200,player));
			EM.addEne(new Ene_slime(handler, 600,370,player));
			EM.addEne(new Ene_slime(handler, 170,150,player));
			EM.addEne(new Ene_slime(handler, 620,310,player));
			EM.addEne(new Ene_golem(handler, 650,200,player));
			EM.addEne(new Ene_golem(handler, 500,200,player));
			EM.addEne(new Ene_shadow(handler, 240,470,player));
			EM.addEne(new Ene_slime(handler, 700,200,player));
			EM.addEne(new Ene_shadow(handler, 150,700,player));
			EM.addSum(new tree(handler,180,110));
			EM.addSum(new tree(handler,1280,110));
			EM.addSum(new tree(handler,250,300));
			EM.addSum(new tree(handler,380,510));
			EM.addSum(new tree(handler,680,710));
			EM.addSum(new tree(handler,880,210));
			EM.addSum(new tree(handler,1080,410));
			EM.addSum(new tree(handler,1280,610));
			EM.addSum(new tree(handler,780,290));
			EM.addSum(new tree(handler,480,60));
			EM.addSum(new tree(handler,400,310));
			EM.addSum(new rock(handler,970,250));
			EM.addSum(new rock(handler,500,610));
			setPortalLoc();
			break;
		case 2:
			setPortalLoc();
			EM.addSum(new tree(handler, 100, 300));
			EM.addSum(new tree(handler, 500, 200));
			EM.addSum(new tree(handler, 70, 30));
			EM.addSum(new tree(handler, 700, 120));
			EM.addSum(new tree(handler, 400, 100));
			EM.addSum(new rock(handler, 600, 420));
			EM.addSum(new rock(handler, 270, 320));
			EM.addEne(new Ene_shadow(handler, 150,200,player));
			EM.addEne(new Ene_kain(handler, 350,50,player));
			EM.addEne(new Ene_kain(handler, 450,270,player));
			EM.addEne(new Ene_kain(handler, 200,200,player));
			EM.addEne(new Ene_golem(handler, 90,170,player));
			EM.addEne(new Ene_earth(handler, 510,110,player));
			EM.addEne(new Ene_earth(handler, 410,310,player));
			break;
		case 3:
			setPortalLoc();
			EM.addSum(new rock(handler, 120, 60));
			EM.addSum(new rock(handler, 650, 420));
			EM.addSum(new tree(handler, 770, 320));
			EM.addSum(new tree(handler, 820, 510));
			EM.addSum(new tree(handler, 720, 140));
			EM.addSum(new tree(handler, 400, 420));
			EM.addSum(new tree(handler, 600, 80));
			EM.addEne(new Ene_earth(handler, 910,400,player));
			EM.addEne(new Ene_earth(handler, 210,210,player));
			EM.addEne(new Ene_golem(handler, 110,300,player));
			EM.addEne(new Ene_dark(handler, 280,230,player));
			EM.addEne(new Ene_kain(handler, 510,430,player));
			EM.addEne(new Ene_shadow(handler, 110,500,player));
			EM.addEne(new Ene_golem(handler, 710,600,player));
			EM.addEne(new Ene_slime(handler, 800,200,player));
			EM.addEne(new Ene_slime(handler, 740,400,player));
			break;
		case 4:
			player.setHealth(player.getMAX_health());
			EM.addSum(new i_npc_1(handler,200,100));
			EM.addSum(new i_npc_2(handler,400,100));
			EM.addSum(new i_npc_3(handler,600,100));
			EM.addSum(new i_npc_4(handler,750,100));
			EM.addSum(new i_npc_5(handler,900,100));
			EM.addSum(new tree_C(handler,100,300));
			EM.addSum(new tree_C(handler,910,250));
			EM.addSum(new tree_C(handler,290,120));
			EM.addSum(new tree_C(handler,850,190));
			EM.addSum(new tree_C(handler,490,410));
			EM.addSum(new tree_C(handler,670,370));
			EM.addSum(new tree_C(handler,70,410));
			EM.addSum(new tree_C(handler,770,370));
			EM.addSum(new rock_ice(handler,450,200));
			EM.addSum(new rock_ice(handler,200,400));
			EM.addSum(new rock_ice(handler,900,440));
			setPortalLoc();
			break;
		case 5:
			EM.addEne(new Ene_golem(handler, 110,200,player));
			EM.addEne(new Ene_light(handler, 190,460,player));
			EM.addEne(new Ene_light(handler, 250,300,player));
			EM.addEne(new Ene_light(handler, 480,200,player));
			EM.addEne(new Ene_kain(handler, 580,120,player));
			EM.addEne(new Ene_dark(handler, 660,360,player));
			EM.addEne(new Ene_dark(handler, 710,220,player));
			EM.addEne(new Ene_slime(handler, 880,530,player));
			EM.addEne(new Ene_slime(handler, 980,610,player));
			EM.addEne(new Ene_light(handler, 1170,440,player));
			EM.addSum(new tree_C(handler,210,250));
			EM.addSum(new tree_C(handler,490,120));
			EM.addSum(new tree_C(handler,850,190));
			EM.addSum(new tree_C(handler,690,410));
			EM.addSum(new tree_C(handler,370,670));
			EM.addSum(new tree_C(handler,1150,190));
			EM.addSum(new tree_C(handler,1090,410));
			EM.addSum(new tree_C(handler,1270,670));
			EM.addSum(new rock_ice(handler,490,450));
			EM.addSum(new rock_ice(handler,70,200));
			EM.addSum(new rock_ice(handler,1020,640));
			setPortalLoc();
			break;
		case 6:
			EM.addEne(new Ene_slime(handler, 110,200,player));
			EM.addEne(new Ene_light(handler, 190,410,player));
			EM.addEne(new Ene_light(handler, 250,300,player));
			EM.addEne(new Ene_light(handler, 480,200,player));
			EM.addEne(new Ene_shadow(handler, 580,120,player));
			EM.addEne(new Ene_dark(handler, 660,360,player));
			EM.addSum(new tree_C(handler,110,150));
			EM.addSum(new tree_C(handler,410,80));
			EM.addSum(new tree_C(handler,710,250));
			EM.addSum(new tree_C(handler,510,350));
			EM.addSum(new rock_ice(handler,220,440));
			EM.addSum(new rock_ice(handler,620,80));
			setPortalLoc();
			break;
		case 7:
			player.setHealth(player.getMAX_health());
			EM.addSum(new f_npc_1(handler,200,100));
			EM.addSum(new f_npc_2(handler,400,100));
			EM.addSum(new f_npc_3(handler,600,100));
			EM.addSum(new f_npc_4(handler,750,100));
			EM.addSum(new f_npc_5(handler,900,100));
			EM.addSum(new rock_fire(handler,110,90));
			EM.addSum(new rock_fire(handler,310,210));
			EM.addSum(new rock_fire(handler,710,300));
			EM.addSum(new rock_fire(handler,1010,400));
			setPortalLoc();
			break;
		case 8:	
			EM.addEne(new Ene_glauca(handler, 410,100,player));
			EM.addEne(new Ene_glauca(handler, 1900,410,player));
			EM.addEne(new Ene_glauca(handler, 250,560,player));
			EM.addEne(new Ene_light(handler, 480,550,player));
			EM.addEne(new Ene_dark(handler, 580,420,player));
			EM.addEne(new Ene_dark(handler, 710,560,player));
			EM.addEne(new Ene_glauca(handler, 1110,100,player));
			EM.addEne(new Ene_kain(handler, 1200,70,player));
			EM.addEne(new Ene_light(handler, 600,200,player));
			EM.addEne(new Ene_glauca(handler, 1110,550,player));
			EM.addEne(new Ene_kain(handler, 1200,310,player));
			EM.addEne(new Ene_glauca(handler, 810,470,player));
			EM.addSum(new rock_fire(handler,810,300));
			EM.addSum(new rock_fire(handler,210,400));
			EM.addSum(new rock_fire(handler,910,90));
			EM.addSum(new rock_fire(handler,510,210));
			EM.addSum(new rock_fire(handler,710,600));
			EM.addSum(new rock_fire(handler,1010,500));
			setPortalLoc();
			break;
		case 9:
			EM.addSum(new rock_fire(handler,210,400));
			EM.addSum(new rock_fire(handler,420,270));
			EM.addSum(new rock_fire(handler,90,90));
			EM.addSum(new rock_fire(handler,610,150));
			EM.addSum(new rock_fire(handler,620,420));
			EM.addEne(new Ene_kyo(handler,500,300,player));
			setPortalLoc();
			break;
		}
	}
}
