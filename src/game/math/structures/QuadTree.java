package game.math.structures;

import java.util.List;

public abstract class QuadTree<T extends Object> {
	
	protected final int MAX_OBJECTS = 10;
	protected final int MAX_LEVELS = 5;
	
	protected int level;
	protected Boundaries bounds;
	protected List<T> objects;
	protected QuadTree<T>[] nodes;
	
	public QuadTree(int level, Bound...bounds) {
		this.level = level;
		for (Bound b : bounds)
			this.bounds.add(b);
		this.objects = null;
		this.nodes = null;
	}
	
	public abstract void clear();
	public abstract void split();
	public abstract int getIndex(T t);
	public abstract void insert(T t);
	public abstract List<T> retrieve();

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

	public QuadTree<T>[] getNodes() {
		return nodes;
	}

	public void setNodes(QuadTree<T>[] nodes) {
		this.nodes = nodes;
	}

	public int getMAX_OBJECTS() {
		return MAX_OBJECTS;
	}

	public int getMAX_LEVELS() {
		return MAX_LEVELS;
	}
	
	public Boundaries getBounds() {
		return bounds;
	}

	public void setBounds(Boundaries bounds) {
		this.bounds = bounds;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.level+1; i++)
			s.append("-");
		s.append(objects);
		return s.toString();
	}
}
