package lightBot;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private TiledMap map;

	public Map(TiledMap map) {
        this.map=map;
    }
	
	public void render() {
		this.map.render(50, 50);
	}

	public void init() throws SlickException {
		this.map = new TiledMap("src/main/resources/map/lvl.tmx");
	}

}
//384 x 192 
//90.5