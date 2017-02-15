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
import java.util.*;
/**
 * @author ZMNF8866
 *
 */

public class WindowsGame extends BasicGame {
	
	private GameContainer container;
	private TiledMap map;
	private float x = 50, y = 50+(5*32)+(16);
	private int direction = 3;
	private boolean moving = false;
	private String str="";
	private boolean bool=false;
	
	private Animation[] animations = new Animation[8];
	
	public WindowsGame() {
		super("test 1 :: lighbot");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
//contenu du jeux
		this.map.render(50, 50);
		g.setBackground(new Color( 204,204 ,255 ));
		 g.setColor(new Color(0, 0, 0, .5f));
		  g.fillOval(x - 16, y - 8, 32, 16);
		   g.drawAnimation(animations[direction + (moving ? 4 : 0)], x-32, y-60);
		   g.drawString( this.str , 0, 0);
		   g.drawLine( 0, 400, 500, 400);
		   g.drawLine( 500, 0, 500, 400);
		   g.drawString( "controlleur" , 200, 500);
		   g.drawString( "sequence" , 600, 200);
		   g.setColor(new Color( 0,255 ,0 ));
		   g.fillRect(400, 300, 100, 100);
		   g.setColor(new Color( 0,0,0 ));
		   g.drawString( "GO" , 440, 350);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
//initialisation
		this.container = container;
		this.map = new TiledMap("C:/Users/ZMNF8866/Documents/GitHub/fa19-lightBotV2/src/main/resources/map/ab.tmx");
		SpriteSheet spriteSheet = new SpriteSheet("C:/Users/ZMNF8866/Documents/GitHub/fa19-lightBotV2/src/main/resources/sprites/c.png", 64, 64);
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
	public void update(GameContainer container, int delta) throws SlickException {
//mise a jour des éléments
		str=""+delta;
		/*if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= 0.1f * delta; break; // mettre des limite pour ne pas sortir de la map
	            case 1: this.x -= 0.1f * delta; break;
	            case 2: this.y += 0.1f * delta; break;
	            case 3: this.x += 0.1f * delta; break;
	        }
	    }*/

if(this.bool){
if(this.x> 50+48 ){
	this.direction=0;
	if(this.y<(50+(5*32)+(16)-32)){
		this.direction=3;
		if(this.x>50+48+64){
			this.direction=0;
			if(this.y<(50+(5*32)+(16)-32)-96){
				this.direction=3;
				if(this.x>50+48+64+96){
					this.moving=false;
				}
				else{
					this.x += 0.1f * delta;
				}
			}
			else{
				this.y -= 0.1f * delta;
			}
		}
		else{
			this.x += 0.1f * delta;
		}
	}
	else{
		this.y -= 0.1f * delta;
	}	
}
else{
	this.x += 0.1f * delta;
}}

}
	public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowsGame(), 680, 680, false).start();
    }

	
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	        animation.addFrame(spriteSheet.getSprite(x, y), 100);
	    }
	    return animation;
	}
	@Override
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;  
	    }
	}
	
	@Override
	public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        this.moving = false;
	    }
	
	@Override
	public void mousePressed(int button, int x, int y) {
		switch (button) {
		//case Input.isMouseButtonDown(button): 
		case Input.MOUSE_LEFT_BUTTON:
			if(400<x&& x<500 && 300<y && y<400) { this.x = 50; this.y = 50+(5*32)+(16); this.moving=true; this.bool=true;} 
			else this.str="mouse active"; break;
	}
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		 //this.str="";
	}
	
	
	}

//http://slick.ninjacave.com/javadoc/org/newdawn/slick/Input.html
