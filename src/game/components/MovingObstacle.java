package game.components;

import game.math.Vector;

public class MovingObstacle extends Obstacle {
	
	private Vector velocity;
	
	public MovingObstacle(Vector position, Vector velocity, char effect) {
		super(position, effect);
		this.velocity = velocity;
	}
	
	public Vector getVelocity() {
		return this.velocity;
	}

}
