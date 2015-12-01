package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Item {
	private Point point;
	private BufferedImage image;
	
	public Item(Point point, BufferedImage image){
		this.point=point;
		this.image=image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}	
	
	abstract void effect();
	
}
