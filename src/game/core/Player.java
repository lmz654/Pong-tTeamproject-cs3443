package game.core;

import java.util.ArrayList;

import game.components.item.Item;

public class Player {
	
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private char keydecrease;
	private char keyincrease;
	private int keydecreasepress;
	private int keyincreasepress;
	
	private char motionAxis; // X is for Top and Bottom Players,  Y is for Side Players
	
	public Player(String name, Paddle paddle,char keydecrease, char keyincrease, char motionAxis) {
		this.name = name;
		this.paddle = paddle;
		this.item = new ArrayList<Item>();
		this.score = new Score(0,0);
		this.keydecrease=keydecrease;
		this.keyincrease=keyincrease;
		this.keyincreasepress=0;
		this.keydecreasepress=0;
		this.motionAxis = motionAxis;
		this.paddle = paddle;
	}
	
	public char getKeyincrease() {
		return keyincrease;
	}

	public void setKeyincrease(char keyincrease) {
		this.keyincrease = keyincrease;
	}

	public char getKeydecrease() {
		return keydecrease;
	}

	public void setkeydecrease(char keydecrease) {
		this.keydecrease = keydecrease;
	}

	public int getkeydecreasepress() {
		return keydecreasepress;
	}

	public void setkeydecreasepress(int keydecreasepress) {
		this.keydecreasepress = keydecreasepress;
	}

	public int getKeyincreasepress() {
		return keyincreasepress;
	}
	
	public void setKeyincreasepress(int keyincreasepress) {
		this.keyincreasepress = keyincreasepress;
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
			System.out.println(keyincreasepress + "  " + keydecreasepress);
			if(this.keyincreasepress==0 && this.keydecreasepress==1){
				paddle.move(motionAxis,-1);
			}else if(this.keyincreasepress==1 && this.keydecreasepress==0){
				paddle.move(motionAxis,1);
			}
			
		} catch (Exception e) {
			// TODO Figure out how to handle movePaddle Error
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
