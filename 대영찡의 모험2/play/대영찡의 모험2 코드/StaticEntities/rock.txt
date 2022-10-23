package StaticEntites;

import java.awt.Graphics;

import basic_one.Handler;
import gfx.Animation;
import gfx.Asset_rock;
import tiles.Tile;

public class rock extends StaticEntity {

	private Animation rock;
	public rock(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT*2);
		rock=new Animation(0,Asset_rock.rock);//이미지 저장
		bounds.x=0;
		bounds.y=60;
		bounds.width=62;
		bounds.height=50;
	}


	public void tick() {
		rock.tick();
	}

	
	public void render(Graphics g) {
		g.drawImage(rock.getCurrentFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width, height,null);//이미지 출력
	}
}
