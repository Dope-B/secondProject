package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_NPC;

public class f_npc_4 extends StaticEntity {

	private Animation f_npc_4;
	
	public f_npc_4(Handler handler, float x, float y) {
		super(handler, x, y,72,77);
		f_npc_4=new Animation(100,Asset_NPC.F_NPC_4);
		bounds.x=10;
		bounds.width=width-20;
		bounds.height=20;
		bounds.y=height-bounds.height;
	}


	public void tick() {
		f_npc_4.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(f_npc_4.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);
	}

}
