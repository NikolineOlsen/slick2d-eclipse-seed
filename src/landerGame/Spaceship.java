package landerGame;

import java.awt.geom.AffineTransform;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

//this is the class for moving the spaceship. BasicGame contains all the basics to create a simple game
public class Spaceship extends BasicGame {


	//this is the place where we create all the variables
	//the game images:
	Image player;
	float x = 20.0f; //x-coordinates for spaceship
	float y = 5.0f; // y-coordinates for spaceship
	
	Image ignitionSprite;
	
	float speed = 0.2f; //speed of spaceship
	int width; //width of player
	int height; //height of player
	
	
	AffineTransform transformer = new AffineTransform(); //initializing the AffineTransform method, that will help rotate the spaceship
	
		
	public double accelx = 0;
	public double accely = 0;
	public float angle = -90;
	public double throttlex;// throttlex and -y will control the difference in
							// acceleration when maneuvering the ship
	public double throttley;
	public boolean ignition = false;


	public Spaceship(String title) { // remember to call this in Landers Main
		super(title);

	}

	
	public void render(GameContainer arg0, Graphics g) throws SlickException { //render is called constantly. This is where all graphics is done.
		// TODO Auto-generated method stub
		//after loading the spaceship image in "init", we draw it in "render"
		g.drawImage(player, x, y); //it's called g, after "Graphics g", above. The spaceship is drawn at location (100,100)
 								
		if (ignition == true) {
			g.drawImage(ignitionSprite, x + 10, y + 70);
		}

	}


	public void init(GameContainer arg0) throws SlickException { //init is called when the game starts. This is where we set things up for the game, like load resources like images and sound.
		// TODO Auto-generated method stub
		//loading the spaceship image:
		player = new Image("landerGame/Resources/minispace.png");
		player.setCenterOfRotation((player.getWidth() / 2) + 7, (player.getHeight() / 2) + 90);
		// loading ignition sprite with rotation:
		ignitionSprite = new Image("landerGame/Resources/ignition.png");
		ignitionSprite.setCenterOfRotation((player.getWidth() / 2) + 7,(player.getHeight() / 2) + 90);

	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {

		Input input = arg0.getInput(); // asks Slick2D what keys are being pressed

		movement();

		if (input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D)) {
			rotateshipright();
		}

		// if the left arrow is being pressed:
		if (input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A)) {
			rotateshipleft();

		}
		throttlex = 0.001f * Math.cos(Math.toRadians(angle)) * delta;
		throttley = 0.001f * Math.sin(Math.toRadians(angle)) * delta;

		// if the up arrow is being pressed:
		if (input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W)) {
			throttling();
			ignition = true;
			System.out.println("Throttle is: " + ignition);

		} else {
			ignition = false;
			System.out.println("Throttle is: " + ignition);
		}

		
	}
		

		
		

	public void movement() { // This function moves the ship in it's current direction	
		x += accelx;
		y += accely;

		accelx = accelx / 1.001;
		accely = accely / 1.001;
	}

	public void rotateshipleft() {
		angle -= 1;
		player.rotate(-1);
		ignitionSprite.rotate(-1);

	}

	public void rotateshipright() {
		angle += 1;
		player.rotate(1);
		ignitionSprite.rotate(1);
	}

	public void throttling() {
		// here the throttle value (with it's embedded angular value) is added
		// to the acceleration
		accelx += throttlex;
		accely += throttley;

	}

}
