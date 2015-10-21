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
	public vbhitModel(ArrayList<Item> item, ArrayList<Obstacle> obstacle, ArrayList<Player> player,
			ArrayList<Ball> ball) {
		super();
		this.item = new ArrayList();
		this.obstacle = new ArrayList();
		this.player = new ArrayList();
		this.ball = new ArrayList();
	}
	public void RemoveItem(Item out){
		item.remove(out);
	}
	public void AddItem(Item in){
		item.add(in);
	}
	public void RemoveObstacle(Obstacle out){
		obstacle.remove(out);
	}
	public void AddObstacle(Obstacle in){
		obstacle.add(in);
	}
	public void RemovePlayer(Player out){
		player.remove(out);
	}
	public void AddPlayer(Player in){
		player.add(in);
	}
	public void RemoveBall(Ball out){
		ball.remove(out);
	}
	public void AddPlayer(Ball in){
		ball.add(in);
	}
}
