package landerGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class GUI {

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO is called constantly. This is where all your graphics is done.
		arg1.resetTransform();
		arg1.drawString("Welcome to the game", Lander.VIEWPORT_SIZE_X / 2,
				Lander.VIEWPORT_SIZE_Y / 2);
		arg1.setColor(new Color(0, 255, 150));
		arg1.drawRect(Lander.VIEWPORT_SIZE_X / 2 - 20, Lander.VIEWPORT_SIZE_Y / 2 - 20,
				210, 80);
		
		arg1.drawString("Collision is: " +CollisionDetection.collision, 20,20);
	
	}

}
