package game.math;

import java.util.ArrayList;
import MVC.vbhitModel;
import game.core.Ball;
import game.math.structures.CollidableQTree;
import game.math.structures.CollisionList;
import test.collision.CollisionModel;

public class CollisionDetector {
	
	// Print Collisions
	public static final boolean PRT_COLLISIONS = true;
	
	// Boolean to use Quad Tree for Collision Detection
	public static final boolean Q_TREE = false;
	
	// Boolean to Run Collision Mechanics in Parallel
	public static final boolean PARALLEL = false;
	
	public static void checkCollisions(vbhitModel model) {
		
		ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
		
		for (Ball ball: model.getBall()) {
			collidableUnits.add(new CollidableCircle(ball));
		}
		
		checkCollisions(collidableUnits);
		
	}
	
	public static void checkCollisions(CollisionModel model) {
		
		if (Q_TREE) { // Collision Detection using Quad Trees for Geometric Binning
			int depth = 2;
			CollidableQTree collidableUnits = new CollidableQTree(0, 0, model.getWidth(), 0, model.getHeight());
			
			// Load Collision Detector with Collidable Units from the Model
			for (Ball ball : model.getBalls()) {
				collidableUnits.insert(new CollidableCircle(ball));
			}
			
			adjustTrajectories(checkQTreeCollisions(collidableUnits));
			
		} else {
			ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
			
			// Load Collision Detector with Collidable Units from the Model
			for (Ball ball : model.getBalls()) {
				collidableUnits.add(new CollidableCircle(ball));
			}
			
			adjustTrajectories(checkCollisions(collidableUnits));
		}		
	}
	
	private static CollisionList checkQTreeCollisions(CollidableQTree cUnits) {
		CollisionList collisions = new CollisionList();
		
		/*
		 *  New Algorithm
		 *  Using QuadTrees for binning to reduce number of checks needed
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
						if (PRT_COLLISIONS) System.out.println("Collision @" + c.getCollisionPoint().toString());
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
