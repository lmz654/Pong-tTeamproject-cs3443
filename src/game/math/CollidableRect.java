package game.math;

import java.util.ArrayList;

import game.core.Paddle;
import game.math.structures.Bound;
import game.math.structures.Vector;

public class CollidableRect extends Collidable {
	private int width, height;

	public CollidableRect(Object object) {
		super(object);
		// TODO Auto-generated constructor stub
		if (object instanceof Paddle) {
			this.position = ((Paddle)object).getPosition();
			this.width = ((Paddle)object).getLength();
			this.height = ((Paddle)object).getHeight();
		}
	}
	
	@Override
	public ArrayList<Bound> getBounds() {
		ArrayList<Bound> bounds = new ArrayList<Bound>();
		
		bounds.add(new Bound((int)position.cartesian(0)+(width/2),(int) position.cartesian(0)-(width/2)));
		bounds.add(new Bound((int)position.cartesian(1)+(height/2),(int) position.cartesian(1)-(height/2)));
		
		return bounds;
	}

	@Override
	public void setVelocity(Vector velocity) {
		// TODO Setting Velocity on CollidableRect
		
	}

	@Override
	public void adjustTrajectory(Vector hyperPlane) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collidable next() {
		// TODO Auto-generated method stub
		return null;
	}

}
