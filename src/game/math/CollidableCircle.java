package game.math;

import java.util.ArrayList;

import game.core.Ball;

public class CollidableCircle extends Collidable {
	private int radius;

	public CollidableCircle(Object object) {
		super(object);
		// TODO Auto-generated constructor stub
		if (object instanceof Ball) {
			this.radius = ((Ball)object).getRadius();
			super.position = ((Ball)object).getPosition();
		}
	}
	
	public int getRadius() {
		return radius;
	}

	@Override
	public ArrayList<Bound> getBounds() {
		ArrayList<Bound> bounds = new ArrayList<Bound>();
		int upper, lower, center;
		
		if (obj instanceof Ball) {
			for (int i = 0; i < position.length(); i++) {
				center = (int) position.cartesian(i);
				upper = center + radius;
				lower = center - radius;
				bounds.add(new Bound(upper, lower));
			}
		}
		
		return bounds;
	}

}
