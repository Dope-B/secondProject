package StaticEntites;

import Entities.Entity;
import basic_one.Handler;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		isplayer=false;
	}

}
