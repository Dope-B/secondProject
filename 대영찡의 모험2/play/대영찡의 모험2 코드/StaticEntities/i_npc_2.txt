package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class i_npc_2 extends StaticEntity {

	private Animation i_npc_2;
	
	public i_npc_2(Handler handler, float x, float y) {
		super(handler, x, y,61,74);
		i_npc_2=new Animation(100,Asset_NPC.I_NPC_2);
		bounds.x=5;
		bounds.width=width-10;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		i_npc_2.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(i_npc_2.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}	

}
