package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class i_npc_5 extends StaticEntity {

	private Animation i_npc_5;
	
	public i_npc_5(Handler handler, float x, float y) {
		super(handler, x, y,59,87);
		i_npc_5=new Animation(100,Asset_NPC.I_NPC_5);
		bounds.x=10;
		bounds.width=width-10;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		i_npc_5.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(i_npc_5.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}	

}
