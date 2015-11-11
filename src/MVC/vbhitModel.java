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
		this.player = new ArrayList<Player>();
		this.ball = new ArrayList<Ball>();
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
	}
	public vbhitModel(ArrayList<Item> item, ArrayList<Obstacle> obstacle, ArrayList<Player> player, ArrayList<Ball> ball) {
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
	}
	public void createball(){
		Ball ball = Controls.getDefaultBall();
		ball.setimage(this.defaultballimage);
		this.ball.add(ball);
	}
	public void createplayer(int number){
		for(int i =0;i<number;i++){
			if(i==0){
				this.addPlayer(Controls.player1default());
			}else if(i==1){
				this.addPlayer(Controls.player2default());
			}else if (i==2){
				this.addPlayer(Controls.player3default());
			}else if(i==3){
				this.addPlayer(Controls.player4default());
			}
			
				
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

	public ArrayList<Player> getPlayer() {
		return player;
	}

	public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}

	public ArrayList<Ball> getBall() {
		return ball;
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
	public void update(){
		this.checkCollisions();
		this.moveBalls();
		for(Player p: player){
			p.movePaddle();
		}
	}
	public void moveBalls() {
		if (Controls.MODEL_HEIGHT == 0) return;
		int posX, posY, radius;
		
		//Collision collision;
		
		for (Ball b : ball) {
			b.move();
			
			posX = (int)b.getPosition().cartesian(0);
			posY = (int)b.getPosition().cartesian(1);
			radius = b.getRadius();
			
			// Check boundries
			// Checking X
			if (posX > (Controls.MODEL_WIDTH - radius) || posX < radius) {
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			// Checking Y
			if (posY > (Controls.MODEL_HEIGHT - radius) || posY < radius) {
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
				//System.out.println("Pos: " + b.getPosition().toString() + " V: " + b.getVelocity().toString());
			}
			
			/*
			 * Checking for Collisions
			 */
			CollisionDetector.checkCollisions(this);
			
//			for (Ball c : balls) {
//				if (b.equals(c)) continue;
//				if (b.intersects(c)) {
//					collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//					System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//				}
//			}
			
			
		}
		
	}
	public void start(){
		this.timer.start();
	}
	public void stop(){
		this.timer.stop();
	}
}
