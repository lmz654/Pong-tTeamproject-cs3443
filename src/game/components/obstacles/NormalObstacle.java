package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.Controls;
import game.core.Ball;
import game.math.structures.Vector;

public class NormalObstacle extends Obstacle {
	
	//private Shape/Image
	private int height, width;
	public static final double PROBABILITY = Controls.NORMALOBSTACLE_PROBABILITY;

	public NormalObstacle(Point postition,BufferedImage image,int timer ) {
		super(postition, image,timer);
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public void Effect(Ball b) {
		// TODO Auto-generated method stub
		
	}

	
}
