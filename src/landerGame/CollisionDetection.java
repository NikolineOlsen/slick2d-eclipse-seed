package landerGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class CollisionDetection {

	public CollisionDetection() {
		// TODO Auto-generated constructor stub
	}
	float boxx = 200;
	float boxy = 200;
	float boxwidth = 100;
	float boxheight = 100;
	public static boolean collision = false; // is only public to use in GUI, otherwise remove public
	
	public void collisionBox(GameContainer arg0, Graphics arg1) throws SlickException{
		
		//below the collisionBox for the spaceship is drawn with
		//the x,y,width and height of the player object in lander			
		arg1.drawRect(Lander.player.x+Lander.VIEWPORT_SIZE_X/2,
				Lander.player.y+Lander.VIEWPORT_SIZE_Y/2,
				Lander.player.player.getWidth(),Lander.player.player.getHeight());
				
		
		//test collision box
		arg1.fillRect(boxx,boxy,boxwidth,boxheight);
		
	
		
		
	}
	public void update(GameContainer arg0, int delta) throws SlickException {
		//either normalize player x,
		
		//if both boxes are within same x+width,y+height, collision is true
		if(boxx < Lander.player.x && Lander.player.x < boxwidth + boxx ||
				boxy < Lander.player.y && Lander.player.y < boxheight + boxy){
					collision = true;
				} else{
					collision = false;
				}
				System.out.println("Collision is: "+collision);
				System.out.println("Boxx: "+boxx);
				System.out.println("Boxy: "+boxy);
	}
	
}
