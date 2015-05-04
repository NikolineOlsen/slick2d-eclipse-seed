package landerGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GUI {
	
	Image heart;

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

			
		arg1.resetTransform(); //makes the following code follow the display window
		arg1.drawImage(heart, 120, 10); //draw heart for healthbar
		arg1.drawString((int)Lander.player.health + "%", 170, 15); //drawing the estimated life that is left
		
		//if statements for fuel for spaceship:
		if (Lander.player.fuelTank > 0){ //if the fuel tank is above zero it should display the values of fuel
			arg1.drawString("Fuel " + Lander.player.fuelTank, 250, 15);
		}
		else if (Lander.player.fuelTank <= 0) { //if the fuel level is below zero it should switch to another fuel variable set to zero.
		arg1.drawString("Fuel " + Lander.player.fuelTankLow, 250, 15);
		}

	}
		
	

	

	public void init(GameContainer arg0) throws SlickException {
		// TODO is called when the game starts. You can put code here to set
		// things up for your game, such as loading resources like images and
		// sounds.
			
		heart = new Image("landerGame/Resources/HeartFull.png"); //healthbar for player

		
		
	
	} 	
}
