package StaticEntites;

import java.awt.Graphics;
import Creature.Creature;
import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_portal;
import tiles.Tile;

public class portal_R extends StaticEntity{

	private Animation portal_R;
	public portal_R(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		portal_R=new Animation(70,Asset_portal.portal_R);
		bounds.x=10;
		bounds.y=90;
		bounds.width=55;
		bounds.height=40;
		isplayer=true;
	}

	public void tick() {
		portal_R.tick();
	}

	public void render(Graphics g) {
		g.drawImage(portal_R.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
	
	public boolean Colli(Creature player) {
		if ((player.getX()+player.bounds.x>x+bounds.x+bounds.width||player.getX()+player.bounds.x+player.bounds.width<x+bounds.x)||
				(player.getY()+player.bounds.y>y+bounds.y+bounds.height||player.getY()+player.bounds.y+player.bounds.height<y+bounds.y)) 
		{return false;} 
		else 
		{if(handler.getKeyManager().enter) {return true;}return false;}}
	}
