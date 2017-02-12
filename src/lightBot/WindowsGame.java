package lightBot;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;

/**
 * @author ZMNF8866
 *
 */
public class WindowsGame extends BasicGame {

	private GameContainer container;
	public WindowsGame() {
		super("test 1 :: lighbot");
	}

	@Override
	public void render(GameContainer container, Graphics arg1) throws SlickException {
//contenu du jeux
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
	}

	@Override
	public void update(GameContainer container, int arg1) throws SlickException {
//mise a jour des éléments

	}
	
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowsGame(), 640, 480, false).start();
    }

	@Override
	public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	    }

}
