package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class f_npc_1 extends StaticEntity {

	private Animation f_npc_1;
	
	public f_npc_1(Handler handler, float x, float y) {
		super(handler, x, y,128,81);
		f_npc_1=new Animation(100,Asset_NPC.F_NPC_1);
		bounds.x=50;
		bounds.width=width-2*bounds.x+5;
		bounds.height=20;
		bounds.y=height-bounds.height-5;
	}


	public void tick() {
		f_npc_1.tick();
	}

	
	public void render(Graphics g) {
	
		g.drawImage(f_npc_1.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}
}
