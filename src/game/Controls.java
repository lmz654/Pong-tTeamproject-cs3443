package game;


import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import game.core.Ball;
import game.core.Paddle;
import game.core.Player;
import game.math.structures.Vector;

// Class that contains all of the control variables for the Game
public class Controls {
	//game fonts default
	public static final Font LARGE_FONT_DEFAULT  = new Font("American Typewriter", Font.BOLD, 30);
	public static final Font MID_FONT_DEFAULT  = new Font("American Typewriter", Font.BOLD, 20);
	public static final Font SMALL_FONT_DEFAULT  = new Font("American Typewriter", Font.BOLD, 10);
		
	//game status
	public static final int GAME_STOP=0;
	public static final int GAME_PAUSE=1;
	public static final int GAME_PLAY=2;
	
	//player status
	public static final int PLAYER_PLAY=2;
	public static final int PLAYER_NOT_PLAY=0;
	public static final int PLAYER_GIVE_UP=1;
	
	//time repeat for model and view
	public static final int MODEL_TIME=20;
	public static final int VIEW_TIME=20;
	
	//Player1 key default
	public static final char P1_KEY_INCREASE='s';
	public static final char P1_KEY_DECREASE='w';
	public static final char P1_KEY_HOLE='q';
	
	//Player2 key default
	public static final char P2_KEY_INCREASE=';';
	public static final char P2_KEY_DECREASE='[';
	public static final char P2_KEY_HOLE=']';
	
	//Player3 key default
	public static final char P3_KEY_INCREASE='c';
	public static final char P3_KEY_DECREASE='x';
	public static final char P3_KEY_HOLE='v';
	
	//Player4 key default
	public static final char P4_KEY_INCREASE='.';
	public static final char P4_KEY_DECREASE=',';
	public static final char P4_KEY_HOLE='M';
	
	// Control Variables for Obstacle Probabilities
	public static final double NORMALOBSTACLE_PROBABILITY = .4;
	public static final double WHACKYOBSTACLE_PROBABILITY = .05;
	public static final double MOVINGOBSTACLE_PROBABILITY = .2;
	
	// Control Variables for Model
	public static final int MODEL_WIDTH = 1000;
	public static final int MODEL_HEIGHT = MODEL_WIDTH;
	public static final int CONER_LENGTH=150;
	
	// Control Variables for Paddles
	public static final int X_OFST = 5;
	public static final int Y_OFST= 5;
	public static final int PADDLE_MAX_SPEED=15;
	public static final int PADDLE_MIN_SPEED=4;
	public static final int PADDLE_DEFAULT_LENGTH = 100;
	public static final int PADDLE_WIDTH = 10;
	public static final int PADDLE_VELOCITY=7;
	public static final int PADDLE_MAXREACH_LIMIT= MODEL_WIDTH-CONER_LENGTH;
	public static final int PADDLE_MINREACH_LIMIT=CONER_LENGTH;
	public static final int PADDLE_ACTIVE_MIN_LENGTH = 50;
	public static final int PADDLE_ACTIVE_MAX_LENGTH = 300;
	public static final int PADDLE_MAX_LENGTH = PADDLE_MAXREACH_LIMIT - PADDLE_MINREACH_LIMIT;
	
	// Control Variables for Ball
	public static final int BALL_MAX_SPEED = 12;
	public static final int BALL_MIN_SPEED = 3;
	public static final int BALL_NORMAL_SPEED=6;
	public static final int BALL_DEFAULT_RADIUS = 30;
	
	// Control Variables for Collision Model
	public static final int SIM_NUM_BALLS = 10; // qT Algorithm allows for 1000 no problem up to 1500 is where performance starts taking a hit 2000 is unplayable
	public static final int SIM_BALL_MAX_SPEED = 10;
	public static final int SIM_BALL_MIN_SPEED = 5;
	public static final int SIM_BALL_DEFAULT_RADIUS = 10;
	
