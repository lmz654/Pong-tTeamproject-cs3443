package game.math;

import java.util.List;

import game.math.structures.CollisionList;

public class CollisionDetectorThread implements Runnable{
	private Collidable c;
	private List<Collidable> possibleCollisions;
	private boolean adjTraj;
	
	public CollisionDetectorThread(Collidable c, List<Collidable> possibleCollisions, boolean adjTraj) {
		this.c = c;
		this.possibleCollisions = possibleCollisions;
		this.adjTraj = adjTraj;
	}
	
	public void run() {
		for (Collidable b: possibleCollisions) {
			Collision collision = c.intersects(b);
			if (collision != null && adjTraj)
				collision.adjustTrajectories();
			else
				continue;
		}
	}
	
}
