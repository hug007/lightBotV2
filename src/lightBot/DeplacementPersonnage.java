package lightBot;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class DeplacementPersonnage {
	protected Animation[] animations = new Animation[8];
	private float x;
	private float y;
	private boolean moving;
	private int direction;

	public DeplacementPersonnage(float x, float y, int direction, boolean moving) {
		this.x=x;
		this.y=y;
		this.direction=direction;
		this.moving=moving;
	}


	public void init() throws SlickException {
		SpriteSheet spriteSheet = new SpriteSheet("src/main/resources/sprites/c.png", 64, 64);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
	    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
	    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
	    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
	    this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
	    this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
	    this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
	    this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}

	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	        animation.addFrame(spriteSheet.getSprite(x, y), 100);
	    }
	    return animation;
	}
}
