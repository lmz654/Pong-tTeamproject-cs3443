package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Item {
	private Point point;
	private BufferedImage image;

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
}
