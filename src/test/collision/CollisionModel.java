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
		balls = new ArrayList<Ball>();
		balls.add(new Ball(new Vector(500.0,400.0), new Vector(2.0, 2.0), 5));
		
		System.out.println("Pos: " + balls.get(0).getPosition().toString() + " V: " + balls.get(0).getVelocity().toString());
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void moveBalls() {
		if (height == 0) return;
		int posX, posY, radius;
		
		for (Ball b : balls) {
			b.move();
			
			posX = (int)b.getPosition().cartesian(0);
			posY = (int)b.getPosition().cartesian(1);
			radius = b.getRadius();
			
			// Check boundries
			// Checking X
			if (posX > width - radius || posX < radius) {
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
				System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			// Checking Y
			if (posY > height - radius || posY < radius) {
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
				System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			
			//System.out.println(b.toString());
			
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
