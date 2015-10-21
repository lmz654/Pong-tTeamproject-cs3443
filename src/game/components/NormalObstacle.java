package game.components;

import game.math.Vector;

public class NormalObstacle extends Obstacle {
	
	//private Shape/Image
	private int height, width;
	public static final double PROBABILITY = .4;

	public NormalObstacle(Vector postition, char effect, int height, int width) {
		super(postition, effect);
		// TODO Auto-generated constructor stub
		this.height = height;
		this.width = width;
	}

}
