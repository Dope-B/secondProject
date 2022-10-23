package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class i_npc_4 extends StaticEntity {

	private Animation i_npc_4;
	
	public i_npc_4(Handler handler, float x, float y) {
		super(handler, x, y,73,98);
		i_npc_4=new Animation(100,Asset_NPC.I_NPC_4);
		bounds.x=0;
		bounds.width=width-10;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		i_npc_4.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(i_npc_4.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}	

}
