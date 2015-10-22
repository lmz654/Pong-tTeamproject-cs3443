package game.core;

import java.util.ArrayList;

import game.components.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	
	private char motionAxis;
			
	public Player(String name, Paddle paddle, char axis) {
		super();
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		
		this.motionAxis = axis;
	}
	
	// Setters and Getters
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

	public ArrayList<Item> getItems() {
		return item;
	}
	
	public char getMotionAxis() {
		return motionAxis;
	}

	public void setMotionAxis(char axis) {
		this.motionAxis = axis;
	}
	
	// Action Methods

	public void addItem(Item i) {
		// TODO Item Validation
		this.item.add(i);
	}
	
	public void movePaddle() {
		try {
			paddle.move(motionAxis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shrinkPaddle(int amount) throws Exception {
		if (amount >= paddle.getLength())
			throw new Exception("Shrink size is larger than Paddle length!");
		if (amount < 0)
			throw new Exception("Cannot have negative Shrink!");
		
		paddle.setLength(paddle.getLength()-amount);
	}
	
	public void enlargePaddle(int amount) throws Exception {
		if (amount < 0)
			throw new Exception("Cannot have Negative Shrink!");
		
		paddle.setLength(paddle.getLength()+amount);
	}
	
	
}
