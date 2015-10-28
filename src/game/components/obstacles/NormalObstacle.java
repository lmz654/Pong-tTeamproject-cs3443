package game.components.obstacles;

import game.Controls;
import game.math.Vector;

public class NormalObstacle extends Obstacle {
	
	//private Shape/Image
	private int height, width;
	public static final double PROBABILITY = Controls.NORMALOBSTACLE_PROBABILITY;

	public NormalObstacle(Vector postition, char effect, int height, int width) {
		super(postition, effect);
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	
}
