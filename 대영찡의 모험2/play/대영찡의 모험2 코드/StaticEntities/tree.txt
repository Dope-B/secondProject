package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_tree;
import tiles.Tile;

public class tree extends StaticEntity{
	
	private Animation tree;
	
	public tree(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		tree=new Animation(0,Asset_tree.tree);
		bounds.x=15;
		bounds.y=93;
		bounds.width=27;
		bounds.height=12;
	}


	public void tick() {
		tree.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(tree.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
