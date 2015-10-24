package game.math;

import java.util.ArrayList;

import game.core.Ball;

public class CollidableCircle extends Collidable {
	private int radius;

	public CollidableCircle(Object object, Vector position) {
		super(object, position);
		// TODO Auto-generated constructor stub
		if (object instanceof Ball) {
			this.radius = ((Ball)object).getRadius();
		}
	}

	@Override
	public Collidable intersects(Collidable object) {
		if (object instanceof CollidableCircle) {
			
		} else if (object instanceof CollidableRect) {
			// TODO Figure out math for Collision of Circle and Rectangle
		}
		
		return null;
	}
	
	public int getRadius() {
		return radius;
	}

	@Override
	public ArrayList<Bound> getXYZProjections() {
		// TODO Auto-generated method stub
		return null;
	}

}
