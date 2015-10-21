package game.core;

import java.util.ArrayList;

public class Game {
	private ArrayList<Player> players;
	private ArrayList<Ball> balls;
	
	public Game(ArrayList<Player> players, ArrayList<Ball> balls) {
		//TODO Add more robust validation of parameters
		this.players = players;
		this.balls = balls;
	}

}