	//player 1 left, 2 right, 3 top, 4 bottom
	public static Paddle getPaddle(int player) {
		Paddle paddle;
		switch(player) {
		case 0:
			paddle = new Paddle(new Vector(0 + X_OFST, MODEL_HEIGHT/2), Controls.MODEL_HEIGHT-(2*Controls.PADDLE_MINREACH_LIMIT), PADDLE_WIDTH);
			break;
		case 1:
			paddle = new Paddle(new Vector(MODEL_WIDTH - X_OFST, MODEL_HEIGHT/2), Controls.MODEL_HEIGHT-(2*Controls.PADDLE_MINREACH_LIMIT), PADDLE_WIDTH);
			break;
		case 2:
			paddle = new Paddle(new Vector(MODEL_WIDTH/2, 0 + Y_OFST), Controls.MODEL_WIDTH-(2*Controls.PADDLE_MINREACH_LIMIT), PADDLE_WIDTH);
			break;
		case 3:
			paddle = new Paddle(new Vector(MODEL_WIDTH/2, MODEL_HEIGHT - Y_OFST), Controls.MODEL_WIDTH-(2*Controls.PADDLE_MINREACH_LIMIT), PADDLE_WIDTH);
			break;
		default:
			paddle = null;
			break;
		}
		
		return paddle;
	}
	
	public static Ball getDefaultBall(){
		Ball ball = new Ball(new Vector(MODEL_WIDTH/2, MODEL_HEIGHT/2), 
				Vector.getRand(new int[]{BALL_MAX_SPEED, -BALL_MIN_SPEED}, 
							   new int[]{BALL_MAX_SPEED, -BALL_MIN_SPEED}), BALL_DEFAULT_RADIUS);
		return ball;
	}
	public static Player player1default(){
		Paddle paddle = Controls.getPaddle(0);
		Player player = new Player("Huu", paddle,Controls.P1_KEY_DECREASE,Controls.P1_KEY_INCREASE,Controls.P1_KEY_HOLE,'y');
		player.getScore().setScore(0);
		player.getScore().setMiss(0);
		player.setPlayernumber(0);
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p11.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p12.png")));
		} catch (IOException e) {
			System.out.println("p1 ballimage input fail");
		}
		try{
			player.addpaddleimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\paddle\\p1.png")));
			
		}catch(IOException e){
			System.err.println("P1 paddleinmage input fail");
		}
		return player;
	}
	public static Player player2default(){
		Paddle paddle = Controls.getPaddle(1);
		Player player = new Player("Fernando", paddle,Controls.P2_KEY_DECREASE,Controls.P2_KEY_INCREASE,Controls.P2_KEY_HOLE,'y');
		player.getScore().setScore(0);
		player.getScore().setMiss(0);
		player.setPlayernumber(1);
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p21.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p22.png")));
		} catch (IOException e) {
			System.out.println("p2 ballimage input fail");
		}
		try{
			player.addpaddleimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\paddle\\p2.png")));
			
		}catch(IOException e){
			System.err.println("P2 paddleinmage input fail");
		}
		
		return player;
	}
	public static Player player3default(){
		Paddle paddle = Controls.getPaddle(2);
		Player player = new Player("Taylor", paddle,Controls.P3_KEY_DECREASE,Controls.P3_KEY_INCREASE,Controls.P3_KEY_HOLE,'x');
		player.getScore().setScore(0);
		player.getScore().setMiss(0);
		player.setPlayernumber(2);
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p31.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p32.png")));
		} catch (IOException e) {
			System.out.println("p3 ballimage input fail");
		}
		try{
			player.addpaddleimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\paddle\\p3.png")));
			
		}catch(IOException e){
			System.err.println("P3 paddleinmage input fail");
		}
		return player;
	}
	public static Player player4default(){
		Paddle paddle = Controls.getPaddle(3);
		Player player = new Player("Christian", paddle,Controls.P4_KEY_DECREASE,Controls.P4_KEY_INCREASE,Controls.P4_KEY_HOLE,'x');
		player.getScore().setScore(0);
		player.getScore().setMiss(0);
		player.setPlayernumber(3);
		try {
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p41.png")));
			player.addBallimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p42.png")));
		} catch (IOException e) {
			System.out.println("p4 ballimage input fail");
		}
		try{
			player.addpaddleimage(ImageIO.read(new File("src\\MVC\\imagecontainer\\paddle\\p4.png")));
			
		}catch(IOException e){
			System.err.println("P4 paddleinmage input fail");
		}
		return player;
	}

}
