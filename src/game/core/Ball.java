package game.core;

import java.awt.Point;

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
	public Point getPositionp() {
		Point point=new Point();
		point.x= (int) position.cartesian(0);
		point.y=(int) position.cartesian(1);
		return point;
	}
	public Vector getPosition(){
		return position;
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
		return ((double)position.distanceTo(ball.getPosition()) < (double)(radius + ball.getRadius()));
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
