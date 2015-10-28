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
		
		adjustTrajectories(checkCollisions(collidableUnits));
	}
	
	private static CollisionList checkCollisions(ArrayList<Collidable> cUnits) {
		CollisionList collisions = new CollisionList();
		
		Collision c;
		/* Finding Collisions
		 *  TODO Figure out a more efficient Algorithm
		 */
		for (Collidable cUnitA : cUnits) {
			for (Collidable cUnitB : cUnits) {
				if (cUnitA.equals(cUnitB)) continue;
				else {
					c = cUnitA.intersects(cUnitB);
					if (c != null && !collisions.contains(c)) {
						collisions.add(c);
						//System.out.println("Collision @" + c.getCollisionPoint().toString());
					}
				}
					
			}
		}
		
		return collisions;
	}
	
	private static void adjustTrajectories(CollisionList collisions) {
		for (Collision collision: collisions) {
			collision.adjustTrajectories();
		}
	}

}
