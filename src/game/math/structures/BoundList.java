package game.math.structures;

import java.util.ArrayList;

public class BoundList extends ArrayList<Bound> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean subSet(BoundList other) {
		/*
		 * Check to see if this is a subset of other
		 */
		if (this.size() != other.size()) return false; // Wrong Dimensionality
		
		for (int i = 0; i < this.size(); i++) {
			if (!this.get(i).subSet(other.get(i)))
				return false;
			else
				continue;
		}		
		
		return true;
	}
	
	

}
