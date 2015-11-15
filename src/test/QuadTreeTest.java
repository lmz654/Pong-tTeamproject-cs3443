package test;

import java.util.Date;
import java.util.List;

import game.core.Ball;
import game.math.Collidable;
import game.math.CollidableCircle;
import game.math.structures.CollidableQTree;
import game.math.structures.Vector;

public class QuadTreeTest {

	public static void main(String[] args) {
		long start, end, popTime, retrTime, collisionCheckTime;
		int numBalls = 50000;
		
		CollidableQTree qT = new CollidableQTree(0, 0, 100, 0, 100);
		
		//System.out.println("Tree Bounds(Before insertion): \n" + qT.printBounds());
		start = new Date().getTime();
		for (int i = 0; i < numBalls; i++) {
			qT.insert(new CollidableCircle(new Ball(Vector.getRand(new int[] { 80, 10 }, new int[] { 80, 10 }),
					Vector.getRand(0, 0), 5)));
		}
		end = new Date().getTime();
		
		popTime = end-start;
		
		CollidableCircle cTest = new CollidableCircle(new Ball(Vector.getRand(new int[] { 80, 10 }, new int[] { 80, 10 }),
				Vector.getRand(0, 0), 5));
		
		//System.out.println("Tree Bounds(After insertion): \n" + qT.printBounds());
		//System.out.println(qT.printTree());
		
		qT.insert(cTest);
		
		start = new Date().getTime();
		List<Collidable> possibleCollisions = qT.retrieve(cTest);
		end = new Date().getTime();
		
		retrTime = end-start;
		
		int collisions = 0;
		start = new Date().getTime();
		for (int i = 0; i < possibleCollisions.size(); i++) {
			if (cTest.intersects(possibleCollisions.get(i)) != null)
				collisions++;
		}
		end = new Date().getTime();
		
		collisionCheckTime = end - start;
		
		double checkRate = 1.0/(collisionCheckTime/1000.0);
		
		System.out.println("Time to populate qTree with "+ numBalls +" balls: " + popTime);
		System.out.println("Time to retreive " + possibleCollisions.size() + " possible collisions with test ball: " + retrTime);
		System.out.println("Time to check " + collisions + " Collisions from " + possibleCollisions.size() + " possible Collisions: " + collisionCheckTime);
		System.out.println("Possible Collision Checks per Second: " + checkRate);

	}

}
