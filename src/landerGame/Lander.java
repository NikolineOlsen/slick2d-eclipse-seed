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
	
	Image bg;
	Image stardust;
	Image asteroidbelt;
	
	public Spaceship player = new Spaceship("Player"); //creates new spaceship object. It's methods is called later in this class
	GUI welcome = new GUI();
	planet testplanet;
	Asteroids asteroid = new Asteroids("asteroid");
	
	
	static int VIEWPORT_SIZE_X = 1200;
	static int VIEWPORT_SIZE_Y = 700;
	
	float bgPosX = player.x-VIEWPORT_SIZE_X/3;
	float bgPosY = player.y-VIEWPORT_SIZE_Y/3;

	float parallaxConstant = 30;
	
	public Lander(String title) {
		super(title);
		//constructor
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO  is called constantly. This is where all your graphics is done.
		
		//translate functions below are used to create "parallax" effect.
		arg1.translate(-player.x/parallaxConstant, -player.y/parallaxConstant);
		arg1.drawImage(bg, bgPosX,bgPosY); // draws background somewhat centralized
		
		
		arg1.translate(-player.x/4, -player.y/4);
		//multiple instances of stardust are created to fill out the scene
		arg1.drawImage(stardust, bgPosX,bgPosY);
		arg1.drawImage(stardust, bgPosX+stardust.getWidth(),bgPosY);
		arg1.drawImage(stardust, bgPosX,bgPosY +stardust.getWidth());
		arg1.drawImage(stardust, bgPosX+stardust.getWidth(),bgPosY +stardust.getWidth());
		
		arg1.translate(-player.x/2,-player.y/2); 
		testplanet.render(arg0, arg1);
		
		asteroid.render(arg0, arg1);
			
		arg1.translate(player.x/parallaxConstant, player.y/parallaxConstant);		
		player.render(arg0, arg1); // calls render method in Spaceship class
		
		//multiple instances of asteroids are created to fill out the scene
		arg1.translate(-player.x*2, -player.y*2);
		arg1.drawImage(asteroidbelt, bgPosX, bgPosY);
		arg1.drawImage(asteroidbelt, bgPosX+asteroidbelt.getWidth(),bgPosY);
		arg1.drawImage(asteroidbelt, bgPosX,bgPosY +asteroidbelt.getWidth());
		arg1.drawImage(asteroidbelt, bgPosX+asteroidbelt.getWidth(),bgPosY +asteroidbelt.getWidth());
		
		welcome.render(arg0, arg1); // calls render method in GUI
		
		//if(player.x >VIEWPORT_SIZE_X/3) --> reset player to middle(slowly) 
		
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO  is called when the game starts. You can put code here to set things up for your game, such as loading resources like images and sounds.
		bg = new Image("landerGame/resources/spaceBg3.jpg");
		player.init(arg0); //calls init method in Spaceship
		testplanet = new planet(1, 200, 100);
		asteroid.init(arg0);
		
		stardust = new Image("landerGame/resources/stardust.png");
		asteroidbelt = new Image("landerGame/resources/asteroidbelt1.png");
		
	
	} 	

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		player.update(arg0, delta); // calls Spaceship class update method, where movement is coded
		asteroid.update(arg0, delta);
	}

	public static void main(String[] args) {
		Lander game = new Lander("Lander Game");
		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(VIEWPORT_SIZE_X, VIEWPORT_SIZE_Y, false); //size for the game window
			container.setTargetFrameRate(60);
			container.start();	
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

}
