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
	private Player player;
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

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void SpeedIncreasement(int speedup){
		int a;
		if((a=this.velocity+speedup)<Controls.PADDLE_MAX_SPEED){
			this.velocity=a;
		}else{
			this.velocity=Controls.PADDLE_MAX_SPEED;
		}
			
	}
	
	public void SpeedDecreasement(int slowdown){
		int a;
		if((a=this.velocity-slowdown)>Controls.PADDLE_MIN_SPEED){
			this.velocity=a;
		}else{
			this.velocity=Controls.PADDLE_MIN_SPEED;
		}
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
	public void ShrinkPaddle(int amount){
		int a;
		if((a=this.length-amount)< Controls.PADDLE_ACTIVE_MIN_LENGTH){
			this.length=Controls.PADDLE_ACTIVE_MIN_LENGTH;
		}else{
			this.length=a;
		}
		
	}
	public void ExpandPaddle(int amount){
		int a;
		if((a=this.length+amount)> Controls.PADDLE_ACTIVE_MAX_LENGTH){
			this.length=Controls.PADDLE_ACTIVE_MAX_LENGTH;
		}else{
			this.length=a;
		}
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
		//Vector v;
		this.position = position.plus(new Vector(velocity*orient, 0.0));
		if(this.player.getBallholded()!=null){
			//v=this.player.getBallholded().getPosition().plus(new Vector(velocity*orient, 0.0));
			this.player.getBallholded().setPosition
			(this.player.getBallholded().getPosition().plus(new Vector(velocity*orient, 0.0)));
		}
	}

	private void moveYAxis(int orient) {
		this.position = position.plus(new Vector(0.0, velocity*orient));
		if(this.player.getBallholded()!=null){
			//v=this.player.getBallholded().getPosition().plus(new Vector(velocity*orient, 0.0));
			this.player.getBallholded().setPosition
			(this.player.getBallholded().getPosition().plus(new Vector(0.0, velocity*orient)));
		}
	}

}
