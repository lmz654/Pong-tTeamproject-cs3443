package game.math.structures;

import java.awt.Point;
import java.util.Random;

import game.Controls;

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
	public Vector (Vector vector){
		LEN=2;
		this.data = new double[2];
		this.data[0]=vector.cartesian(0);
		this.data[1]=vector.cartesian(1);
	}
	// data[0] min, data[1] max
	public static Vector getRand(int...data) {
		double max,d1;
		double[] rand = new double[data.length];
		Random random = new Random();
		d1=data[0] + random.nextDouble()*(data[1]-data[0]);
		rand[0] =random.nextDouble()*d1;
		if(random.nextBoolean()==true){
			rand[0]=-rand[0];
		}
		max=Math.sqrt(Math.pow(d1, 2) - Math.pow(rand[0], 2));
		rand[1]=max;
		if(random.nextBoolean()==true){
			rand[1]=-max;
		}
	
	
		
		return new Vector(rand);
	}
	
	public static Vector getRand(int[]...data) {
		double[] rand = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			rand[i] = Math.rint((Math.random()*data[i][0] + data[i][1]));
		}
		
		return new Vector(rand);
	}
	
	public double[] getData(){
		return this.data;
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
			result.data[i] = (double)(this.data[i] - v.data[i]);
		return result;
	}
	
	public double cartesian(int i) {
		return data[i];
	}
	
	public Vector times(double factor) {
		Vector result = new Vector(LEN);
		for (int i = 0; i < LEN; i++)
			result.data[i] =(double) factor * data[i];
		return result;
	}
	//increase in percent
	public void PercentAdjust(double percent){
		for(int i=0;i<LEN;i++){
			this.data[i]=this.data[i]*percent;
		}
	}
	public double angleTo(Vector other) {
		return Math.acos((this.dot(other))/(this.magnitude()*other.magnitude()));
	}
	
	public Vector rotate2D(double a) throws Exception{
		if (this.LEN != 2) throw new Exception("Wrong Dimensions");
		
		double xP = (this.cartesian(0)*Math.cos(a))+(this.cartesian(1)*Math.sin(a));
		double yP = (-1*this.cartesian(0)*Math.sin(a)) + (this.cartesian(1)*Math.cos(a));
		
		return new Vector((int)xP, (int)yP);
	}
	
	public Vector getPerpendicular() throws Exception {
		if (this.LEN != 2) throw new Exception("Wrong Dimensionallity");
		return this.rotate2D(Math.PI/2);
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
