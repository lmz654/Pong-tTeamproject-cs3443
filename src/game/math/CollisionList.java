package game.math;

import java.util.ArrayList;
import java.util.Collection;

public class CollisionList extends ArrayList<Collision> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CollisionList() {
		// TODO Auto-generated constructor stub
	}

	public CollisionList(int initialCapacity) {
		super(initialCapacity);
	}

	public CollisionList(Collection<Collision> c) {
		super(c);
	}
	
	public boolean contains(Collision c) {
		for (Collision collision: this) {
			if (collision.equals(c))
				return true;
		}
		
		return false;
	}

}
