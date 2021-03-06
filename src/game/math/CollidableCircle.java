package game.math;

import java.util.ArrayList;

import game.core.Ball;
import game.math.structures.Bound;
import game.math.structures.Vector;

public class CollidableCircle extends Collidable {
	private int radius;

	public CollidableCircle(Object object) {
		super(object);
		// Conversion of Balls to Collidable Circles
		if (object instanceof Ball) {
			this.radius = ((Ball)object).getRadius();
			super.position = ((Ball)object).getPosition();
			super.velocity = ((Ball) object).getVelocity();
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

	@Override
	public void setVelocity(Vector velocity) {
		if (this.obj instanceof Ball) {
			((Ball)this.obj).setVelocity(velocity);
		}
		
	}
	
	public Vector getVelocity() {
		if (this.obj instanceof Ball) {
			return ((Ball)this.obj).getVelocity();
		}
		return null;
	}
	
	@Override
	public void adjustTrajectory(Vector hyperPlane) {
		if (this.obj instanceof Ball) {
			Ball b = (Ball)this.obj;
			Vector vPrime = b.getVelocity();
			double reflectionAngle = vPrime.angleTo(hyperPlane);
			double energyLoss = .05;
			double energyBias = 1;
			
			// Set next positions of the balls
			b.collided();
			b.setPosition(b.getPosition().plus(b.getVelocity().unit().times(b.getVelocity().distanceTo(hyperPlane)-b.getRadius())));
			
			try {
				vPrime = vPrime.rotate2D(2*(Math.min(reflectionAngle, Math.PI - reflectionAngle)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			energyBias += energyLoss;
			
			b.setVelocity(vPrime.times(energyBias));
			
		}
	}
	
	public static CollidableCircle randBall(int r, int lX, int uX, int lY, int uY) {
		return new CollidableCircle(new Ball(Vector.getRand(new int[]{(uX - lX) - 2*r, lX - r}, new int[]{(uY - lY) - 2*r, lY - r}),Vector.getRand(0,0) , r));
	}

	@Override
	public Collidable next() {
		if (this.obj instanceof Ball) {
			return new CollidableCircle(new Ball(((Ball) obj).getPosition().plus(((Ball) obj).getVelocity()), ((Ball) obj).getVelocity(), ((Ball) obj).getRadius()));
		}
		return null;
	}

}
