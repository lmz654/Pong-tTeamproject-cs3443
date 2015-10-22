package game.core;

import java.util.ArrayList;

import game.components.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private int keyupright;
	private int keydownleft;
			
	public Player(String name, Paddle paddle) {
		super();
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		keyupright=0;
		keydownleft=0;
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
	public void setKeyUpRight(int in){
		keyupright=in;
	}
	public int getKeyUpRight(){
		return keyupright;
	}
	public void setKeyDownLeft(int in){
		keydownleft=in;
	}
	public int getKeyDownLeft(){
		return keydownleft;
	}
}
