package game.components;

import game.math.Vector;

public abstract class Obstacle {
	
	private Vector position;
	private final char effect;
	
	public Obstacle(Vector postition, char effect) {
		this.position = position;
		this.effect = effect;
	}
	
	public char getEffect() {
		return this.effect;
	}
	

}
