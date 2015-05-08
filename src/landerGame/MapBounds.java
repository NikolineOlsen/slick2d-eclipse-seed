package landerGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class MapBounds {

	public MapBounds() {
		// TODO Auto-generated constructor stub
	}
	public void update(GameContainer arg0, int delta) throws SlickException {
		// below code will prevent player going over screen edges
		//4 is statements for each of the 4 sides of the map
				System.out.println("Player x pos: " + Lander.player.x );
				System.out.println("Player y pos: "+ Lander.player.y);
				if (Lander.player.y < -1400) {
					Lander.player.y += 200;
					Lander.player.accely = 0;
					System.out.println("player out of bounds");
				} else if (Lander.player.y > 1000) {
					Lander.player.y -= 200;
					Lander.player.accely = 0;
					System.out.println("player out of bounds");
				}else if (Lander.player.x > 1700) {
					Lander.player.x -= 200;
					Lander.player.accelx = 0;
					System.out.println("player out of bounds");
				}else if (Lander.player.x < -1700) {
					Lander.player.x += 200;
					Lander.player.accelx = 0;
					System.out.println("player out of bounds");
				}
	}
}
