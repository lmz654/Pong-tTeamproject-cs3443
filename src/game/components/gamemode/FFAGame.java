package game.components.gamemode;

import java.util.ArrayList;

import game.core.Ball;
import game.core.Game;
import game.core.Player;

public class FFAGame extends Game {

	// TODO Need to figure out if we want to use a score/timer or health for the FFA Game Players
	
	public FFAGame(ArrayList<Player> players, ArrayList<Ball> balls) {
		super(players, balls);
		// TODO Auto-generated constructor stub
	}
	
	public FFAGame(int nPlayers, int nBalls) {
		super(nPlayers, nBalls);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
