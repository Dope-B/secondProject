package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_rock_ice;
import tiles.Tile;

public class rock_ice extends StaticEntity{

	private Animation rock_ice;
	public rock_ice(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		rock_ice=new Animation(0,Asset_rock_ice.rock_ice);
		bounds.x=0;
		bounds.y=60;
		bounds.width=59;
		bounds.height=50;
	}


	public void tick() {
		rock_ice.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(rock_ice.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
}
