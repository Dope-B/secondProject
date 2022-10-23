package Entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import Creature.Creature;
import Enemy.Ene_Creature;
import StaticEntites.StaticEntity;
import basic_one.Handler;
import sound.Sounds;

public class EntityManager {

	private Handler handler;
	private Creature ch;//캐릭터 저장
	private ArrayList<Entity> objects;//entity 저장배열
	private ArrayList<StaticEntity> Sobjects;//static 저장 배경
	private ArrayList<Ene_Creature> Eobjects;//ene_creature 저장 배열
	private Sounds sound;
	private Comparator<Entity> renderSorter=new Comparator<Entity>() {
		public int compare(Entity a, Entity b) {
			if(a.getY()+a.getHeight()<b.getY()+b.getHeight()) {return -1;}
			return 1;}};
	
	
	public EntityManager(Handler handler, Creature player) {
		this.handler=handler;
		this.ch=player;
		sound=new Sounds();
		objects=new ArrayList<Entity>();
		Sobjects=new ArrayList<StaticEntity>();
		Eobjects=new ArrayList<Ene_Creature>();
		addEntity_ob(player);
		
	}
	public void Delete() {//모든 배열에 있는 오브젝트 삭제
		Iterator<StaticEntity> remove_s=Sobjects.iterator();
		Iterator<Entity> remove=objects.iterator();
		Iterator<Ene_Creature> remove_e=Eobjects.iterator();
		while(remove_s.hasNext()) {
			remove_s.next();
			remove_s.remove();
		}
		
		while(remove_e.hasNext()) {
			remove_e.next();
			remove_e.remove();
		}
		while(remove.hasNext()) {
			Entity k=remove.next();
			if(!k.isplayer) {
			remove.remove();}
		}
	}
	public void remove_E() {//ene_creaure 사망시 배열에서 삭제
	
	for(int i=0;i<Eobjects.size();i++) {//ene_creature에서 삭제
		Ene_Creature e=Eobjects.get(i);
		if(!e.active) {Eobjects.remove(e);}
	}
	for(int i=0;i<objects.size();i++) {//entity에서 삭제
		Entity k=objects.get(i);
		if(!k.isActive()&&!k.isplayer) {
			if(k.dead_ticker==1) {sound.E_die();}//사망 소리 출력
			if(k.dead_ticker>200) {//200이 넘으면 삭제
				objects.remove(i);
				k.dead_ticker=0;
			}
			else {k.dead_ticker++;}
		}}
	}
		
	public void tick() {
		remove_E();
		for(int i=0;i<objects.size();i++) {
			Entity e=objects.get(i);
			e.tick();//배열에 포함된 요소에 있는 tick함수 실행
		}
		objects.sort(renderSorter);//y값에 따른 순서 변경
	}
	public void render(Graphics g) {
		for(Entity e: objects) {
			e.render(g);//배열에 포함된 요소에 있는 render함수 실행
		}
	}

	public void addEntity_ob(Entity e) {//추가 함수
		objects.add(e);
	}

	public void addEntity_Sob(StaticEntity e) {//추가 함수
		Sobjects.add(e);
	}
	public void addEntity_Ene(Ene_Creature e) {//추가 함수
		Eobjects.add(e);
	}
	public void addSum(Entity e) {//static 추가 함수
		addEntity_ob(e);
		addEntity_Sob((StaticEntity)e);
	}
	public void addEne(Entity e) {//ene_creature 추가 함수
		addEntity_ob(e);
		addEntity_Ene((Ene_Creature)e);
	}
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Creature getPlayer() {
		return ch;
	}

	public void setPlayer(Creature player) {
		this.ch = player;
	}

	public ArrayList<Entity> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<Entity> objects) {
		this.objects = objects;
	}

	public ArrayList<StaticEntity> getSobjects() {
		return Sobjects;
	}

	public void setSobjects(ArrayList<StaticEntity> sobjects) {
		Sobjects = sobjects;
	}
	public ArrayList<Ene_Creature> getEobjects() {
		return Eobjects;
	}

	public void setEobjects(ArrayList<Ene_Creature> eobjects) {
		Eobjects = eobjects;
	}
	
}
