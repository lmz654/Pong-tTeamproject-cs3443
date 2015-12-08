package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;

import game.Controls;
import game.core.Ball;
import game.math.structures.Vector;

public abstract class Obstacle {
	
	private Point position;
	private BufferedImage image;
	private long durationtime;
	
	public Obstacle(Point position, BufferedImage image,int timer) {
		this.position = position;
		this.image = image;
		this.durationtime=Controls.WHACKY_OBSATCLE_DURABLE_TIME;
	}
	
	public boolean isLast(){
		this.durationtime-=Controls.MODEL_TIME;
		if(this.durationtime>0){
			return true;
		}else{
			return false;
		}
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
