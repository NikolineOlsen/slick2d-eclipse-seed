package landerGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;

public class GUI {
	
	Image heart;
	private boolean gameloss;
	private int welcomeGUIAlpha = 200;
	private int lossGUIAlpha = 200;

	public GUI() {
		// TODO Auto-generated constructor stub
	}

	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
	
		//resetTransform is needed to make sure gui doesnt parallax
		//This first part is for the start menu intro text
		arg1.resetTransform();
		arg1.setColor(new Color(0, 255, 150,welcomeGUIAlpha));
		arg1.drawString("Welcome to the game", Lander.VIEWPORT_SIZE_X / 2,
				Lander.VIEWPORT_SIZE_Y / 2);
		arg1.drawString("CONTROL spaceship with WASD or arrow keys", Lander.VIEWPORT_SIZE_X / 2,
				Lander.VIEWPORT_SIZE_Y / 2+ 20);
		arg1.drawString("Exit game with E", Lander.VIEWPORT_SIZE_X / 2,
				Lander.VIEWPORT_SIZE_Y / 2+ 40);
		arg1.drawString("Restart game with R", Lander.VIEWPORT_SIZE_X / 2,
				Lander.VIEWPORT_SIZE_Y / 2+ 60);
		arg1.drawRect(Lander.VIEWPORT_SIZE_X / 2 - 20, Lander.VIEWPORT_SIZE_Y / 2 - 20,
				400, 120);
		if(Lander.player.ignition == true){
			welcomeGUIAlpha --; // makes intro text fade out when throtthling
		}
		
		
		//healthbar code below
		arg1.resetTransform(); //makes the following code follow the display window
		arg1.setColor(new Color(255, 0, 0,200));
		arg1.drawImage(heart, 120, 10); //draw heart for healthbar
		arg1.drawString((int)Lander.player.health + "%", 170, 15); //drawing the estimated life that is left
		
		//if statements for fuel for spaceship:
		if (Lander.player.fuelTank > 0){ //if the fuel tank is above zero it should display the values of fuel
			arg1.drawString("Fuel " + Lander.player.fuelTank, 250, 15);
		}
		else if (Lander.player.fuelTank <= 0) { //if the fuel level is below zero it should switch to another fuel variable set to zero.
		arg1.drawString("Fuel " + Lander.player.fuelTankLow, 250, 15);
		}
		//if statements for damage, destruction and reset:
		if(CollisionDetection.collides == true && Lander.player.shipTooFast == true){
			arg1.setColor(Color.red);
			arg1.drawString("Your spaceship is taking damage", 50, 50);
		}
		if(Lander.player.health <=0){
			 gameloss = true;
		}
		if (gameloss == true){ // loss screen
			arg1.setColor(new Color(80, 60, 60,lossGUIAlpha));
			arg1.fillRect(20,20,Lander.VIEWPORT_SIZE_X-40,Lander.VIEWPORT_SIZE_Y-40);
			arg1.setColor(new Color(255, 225, 255,lossGUIAlpha));
			arg1.drawString("Your spaceship has been destroyed", Lander.VIEWPORT_SIZE_X/3, Lander.VIEWPORT_SIZE_Y/2);
			arg1.drawString("Exit game with E", Lander.VIEWPORT_SIZE_X / 2,
					Lander.VIEWPORT_SIZE_Y / 2+ 40);
			arg1.drawString("Restart game with R", Lander.VIEWPORT_SIZE_X / 2,
					Lander.VIEWPORT_SIZE_Y / 2+ 60);
			
		}
	}
		
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput(); // asks Slick2D what keys are being pressed
		
		if (input.isKeyDown(Input.KEY_E)) { //exits the game when pressing E
			container.exit();
		}
		if (input.isKeyDown(Input.KEY_R)) { //restarts the game when pressing R
			Lander.player.x = 20;
			Lander.player.y = 5;
			Lander.player.fuelTank = 1000;
			Lander.player.health = 100;
			Lander.player.player.setAlpha(255);
			Lander.player.ignitionSprite.setAlpha(255);
			welcomeGUIAlpha = 200;
			lossGUIAlpha  = 0;
			
		}

	} 	
	public void init(GameContainer arg0) throws SlickException {
		// TODO is called when the game starts. You can put code here to set
		// things up for your game, such as loading resources like images and
		// sounds.
			
		heart = new Image("landerGame/Resources/HeartFull.png"); //healthbar for player

	} 	
}
