package game.math;

import java.awt.Point;

public class Vector {
	private final int LEN;
	private double[] data;
	
	
	public Vector(int LEN1) {
		this.LEN = LEN1;
		data = new double[LEN];
	}
	
	public Vector(double...data) {
		LEN = data.length;
		
		this.data = new double[LEN];
		for (int i = 0; i < LEN; i++) {
			this.data[i] = data[i];
		}
	}
	
	public static Vector getRand(int...data) {
		double[] rand = new double[data.length];
		
		for (int i = 0; i < data.length; i++) {
			rand[i] = Math.round(Math.random()*data[i]);
		}
		
		return new Vector(rand);
	}
	
	public static Vector getRand(int[]...data) {
		double[] rand = new double[data.length];
		
		for (int i = 0; i < data.length; i++) {
			rand[i] = Math.round(Math.random()*(data[i][0] - 2*data[i][1]) + data[i][1]);
		}
		
		return new Vector(rand);
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
	
	public Vector unit() {
		if (this.magnitude() == 0)
			return this;
		return this.times(1/this.magnitude());
	}
	
	public double distanceTo(Vector v) {
		if (this.LEN != v.length()) throw new RuntimeException("Dimentions are not equal.");
		return this.minus(v).magnitude();
	}
	
	public Vector plus(Vector v) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] = this.data[i] + v.data[i];
		return result;
	}
	
	public Vector minus(Vector v) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] = this.data[i] - v.data[i];
		return result;
	}
	
	public double cartesian(int i) {
		return data[i];
	}
	
	public Vector times(double factor) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] = factor * data[i];
		return result;
	}
	
	public Point toPoint() {
		return new Point((int) data[0],(int) data[1]);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<");
		for (int i = 0; i < LEN; i++) {
			s.append(data[i]);
			if (i < LEN -1) s.append(", ");
		}
		s.append(">");
		return s.toString();			
	}
}
