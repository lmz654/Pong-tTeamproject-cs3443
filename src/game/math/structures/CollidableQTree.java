package game.math.structures;

import java.util.ArrayList;
import java.util.List;

import game.math.Collidable;

public class CollidableQTree extends QuadTree<Collidable> {
	
	
	
	public CollidableQTree(int level, Bound...bound) {
		// TODO Auto-generated constructor stub
		super(level,bound);
		this.objects = new ArrayList<Collidable>();
		this.nodes = new CollidableQTree[4];
		
	}
	
	public CollidableQTree(int level, int xL, int xU, int yL, int yU) {
		this(level, new Bound(xU, xL), new Bound(yU, yL));
	}

	@Override
	public void clear() {
		objects.clear();
		
		for (QuadTree<Collidable> node: nodes) {
			if (node != null) {
				node.clear();
				node = null;
			}				
		}
		
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
		if (nodes[0] != null) {
			int index = this.getIndex(c);
			
			if (index != -1) {
				nodes[index].insert(c);
				return;
			}
		}
		
		objects.add(c);
		
		if (objects.size() > MAX_OBJECTS && this.level < MAX_LEVELS) {
			if (nodes[0] == null) {
				this.split();
			}
			
			for (int i = 0; i < this.objects.size(); i++) {
				int index = this.getIndex(this.objects.get(i));
				if (index != -1) {
					nodes[index].insert(this.objects.remove(i));
				} else
					continue;
			}
		}		
	}

	@Override
	public List<Collidable> retrieve(Collidable c) {
		List<Collidable> returnObjects = new ArrayList<Collidable>();
		
		return retrieve(returnObjects, c);
	}
	
	public List<Collidable> retrieve(List<Collidable> returnObjects, Collidable c) {
		int index = getIndex(c);
		if (index != -1 && nodes[0] != null) {
			nodes[index].retrieve(returnObjects, c);
		}
		
		returnObjects.addAll(objects);
		
		return returnObjects;
	}
	
	public String printTree() {
		if (nodes[0] == null)
			return this.toString();
		
		StringBuilder s = new StringBuilder();
		
		s.append(this.toString()+"\n");
		s.append(((CollidableQTree)nodes[0]).printTree()+"\n");
		s.append(((CollidableQTree)nodes[1]).printTree()+"\n");
		s.append(((CollidableQTree)nodes[2]).printTree()+"\n");
		s.append(((CollidableQTree)nodes[3]).printTree()+"\n");
		
		return s.toString();
	}
	
	public String printBounds() {
		StringBuilder lvl = new StringBuilder();
		
		for (int i = 0; i < this.level; i++)
			lvl.append("\t");
		
		if (nodes[0] == null) {
			return lvl.toString() + bounds.toString();
		}
		
		StringBuilder s = new StringBuilder();
		s.append(lvl.toString()+bounds.toString()+"\n");
		s.append(lvl.toString()+((CollidableQTree)nodes[0]).printBounds()+"\n");
		s.append(lvl.toString()+((CollidableQTree)nodes[1]).printBounds()+"\n");
		s.append(lvl.toString()+((CollidableQTree)nodes[2]).printBounds()+"\n");
		s.append(lvl.toString()+((CollidableQTree)nodes[3]).printBounds()+"\n");
		
		return s.toString();
	}

}
