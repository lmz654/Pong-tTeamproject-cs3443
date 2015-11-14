package test;

import game.core.Ball;
import game.math.CollidableCircle;
import game.math.structures.CollidableQTree;
import game.math.structures.Vector;

public class QuadTreeTest {

	public static void main(String[] args) {

		CollidableQTree qT = new CollidableQTree(0, 0, 100, 0, 100);
		
		System.out.println("Tree Bounds(Before insertion): \n" + qT.printBounds());
		
		for (int i = 0; i < 15; i++) {
			qT.insert(new CollidableCircle(new Ball(Vector.getRand(new int[] { 80, 10 }, new int[] { 80, 10 }),
					Vector.getRand(0, 0), 5)));
		}
		
		CollidableCircle cTest = new CollidableCircle(new Ball(Vector.getRand(new int[] { 80, 10 }, new int[] { 80, 10 }),
				Vector.getRand(0, 0), 5));
		
		System.out.println("Tree Bounds(After insertion): \n" + qT.printBounds());
		System.out.println(qT.printTree());
		

	}

}
