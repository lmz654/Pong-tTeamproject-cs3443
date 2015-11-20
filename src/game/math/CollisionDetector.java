package game.math;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import MVC.vbhitModel;
import game.Controls;
import game.core.Ball;
import game.math.structures.CollidableQTree;
import game.math.structures.CollisionList;
import test.collision.CollisionModel;

public class CollisionDetector {
	
	// Print Collisions
	public static final boolean PRT_COLLISIONS = true;
	
	// Boolean to use Quad Tree for Collision Detection
	public static final boolean Q_TREE = true;
	
	// Boolean to Run Collision Mechanics in Parallel
	public static final boolean PARALLEL = true;
	
	public static void checkCollisions(vbhitModel model) {
		
		ArrayList<Collidable> collidableUnits = new ArrayList<Collidable>();
		
		for (Ball ball: model.getBall()) {
			collidableUnits.add(new CollidableCircle(ball));
		}
		
		checkCollisions(collidableUnits, Controls.MODEL_WIDTH, Controls.MODEL_HEIGHT);
		
	}

	public static void checkCollisions(CollisionModel model) {
		List<Collidable> cUnits = new ArrayList<Collidable>();
		
		for (Ball b: model.getBalls()) {
			cUnits.add(new CollidableCircle(b));
		}
		
		checkCollisions(cUnits, model.getWidth(), model.getHeight());
		
	}
	
	private static void checkCollisions(List<Collidable> collidableUnits, int width, int height) {
		if (Q_TREE) {
			CollidableQTree qT = new CollidableQTree(0, 0, width, 0, height);
			for (Collidable c: collidableUnits)
				qT.insert(c);
			checkQTreeCollisions(qT, collidableUnits);			
		} else {
			checkCollisionsN2(collidableUnits);
		}
		
	}
	
	private static void checkQTreeCollisions(CollidableQTree qT, List<Collidable> cUnits) {		
		if (PARALLEL) {
			ExecutorService threadPool = Executors.newCachedThreadPool();
			Runnable task;
			for (Collidable c: cUnits) {
				List<Collidable> posCollisions = qT.retrieve(c);
				if (!posCollisions.isEmpty()) {
					task = new CollisionDetectorThread(c, posCollisions, null);
					threadPool.execute(task);
				}
			}
			threadPool.shutdown();
			while(!threadPool.isTerminated()) {
				
			}
			
		} else {
			for (Collidable a: cUnits) {
				List<Collidable> pCollisions = qT.retrieve(a);
				for (Collidable b: pCollisions) {
					if (pCollisions.isEmpty() || a.equals(b)) continue;
					Collision collision = a.intersects(b);
					if (collision != null) {
						//collision.adjustTrajectories();
						//collisions.add(collision);
						//System.out.println(collision);
					}
				}
			}
		}
		//System.out.println(qT.printTree());
	}
	
	private static void checkCollisionsN2(List<Collidable> collidableUnits) {
		Collision c;
		/* Finding Collisions
		 * 
		 */
	
		for (Collidable cUnitA : collidableUnits) {
			for (Collidable cUnitB : collidableUnits) {
				if (cUnitA.equals(cUnitB)) continue;
				// else
				else {
					c = cUnitA.intersects(cUnitB);
					if (c != null) {
						if (PRT_COLLISIONS) System.out.println("Collision @" + c.getCollisionPoint().toString());
					}
				}					
			}
			
		}
		
	}

	private static void adjustTrajectories(CollisionList collisions) {
		for (Collision collision: collisions) {
			collision.adjustTrajectories();
		}
	}

}
