package landerGame;

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
	
	public double accelx = 0;
	public double accely = 0;
	public float angle = -90;
	public double throttlex;//throttlex and -y will control the difference in acceleration when maneuvering the ship
	public double throttley;
	
	public Spaceship(String title) { // remember to call this in Landers Main
		super(title);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException { //render is called constantly. This is where all graphics is done.
		// TODO Auto-generated method stub
		//after loading the spaceship image in "init", we draw it in "render"
		
		arg1.drawImage(hero, x, y); //it's called arg1, after "Graphics arg1", above. The spaceship is drawn at location (100,100)
	}

	@Override
	public void init(GameContainer arg0) throws SlickException { //init is called when the game starts. This is where we set things up for the game, like load resources like images and sound.
		// TODO Auto-generated method stub
		//loading the spaceship image:
		hero = new Image("landerGame/Resources/minispace.png");
		hero.setCenterOfRotation((hero.getWidth()/2)+7, (hero.getHeight()/2)+90);

	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		// TODO  is called periodically, usually every 20 milliseconds, but the time will vary depending on how much processing you’ll be putting in. This is where the game logic is done.

		Input input = arg0.getInput(); //asks Slick2D what keys are being pressed
		
	
		movement();
		
		
		if(input.isKeyDown(Input.KEY_RIGHT ) || input.isKeyDown(Input.KEY_D))
		{
			
			rotateshipright();
		}

		//if the left arrow is being pressed:
		if(input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A))
		{
		
		rotateshipleft();
		
		}
		throttlex = 0.001f * Math.cos(Math.toRadians(angle))* delta; 
		throttley = 0.001f * Math.sin(Math.toRadians(angle))* delta;
			
		
		//if the up arrow is being pressed:
		if(input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W))
		{
			throttling();
	
		}
		
	}
	public void movement(){ //This function moves the ship in it's current direction
		x += accelx;

		y += accely;
		
		accelx = accelx/1.001;
		accely = accely/1.001;
		
	}
	
	public void rotateshipleft(){
		angle -= 1;
		hero.rotate(-1);
		
	}
	
	public void rotateshipright(){
		angle += 1;
		hero.rotate(1);
	}
	public void throttling(){
		
		//here the throttle value (with it's embedded angular value) is added to the acceleration	
		accelx += throttlex;
		accely += throttley;
	}
	
	public static void main(String[] args) { //everything starts in main
		// TODO Auto-generated method stub
	
	}

}
