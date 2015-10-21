package game.core;

import java.awt.Point;

public abstract class Item {
	private Point point;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}	
}
