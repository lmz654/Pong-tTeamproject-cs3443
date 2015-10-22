package game.components;

import java.util.ArrayList;

import game.core.Ball;
import game.core.Game;
import game.core.player.Player;

public class TimedGame extends Game {
	
	private final long timeLimit;

	public TimedGame(ArrayList<Player> players, ArrayList<Ball> balls, long timeLimit) {
		super(players, balls);
		
		this.timeLimit = timeLimit;
	}
	
	public long getTimeLimit() {
		return this.timeLimit;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
