package game.components.obstacles;

import game.math.Vector;

public abstract class Obstacle {
	
	private Vector position;
	private final char effect;
	
	public Obstacle(Vector position, char effect) {
		this.position = position;
		this.effect = effect;
	}
	
	public Vector getPosition() {
		return this.position;
	}
	
	public char getEffect() {
		return this.effect;
	}

}
