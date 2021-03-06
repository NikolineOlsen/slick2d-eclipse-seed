package landerGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
//import org.newdawn.slick.Color; // is not used anymore since all Color operations have been moved to GUI class
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
//import org.newdawn.slick.Input; //is for handling key input
import org.newdawn.slick.SlickException;
//class for general game folder, uses Slick2d library "Basic Game"
//is built from this tutorial:
// https:baksteenbrick.wordpress.com/2011/02/08/writing-java-games-with-slick-part-two-hello-world/

public class Lander extends BasicGame {

//declaring the background and foreground images for the game
	Image bg;
	Image stardust;
	Image asteroidbelt;
	
	
	//creating a new instance of the player in the main lander game
	public static Spaceship player = new Spaceship("Player"); // creates new spaceship object.
	
							
	MapBounds bounds = new MapBounds(); //declaration of the boundaries of the map
	public static GUI gui = new GUI(); //declaration of the GUI class
	public static planet testplanet; //declaration of all of the 3 planets
	public static planet testplanet2;
	public static planet testplanet3;
	Asteroids asteroid = new Asteroids("asteroid"); //declaration of the asteroid image in the foreground
	public static Platform platform; //declaration of all of the 3 platforms
	public static Platform platform2;
	public static Platform platform3;

	Collision Shape; //declaration of the collision class

	public static CollisionDetection collision = new CollisionDetection("CollisionDetector"); //creating a new instance of the collision detection


	//setting the size of the game
	static int VIEWPORT_SIZE_X = 1200; 
	static int VIEWPORT_SIZE_Y = 700;

	//setting the players start position
	float bgPosX = player.x - VIEWPORT_SIZE_X / 3;
	float bgPosY = player.y - VIEWPORT_SIZE_Y / 3;
	

	//creating a class of the main game where all of the other classes will be tied together with this one
	public Lander(String title) {
		super(title);
		// constructor
	}

	//this is where all of the images from the other classes; platform, planet and collision detection, player is drawn
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO is called constantly. This is where all your graphics is done.

		// translate functions below are used to create "parallax" effect.
		arg1.translate(-player.x / 30, -player.y / 30);
		arg1.drawImage(bg, bgPosX, bgPosY); // draws background somewhat
											// centralized

		arg1.translate(-player.x / 4, -player.y / 4);
		// multiple instances of stardust are created to fill out the scene
		arg1.drawImage(stardust, bgPosX, bgPosY);
		arg1.drawImage(stardust, bgPosX + stardust.getWidth(), bgPosY);
		arg1.drawImage(stardust, bgPosX, bgPosY + stardust.getWidth());
		arg1.drawImage(stardust, bgPosX + stardust.getWidth(), bgPosY
				+ stardust.getWidth());

		arg1.translate(-player.x / 2, -player.y / 2);

		
		testplanet.render(arg0, arg1);
		testplanet2.render(arg0, arg1);
		testplanet3.render(arg0, arg1);
		
		platform.render(arg0, arg1);
		platform2.render(arg0, arg1);
		platform3.render(arg0, arg1);

		
		
		
		arg1.translate(player.x / 30, player.y / 30);
		player.render(arg0, arg1); // calls render method in Spaceship class
		collision.render(arg0, arg1);
		
		// multiple instances of asteroids are created to fill out the scene
		arg1.translate(-player.x * 2, -player.y * 2);
		arg1.drawImage(asteroidbelt, bgPosX, bgPosY);
		arg1.drawImage(asteroidbelt, bgPosX + asteroidbelt.getWidth()-1000, bgPosY-1000);
		arg1.drawImage(asteroidbelt, bgPosX-1000, bgPosY + asteroidbelt.getWidth()-1000);
		arg1.drawImage(asteroidbelt, bgPosX + asteroidbelt.getWidth()-1000, bgPosY
				+ asteroidbelt.getWidth()-1000);
		
		asteroid.render(arg0, arg1);
		gui.render(arg0, arg1); // calls render method in GUI
	


	}
	//initializing all of the 3 planets, platforms, player and collision
	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO is called when the game starts. You can put code here to set
		// things up for your game, such as loading resources like images and
		// sounds.
		bg = new Image("spaceBg3.jpg");
		player.init(arg0); // calls init method in Spaceship
		
		
		testplanet = new planet(1, -150, 900);
		testplanet2 = new planet(1, 600, 400);
		testplanet3 = new planet(1, -150, -450);
		
		platform = new Platform(1, 75, 870);
		platform2 = new Platform(1, 800, 370);
		platform3 = new Platform(1, 75, -480);
		
		asteroid.init(arg0);
		gui.init(arg0);
		stardust = new Image("stardust.png");
		asteroidbelt = new Image("asteroidbelt1.png");

		collision.init(arg0);
		
	
	} 	

	//refering to all of the classes' update
	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		player.update(arg0, delta); // calls Spaceship class update method,
		asteroid.update(arg0, delta);
		bounds.update(arg0, delta);

		collision.update(arg0, delta);
		testplanet.update(arg0,delta);
		testplanet2.update(arg0,delta);
		testplanet3.update(arg0,delta);
		platform.update(arg0, delta);

		
		gui.update(arg0, delta);
		
		//for every planet in the array there should be drawn a planet at these positions
				
		


	}
	//static void main
	public static void main(String[] args) {
		Lander game = new Lander("Lander Game");
		try {
		AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(VIEWPORT_SIZE_X, VIEWPORT_SIZE_Y, false); // size for the game window
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

}
