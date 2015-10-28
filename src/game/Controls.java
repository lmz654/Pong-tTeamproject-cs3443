package game;

import game.core.Paddle;
import game.math.Vector;

// Class that contains all of the control variables for the Game
public class Controls {
	
	// Control Variables for Obstacle Probabilities
	public static final double NORMALOBSTACLE_PROBABILITY = .4;
	public static final double WHACKYOBSTACLE_PROBABILITY = .05;
	public static final double MOVINGOBSTACLE_PROBABILITY = .2;
	
	// Control Variables for Model
	public static final int MODEL_WIDTH = 0;
	public static final int MODEL_HEIGHT = 0;
	
	// Control Variables for Paddles
	public static final int X_OFST = 0;
	public static final int Y_OFST= 0;
	public static final int PADDLE_LENGTH = 100;
	public static final int PADDLE_WIDTH = 5;
	
	
	public static Paddle getPaddle(int player) {
		Paddle paddle;
		switch(player) {
		case 1:
			paddle = new Paddle(new Vector(0 + X_OFST, MODEL_HEIGHT/2), PADDLE_WIDTH, PADDLE_LENGTH);
			break;
		case 2:
			paddle = new Paddle(new Vector(MODEL_WIDTH - X_OFST, MODEL_HEIGHT/2), PADDLE_WIDTH, PADDLE_LENGTH);
			break;
		case 3:
			paddle = new Paddle(new Vector(MODEL_WIDTH/2, 0 + Y_OFST), PADDLE_LENGTH, PADDLE_WIDTH);
			break;
		case 4:
			paddle = new Paddle(new Vector(MODEL_WIDTH/2, MODEL_HEIGHT - Y_OFST), PADDLE_LENGTH, PADDLE_WIDTH);
			break;
		default:
			paddle = null;
			break;
		}
		
		return paddle;
	}
	

}
