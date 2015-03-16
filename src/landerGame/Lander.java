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
	Spaceship player = new Spaceship("Player"); //creates new spaceship object. It's methods is called later in this class
	GUI welcome = new GUI();
	planet testplanet;
	
	static int xResolution = 1200;
	static int yResolution = 700;

	public Lander(String title) {
		super(title);
		//constructor
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO  is called constantly. This is where all your graphics is done.
		
		arg1.translate(-player.x, -player.y); // makes screen follow character(gives the illusion of it)
		
		arg1.drawImage(bg,player.x-600,player.y-400); // draws background
			
		testplanet.render(arg0, arg1);
				
		player.render(arg0, arg1); // calls render method in Spaceship class
		welcome.render(arg0, arg1); // calls render method in GUI
		
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO  is called when the game starts. You can put code here to set things up for your game, such as loading resources like images and sounds.
		bg = new Image("landerGame/resources/spaceBg2.jpg");
		player.init(arg0); //calls init method in Spaceship
		testplanet = new planet(1, 200, 100);

	
	} 	

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		player.update(arg0, delta); // calls Spaceship class update method, where movement is coded
	}

	public static void main(String[] args) {
		Lander game = new Lander("Lander Game");
		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(xResolution, yResolution, false); //size for the game window
			container.setTargetFrameRate(60);
			container.start();	
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
