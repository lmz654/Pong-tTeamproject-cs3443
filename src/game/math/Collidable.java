package game.math;

import java.util.ArrayList;

public abstract class Collidable {
	protected Object obj;
	protected Vector position;
	
	public Collidable(Object object, Vector position) {
		this.obj = object;
		this.position = position;
	}
	
	public Object getObject() {
		return obj;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(obj.getClass().getSimpleName());
		s.append(": Position " + position.toString());
		return s.toString();
	}
	
	public abstract Collidable intersects(Collidable object);
	public abstract ArrayList<Bound> getXYZProjections();
}
