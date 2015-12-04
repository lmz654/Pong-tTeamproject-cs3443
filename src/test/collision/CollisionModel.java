package test.collision;

import java.util.ArrayList;
import java.util.Date;

import game.Controls;
import game.components.item.Item;
import game.components.obstacles.Obstacle;
import game.core.*;
import game.math.*;
import game.math.structures.Vector;

public class CollisionModel {
	private ArrayList<Ball> balls;
	private ArrayList<Paddle> paddles;
	private ArrayList<Item> items;
	private ArrayList<Obstacle> obstacles;
	
	//Information Markers
	public boolean showVelocityVectors = false;
	public boolean showPositionVectors = false;
	public boolean showProjections = false;
	public boolean showMoreInfo = false;
	
	// Simulation Properties
	public int numBalls = Controls.SIM_NUM_BALLS; // 1500 Still ran, seems like good upper limit. 2000 Lagged.
	public int radius = Controls.SIM_BALL_DEFAULT_RADIUS;
	public int tolerance = 20;
	public int redux = 2*(radius+tolerance);
	public int ofst = radius + tolerance;
	
	// Simulation Times
	public long collisionTime = 0;
	public long modelTime = 0;
	public long repaintTime = 0;
	
	// Panel Properties
	private int width, height;
	
	//private ArrayList<Collision> collisions;
	
	public CollisionModel() {
		// Environment Setup
		width = 0;
		height = 0;
		
		//collisions = new ArrayList<Collision>();
		balls = new ArrayList<Ball>();
		paddles = new ArrayList<Paddle>();
		
		for (int i = 0; i < numBalls; i++) {
			balls.add(new Ball(Vector.getRand(new int[]{1000-redux, ofst}, new int[]{750-redux, ofst}), Vector.getRand(new int[]{20, -10}, new int[]{20, -10}), radius));
		}
		
		paddles.add(new Paddle(new Vector(10, 800/2), 5, 100));
		
		//balls.add(new Ball(new Vector(200, 395), new Vector(5, 0), radius));
		//balls.add(new Ball(new Vector(600, 400), new Vector(-5, 0), radius));
		
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
		
		//Collision collision;
		
		for (Ball b : balls) {
			b.move();
			
			posX = (int)b.getPosition().cartesian(0);
			posY = (int)b.getPosition().cartesian(1);
			radius = b.getRadius();
			
			// Check boundries
			// Checking X
			if (posX > (width - radius) || posX < radius) {
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			// Checking Y
			if (posY > (height - radius) || posY < radius) {
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			
			
//			for (Ball c : balls) {
//				if (b.equals(c)) continue;
//				if (b.intersects(c)) {
//					collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//					System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//				}
//			}
			
			
		}
		
		
		/*
		 * Checking for Collisions
		 */
		long start = new Date().getTime();
		CollisionDetector.checkCollisions(this);
		collisionTime = new Date().getTime() - start;
		
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}
	
	public ArrayList<Paddle> getPaddles() {
		return paddles;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

}
