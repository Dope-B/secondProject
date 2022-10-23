package world;
import java.awt.Graphics;
import java.net.URL;

import basic_one.Handler;
import tiles.Tile;
import utils.Utils;

public class World {

	private Handler handler;
	private int width,height;
	private int[][] tiles;//배경 출력을 위한 타일배열
	private int spawnX,spawnY;//사용 x
	
	
	public World(Handler handler,String path) {
		this.handler=handler;
		loadWorld(path);
		
	}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public void render(Graphics g) {//화면 범위만큼만 출력
		int xStart=(int)Math.max(0,handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);//x범위 화면 시작점 
		int xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1 );// x범위 끝점
		int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT+1 );
		for(int y=yStart;y<yEnd;y++) {
			for(int x=xStart;x<xEnd;x++) {// 지정 범위만큼 출력
				getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()),(int)( y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));
			}
		}
	}
	public Tile getTile(int x, int y) {
		if(x<0||y<0||x>=width||y>=height) {return Tile.grassTile;}//x또는 y가 범위 밖일 경우 grass 리턴
		Tile t=Tile.tiles[tiles[x][y]];
		if(t==null) {return Tile.rockTile;}//t가 null이면 rock 리턴
		return t;//배열에 따른 타일 리턴
	}
	private void loadWorld(String path) {
		String file=Utils.loadFileAsString(path);// file 저장
		String[] tokens=file.split("\\s+");// 토큰으로 나눔
		width=Utils.parseInt(tokens[0]);//1번째 토큰은 가로
		height=Utils.parseInt(tokens[1]);//2번째 토큰은 세로
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		tiles=new int[width][height];//가로, 세로에 따라 타일 배열 생성
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);// 토큰 배열과 타일 id에 따라 타일 저장
			}
		}
	}
}
