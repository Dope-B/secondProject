package tiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles=new Tile[256];
	public static Tile grassTile=new GrassTile(0);
	public static Tile rockTile=new RockTile(1);
	public static Tile iceTile=new IceTile(2);
	public static Tile fireTile=new FireTile(3);
	public static final int TILEWIDTH=60,TILEHEIGHT=60;//타일 크기
	protected BufferedImage texture;
	protected final int id;//타일들을 구분할 id
	public Tile(BufferedImage texture, int id) {
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
	}
	public void tick() {
		
	}
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT,null);
	}
	public boolean isSolid() {return false;}
	public int getId() {return id;}
}
