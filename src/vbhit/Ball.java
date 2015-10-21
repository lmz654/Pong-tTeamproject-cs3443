package vbhit;

import game.math.Vector;

public class Ball {
	// --- Ball Mechanics ---
	private Vector position;
	private Vector velocity;
	private final int radius;
	
	// --- Game Metrics ---
	private Player lastHit;
	
	// Constructor
	public Ball(Vector position, Vector velocity, int radius) {
		this.position = position;
		this.velocity = velocity;
		this.radius = radius;
	}
	
	public Vector getPosition() {
		return this.position;
	}
	
	public Vector getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public Player getLastHit() {
		return this.lastHit;
	}
	
	public void setLastHit(Player player) {
		this.lastHit = player;
	}
}
