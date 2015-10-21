package game.core;

import game.math.Vector;

public class Paddle {
	
	// Paddle Mechanics
	private Vector position;
	private Vector velocity;
	private int length;
	
	public Paddle(Vector position, int length) {
		this.position = position;
		this.velocity = new Vector(position.length());
		this.length = length;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
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
	
	
	
}
