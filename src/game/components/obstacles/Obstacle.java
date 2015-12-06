package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.core.Ball;
import game.math.structures.Vector;

public abstract class Obstacle {
	
	private Point position;
	private BufferedImage image;
	private int timer;
	
	public Obstacle(Point position, BufferedImage image,int timer) {
		this.position = position;
		this.image = image;
		this.timer = timer;
	}
	
	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public abstract void Effect (Ball b);

}
