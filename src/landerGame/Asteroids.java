package landerGame;

import java.awt.geom.AffineTransform;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

//this is the class for moving the spaceasteroid. BasicGame contains all the basics to create a simple game
public class Asteroids extends BasicGame {

	Image asteroid;
	float x = 20.0f; // x-coordinates for spaceasteroid
	float y = 5.0f; // y-coordinates for spaceasteroid

	float speed = 0.2f; // speed of spaceasteroid
	int width; // width of player
	int height; // height of player

	AffineTransform transformer = new AffineTransform(); 

	public double accelx = 0;
	public double accely = 0;
	public float angle = -90;
	public double throttlex;
	public double throttley;
	public boolean ignition = false;

	public Asteroids(String title) {
		super(title);

	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException { 
		g.drawImage(asteroid, x +200+ Lander.VIEWPORT_SIZE_X / 2, y
				+200+ Lander.VIEWPORT_SIZE_Y / 2); 
	}

	@Override
	public void init(GameContainer arg0) throws SlickException { 
		// loading the spaceasteroid image:
		asteroid = new Image("asteroid1.png");
		asteroid.setCenterOfRotation((asteroid.getWidth() / 2),
				(asteroid.getHeight() / 2));

	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {

		float randNum = (float)Math.random();
		System.out.println("Random number generated: "+randNum);
		movement();

		//if (Math.random() < 0.5) {
			rotateasteroidright();
		//}

			//if (Math.random() > 0.5) {
			// rotateasteroidleft();

		//}
		throttlex = Math.random()/1000 * Math.cos(Math.toRadians(angle)) * delta;
		throttley = Math.random()/1000 * Math.sin(Math.toRadians(angle)) * delta;

		// if the up arrow is being pressed:
		if (Math.random() > 0.9) {
			throttling();

		}

	}

	public void movement() { // This function moves the asteroid in it's current
								// direction
		x += accelx;
		y += accely;

		accelx = accelx / 1.001;
		accely = accely / 1.001;
	}

	public void rotateasteroidleft() {
		angle -= 0.1;
		asteroid.rotate(-1);

	}

	public void rotateasteroidright() {
		angle += 1;
		asteroid.rotate(1);
	}

	public void throttling() {
		// here the throttle value (with it's embedded angular value) is added
		// to the acceleration
		accelx += throttlex;
		accely += throttley;

	}

}
