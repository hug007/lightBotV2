package lightBot;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Controleur {
	private TiledMap controleur;

	public Controleur(TiledMap controleur) {
        this.controleur=controleur;
    }
	
	public void render() {
		this.controleur.render(50, 550);
	}

	public void init() throws SlickException {
		this.controleur = new TiledMap("src/main/resources/controleur/controleurLvl1.tmx");
	}
}
