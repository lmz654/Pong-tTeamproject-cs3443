package game;

import game.core.Ball;
import game.core.Paddle;
import game.core.Player;
import game.math.Vector;

// Class that contains all of the control variables for the Game
public class Controls {
	
	//time repeat for model and view
	public static final int MODEL_TIME=15;
	public static final int VIEW_TIME=24;
	
	// Control Variables for Obstacle Probabilities
	public static final double NORMALOBSTACLE_PROBABILITY = .4;
	public static final double WHACKYOBSTACLE_PROBABILITY = .05;
	public static final double MOVINGOBSTACLE_PROBABILITY = .2;
	
	// Control Variables for Model
	public static final int MODEL_WIDTH = 1000;
	public static final int MODEL_HEIGHT = 1000;
	
	// Control Variables for Paddles
	public static final int X_OFST = 0;
	public static final int Y_OFST= 0;
	public static final int PADDLE_LENGTH = 100;
	public static final int PADDLE_WIDTH = 10;
	
	// Control Variables for Ball
	public static final int BALL_MAX_SPEED = 10;
	public static final int BALL_MIN_SPEED = 5;
	public static final int BALL_DEFAULT_RADIUS = 30;
	
	// Control Variables for Collision Model
	public static final int SIM_NUM_BALLS = 10;
	public static final int SIM_BALL_MAX_SPEED = 10;
	public static final int SIM_BALL_MIN_SPEED = 5;
	public static final int SIM_BALL_DEFAULT_RADIUS = 10;
	
	//player 1 left, 2 right, 3 top, 4 bottom
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
	
	public static Ball getDefaultBall() {
		return new Ball(new Vector(MODEL_WIDTH/2, MODEL_HEIGHT/2), 
				Vector.getRand(new int[]{BALL_MAX_SPEED - BALL_MIN_SPEED, -BALL_MIN_SPEED}, 
							   new int[]{BALL_MAX_SPEED - BALL_MIN_SPEED, -BALL_MIN_SPEED}), BALL_DEFAULT_RADIUS);
	}
	public static Player player1default(){
		Paddle paddle = Controls.getPaddle(1);
		return new Player("Huu", paddle,'w','s','y');
	}
	public static Player player2default(){
		Paddle paddle = Controls.getPaddle(2);
		return new Player("Fernando", paddle,';','[','y');
	}
	public static Player player3default(){
		Paddle paddle = Controls.getPaddle(3);
		return new Player("Christian", paddle,'c','v','x');
	}
	public static Player player4default(){
		Paddle paddle = Controls.getPaddle(4);
		return new Player("Taylor", paddle,',','.','x');
	}

}
