package vbhit;

public class Paddle {
	private double movepos;// the position of moving left right or up down
	private char playerpos;//the paddle of which player player 1 =1, player 2=2, player 3=3, player4=4
	private int length;
	private float speed;
	public Paddle(){
		
	}
	public double getMovepos() {
		return movepos;
	}
	public void setMovepos(double movepos) {
		this.movepos = movepos;
	}
	public char getPlayerpos() {
		return playerpos;
	}
	public void setPlayerpos(char playerpos) {
		this.playerpos = playerpos;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
