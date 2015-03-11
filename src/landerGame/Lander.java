package landerGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
//class for general game folder, uses Slick2d library "Basic Game"
//is built from this tutorial:
// https:baksteenbrick.wordpress.com/2011/02/08/writing-java-games-with-slick-part-two-hello-world/
public class Lander extends BasicGame {

	public Lander(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO  is called constantly. This is where all your graphics is done.

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO  is called when the game starts. You can put code here to set things up for your game, such as loading resources like images and sounds.

	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO  is called periodically, usually every 20 milliseconds, but the time will vary depending on how much processing you’ll be putting in. This is where the game logic is done.

	}

	public static void main(String[] args) {
		// TODO  Everything starts here. Let’s put in the first few lines of code to get things going

		Lander game = new Lander("Lander Game");
		try {
			AppGameContainer container = new AppGameContainer(game);
			container.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
