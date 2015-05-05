package landerGame;


import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;


public class CollisionDetection extends BasicGame {

	public static Shape shipCollider = null;
	private Circle planetCollider = null;
	public static boolean collides = false;
	public static boolean collides2 = false;
	private Rectangle platformCollider = null;
	
	public CollisionDetection(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g)	throws SlickException {

		g.setColor(new Color(255,255,255,0.4f));
		g.fill(planetCollider); // fills planetCollider with above defined white colour and transparency
		
		g.setColor(new Color(255,255,255,0.2f));
		g.fill(shipCollider);
		
		g.setColor(new Color(255,255,255,0.2f));
		g.fill(platformCollider);
		
		
		
		g.resetTransform();
		g.drawString("Collides: "+collides, 10, 40); //for debugging collision
		
		
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		planetCollider = new Circle(0,0,Lander.testplanet.planetimage.getWidth()/2);
		
		shipCollider = new Circle(0,0,Lander.player.player.getWidth()/2,20); //needs to get values from player png size this way
		
		platformCollider = new Rectangle(0,0, landerGame.Platform.platform.getWidth(), landerGame.Platform.platform.getHeight());
	}	


	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		//shipCollider.setLocation(container.getInput().getMouseX(), container.getInput().getMouseY());//shipSquare follows mouse
		shipCollider.setLocation(Lander.player.x+Lander.VIEWPORT_SIZE_X/2,Lander.player.y+Lander.VIEWPORT_SIZE_Y/2); //divides by viewport size because player is placed in game center
		planetCollider.setLocation(Lander.testplanet.position.x, Lander.testplanet.position.y);
		platformCollider.setLocation(Lander.platform.position.x,Lander.platform.position.y);
		
		collides2 = shipCollider.intersects(platformCollider); 	
		collides = shipCollider.intersects(planetCollider); //checks if ship collision box collides with planet collision box
		
		
	}
	
	
	
	
	
}
