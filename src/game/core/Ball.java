package game.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import game.Controls;
import game.components.obstacles.Obstacle;
import game.math.structures.Vector;

public class Ball {
	// --- Ball Mechanics ---
	private Vector position;
	private Vector velocity;
	private final int radius;
	private boolean collided;
	private BufferedImage image;
	private Player holded;
	private Obstacle inobstacle;
	private ArrayList<BufferedImage> shadowimage;
	private LinkedList<Vector> ballshaddow;//6 shadow;
	// --- Game Metrics ---
	private Player lastHit;
	
	// Constructor
	public Ball(Vector position, Vector velocity, int radius) {
		//this.shadowimage= new ArrayList<BufferedImage>();
		this.position = position;
		this.velocity = velocity;
		this.radius = radius;
		this.collided = false;
		this.holded=null;
		this.inobstacle=null;
		this.ballshaddow = new LinkedList<Vector>();
		
		
	}
	
	// Setters and Getters
	
	public Vector getPosition(){
		return position;
	}
	
	/*public ArrayList<BufferedImage> getShadowimage() {
		return shadowimage;
	}

	public void setShadowimage(ArrayList<BufferedImage> shadowimage) {
		this.shadowimage = shadowimage;
	}*/

	public ArrayList<BufferedImage> getShadowimage() {
		return shadowimage;
	}

	public void setShadowimage(ArrayList<BufferedImage> shadowimage) {
		this.shadowimage = shadowimage;
	}

	public LinkedList<Vector> getBallshaddow() {
		return ballshaddow;
	}

	public void setBallshaddow(LinkedList<Vector> ballshaddow) {
		this.ballshaddow = ballshaddow;
	}

	public Player getHolded() {
		return holded;
	}

	public void setHolded(Player player) {
		this.holded = player;
	}
	
	public Obstacle getInobstacle() {
		return inobstacle;
	}

	public void setInobstacle(Obstacle inobstacle) {
		this.inobstacle = inobstacle;
	}

	public Vector getVelocity() {
		return this.velocity;
	}
	
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setCollided() {
		this.collided = true;
	}
	
	public boolean collided() {
		return this.collided;
	}
	
	public Player getLastHit() {
		return this.lastHit;
	}
	public void release(){
		this.holded=null;
	}
	public void setLastHit(Player player) {
		this.lastHit = player;
	}
	public void move() {
		//if (!collided)
			//this.setShaddow();
		this.ballshaddow.addLast(new Vector(this.position));
		if(this.ballshaddow.size()>6){
			this.ballshaddow.removeFirst();
		}
		
			position = position.plus(velocity);
			//System.out.print(this.ballshaddow.get(0)+" " + this.ballshaddow.get(1)+"  " + this.position+"-");
		//collided = false;
	}
	

	public void setPosition(Vector position) {
		this.position = position;
	}
	
	/*public LinkedList<Vector> getShaddow(){
		return this.ballshaddow;
	}*/
	public void setShaddow(){
		
		/*this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(12))));
		this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(10))));
		this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(8))));
		this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(6))));
		this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(4))));
		this.ballshaddow.add(new Vector(this.position.minus(this.velocity.times(2))));*/
		/*System.out.print(this.ballshaddow.get(0)+ "  " + this.ballshaddow.get(1));*/
	}
	
	public boolean intersects(Ball ball) {
		return ((double)position.distanceTo(ball.getPosition()) < (double)(radius + ball.getRadius()));
	}
	public void setimage(BufferedImage image){
		this.image=image;
	}
	public BufferedImage getimage(){
		return this.image;
	}
	//increase in percent
	public void IncreaseSpeed(double speedup){
		if(this.velocity.magnitude()<Controls.BALL_MAX_SPEED){
			this.velocity.PercentAdjust(1+speedup);//speed up by percent
			//System.out.print(this.velocity.toString());
		}
	}
	//decrease in percent
	public void DecreaseSpeed(double slowdown){
		if(this.velocity.magnitude()>Controls.BALL_MIN_SPEED){
			this.velocity.PercentAdjust(1-slowdown);
		}
	}
	
	
	public Ball clone(){
		Ball b = new Ball(new Vector(this.getPosition().getData().clone()),
				Vector.getRand(new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}, 
						   new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}),Controls.BALL_DEFAULT_RADIUS);
		return b;
	}
	
	// Information Methods
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("{");		
		s.append("Position: " + position.toString());
		s.append(" Speed: " + velocity.magnitude());
		s.append(" Direction Vector: " + velocity.unit().toString());
		s.append(" Velocity Vector: " + velocity.toString());
		s.append("}");
		return s.toString();
	}
	
	
}
