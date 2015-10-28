package game.core;

import java.util.ArrayList;

import game.components.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private char keyupright;
	private char keydownleft;
	private int keyuprightpress;
	private int keydownleftpress;
	
	private char motionAxis; // X is for Top and Bottom Players,  Y is for Side Players
	
	public Player(String name,char keyupright, char keydownleft, char motionAxis) {
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		this.keydownleft=keydownleft;
		this.keyupright=keyupright;
		this.keyuprightpress=0;
		this.keydownleft=0;
		this.motionAxis = motionAxis;
		this.paddle= new Paddle()
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
	
	public char getMotionAxis() {
		return motionAxis;
	}

	public void setMotionAxis(char axis) {
		this.motionAxis = axis;
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
	
	public void movePaddle() {
		try {
			paddle.move(motionAxis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enlargePaddle(int amount) throws Exception {
		if (amount < 0)
			throw new Exception("Cannot have Negative Shrink!");
		
		switch(motionAxis) {
		case 'X':
		case 'x':
			paddle.setLength(paddle.getLength()+amount);
			break;
		case 'y':
		case 'Y':
			paddle.setHeight(paddle.getHeight()+amount);
			break;
		default:
			System.err.println("Something went wrong shrinking paddle");
			
		}
	}


	public void shrinkPaddle(int amount) throws Exception {
		if (amount >= paddle.getLength())
			throw new Exception("Shrink size is larger than Paddle length!");
		if (amount < 0)
			throw new Exception("Cannot have negative Shrink!");
		
		switch(motionAxis) {
		case 'X':
		case 'x':
			paddle.setLength(paddle.getLength()-amount);
			break;
		case 'y':
		case 'Y':
			paddle.setHeight(paddle.getHeight()-amount);
			break;
		default:
			System.err.println("Something went wrong shrinking paddle");
			
		}
	}
}
