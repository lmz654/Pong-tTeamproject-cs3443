package test;

import game.core.Ball;
import game.math.Bound;
import game.math.Collidable;
import game.math.CollidableCircle;
import game.math.CollidableQTree;
import game.math.QuadTree;
import game.math.Vector;

public class QuadTreeTest {

	public static void main(String[] args) {
		Bound x = new Bound(0, 100);
		Bound y = new Bound(0, 100);
		
		QuadTree<Collidable> qT1 = new CollidableQTree(0, x, y);
		
		for (int i = 0; i < 10; i++) {
			Ball b = new Ball(Vector.getRand(50,50), Vector.getRand(10,10), 5);
			qT1.insert(new CollidableCircle(b));
		}
		
		System.out.println(qT1.toString());

	}

}
