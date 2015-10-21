package MVC;

import java.util.ArrayList;

import game.components.Item;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.Player;

public class vbhitModel {
	private ArrayList<Item> item;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Player> player;
	private ArrayList<Ball> ball;
	
	public vbhitModel(ArrayList<Item> item, ArrayList<Obstacle> obstacle, ArrayList<Player> player, ArrayList<Ball> ball) {
		super();
		this.item = new ArrayList<Item>();
		this.obstacle = new ArrayList<Obstacle>();
		this.player = new ArrayList<Player>();
		this.ball = new ArrayList<Ball>();
	}
	
	public void removeItem(Item out){
		item.remove(out);
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
	
}
