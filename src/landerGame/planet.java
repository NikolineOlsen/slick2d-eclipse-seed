package landerGame;

//import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class planet {

	
	
	int gravity;
	
	int fuelamount;
	
	static Image planetimage;
	
	Vector2f position;
	
	public planet(int size,int xlocation, int ylocation){
		
		position = new Vector2f(xlocation, ylocation);
		
		if(size == 1){
			gravity = 100;        //<--- numbers for gravity and fuel are temporary. they will likely be changed once we implement fuel and gravity
			fuelamount = 100;
			try {
				planetimage = new Image("landerGame/resources/tempsmallplanet.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(size == 2){
			gravity = 200;
			fuelamount = 300;
		}
		if(size == 3){
			gravity = 200;
			fuelamount = 300;
			
		}
	}
		public void render(GameContainer arg0, Graphics arg1) throws SlickException {
			arg1.drawImage(planetimage,position.x,position.y);
	}
		public int width() {
			// TODO Auto-generated method stub
			return 0;
		}
		public int height() {
			// TODO Auto-generated method stub
			return 0;
		}
	
	
	
	
	
}
