package vbhit;

import java.util.ArrayList;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private char keyLeftDown, keyRightUp;
	private char keyHoldBall;
	
	public Player(String name, Paddle paddle, char keyLeftDown, char keyRightUp, char keyHoldBall) {
		super();
		this.name = name;
		this.paddle = paddle;
		this.keyLeftDown = keyLeftDown;
		this.keyRightUp = keyRightUp;
		this.keyHoldBall = keyHoldBall;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);		
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public char getKeyLeftDown() {
		return keyLeftDown;
	}

	public void setKeyLeftDown(char keyLeftDown) {
		this.keyLeftDown = keyLeftDown;
	}

	public char getKeyRightUp() {
		return keyRightUp;
	}

	public void setKeyRightUp(char keyRightUp) {
		this.keyRightUp = keyRightUp;
	}

	public char getKeyHoldBall() {
		return keyHoldBall;
	}

	public void setKeyHoldBall(char keyHoldBall) {
		this.keyHoldBall = keyHoldBall;
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
