package landerGame;

import java.awt.Shape;
import java.awt.geom.AffineTransform;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import sun.awt.image.PixelConverter.Bgrx;

//this is the class for moving the spaceship. BasicGame contains all the basics to create a simple game
public class Spaceship extends BasicGame {

	// this is the place where we create all the variables
	// the game images:
	public Image player;
	float x = 20.0f; // x-coordinates for spaceship
	float y = 5.0f; // y-coordinates for spaceship

	Image ignitionSprite;


	float speed = 0.2f; // speed of spaceship
	float width; // width of player
	float height; // height of player'
	public float health = 100; // health of player
	int score = 0;

	AffineTransform transformer = new AffineTransform(); // initializing the AffineTransform method, that will help rotate the spaceship


	public double accelx = 0;
	public double accely = 0;
	public float angle = -90;
	public double throttlex;// throttlex and -y will control the difference in
							// acceleration when maneuvering the ship
	public double throttley;
	public boolean ignition = false;

	public int fuelTank = 1000; // starting value of fuel tank of spaceship
	public int fuelTankLow = 0;// new value that switches place with fuelTank
								// when fuelTank = 0
	public int platformFuel = 1000;
	public int platformFuel2 = 1000;
	public int platformFuel3 = 1000;
	public boolean shipTooFast = false;
	
	public planet closestPlanet = null;

	public Spaceship(String title) { // remember to call this in Landers Main
		super(title);

	}


	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException { 
		// after loading the spaceship image in "init", we draw it in "render"
		g.drawImage(player, x + Lander.VIEWPORT_SIZE_X / 2, y
				+ Lander.VIEWPORT_SIZE_Y / 2); // it's called g, after "Graphics g", above. The spaceship is drawn at location(100,100)
		if (ignition == true) { // draws the ignitionsprite if w is pressed
			g.drawImage(ignitionSprite, x + Lander.VIEWPORT_SIZE_X / 2, y
					+ Lander.VIEWPORT_SIZE_Y / 2);
			ignitionSprite.setCenterOfRotation(player.getCenterOfRotationX(),
					player.getCenterOfRotationY()); // sets ignitionsprites center of rotation to the same as the spaceship as defined in init

		}

	}

	public void init(GameContainer arg0) throws SlickException { // init is called when the game starts. This is where we set things up for the game, like load resources like images and sound.
		// loading the spaceship image:
		player = new Image("landerGame/Resources/minispace.png");

		player.setCenterOfRotation((player.getWidth() / 2),
				(player.getHeight() / 3) - 10); // sets point of rotation on player, is a bit offset because the image is heigher than the spaceship sprite
		ignitionSprite = new Image("landerGame/Resources/ignition.png");// loading ignition sprite

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
			if (fuelTank > 0) {
			throttling();
			ignition = true;
			System.out.println("Throttle is: " + ignition + " Fuel level: "
					+ fuelTank--);
			}

		} else {
			ignition = false;
			System.out.println("Throttle is: " + ignition);
		}

		// fuel code for spaceship:
		if (fuelTank <= 0) { // if the fuel is equal or less than zero, the accelx and -y will be reduced by 1.05 for a smoother stop, when it's out of gas


			stopShip();
			GUI.gameloss = true;
		}



		if (CollisionDetection.collidesWithPlanet == true || CollisionDetection.collidesWithPlanet2 == true || CollisionDetection.collidesWithPlanet3 == true) { // if ship collides with planet it stops

			// land ship
			shipCollision(); // also checks if accel is too high and reduces health if it is. also checks angle

		
		
		}

		// if ships angle is off it loses life, it the angle is right it gets
		// fuel, when landing on platform
		if (CollisionDetection.collidesWithPlatform == true ||CollisionDetection.collidesWithPlatform2 == true || CollisionDetection.collidesWithPlatform3 == true) {

			shipCollision();
			// only gives as much fuel there is in the platform
			if (angle > -100 && angle < -70 && 0 < platformFuel) { // spaceship will keep tanking fuel until the platforms fuel is empty
				platformFuel -= 50;
				fuelTank +=50;

				score +=50;

			}
		}

		
		if (health <= 0) { // if health is below 0, player sprites are removed(made invisible)
			player.setAlpha(0);
			ignitionSprite.setAlpha(0);
		}
		if (health < 0) {
			health = 0; // stops health counter going down when reaching 0
		}
	
	
		System.out.println("Ship angle is: " + angle);
		System.out.println("Accel " + (accelx + accely) / 2);
		
						
	}

	private void shipCollision() {

		x += accelx - Lander.testplanet.gx; // this stops the ship by canceling out the movement values with their negative values
		y += accely - Lander.testplanet.gy;
	
		stopShip();
		
		if ((accelx + accely) / 2 > -0.5) { // if ship collides and goes too
											// fast, health is reduced
			shipTooFast = true;
			health -= 0.2f;
		} else if ((accelx + accely) / 2 < -0.5) {
			shipTooFast = false; // doesnt work atm for some reason, should not display damage when not going too fast
		}
		
		if (angle < -100 || angle > -70) { // if angle is too wrong, ship takes more damage
												
			health -= 0.5f;
			System.out.println("Angle is wrong");
		} else {
			System.out.println("Angle is right");
		}
	}

	public void movement() { // This function moves the ship in it's current
								// direction
		if (CollisionDetection.GravitationalEffect == true){

		x += accelx + Lander.testplanet.gx;
		y += accely + Lander.testplanet.gy;
		}else{
			x += accelx;
			y += accely;
		}

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
		if(accelx < 1){
		accelx += throttlex;
		}
		
		if(accely <1){
		accely += throttley;
		}
	}

	public void stopShip() { // method for stopping ship
		accelx = accelx / 1.05;
		accely = accely / 1.05;

	}

}
