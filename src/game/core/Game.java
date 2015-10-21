package game.core;

import java.util.ArrayList;

public abstract class Game {
	
	private ArrayList<Player> playerArr;
	private ArrayList<Ball> ballArr;
	
	public Game(ArrayList<Player> players, ArrayList<Ball> balls) {
		//TODO Add more robust validation of parameters
		this.playerArr = players;
		this.ballArr = balls;
	}
	
	public Game(int nPlayers, int nBalls) {		
		this.playerArr = new ArrayList<Player>();
		this.ballArr = new ArrayList<Ball>();
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
	
	public abstract void update();
}
