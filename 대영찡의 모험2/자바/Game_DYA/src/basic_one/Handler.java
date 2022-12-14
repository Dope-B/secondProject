package basic_one;

import gfx.GameCamera;
import input.KeyManager;
import world.World;
import world.World_checker;

public class Handler {// 각 클래스 변수참조를 위한 클래스 

	private Game game;
	private World_checker world_checker;
	private World world;
	public Handler(Game game) {
		this.game=game;
	}
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public World_checker getWorld_checker() {
		return world_checker;
	}
	public void setWorld_checker(World_checker world_checker) {
		this.world_checker = world_checker;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	
}
