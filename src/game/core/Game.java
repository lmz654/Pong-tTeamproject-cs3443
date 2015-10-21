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
	
	public ArrayList<Ball> getBalls() {
		return ballArr;
	}
	
	public ArrayList<Player> getPLayers() {
		return playerArr;
	}
	
	abstract void update();
}
