package game.math;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import MVC.vbhitModel;
import game.Controls;
import game.core.Ball;
import game.core.Paddle;
import game.math.structures.CollidableQTree;
import test.collision.CollisionModel;

public class CollisionDetector {
	
	// Print Collisions
	public static boolean PRT_COLLISIONS = false;
	
	// Boolean to use Quad Tree for Collision Detection
	public static boolean Q_TREE = true;
	
	// Boolean to Run Collision Mechanics in Parallel
	public static boolean PARALLEL = false;
	
	public static boolean ADJUST_TRAJECTORIES = false;
	
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
		
		for (Paddle p: model.getPaddles()) {
			cUnits.add(new CollidableRect(p));
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
					task = new CollisionDetectorThread(c, posCollisions, ADJUST_TRAJECTORIES);
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
					Collision collision = a.next().intersects(b.next());
					if (collision != null && ADJUST_TRAJECTORIES) {
						collision.adjustTrajectories();
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
						if (ADJUST_TRAJECTORIES) c.adjustTrajectories();
					}
				}					
			}
			
		}
		
	}
	
	public static void optimizer(List<Collidable> collidableUnits, int state, int height, int width) {
		/*
		 * States
		 * 0 - N2 Algorithm Non-Threaded
		 * 1 - N2 Algorithm Threaded
		 * 2 - QTree Algorithm Non-Threaded
		 * 3 - QTree Algorithm Threaded
		 */
		
		switch (state) {
		case 0: // N2 Non-Threaded
			checkCollisionsOpt(collidableUnits, false, false, height, width);
			break;
		case 1: // N2 Threaded
			checkCollisionsOpt(collidableUnits, false, true, height, width);
			break;
		case 2: // QTree Non-Threaded
			checkCollisionsOpt(collidableUnits, true, false, height, width);
			break;
		case 3: // QTree Threaded
			checkCollisionsOpt(collidableUnits, true, true, height, width);
			break;
		default: // Wrong State
			break;
		}
	}

	private static void checkCollisionsOpt(List<Collidable> collidableUnits, boolean qTree, boolean threaded, int height, int width) {
		if (qTree) {
			CollidableQTree qT = new CollidableQTree(0, 0, width, 0, height);
			for (Collidable c : collidableUnits)
				qT.insert(c);
			
			if (threaded) {
				ExecutorService threadPool = Executors.newCachedThreadPool();
				Runnable task;
				for (Collidable c: collidableUnits) {
					List<Collidable> posCollisions = qT.retrieve(c);
					if (!posCollisions.isEmpty()) {
						task = new CollisionDetectorThread(c, posCollisions, false);
						threadPool.execute(task);
					}
				}
				threadPool.shutdown();
				while(!threadPool.isTerminated()) {
					
				}
				
			} else {
				for (Collidable a: collidableUnits) {
					List<Collidable> pCollisions = qT.retrieve(a);
					for (Collidable b: pCollisions) {
						if (pCollisions.isEmpty() || a.equals(b)) continue;
						Collision collision = a.intersects(b);
						if (collision != null)
							continue;
					}
				}
			} // End of QTree Non-Threaded
		} else {
			if (threaded) {
				ExecutorService threadPool = Executors.newCachedThreadPool();
				Runnable task;
				for (Collidable c: collidableUnits) {
						task = new CollisionDetectorThread(c, collidableUnits, false);
						threadPool.execute(task);
				}
				threadPool.shutdown();
				while(!threadPool.isTerminated()) {
					
				}
				
			} else {
				Collision c;
				
				for (Collidable cUnitA : collidableUnits) {
					for (Collidable cUnitB : collidableUnits) {
						if (cUnitA.equals(cUnitB)) continue;
						// else
						else {
							c = cUnitA.intersects(cUnitB);
							if (c != null) {
								if (PRT_COLLISIONS) System.out.println("Collision @" + c.getCollisionPoint().toString());
								if (ADJUST_TRAJECTORIES) c.adjustTrajectories();
							}
						}					
					}					
				}
			} // End of N2 Non-Threaded
		}
		
		// End of Method
	}

}
