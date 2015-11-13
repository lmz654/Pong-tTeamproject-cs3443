package game.math;

import java.util.ArrayList;

public class QuadTree <T> {
	
	private final int depth;
	private int level;
	
	private int[] origin;
	private int[] crossBound;
	
	protected ArrayList<QuadTree<T>> children;
	
	private ArrayList<T> contents;

	public QuadTree(int height, int width, int depth) {
		this.origin = new int[]{0,0};
		this.crossBound = new int[]{width, height};
		this.level = 0;
		this.depth = depth;
		
		if (this.getLevel() == depth-1) {
			contents = new ArrayList<T>();
			children = null;
		} else {
			children = subDivide(this);
		}		
	}
	
	private QuadTree(int[] origin, int[] crossBound,int depth, int level) {
		super();
		this.depth = depth;
		this.level = level;
		this.origin = origin;
		this.crossBound = crossBound;
		
		if (this.getLevel() == depth-1) {
			setContents(new ArrayList<T>());
			setChildren(null);
		} else {
			setChildren(subDivide(this));
		}		
	}

	private ArrayList<QuadTree<T>> subDivide(QuadTree<T> qTree) {
		ArrayList<QuadTree<T>> nextChildren = new ArrayList<QuadTree<T>>();
		nextChildren.add(new QuadTree<T>(qTree.origin, new int[]{qTree.crossBound[0]/2, qTree.crossBound[1]/2}, qTree.getDepth(), qTree.getLevel()+1));
		nextChildren.add(new QuadTree<T>(new int[]{qTree.crossBound[0]/2, qTree.origin[1]}, new int[]{qTree.crossBound[0], qTree.crossBound[1]/2}, qTree.getDepth(), qTree.getLevel()+1));
		nextChildren.add(new QuadTree<T>(new int[]{qTree.origin[0], qTree.crossBound[1]/2}, new int[]{qTree.crossBound[0]/2, qTree.crossBound[1]}, qTree.getDepth(), qTree.getLevel()+1));
		nextChildren.add(new QuadTree<T>(new int[]{qTree.crossBound[0]/2, qTree.crossBound[1]/2}, qTree.crossBound, qTree.getDepth(), qTree.getLevel()+1));
		return nextChildren;
	}

	public ArrayList<QuadTree<T>> getChildren() {
		if (this.children == null) 
			return null;
		ArrayList<QuadTree<T>> result = new ArrayList<QuadTree<T>>();
		
		for (QuadTree<T> child: children) {
			if (child.hasChildren())
				result.addAll(child.getChildren());
		}
		
		return result;
	}
	
	public boolean hasChildren() {
		return children != null;
	}
	
	public void setChildren(ArrayList<QuadTree<T>> children) {
		this.children = children;
	}

	public ArrayList<T> getContents() {
		return contents;
	}

	public void setContents(ArrayList<T> contents) {
		this.contents = contents;
	}
	
	public void add(T item, int x, int y) {
		if (children == null && contents != null) {
			contents.add(item);
		} else if (contents == null) {
			contents = new ArrayList<T>();
			contents.add(item);
		} else {
			for (QuadTree<T> child : children)
				if (child.inBoundaries(x, y))
					child.add(item, x, y);
		}
	}

	public int getDepth() {
		return depth;
	}

	public int getLevel() {
		return level;
	}
	
	public boolean inBoundaries(int x, int y) {
		if (x >= origin[0] && x < crossBound[0] && y >= origin[1] && y < crossBound[1])		
			return true;
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		if (!this.hasChildren()) {
			for (int i = 0; i < this.getLevel()+1; i++)
				s.append("-");
			s.append(this.getContents() + "\n");
			return s.toString();
		}
		
		for (QuadTree<T> child : this.children)
			s.append(child.toString());
		
		return s.toString();
	}

}
