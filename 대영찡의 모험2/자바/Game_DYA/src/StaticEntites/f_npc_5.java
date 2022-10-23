package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class f_npc_5 extends StaticEntity {

	private Animation f_npc_5;
	
	public f_npc_5(Handler handler, float x, float y) {
		super(handler, x, y,108,98);
		f_npc_5=new Animation(100,Asset_NPC.F_NPC_5);
		bounds.x=15;
		bounds.width=width-45;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		f_npc_5.tick();
	}

	
	public void render(Graphics g) {
		
		g.drawImage(f_npc_5.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
