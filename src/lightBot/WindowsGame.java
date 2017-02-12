package lightBot;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.AppGameContainer;

/**
 * @author ZMNF8866
 *
 */
public class WindowsGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	public WindowsGame() {
		super("test 1 :: lighbot");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
//contenu du jeux
		this.map.render(0, 0);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
		this.map = new TiledMap("C:/Users/ZMNF8866/Documents/GitHub/lightBotV2/src/main/resources/map/LVL1.tmx");
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
//mise a jour des éléments

	}
	
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowsGame(), 680, 680, false).start();
    }

	@Override
	public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	    }

}
