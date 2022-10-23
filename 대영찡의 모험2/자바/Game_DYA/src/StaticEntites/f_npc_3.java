package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class f_npc_3 extends StaticEntity {

	private Animation f_npc_3;
	
	public f_npc_3(Handler handler, float x, float y) {
		super(handler, x, y,90,81);
		f_npc_3=new Animation(100,Asset_NPC.F_NPC_3);
		bounds.x=30;
		bounds.width=width-60;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		f_npc_3.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(f_npc_3.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
