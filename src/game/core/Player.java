package game.core;

import java.util.ArrayList;

import game.components.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
			
	public Player(String name, Paddle paddle) {
		super();
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);		
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public ArrayList<Item> getItem() {
		return item;
	}
	
	public void addItem(Item i) {
		// TODO Item Validation
		this.item.add(i);
	}
}
