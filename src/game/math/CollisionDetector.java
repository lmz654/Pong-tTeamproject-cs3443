package game.math;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

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
		
		Collections.sort(collidableUnits, Collidable.magnitudeComparator);
		
		adjustTrajectories(checkCollisions(collidableUnits));
	}
	
	private static CollisionList checkCollisions(ArrayList<Collidable> cUnits) {
		CollisionList collisions = new CollisionList();
		
		Collision c;
		/* Finding Collisions
		 *  TODO Figure out a more efficient Algorithm
		 */
		/*
		 *  Old Algorithm
		 * for (Collidable cUnitA : cUnits) {
			for (Collidable cUnitB : cUnits) {
				if (cUnitA.equals(cUnitB)) continue;
				// else
				else {
					c = cUnitA.intersects(cUnitB);
					if (c != null && !collisions.contains(c)) {
						collisions.add(c);
						//System.out.println("Collision @" + c.getCollisionPoint().toString());
					}
				}					
			}
			System.out.println(collisions + "\n");
		}*/
		
		/*
		 *  New Algorithm
		 */
		for (int i = 0; i < cUnits.size()-1; i++) {
			c = cUnits.get(i).intersects(cUnits.get(i+1)); 
		}
		
		
		return collisions;
	}
	
	private static void adjustTrajectories(CollisionList collisions) {
		for (Collision collision: collisions) {
			collision.adjustTrajectories();
		}
	}

}
