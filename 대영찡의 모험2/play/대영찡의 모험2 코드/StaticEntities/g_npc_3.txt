package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class g_npc_3 extends StaticEntity {

	private Animation g_npc_3;
	
	public g_npc_3(Handler handler, float x, float y) {
		super(handler, x, y,57,67);
		g_npc_3=new Animation(100,Asset_NPC.G_NPC_3);
		bounds.x=5;
		bounds.width=width-10;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		g_npc_3.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(g_npc_3.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
