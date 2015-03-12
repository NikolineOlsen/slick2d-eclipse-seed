package landerGame;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spaceship extends BasicGame {  //this is the class for moving the spaceship. BasicGame contains all the basics to create a simple game

	//this is the place where we create all the variables
	//the game images:
	//Image hero;
	
	public Spaceship(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException { //render is called constantly. This is where all graphics is done.
		// TODO Auto-generated method stub
		//after loading the spaceship image in "init", we draw it in "render"
		//arg1.drawImage(hero, 100, 100); //it's called arg1, after "Graphics arg1", above. The spaceship is drawn at location (100,100)

	}

	@Override
	public void init(GameContainer arg0) throws SlickException { //init is called when the game starts. This is where we set things up for the game, like load resources like images and sound.
		// TODO Auto-generated method stub
		//loading the spaceship image:
		//hero = new Image("landerGame/triangle.png");
	

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException { //update is called periodically (usually every 20 milliseconds), this is where the game logic is done
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) { //everything starts in main
		// TODO Auto-generated method stub

	}

}
