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
	private Creature ch;//ĳ���� ����
	private ArrayList<Entity> objects;//entity ����迭
	private ArrayList<StaticEntity> Sobjects;//static ���� ���
	private ArrayList<Ene_Creature> Eobjects;//ene_creature ���� �迭
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
	public void Delete() {//��� �迭�� �ִ� ������Ʈ ����
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
	public void remove_E() {//ene_creaure ����� �迭���� ����
	
	for(int i=0;i<Eobjects.size();i++) {//ene_creature���� ����
		Ene_Creature e=Eobjects.get(i);
		if(!e.active) {Eobjects.remove(e);}
	}
	for(int i=0;i<objects.size();i++) {//entity���� ����
		Entity k=objects.get(i);
		if(!k.isActive()&&!k.isplayer) {
			if(k.dead_ticker==1) {sound.E_die();}//��� �Ҹ� ���
			if(k.dead_ticker>200) {//200�� ������ ����
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
			e.tick();//�迭�� ���Ե� ��ҿ� �ִ� tick�Լ� ����
		}
		objects.sort(renderSorter);//y���� ���� ���� ����
	}
	public void render(Graphics g) {
		for(Entity e: objects) {
			e.render(g);//�迭�� ���Ե� ��ҿ� �ִ� render�Լ� ����
		}
	}

	public void addEntity_ob(Entity e) {//�߰� �Լ�
		objects.add(e);
	}

	public void addEntity_Sob(StaticEntity e) {//�߰� �Լ�
		Sobjects.add(e);
	}
	public void addEntity_Ene(Ene_Creature e) {//�߰� �Լ�
		Eobjects.add(e);
	}
	public void addSum(Entity e) {//static �߰� �Լ�
		addEntity_ob(e);
		addEntity_Sob((StaticEntity)e);
	}
	public void addEne(Entity e) {//ene_creature �߰� �Լ�
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
