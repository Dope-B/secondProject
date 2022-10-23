package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_treeC;
import tiles.Tile;

public class tree_C extends StaticEntity {

	private Animation tree_C;
	public tree_C(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		tree_C=new Animation(0,Asset_treeC.treeC);
		bounds.x=15;
		bounds.y=100;
		bounds.width=27;
		bounds.height=12;
	}


	public void tick() {
		tree_C.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(tree_C.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
}
