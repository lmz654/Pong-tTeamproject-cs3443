package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.core.Ball;
import game.math.structures.Vector;

public class MovingObstacle extends Obstacle {
	
	private Vector velocity;
	
	public MovingObstacle(Point position, BufferedImage image,int timer) {
		super(position, image,timer);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public Vector getVelocity() {
		return this.velocity;
	}





	@Override
	public void Effect(Ball b) {
		// TODO Auto-generated method stub
		
	}

}
