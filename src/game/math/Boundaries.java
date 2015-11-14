package game.math;

import java.util.ArrayList;

public class Boundaries extends ArrayList<Bound> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean inBounds(Boundaries bounds) {
		for (int i = 0; i < this.size(); i++)
			if (!this.get(i).intersects(bounds.get(i)))
				return false;		
		return true;
	}
	
	

}
