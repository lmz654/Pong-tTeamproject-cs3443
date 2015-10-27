package game.core;

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
	
	// Setters and Getters
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
	public void move(){
		position = position.plus(velocity);
	}
	
	public boolean intersects(Ball ball) {
		return position.distanceTo(ball.getPosition()) < (radius + ball.getRadius());
	}
	
	// Information Methods
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");		
		s.append("Position: " + position.toString());
		s.append(" Speed: " + velocity.magnitude());
		s.append(" Direction Vector: " + velocity.unit().toString());
		s.append(" Velocity Vector: " + velocity.toString());
		s.append("}");
		return s.toString();
	}
	
	
}
