package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class i_npc_3 extends StaticEntity {

	private Animation i_npc_3;
	
	public i_npc_3(Handler handler, float x, float y) {
		super(handler, x, y,93,94);
		i_npc_3=new Animation(100,Asset_NPC.I_NPC_3);
		bounds.x=20;
		bounds.width=width-30;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		i_npc_3.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(i_npc_3.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}	

}
