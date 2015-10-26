package game.math;

import java.util.ArrayList;

import MVC.vbhitModel;
import game.core.Ball;
import test.collision.CollisionModel;

public class CollisionDetector {
	
	public static void checkCollisions(vbhitModel model) {
		
	}
	
	public static void checkCollisions(CollisionModel model) {
		ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
		
		// Load Collision Detector with Collidable Units from the Model
		for (Ball ball : model.getBalls()) {
			collidableUnits.add(new CollidableCircle(ball));
		}
		
		// TODO Test for Collisions
		
	}

}
