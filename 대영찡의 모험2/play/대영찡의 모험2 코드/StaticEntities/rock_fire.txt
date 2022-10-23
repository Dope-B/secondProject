package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_rock_fire;
import tiles.Tile;

public class rock_fire extends StaticEntity{

	private Animation rock_fire;
	public rock_fire(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		rock_fire=new Animation(80,Asset_rock_fire.rock_fire);
		bounds.x=0;
		bounds.y=60;
		bounds.width=62;
		bounds.height=50;
	}


	public void tick() {
		rock_fire.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(rock_fire.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
}
