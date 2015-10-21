package test.basicGame;

import java.util.ArrayList;

import game.components.*;
import game.core.*;

public class BasicModel {

	private Game game;
	private ArrayList<Player> playerArr;
	private ArrayList<Ball> ballArr;
	
	public BasicModel() {
		//Game Constructor for 2 players and 1 ball
		this.game = new FFAGame(2, 1);
		
		this.playerArr = this.game.getPlayers();
		this.ballArr = this.game.getBalls();
	}
}
