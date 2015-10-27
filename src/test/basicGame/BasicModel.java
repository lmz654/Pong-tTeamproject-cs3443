package test.basicGame;

import java.util.ArrayList;

import game.components.*;
import game.core.*;

public class BasicModel {

	// Properties of the Game stored in the Game Class
	private Game game;
	
	// Properties for Players and Balls Stored in 
	// Player and Ball Classes
	private ArrayList<Player> playerArr;
	private ArrayList<Ball> ballArr;
	
	// Panel Properties
	private int width, height;
	
	public BasicModel() {
		//Game Constructor for 2 players and 1 ball
		this.game = new FFAGame(2, 1);
		
		this.playerArr = this.game.getPlayers();
		this.ballArr = this.game.getBalls();
		
		this.width = 0;
		this.height = 0;
		
	}
	
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

}
