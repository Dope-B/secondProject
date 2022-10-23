package tiles;

import gfx.Asset_tile;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Asset_tile.rock_tile, id);
	}
	public boolean isSolid() {return true;}//∫Æ ≈∏¿œ
}
