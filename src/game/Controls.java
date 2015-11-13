package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import game.core.Ball;
import game.core.Paddle;
import game.core.Player;
import game.math.Vector;

// Class that contains all of the control variables for the Game
public class Controls {
	
	//time repeat for model and view
	public static final int MODEL_TIME=20;
	public static final int VIEW_TIME=20;
	
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
	public static final int PADDLE_VELOCITY=7;
	public static final int PADDLE_MAXREACH_LIMIT=900;
	public static final int PADDLE_MINREACH_LIMIT=100;
	
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
		Ball ball = new Ball(new Vector(MODEL_WIDTH/2, MODEL_HEIGHT/2), 
				Vector.getRand(new int[]{BALL_MAX_SPEED - BALL_MIN_SPEED, -BALL_MIN_SPEED}, 
							   new int[]{BALL_MAX_SPEED - BALL_MIN_SPEED, -BALL_MIN_SPEED}), BALL_DEFAULT_RADIUS);
		return ball;
	}
	public static Player player1default(){
		Paddle paddle = Controls.getPaddle(1);
		Player player = new Player("Huu", paddle,'w','s','y');
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p11.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p12.png")));
		} catch (IOException e) {
			System.out.println("p1 ballimage input fail");
		}
		return player;
	}
	public static Player player2default(){
		Paddle paddle = Controls.getPaddle(2);
		Player player = new Player("Fernando", paddle,'[',';','y');
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p21.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p22.png")));
		} catch (IOException e) {
			System.out.println("p2 ballimage input fail");
		}
		
		return player;
	}
	public static Player player3default(){
		Paddle paddle = Controls.getPaddle(3);
		Player player = new Player("Christian", paddle,'x','c','x');
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p31.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p32.png")));
		} catch (IOException e) {
			System.out.println("p3 ballimage input fail");
		}
		
		return player;
	}
	public static Player player4default(){
		Paddle paddle = Controls.getPaddle(4);
		Player player = new Player("Christian", paddle,',','.','x');
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p41.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p42.png")));
		} catch (IOException e) {
			System.out.println("p4 ballimage input fail");
		}
		
		return player;
	}

}
