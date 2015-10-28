package game.components.gamemode;

import java.util.ArrayList;

import game.core.Ball;
import game.core.Game;
import game.core.Player;

public class TeamGame extends Game {
	
	private ArrayList<Team> teamArr;
	
	public TeamGame(ArrayList<Player> players, ArrayList<Ball> balls, ArrayList<Team> teams) {
		super(players, balls);
		this.teamArr = teams;
		// TODO There has to be a better way to pass the parameters
	}

	public ArrayList<Team> getTeams() {
		return this.teamArr;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
