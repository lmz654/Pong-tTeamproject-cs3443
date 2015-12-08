package game.math;

import game.math.structures.Vector;

public class Collision {
	private Collidable a;
	private Collidable b;
	
	private Vector collisionPoint;
	
	public Collision(Collidable a, Collidable b) {
		this.a = a;
		this.b = b;
		
		a.setLastCollided(b);
		b.setLastCollided(a);
		
		this.collisionPoint = calculateCollisionPoint();
	}

	public Collidable getA() {
		return a;
	}

	public void setA(Collidable a) {
		this.a = a;
	}

	public Collidable getB() {
		return b;
	}

	public void setB(Collidable b) {
		this.b = b;
	}
	
	public Vector getCollisionPoint() {		
		return collisionPoint;
	}
	
	public boolean equals(Collision other) {
		return (this.a.equals(other.a) && this.b.equals(other.b)) || (this.a.equals(other.b) && this.b.equals(other.a));
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Collision between {");
		s.append(a.getObject().getClass().getSimpleName());
		s.append(", " + b.getObject().getClass().getSimpleName());
		s.append("} @ " + collisionPoint.toString());
		return s.toString();
	}
	
	public synchronized void adjustTrajectories() {
		// TODO Math to find reflection velocities of the objects
		Vector hyperplane = this.getHyperplane();
		//System.out.println(a.getPosition().toString() + b.getPosition().toString() + hyperplane.toString());
	
		
		if (a instanceof CollidableCircle && b instanceof CollidableCircle) {
			a.adjustTrajectory(hyperplane);
			b.adjustTrajectory(hyperplane);
		} else 
			return;
		
	}
	
	private Vector calculateCollisionPoint() {
		Vector c = b.position.minus(a.position);	
		double t = c.dot(b.velocity) / a.velocity.dot(b.velocity);
		
		Vector cPoint = a.velocity.times(t).plus(a.position);
		
		return cPoint;
	}
	
	private Vector getHyperplane() {
		try {
			return a.getPosition().minus(b.getPosition()).getPerpendicular();
		} catch (Exception e) {
			// Something went wrong getting the Hyperplane
			e.printStackTrace();
		}
		return null;
	}
	
}
