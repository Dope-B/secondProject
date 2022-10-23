package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class g_npc_4 extends StaticEntity {

	private Animation g_npc_4;
	
	public g_npc_4(Handler handler, float x, float y) {
		super(handler, x, y,96,142);
		g_npc_4=new Animation(100,Asset_NPC.G_NPC_4);
		bounds.x=10;
		bounds.width=width-20;
		bounds.height=30;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		g_npc_4.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(g_npc_4.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
