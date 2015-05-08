package landerGame;

//import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class planet {

	public float gx;
	public float gy;
	
	int gravity;
	
	int fuelamount;
	
	static Image planetimage;
	
	
	//This is the position of the planets that they will be spawned at
	Vector2f position;
	
	
	//this is the planet class being created. The planet class contains some amount of gravity , that attracts the player to the planet
	public planet(int size,float xlocation, float ylocation){
		
		position = new Vector2f(xlocation, ylocation);
		
		if(size == 1){
			gravity = 100;        
			
			try {
				planetimage = new Image("tempsmallplanet.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(size == 2){
			gravity = 200;
			
		}
		if(size == 3){
			gravity = 200;
			
			
		}
	}
	//here the image for the planet will be drawn on the screen in the said position
		public void render(GameContainer arg0, Graphics arg1) throws SlickException {

			

			arg1.drawImage(planetimage,position.x,position.y);
			
			
			
			
	}
		
		/*public int width() {
			// TODO Auto-generated method stub
			return 0;
		}
		public int height() {
			// TODO Auto-generated method stub
			return 0;
		}*/
		//the force that attracts the player towards it
		public void update(GameContainer arg0, int delta) {
			gx = ((position.x-300) - Lander.player.x)/400;
			gy = ((position.y-50) - Lander.player.y)/400;
		}
	
		
		
		
		
		
	
		public void init(GameContainer arg0) throws SlickException {
			
			
			
		}
		
	
	
}
