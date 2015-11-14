package game.math.structures;

public class Bound {
	private int upper;
	private int lower;
	
	public Bound(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public int getLower() {
		return lower;
	}
	
	public boolean intersects(Bound other) {
		return (this.upper > other.lower && this.lower < other.upper) || (this.lower < other.upper && this.upper > other.lower);
	}
	
	public boolean subSet(Bound other) {
		return this.equals(other) || (this.upper < other.upper && this.lower > other.lower);
	}
	
	public boolean equals(Bound b) {
		return this.lower == b.lower && this.upper == b.upper;
	}

	public String toString() {
		return "<" + lower + ", " + upper + ">";
	}
	
}
