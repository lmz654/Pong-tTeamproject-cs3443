package game.math;

public class Collision {
	private Collidable a;
	private Collidable b;
	
	private Vector collisionPoint;
	
	public Collision(Collidable a, Collidable b) {
		this.a = a;
		this.b = b;
		
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
	
	public void adjustTrajectories() {
		// TODO Math to find reflection velocities of the objects
		Vector hyperplane = this.getHyperplane();
		System.out.println(a.getPosition().toString() + b.getPosition().toString() + hyperplane.toString());
		Vector aPrime, bPrime;
		
		if (a instanceof CollidableCircle && b instanceof CollidableCircle) {
			aPrime = ((CollidableCircle)a).getVelocity();
			bPrime = ((CollidableCircle)b).getVelocity();
			
			if (aPrime == null || bPrime == null) return;
			
			try {
				aPrime = aPrime.rotate2D(2*aPrime.angleTo(hyperplane));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				bPrime = bPrime.rotate2D(2*bPrime.angleTo(hyperplane));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			a.setVelocity(aPrime);
			b.setVelocity(bPrime);
		}
		
	}
	
	private Vector calculateCollisionPoint() {
		Vector aTob = b.position.minus(a.position);	
		Vector cPoint = aTob.unit();
		
		if (a instanceof CollidableCircle) {
			cPoint = cPoint.times(((CollidableCircle)a).getRadius());
		}
		cPoint = a.position.plus(cPoint);		
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
