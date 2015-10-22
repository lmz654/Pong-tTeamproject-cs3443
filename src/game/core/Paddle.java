package game.core;

import game.math.Vector;

public class Paddle {
	
	// Paddle Mechanics
	private Vector position;
	private Vector velocity;
	private int length;
	
	public Paddle(Vector position, Vector velocity, int length) {
		this.position = position;
		this.velocity = velocity;
		this.length = length;
	}
	
	public Paddle(int dimension, int length) {
		this.position = new Vector(dimension);
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(Vector position) {
		this.position = position;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
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
		position = position.plus(velocity);
	}

	private void moveYAxis() {
		position = position.plus(velocity);		
	}
}
