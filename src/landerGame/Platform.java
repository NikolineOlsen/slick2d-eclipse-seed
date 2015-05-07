package landerGame;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Platform {

	static Image platform; 
	
	public float gx;
	public float gy;
	
	Vector2f position; //using the vector position from the planet
	public int platformFuel;

	
	
	public Platform(int size,int xlocation, int ylocation) throws SlickException{ //constructor for the platform to be called in the init section in Lander
		
		platform = new Image("landerGame/Resources/platform.png"); //loading image for platform
		position = new Vector2f(xlocation, ylocation); //setting the vector position equal to the coords from the constructor for the platform
		platformFuel = 500;
	}

	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		arg1.drawImage(platform, position.x, position.y);//draw platform on screen
	}
	
	
	public void init(GameContainer arg0) throws SlickException {
		// TODO is called when the game starts. You can put code here to set
		// things up for your game, such as loading resources like images and
		// sounds.
		
	} 	
	
	public void update(GameContainer arg0, int delta) {
		gx = ((position.x-300) - Lander.player.x)/100;
		gy = ((position.y-50) - Lander.player.y)/100;
	}
}