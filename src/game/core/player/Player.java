package game.core.player;

import java.util.ArrayList;

import game.components.Item;
import game.core.Score;
import game.core.paddle.Paddle;

public abstract class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private char keyupright;
	private char keydownleft;
	private int keyuprightpress;
	private int keydownleftpress;
	
	public Player(String name, Paddle paddle,char keyupright, char keydownleft) {
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		this.keydownleft=keydownleft;
		this.keyupright=keyupright;
		this.keyuprightpress=0;
		this.keydownleft=0;		
	}
	
	public char getKeyupright() {
		return keyupright;
	}

	public void setKeyupright(char keyupright) {
		this.keyupright = keyupright;
	}

	public char getKeydownleft() {
		return keydownleft;
	}

	public void setKeydownleft(char keydownleft) {
		this.keydownleft = keydownleft;
	}

	public int getKeyuprightpress() {
		return keyuprightpress;
	}

	public void setKeyuprightpress(int keyuprightpress) {
		this.keyuprightpress = keyuprightpress;
	}

	public int getKeydownleftpress() {
		return keydownleftpress;
	}
	
	public void setKeydownleftpress(int keydownleftpress) {
		this.keydownleftpress = keydownleftpress;
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
	public abstract void moveupright();
	public abstract void movedownleft();
}
