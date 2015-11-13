package game.math;

import java.util.ArrayList;
import java.util.Collections;

import MVC.vbhitModel;
import game.core.Ball;
import test.collision.CollisionModel;

public class CollisionDetector {
	
	public static void checkCollisions(vbhitModel model) {
		
		ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
		
		for (Ball ball: model.getBall()) {
			collidableUnits.add(new CollidableCircle(ball));
		}
		
		checkCollisions(collidableUnits);
		
	}
	
	public static void checkCollisions(CollisionModel model) {
		//ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
		int depth = 2;
		CollidableQTree collidableUnits = new CollidableQTree(model.getWidth(), model.getHeight(), depth);
		// Load Collision Detector with Collidable Units from the Model
		for (Ball ball : model.getBalls()) {
			collidableUnits.add(new CollidableCircle(ball));
		}
		
		//Collections.sort(collidableUnits, Collidable.magnitudeComparator);
		
		
		adjustTrajectories(checkCollisions(collidableUnits));
	}
	
	private static CollisionList checkCollisions(CollidableQTree cUnits) {
		CollisionList collisions = new CollisionList();
		
		/*
		 *  New Algorithm
		 */
		
		//ArrayList<QuadTree<Collidable>> bins = cUnits.getChildren();
		
		/*for (QuadTree<Collidable> leaf: bins) {
			if (leaf.getContents().size() < 2) continue;
			else {
				collisions.addAll(checkCollisions(leaf.getContents()));
			}
		}*/
		
		System.out.println(cUnits + "\n----------------------------------------------------------");
		
		return collisions;
	}
	
	private static CollisionList checkCollisions(ArrayList<Collidable> cUnits) {
		CollisionList collisions = new CollisionList();
		
		Collision c;
		/* Finding Collisions
		 * 
		 */
	
		for (Collidable cUnitA : cUnits) {
			for (Collidable cUnitB : cUnits) {
				if (cUnitA.equals(cUnitB)) continue;
				// else
				else {
					c = cUnitA.intersects(cUnitB);
					if (c != null && !collisions.contains(c)) {
						collisions.add(c);
						System.out.println("Collision @" + c.getCollisionPoint().toString());
					}
				}					
			}
			//System.out.println(collisions + "\n");
		}
		
		return collisions;
		
	}

	private static void adjustTrajectories(CollisionList collisions) {
		for (Collision collision: collisions) {
			collision.adjustTrajectories();
		}
	}

}
