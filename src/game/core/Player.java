package game.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Controls;
import game.components.item.Item;

public class Player {
	private boolean activestatus;
	private String name;
	private Paddle paddle;
	private Score score;
	private ArrayList<Item> item;
	private char keydecrease;
	private char keyincrease;
	private int keydecreasepress;//the value is 0 or -1
	private int keyincreasepress;//the value is 0 or 1
	private ArrayList<BufferedImage> ballimage;
	private ArrayList<BufferedImage> paddleimage;
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
		this.ballimage = new ArrayList<BufferedImage>();
		this.paddleimage = new ArrayList<BufferedImage>();
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
	public ArrayList<BufferedImage> getBallimage() {
		return ballimage;
	}

	public void addBallimage(BufferedImage ballimage) {
		this.ballimage.add(ballimage);
	}
	public void setBallimage(ArrayList<BufferedImage> paddleimage){
		this.paddleimage=paddleimage;
	}

	public ArrayList<BufferedImage> getPaddleimage() {
		return paddleimage;
	}

	public void setPaddleimage(ArrayList<BufferedImage> paddleimage) {
		this.paddleimage = paddleimage;
	}
	public void addpaddleimage(BufferedImage paddleimage){
		this.paddleimage.add(paddleimage);
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
	public boolean isActivestatus() {
		return activestatus;
	}

	public void setActivestatus(boolean activestatus) {
		this.activestatus = activestatus;
		this.paddle.setLength(Controls.PADDLE_LENGTH);
	}
	
	public void movePaddle() {
		try {
				paddle.move(motionAxis,this.keydecreasepress+this.keyincreasepress);
			
		} catch (Exception e) {
			System.err.println("fail to movePaddle in player");
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
