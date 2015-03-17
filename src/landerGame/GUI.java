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
		arg1.drawString("Welcome to the game", Lander.xResolution / 2,
				Lander.yResolution / 2);
		arg1.setColor(new Color(0, 255, 150));
		arg1.drawRect(Lander.xResolution / 2 - 20, Lander.yResolution / 2 - 20,
				210, 80);

	}

}
