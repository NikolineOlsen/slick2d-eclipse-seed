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
	private static Circle planetCollider = null;
	private static Circle planet2Collider = null;
	private static Circle planet3Collider = null;
	private static Rectangle platformCollider = null;
	private static Rectangle platform2Collider = null;
	private static Rectangle platform3Collider = null;
	
	public static boolean collidesWithPlanet = false;
	public static boolean collidesWithPlanet2 = false;
	public static boolean collidesWithPlanet3 = false;
	public static boolean collidesWithPlatform = false;
	public static boolean collidesWithPlatform2 = false;
	public static boolean collidesWithPlatform3 = false;
	public static boolean GravitationalEffect = false;
	public static boolean GravitationalEffect2 = false;
	public static boolean GravitationalEffect3 = false;
	
	public static Circle GPull;
	public static Circle GPull2;
	public static Circle GPull3;
	
	public CollisionDetection(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g)	throws SlickException {

		g.setColor(new Color(255,255,255,0f));
		g.fill(planetCollider); // fills planetCollider with above defined white colour and transparency
		g.fill(planet2Collider);
		g.fill(planet3Collider);
		
		g.setColor(new Color(255,255,255,0f));
		g.fill(shipCollider);
		
		g.setColor(new Color(95,150,100,255));
		g.fill(platformCollider);
		g.fill(platform2Collider);
		g.fill(platform3Collider);
		

		g.setColor(new Color(255,0,255,0f));
		g.fill(GPull);
		g.setColor(new Color(255,0,255,0f));
		g.fill(GPull2);
		g.setColor(new Color(255,0,255,0f));
		g.fill(GPull3);
		
		
		/*

		g.resetTransform();
		g.setColor(Color.black);
		g.drawString("Collides with planet: "+collidesWithPlanet, 10, 40); //for debugging collision
		g.drawString("Collides with planet2: "+collidesWithPlanet2, 10, 60);
		g.drawString("Collides with planet3: "+collidesWithPlanet3, 10, 80);
		g.drawString("Collides with platform: "+collidesWithPlatform, 10, 100);
		g.drawString("Collides with platform2: "+collidesWithPlatform2, 10, 120);
		g.drawString("Collides with platform3: "+collidesWithPlatform3, 10, 140);
		
		*/
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		planetCollider = new Circle(0,0,planet.planetimage.getWidth()/2);
		planet2Collider = new Circle(0,0,planet.planetimage.getWidth()/2);
		planet3Collider = new Circle(0,0,planet.planetimage.getWidth()/2);
		
		
		shipCollider = new Circle(0,0,Lander.player.player.getWidth()/2,20); //needs to get values from player png size this way
		
		platformCollider = new Rectangle(0,0, landerGame.Platform.platform.getWidth(), landerGame.Platform.platform.getHeight());
		platform2Collider = new Rectangle(0,0, landerGame.Platform.platform.getWidth(), landerGame.Platform.platform.getHeight());
		platform3Collider = new Rectangle(0,0, landerGame.Platform.platform.getWidth(), landerGame.Platform.platform.getHeight());
		
	
		GPull = new Circle (Lander.testplanet.position.x +(planet.planetimage.getWidth()/2),Lander.testplanet.position.y +(planet.planetimage.getWidth()/2),planet.planetimage.getWidth());
		GPull2 = new Circle (Lander.testplanet2.position.x +(planet.planetimage.getWidth()/2),Lander.testplanet2.position.y +(planet.planetimage.getWidth()/2),planet.planetimage.getWidth());
		GPull3 = new Circle (Lander.testplanet3.position.x +(planet.planetimage.getWidth()/2),Lander.testplanet3.position.y +(planet.planetimage.getWidth()/2),planet.planetimage.getWidth());
	}	


	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		///shipCollider.setLocation(container.getInput().getMouseX(), container.getInput().getMouseY());//shipSquare follows mouse
		shipCollider.setLocation(Lander.player.x + Lander.VIEWPORT_SIZE_X / 2, Lander.player.y
				+ Lander.VIEWPORT_SIZE_Y / 2); //divides by viewport size because player is placed in game center
		planetCollider.setLocation(Lander.testplanet.position.x, Lander.testplanet.position.y);
		planet2Collider.setLocation(Lander.testplanet2.position.x, Lander.testplanet2.position.y);
		planet3Collider.setLocation(Lander.testplanet3.position.x, Lander.testplanet3.position.y);
		platformCollider.setLocation(Lander.platform.position.x,Lander.platform.position.y);
		platform2Collider.setLocation(Lander.platform2.position.x,Lander.platform2.position.y);
		platform3Collider.setLocation(Lander.platform3.position.x,Lander.platform3.position.y);
		
		collidesWithPlatform = shipCollider.intersects(platformCollider);
		collidesWithPlatform2 = shipCollider.intersects(platform2Collider); 
		collidesWithPlatform3 = shipCollider.intersects(platform3Collider); 
		collidesWithPlanet = shipCollider.intersects(planetCollider); //checks if ship collision box collides with planet collision box
		collidesWithPlanet2 = shipCollider.intersects(planet2Collider);
		collidesWithPlanet3 = shipCollider.intersects(planet3Collider);
		
		GravitationalEffect = shipCollider.intersects(GPull);
		GravitationalEffect2 = shipCollider.intersects(GPull2);
		GravitationalEffect3 = shipCollider.intersects(GPull3);
		
		//System.out.println(GravitationalEffect);
		
		
	}
	
	
	
	
	
}
