package landerGame;

import java.awt.geom.AffineTransform;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Spaceship extends BasicGame {  //this is the class for moving the spaceship. BasicGame contains all the basics to create a simple game

	//this is the place where we create all the variables
	//the game images:
	Image hero;
	float x = 20.0f; //x-coordinates for spaceship
	float y = 5.0f; // y-coordinates for spaceship
	float speed = 0.2f; //speed of spaceship
	
	
	AffineTransform transformer = new AffineTransform(); //initializing the AffineTransform method, that will help rotate the spaceship
	
		
	public Spaceship(String title) { // remember to call this in Landers Main
		super(title);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException { //render is called constantly. This is where all graphics is done.
		// TODO Auto-generated method stub
		//after loading the spaceship image in "init", we draw it in "render"
		g.drawImage(hero, x, y); //it's called g, after "Graphics g", above. The spaceship is drawn at location (100,100)
	}

	@Override
	public void init(GameContainer arg0) throws SlickException { //init is called when the game starts. This is where we set things up for the game, like load resources like images and sound.
		// TODO Auto-generated method stub
		//loading the spaceship image:
		hero = new Image("landerGame/Resources/minispace.png");

	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		// TODO  is called periodically, usually every 20 milliseconds, but the time will vary depending on how much processing you’ll be putting in. This is where the game logic is done.

		Input input = arg0.getInput(); //asks Slick2D what keys are being pressed
		
		//movements of the spaceship
		//if the right arrow is being pressed:
		if(input.isKeyDown(Input.KEY_RIGHT))
		{
			x+= speed * delta; //going in the positive x-direction. multiplied by delta so the FPS is stabilized for all computers(same speed for all).
		}

		//if the left arrow is being pressed:
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			x-= speed * delta; //going in the decreasing x-direction. multiplied by delta so the FPS is stabilized for all computers(same speed for all).
		}
		
		//if the down arrow is being pressed:
		if(input.isKeyDown(Input.KEY_DOWN))
		{
			y+= speed * delta; //going in the positive y-direction. multiplied by delta so the FPS is stabilized for all computers(same speed for all).
		}
		
		//if the up arrow is being pressed:
		if(input.isKeyDown(Input.KEY_UP))
		{
			y-= speed * delta; //going in the decreasing y-direction. multiplied by delta so the FPS is stabilized for all computers(same speed for all).
		}
		
		//to create an acceleration thrust for the player:
		//if(input.isKeyDown(Input.KEY_SPACE)&&(input.isKeyDown(Input.KEY_UP)))
		//{
			//y-= speed*10; //creates an acceleration for the spaceship in the upwards direction
		//}
		
	
	    
		
	}
	
	public static void main(String[] args) { //everything starts in main
		// TODO Auto-generated method stub
		
		
	
	}

}
