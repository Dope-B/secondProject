package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class g_npc_5 extends StaticEntity {


	private Animation g_npc_5;
	
	public g_npc_5(Handler handler, float x, float y) {
		super(handler, x, y,50,64);
		g_npc_5=new Animation(100,Asset_NPC.G_NPC_5);
		bounds.x=0;
		bounds.width=width;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		g_npc_5.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(g_npc_5.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
}
