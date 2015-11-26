package game.core;

import game.Controls;
import game.math.structures.Vector;

public class Paddle {
	
	// Paddle Mechanics
	private Vector position;
	private int velocity;
	private int length;//the real length
	private int height;
	private boolean sticky;
	//the thickness
	
	
	public Paddle(Vector position, int length, int height) {
		this.position = position;
		this.velocity = Controls.PADDLE_VELOCITY;
		this.length = length;
		this.setHeight(height);
		this.sticky=false;
	}
	
	public boolean isSticky() {
		return sticky;
	}

	public void setSticky(boolean sticky) {
		this.sticky = sticky;
	}

	public Paddle(int dimension, int length) {
		this.position = new Vector(dimension);
		this.velocity = Controls.PADDLE_VELOCITY;
		this.length = length;
	}
	public Vector getPosition(){
		return position;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public void move(char axis, int orient) throws Exception{
		if(orient!=0){
			switch(axis) {
			case 'x':
			case 'X':
				if((this.position.cartesian(0)-this.length/2)>Controls.PADDLE_MINREACH_LIMIT && orient==-1){
					moveXAxis(orient);
				}else if((this.position.cartesian(0)+this.length/2)<Controls.PADDLE_MAXREACH_LIMIT && orient==1){
					moveXAxis(orient);
				}
				break;
			case 'y':
			case 'Y':
				if((this.position.cartesian(1)-this.length/2)>Controls.PADDLE_MINREACH_LIMIT && orient==-1){
					moveYAxis(orient);
				}else if((this.position.cartesian(1)+this.length/2)<Controls.PADDLE_MAXREACH_LIMIT && orient==1){
					moveYAxis(orient);
				}
				break;
			default:
				throw new Exception("Invalid Motion Axis!");
			}
		}
	}

	private void moveXAxis(int orient) {
		position = position.plus(new Vector(velocity*orient, 0.0));
	}

	private void moveYAxis(int orient) {
		position = position.plus(new Vector(0.0, velocity*orient));		
	}

}
