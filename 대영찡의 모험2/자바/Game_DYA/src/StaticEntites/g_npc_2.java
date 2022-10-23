package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class g_npc_2 extends StaticEntity {

	private Animation g_npc_2;
	
	public g_npc_2(Handler handler, float x, float y) {
		super(handler, x, y,103,78);
		g_npc_2=new Animation(100,Asset_NPC.G_NPC_2);
		bounds.x=47;
		bounds.width=width-70;
		bounds.height=20;
		bounds.y=height-bounds.height-5;
	}


	public void tick() {
		g_npc_2.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(g_npc_2.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
