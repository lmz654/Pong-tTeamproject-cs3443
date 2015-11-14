package game.math.structures;

import java.util.List;

public abstract class QuadTree<T extends Object> {
	
	protected final int MAX_OBJECTS = 10;
	protected final int MAX_LEVELS = 5;
	
	protected int level;
	protected BoundList bounds;
	protected List<T> objects;
	protected QuadTree<T>[] nodes;
	
	public QuadTree(int level, Bound...bounds) {
		this.level = level;
		this.bounds = new BoundList();
		for (Bound b : bounds)
			this.bounds.add(b);
	}
	
	public abstract void clear();
	public abstract void split();
	public abstract int getIndex(T t);
	public abstract void insert(T t);
	public abstract List<T> retrieve(T t);
	public abstract List<T> retrieve(List<T> returnObjects, T t);

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
	
	public BoundList getBounds() {
		return bounds;
	}

	public void setBounds(BoundList bounds) {
		this.bounds = bounds;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.level; i++)
			s.append("\t");
		s.append("-->" + objects);
		return s.toString();
	}

}
