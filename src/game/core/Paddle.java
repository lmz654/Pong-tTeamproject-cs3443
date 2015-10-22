package game.core;

import game.math.Vector;

public class Paddle {
	
	// Paddle Mechanics
	private Vector position;
	private int length;
	
	public Paddle(Vector position, int length) {
		this.position = position;
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
	
	public void move(char axis, int amount) throws Exception{
		switch(axis) {
		case 'x':
		case 'X':
			moveXAxis(amount);
			break;
		case 'y':
		case 'Y':
			moveYAxis(amount);
			break;
		default:
			throw new Exception("Invalid Motion Axis!");
		}
	}

	private void moveXAxis(int amount) {
		double[] movement = new double[position.length()];
		movement[0] = amount;
		Vector nextPos = new Vector(movement);
		
		position = position.plus(nextPos);
	}

	private void moveYAxis(int amount) {
		double[] movement = new double[position.length()];
		movement[1] = amount;
		Vector nextPos = new Vector(movement);
		
		position = position.plus(nextPos);		
	}
}
