package game.math;

public class Collision {
	private Collidable a;
	private Collidable b;
	
	public Collision(Collidable a, Collidable b) {
		
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
	
}
