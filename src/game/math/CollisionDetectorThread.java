package game.math;

import java.util.List;

import game.math.structures.CollisionList;

public class CollisionDetectorThread implements Runnable{
	private Collidable c;
	private List<Collidable> possibleCollisions;
	private CollisionList collisions;
	
	public CollisionDetectorThread(Collidable c, List<Collidable> possibleCollisions, CollisionList collisions) {
		this.c = c;
		this.possibleCollisions = possibleCollisions;
		this.collisions = collisions;
	}
	
	public void run() {
		for (Collidable b: possibleCollisions) {
			Collision collision = c.intersects(b);
			if (collision != null && collisions != null)
				collisions.add(collision);
		}
	}
	
}
