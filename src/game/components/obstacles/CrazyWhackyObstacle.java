package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.Controls;
import game.core.Ball;
import game.math.structures.Vector;

public class CrazyWhackyObstacle extends Obstacle {
	
	public CrazyWhackyObstacle(Point position, BufferedImage image,int timer){
		super(position, image,timer);
		
	}

	@Override
	public void Effect(Ball b) {
		b.setVelocity(Vector.getRand(Controls.BALL_MIN_SPEED, Controls.BALL_MAX_SPEED));
		
	}

}
