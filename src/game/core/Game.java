package game.core;

import java.util.ArrayList;

public abstract class Game {
	
	// ArrayList of Players in the Game
	private ArrayList<Player> playerArr;
	
	// ArrayList of Balls in the Game
	private ArrayList<Ball> ballArr;
	
	private boolean paused;
	
	public Game(ArrayList<Player> players, ArrayList<Ball> balls) {
		//TODO Add more robust validation of parameters
		this.playerArr = players;
		this.ballArr = balls;
		this.paused = false;
	}
	
	public Game(int nPlayers, int nBalls) {		
		this.playerArr = new ArrayList<Player>();
		this.ballArr = new ArrayList<Ball>();
		this.paused = false;
	}
	
	public ArrayList<Ball> getBalls() {
		return ballArr;
	}
	
	public ArrayList<Player> getPlayers() {
		return playerArr;
	}
	
	public void addBall(Ball b) {
		this.ballArr.add(b);
	}
	
	public boolean isPaused(){
		return this.paused;
	}
	
	public void pause() {
		this.paused = true;
	}
	
	public void unpause() {
		this.paused = false;
	}
	
	public abstract void update();
}
