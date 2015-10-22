package game.core;

import java.util.ArrayList;

import game.components.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private int keyuprightpress;
	private int keydownleftpress;
	private char keyupright;
	private char keydownleft;
			
	public Player(String name, Paddle paddle,char upright, char downleft) {
		super();
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		keyuprightpress=0;
		keydownleftpress=0;
		keyupright=upright;
		keydownleft=downleft;
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
		keyuprightpress=in;
	}
	public int getKeyUpRight(){
		return keyuprightpress;
	}
	public void setKeyDownLeft(int in){
		keydownleftpress=in;
	}
	public int getKeyDownLeft(){
		return keydownleftpress;
	}
}
