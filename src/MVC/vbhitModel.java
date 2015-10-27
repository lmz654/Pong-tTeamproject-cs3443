package MVC;

import java.util.ArrayList;

import game.components.Item;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.player.Player;
import game.math.CollisionDetector;

public class vbhitModel {
	private ArrayList<Item> item;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Player> player;
	private ArrayList<Ball> ball;
	
	public vbhitModel() {
		super();
		this.item = new ArrayList<Item>();
		this.obstacle = new ArrayList<Obstacle>();
		this.player = new ArrayList<Player>();
		this.ball = new ArrayList<Ball>();
	}
	public vbhitModel(ArrayList<Item> item, ArrayList<Obstacle> obstacle, ArrayList<Player> player, ArrayList<Ball> ball) {
		super();
		this.item = item;
		this.obstacle = obstacle;
		this.player = player;
		this.ball = ball;
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
	
}
