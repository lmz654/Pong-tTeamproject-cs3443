package game.core.paddle;

import game.math.Vector;

public abstract class Paddle {
	
	// Paddle Mechanics
	private Vector position;
	private double velocity;
	private int length;
	private int height;
	
	
	public Paddle(Vector position, int length, int height) {
		this.position = position;
		this.velocity = 3.0;
		this.length = length;
		this.setHeight(height);
	}
	
	public Paddle(int dimension, int length) {
		this.position = new Vector(dimension);
		this.velocity = 3;
		this.length = length;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(Vector position) {
		this.position = position;
	}
	public abstract void slideup();
	public abstract void slidedown();

	public void move(char axis) throws Exception{
		switch(axis) {
		case 'x':
		case 'X':
			moveXAxis();
			break;
		case 'y':
		case 'Y':
			moveYAxis();
			break;
		default:
			throw new Exception("Invalid Motion Axis!");
		}
	}

	private void moveXAxis() {
		position = position.plus(new Vector(velocity, 0.0));
	}

	private void moveYAxis() {
		position = position.plus(new Vector(0.0, velocity));		
	}

}
