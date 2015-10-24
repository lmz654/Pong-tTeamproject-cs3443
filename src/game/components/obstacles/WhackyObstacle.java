package game.components.obstacles;

import game.Controls;
import game.math.Vector;

public class WhackyObstacle extends Obstacle {

	//private Shape/Image
	private int height, width;
	private Vector reflection;
	
	public static final double PROBABILITY = Controls.WHACKYOBSTACLE_PROBABILITY;
	
	public WhackyObstacle(Vector position, char effect, int height, int width) {
		super(position, effect);
		this.height = height;
		this.width = width;
		
		this.reflection = this.getRandomReflection();
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public Vector getReflection() {
		return this.reflection;
	}
	
	private Vector getRandomReflection() {
		return Vector.getRand(new int[]{10, -5}, new int[]{10, -5});
	}

	
}
