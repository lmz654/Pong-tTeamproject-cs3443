package test.collision;

import java.util.ArrayList;

import game.core.Ball;
import game.math.Vector;

public class CollisionModel {
	private ArrayList<Ball> balls;
	
	// Panel Properties
	private int width, height;
	
	//private ArrayList<Collision> collisions;
	
	public CollisionModel() {
		// Environment Setup
		width = 0;
		height = 0;
		
		//collisions = new ArrayList<Collision>();
		
		
		for (int i = 0; i < 5; i++) {
			balls.add(new Ball(Vector.getRand(width, height), new Vector(2, 2), 2));
		}
	}

	public void moveBalls() {
		for (Ball b : balls) {
			// Check boundries
			// Checking X
			if (b.getPosition().cartesian(0) > width - b.getRadius() ||
				b.getPosition().cartesian(1) < b.getRadius()) {
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), 
											b.getVelocity().cartesian(1)));
				
			}
			// Checking Y
			if (b.getPosition().cartesian(0) > height - b.getRadius() ||
				b.getPosition().cartesian(1) < b.getRadius()) {
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
			}
			
		}
		
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

}
