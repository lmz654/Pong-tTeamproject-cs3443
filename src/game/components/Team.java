package game.components;

import java.util.ArrayList;

import game.core.player.Player;

public class Team {
	
	private ArrayList<Player> players;
	
	public Team(Player...players) {
		for (Player player : players)
			this.players.add(player);
	}
	
	public Team(ArrayList<Player> players) {
		this.players = players;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
}
