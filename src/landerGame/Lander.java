package landerGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
//import org.newdawn.slick.Input; //is for handling key input
import org.newdawn.slick.SlickException;
//class for general game folder, uses Slick2d library "Basic Game"
//is built from this tutorial:
// https:baksteenbrick.wordpress.com/2011/02/08/writing-java-games-with-slick-part-two-hello-world/
public class Lander extends BasicGame {
	
	//Image hero; 
	Image bg;
	Spaceship player = new Spaceship("Player"); //creates new spaceship object. It's methods is called later in this class
	
	public Lander(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO  is called constantly. This is where all your graphics is done.
		arg1.drawImage(bg,0,0);
		arg1.drawString("Welcome to the game", 200, 200); //places text at 200, 200 in the screen
		//arg1.setColor(Color.red);
		arg1.setColor(new Color(0,255,150)); // A  yucky green defined using three integers
		//arg1.setColor(new Color(1.0f,0.5f,0.5f,0.8f)); // A light purple with 80% transparency defined using four floats
		arg1.drawRect(180, 170, 210, 80);	
		
		player.render(arg0, arg1); // calls render method in Spaceship class
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO  is called when the game starts. You can put code here to set things up for your game, such as loading resources like images and sounds.
		bg = new Image("landerGame/resources/spaceBg.jpg");
		player.init(arg0); //calls init method in Spaceship
	} 	

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		player.update(arg0, delta); // calls Spaceship class update method, where movement is coded
	}

	public static void main(String[] args) {
		Lander game = new Lander("Lander Game");
		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(800, 600, false); //size for the game window
			container.start();	
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
