package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Control;
import javax.swing.Timer;

import game.Controls;
import game.components.item.Item;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.Paddle;
import game.core.Player;
import game.math.CollisionDetector;
import game.math.Vector;

public class vbhitModel {
	private ArrayList<Item> item;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Player> player;
	private ArrayList<Ball> ball;
	private Timer timer;
	private BufferedImage defaultballimage;
	
	public vbhitModel() {
		super();
		this.item = new ArrayList<Item>();
		this.obstacle = new ArrayList<Obstacle>();
		//this.player = new ArrayList<Player>();
		this.ball = new ArrayList<Ball>();
		player= new ArrayList<Player>();
		this.createdefaultplayer();
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vbhitModel.this.update();
			}
			
		};
		try {
			defaultballimage = ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\default.png"));
		} catch (IOException e) {
			System.err.println("defautballimage input is fail in vbhitModel");
		}
		timer = new Timer(Controls.MODEL_TIME, action);
	}
	/*public vbhitModel(ArrayList<Item> item, ArrayList<Obstacle> obstacle, Player[] player, ArrayList<Ball> ball) {
		super();
		this.item = item;
		this.obstacle = obstacle;
		this.player = player;
		this.ball = ball;
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vbhitModel.this.update();
			}
			
		};
		try {
			defaultballimage = ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\default.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer = new Timer(Controls.MODEL_TIME, action);
	}*/
	public void activateplayer(int player){
	//	System.out.println(this.player.get(player).getMotionAxis());
		//System.out.println(this.player.get(player).getPaddle().getLength());
		this.player.get(player).setActivestatus(true);
		//System.out.println(this.player.get(player).getPaddle().getLength());
	}
	public void createball(){
		Ball ball = Controls.getDefaultBall();
		ball.setimage(this.defaultballimage);
		this.ball.add(ball);
	}
	public void createdefaultplayer(){
		if(this.player.size()==0){
			this.player.add(0, Controls.player1default());
			this.player.add(1,Controls.player2default());
			this.player.add(2,Controls.player3default());
			this.player.add(3,Controls.player4default());
		}
	}
	
	public void removeItem(Item out){
		item.remove(out);
	}
	
	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public ArrayList<Obstacle> getObstacle() {
		return obstacle;
	}

	public void setObstacle(ArrayList<Obstacle> obstacle) {
		this.obstacle = obstacle;
	}

	public ArrayList<Player> getAllPlayer() {
		return this.player;
	}
	public Player getPlayer(int index){
		return this.player.get(index);
	}
	/*public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}*/

	public ArrayList<Ball> getBall() {
		return this.ball;
	}

	public void setBall(ArrayList<Ball> ball) {
		this.ball = ball;
	}

	public void addItem(Item in){
		item.add(in);
	}
	
	public void removeObstacle(Obstacle out){
		obstacle.remove(out);
	}
	
	public void addObstacle(Obstacle in){
		obstacle.add(in);
	}
	
	public void removePlayer(Player out){
		player.remove(out);
	}
	
	public void addPlayer(Player in){
		player.add(in);
	}
	
	public void removeBall(Ball out){
		ball.remove(out);
	}
	
	public void addBall(Ball in){
		ball.add(in);
	}
	
	public void checkCollisions() {
		CollisionDetector.checkCollisions(this);
	}
	//update total action  in the game
	public void update(){
		this.moveBalls();
		for(Player p: player){
			if(p.isActivestatus()==true){
				p.movePaddle();
			}
			
		}
	}
	public void moveBalls() {
		if (Controls.MODEL_HEIGHT == 0) return;
		int posX, posY, radius;
		boolean remove = false;
		
		//Collision collision;
		try{
			for (Ball b : ball) {
				b.move();
				
				posX = (int)b.getPosition().cartesian(0);
				posY = (int)b.getPosition().cartesian(1);
				radius = b.getRadius();
				
				
				// Check boundries
				// Checking X
				if (posX > (Controls.MODEL_WIDTH-radius) || posX < radius) {
					if((posY + radius< Controls.CONER_LENGTH) || (posY - b.getRadius()> Controls.MODEL_HEIGHT-Controls.CONER_LENGTH)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						//check the ball within paddle on leftside
					}else if(posX<radius && Math.abs(posY-this.player.get(0).getPaddle().getPosition().cartesian(1))<=(this.player.get(0).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(0));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
						//check the ball within paddle on rightside
					}else if(posX > (Controls.MODEL_WIDTH-radius) && Math.abs(posY-this.player.get(1).getPaddle().getPosition().cartesian(1))<=(this.player.get(1).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(1));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
					}else{// ball go out of the panel
						remove=true;
						this.ball.remove(b);
						this.createball();	
					}
				}
				//check Y
				if ((posY > (Controls.MODEL_HEIGHT -radius ) || posY <radius)&& remove==false) {
					if((posX + b.getRadius()< Controls.CONER_LENGTH) || (posX - b.getRadius()> Controls.MODEL_WIDTH-Controls.CONER_LENGTH)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						//check the ball within paddle on the top side
					}else if(posY<radius && Math.abs(posX-this.player.get(2).getPaddle().getPosition().cartesian(0))<=(this.player.get(2).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(2));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
						//check the ball within paddle on the bottom side
					}else if(posY>(Controls.MODEL_HEIGHT-radius) && Math.abs(posX-this.player.get(3).getPaddle().getPosition().cartesian(0))<=(this.player.get(3).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(3));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
					}else{
						this.ball.remove(b);
						this.createball();
					}			
				}
				remove=false;
			}
			
		}catch(Exception e){
				System.err.println(e.getMessage());
			}
			
			/*
			 * Checking for Collisions
			 */
			//CollisionDetector.checkCollisions(this);
			
//			for (Ball c : balls) {
//				if (b.equals(c)) continue;
//				if (b.intersects(c)) {
//					collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//					System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//				}
//			}
			
			
		
		
	}
	public void start(){
		this.timer.start();
	}
	public void stop(){
		this.timer.stop();
	}
}
