package game.math.structures;

import java.util.ArrayList;
import java.util.List;

import game.math.Collidable;

public class CollidableQTree extends QuadTree<Collidable> {
	
	
	
	public CollidableQTree(int level, Bound...bound) {
		// TODO Auto-generated constructor stub
		super(level, bound);
		this.setObjects(new ArrayList<Collidable>());
	}
	
	public CollidableQTree(int level, int xL, int xU, int yL, int yU) {
		this(level, new Bound(xU, xL), new Bound(yU, yL));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void split() {
		CollidableQTree[] nodes = new CollidableQTree[4];
 		Bound x = this.bounds.get(0);
 		Bound y = this.bounds.get(1);
 		int xMid = (x.getUpper()-x.getLower())/2;
 		int yMid = (y.getUpper()-y.getLower())/2;
 		
 		// Creating Nodes
		nodes[0] = new CollidableQTree(this.level+1, x.getLower(), xMid, y.getLower(), yMid);
		nodes[1] = new CollidableQTree(this.level+1, xMid, x.getUpper(), y.getLower(), yMid);
		nodes[2] = new CollidableQTree(this.level+1, x.getLower(), xMid, yMid, y.getUpper());
		nodes[3] = new CollidableQTree(this.level+1, xMid, x.getUpper(), yMid, y.getUpper());
		this.setNodes(nodes);
		
	}

	@Override
	public int getIndex(Collidable c) {
		Bound x = this.bounds.get(0);
 		Bound y = this.bounds.get(1);
 		int xMid = (x.getUpper()-x.getLower())/2;
 		int yMid = (y.getUpper()-y.getLower())/2;
 		
 		Bound cX = c.getBounds().get(0);
 		Bound cY = c.getBounds().get(1);
 		//int cXMid = (cX.getUpper()-cX.getLower())/2;
 		//int cYMid = (cY.getUpper()-cY.getLower())/2;
 		
 		if (cX.getUpper() < xMid && cX.getLower() > x.getLower()) {
 			// Lower X boundary
 			if (cY.getUpper() < yMid && cY.getLower() > y.getLower()) {
 				// Lower Y boundary
 				return 0;
 			} else if (cY.getUpper() < y.getUpper()) {
 				// Upper Y boundary
 				return 2;
 			}
  		} else if( cX.getUpper() < x.getUpper()) {
  			// Upper X boundary
  			if (cY.getUpper() < yMid && cY.getLower() > y.getLower()) {
  				// Lower Y boundary
  				return 1;
 			} else if (cY.getUpper() < y.getUpper()) {
 				// Upper Y boundary
 				return 3;
 			}
 		}
 		
 		return -1;
	}

	@Override
	public void insert(Collidable c) {
		int index = this.getIndex(c);
		
		if (index == -1) { // Collidable does not fit fully into children
			if (this.level == 0) {
				// TODO Handle Out of Bounds
			} else if (this.getObjects().size() >= this.MAX_OBJECTS) {
				// TODO Handle Bin full
			} else {
				this.objects.add(c);
			}			
		} else { // Collidable fits into a child
			if (this.nodes == null) {
				this.split();
				nodes[index].insert(c);
			}
		}
		
		
	}

	@Override
	public List<Collidable> retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String printTree() {
		
		return "";
	}

}
