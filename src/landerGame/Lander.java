package landerGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
//class for general game folder, uses Slick2d library "Basic Game"
//is built from this tutorial:
// https:baksteenbrick.wordpress.com/2011/02/08/writing-java-games-with-slick-part-two-hello-world/
public class Lander extends BasicGame {
	
	Image hero; //this is where we initialize the image of the spaceship
	Image bg;
	float x = 20.0f; //x-coordinates for spaceship
	float y = 5.0f; // y-coordinates for spaceship
	float speed = 0.2f; //speed of spaceship

	
	public Lander(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO  is called constantly. This is where all your graphics is done.
		arg1.drawImage(bg,0,0);
		//after loading the spaceship image in "init", we draw it in "render"
		arg1.drawImage(hero, x, y); //it's called arg1, after "Graphics arg1", above. The spaceship is drawn at location (100,100)
		
		arg1.drawString("Welcome to the game", 200, 200); //places text at 200, 200 in the screen

		//arg1.setColor(Color.red);
		arg1.setColor(new Color(0,255,150)); // A  yucky green defined using three integers
		//arg1.setColor(new Color(1.0f,0.5f,0.5f,0.8f)); // A light purple with 80% transparency defined using four floats
		arg1.drawRect(180, 170, 210, 80);

		arg1.setColor(Color.red);
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO  is called when the game starts. You can put code here to set things up for your game, such as loading resources like images and sounds.
		//loading the spaceship image:
		hero = new Image("landerGame/Resources/minispace.png");
		bg = new Image("landerGame/resources/spaceBg.jpg");
		
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
		
		
	}

	public static void main(String[] args) {
		// TODO  Everything starts here. Let’s put in the first few lines of code to get things going

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
