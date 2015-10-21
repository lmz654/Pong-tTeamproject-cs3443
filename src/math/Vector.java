package math;

public class Vector {
	private final int LEN;
	private double[] data;
	
	
	public Vector(int LEN) {
		this.LEN = LEN;
		data = new double[LEN];
	}
	
	public Vector(double[] data) {
		LEN = data.length;
		
		this.data = new double[LEN];
		for (int i = 0; i < LEN; i++) {
			this.data[i] = data[i];
		}
	}
	
	public int length() {
		return this.LEN;
	}
	
	public double dot(Vector v) {
		if (this.LEN != v.length()) throw new RuntimeException("Dimentions are not equal.");
		double sum = 0.0;
		for (int i = 0; i < LEN; i++) 
			sum += this.data[i] * v.data[i];
		return sum;
	}
	
	public double magnitude() {
		return Math.sqrt(this.dot(this));
	}
	
	public double distanceTo(Vector v) {
		if (this.LEN != v.length()) throw new RuntimeException("Dimentions are not equal.");
		return this.minus(v).magnitude();
	}
	
	//TODO Override + sign Operator
	public Vector plus(Vector v) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] = this.data[i] + v.data[i];
		return result;
	}
	
	//TODO Override - sign Operator
	public Vector minus(Vector v) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] = this.data[i] - v.data[i];
		return result;
	}
	
	
}
