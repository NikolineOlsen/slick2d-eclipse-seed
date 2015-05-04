/**
 * 
 */
package landerGame;

import java.awt.Rectangle;
import java.awt.Shape;

import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;


public class Collision {
	{
	
	Image player;
	Image planetimage;
	
	
	if (((Shape) landerGame.planet.planetimage).getBounds2D().intersects(((Shape) Lander.player).getBounds2D()) )
	{
	    System.out.println("true somethinggggg ");
	   
}
}
}
		
	/*Rectangle playerSquare = new Rectangle();
	Sphere planetSpehere = new Sphere();
	
	
	//references to the sprite image of the player
	Collision(Spaceship player, int x, int y) {
		
		this.player = player;
		this.x = player.x;
		this.y = player.y;
	}
	
	
	public void draw() {
		//player.draw((int)player.x, (int) player.y);
	}
	
	//public boolean collidesWith(Collision other) {
        //playerSquare.setBounds((int) x, (int) y, player.width(), player.height());

        //planetSphere.setBounds((int) other.x, (int) other.y, other.testplanet.width(), other.testplanet.height());

       // return playerSquare.intersects(planetSphere);

	} */
	
		


	

