package lightBot;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.*;
/**
 * @author ZMNF8866
 *
 */
public class WindowsGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	private float x = 300, y = 300;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	
	public WindowsGame() {
		super("test 1 :: lighbot");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
//contenu du jeux
		this.map.render(50, 50);
		g.setBackground(new Color( 204,204 ,255 ));
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
		this.map = new TiledMap("C:/Users/ZMNF8866/Documents/GitHub/lightBotV2/src/main/resources/map/lvl.tmx");
		SpriteSheet spriteSheet = new SpriteSheet("C:/Users/ZMNF8866/Documents/GitHub/lightBotV2/src/main/resources/sprites/c.png", 64, 64);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
	    this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
	    this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
	    this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
	    this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
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
	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	        animation.addFrame(spriteSheet.getSprite(x, y), 100);
	    }
	    return animation;
	}

}
