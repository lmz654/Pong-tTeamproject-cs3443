package MVC;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import game.Controls;
import game.Sound;
import game.components.item.Item;
import game.components.item.ItemAllBallSpeedup;
import game.components.item.ItemAllBallSplit;
import game.components.item.ItemPExtended;
import game.components.item.ItemPShrinked;
import game.components.item.ItemPSlower;
import game.components.item.ItemPfaster;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.Player;
import game.math.CollisionDetector;
import game.math.structures.Vector;

public class vbhitModel {
	private Sound gamesound;
	//0:allballspeedup, 1: allballsplit, 2:pextended, 3:pfaster, 4:pshrinked, 5:pslower
	private ArrayList<BufferedImage> itemimagelist;
	private ArrayList<Item>	item;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Player> player;
	private ArrayList<Ball> ball;
	private Timer timer;
	private BufferedImage defaultballimage;
	private vbhitController controller;
	private int gamestate;
	
	public vbhitModel() {
		super();
		gamesound = new Sound();
		this.item = new ArrayList<Item>();
		this.itemimagelist=new ArrayList<BufferedImage>();
		this.obstacle = new ArrayList<Obstacle>();
		this.ball = new ArrayList<Ball>();
		player= new ArrayList<Player>();
		this.gamestate=Controls.GAME_STOP;
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vbhitModel.this.update();
			}
			
		};
		this.loadItemImage();
		try {
			defaultballimage = ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball.png"));
		} catch (IOException e) {
			System.err.println("defautballimage input is fail in vbhitModel");
		}
		this.createdefaultplayer();
		//this.createball();
		timer = new Timer(Controls.MODEL_TIME, action);
	}
	
	public Sound getGameSound(){
		return this.gamesound;
	}
	
	public void resetgame(){
		this.ball.clear();
		for(Player pl:this.player){
			pl.resetPlayer();
		}
		//this.player.clear();
		//this.createdefaultplayer();
	}
	
	public int getGameState(){
		return this.gamestate;
	}
	
	public void setGameState(int state){
		this.gamestate=state;
	}
	public void addController (vbhitController controller){
		this.controller=controller;
	}
	
	public void setPlayerStatus(int player,int status){
		this.player.get(player).setPlayerstatus(status);;
	}
	public void loadItemImage(){
		try {
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\ball_speed_inc.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\num_balls_inc.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\paddle_longer_alpha.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\fire_ball.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\paddle_shorter.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups\\ice_ball.png")));
			
		} catch (IOException e) {
			System.err.println("Itemimage input is fail loadItemImage in vbhitModel");
		}
	}
	public void CreatRandomItem(){
		Point point= new Point();
		point.setLocation(200+Math.random()*600, 200+Math.random()*600);
		int itemtype= Math.round((float)Math.round(Math.random()*5));
		System.out.print(itemtype + "  ");
		switch (itemtype){
		case 0:
			this.item.add(new ItemAllBallSpeedup(point,this.itemimagelist.get(0),this));
			break;
		case 1:
			this.item.add(new ItemAllBallSplit(point,this.itemimagelist.get(1),this));
			break;
		case 2:
			this.item.add(new ItemPExtended(point,this.itemimagelist.get(2),this));
			break;
		case 3:
			this.item.add(new ItemPfaster(point,this.itemimagelist.get(3),this));
			break;
		case 4:
			this.item.add(new ItemPShrinked(point,this.itemimagelist.get(4),this));
			break;
		case 5:
			this.item.add(new ItemPSlower(point,this.itemimagelist.get(5),this));
			break;
			
		}
	}
	
	public void createCoresponseBall(Player player){
		try {
			Ball b;
			ArrayList<Ball> temp = new ArrayList<Ball>();
			for(Ball ball:this.ball){
				b=ball.clone();
				b.setVelocity(Vector.getRand(new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}, 
								   new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}));
				b.setLastHit(player);
				b.setimage(player.getBallimage().get(0));
				temp.add(b);
			}
			this.ball.addAll(temp);
		} catch (Exception e) {
			System.out.print("problem with clone ball in CreateCoresponseBall in model");
		}
	}
	public void createDefaultball(){
		Ball ball = Controls.getDefaultBall();
		ball.setimage(this.defaultballimage);
		this.ball.add(ball);
	}
	public void createdefaultplayer(){
			this.player.clear();
			this.player.add(0, Controls.player1default());
			this.player.add(1,Controls.player2default());
			this.player.add(2,Controls.player3default());
			this.player.add(3,Controls.player4default());
	}
	
	public void removeItem(Item out){
		item.remove(out);
	}
	
	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public ArrayList<Obstacle> getObstacle() {
		return obstacle;
	}

	public void setObstacle(ArrayList<Obstacle> obstacle) {
		this.obstacle = obstacle;
	}

	public ArrayList<Player> getAllPlayer() {
		return this.player;
	}
	public Player getPlayer(int index){
		return this.player.get(index);
	}
	/*public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}*/

	public ArrayList<Ball> getBall() {
		return this.ball;
	}

	public void setBall(ArrayList<Ball> ball) {
		this.ball = ball;
	}

	public void addItem(Item in){
		item.add(in);
	}
	
	public void removeObstacle(Obstacle out){
		obstacle.remove(out);
	}
	
	public void addObstacle(Obstacle in){
		obstacle.add(in);
	}
	
	public void removePlayer(Player out){
		player.remove(out);
	}
	
	public void addPlayer(Player in){
		player.add(in);
	}
	
	public void removeBall(Ball out){
		ball.remove(out);
	}
	
	public void addBall(Ball in){
		ball.add(in);
	}
	
	public void checkCollisions() {
		CollisionDetector.checkCollisions(this);
	}
	//update totally action  in the game
	public void update(){
		new Thread(new Runnable(){

			public void run() {
				for(Player p: player){
					if(p.getPlayerStatus()==Controls.PLAYER_PLAY){
						p.movePaddle();
					}
					
				}
				
			}
			
		}).start();
		
		this.moveBalls();
		
	}
	public void moveBalls() {
		if (Controls.MODEL_HEIGHT == 0) return;
		int posX, posY, radius;
		boolean remove = false;
		//this.controller.repaintall();
		//Collision collision;
		try{
			for (int i=0;i<this.ball.size();i++) {
				Ball b = ball.get(i);
				b.move();
				posX =(int)Math.round(b.getPosition().cartesian(0));
				posY = (int)Math.rint(b.getPosition().cartesian(1));
				radius = b.getRadius();
				
				
				// Check boundries
				// Checking X
				if (posX > (Controls.MODEL_WIDTH-radius) || posX < radius) {
					if((posY + radius< Controls.CONER_LENGTH) || (posY - b.getRadius()> Controls.MODEL_HEIGHT-Controls.CONER_LENGTH)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						//check the ball within paddle on leftside
					}else if(posX<radius && Math.abs(posY-this.player.get(0).getPaddle().getPosition().cartesian(1))<=(this.player.get(0).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(0));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
						//check the ball within paddle on rightside
					}else if(posX > (Controls.MODEL_WIDTH-radius) && Math.abs(posY-this.player.get(1).getPaddle().getPosition().cartesian(1))<=(this.player.get(1).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(1));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
					}else{// ball go out of the panel
						remove=true;
						if(posX<radius){
							this.player.get(0).increaseMiss();
							
						}else if(posX> (Controls.MODEL_WIDTH-radius)){
							this.player.get(1).increaseMiss();
						}
						try{
							if(b.getLastHit()!=null){
								b.getLastHit().increaseScore();
							}
						}catch(NullPointerException e){
							System.err.println("fail to increase score of 1");
						}
						
						;
						remove=true;
						
						
					}
				}
				//check Y
				if ((posY > (Controls.MODEL_HEIGHT -radius ) || posY <radius)&& remove==false) {
					if((posX + b.getRadius()< Controls.CONER_LENGTH) || (posX - b.getRadius()> Controls.MODEL_WIDTH-Controls.CONER_LENGTH)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						//check the ball within paddle on the top side
					}else if(posY<radius && Math.abs(posX-this.player.get(2).getPaddle().getPosition().cartesian(0))<=(this.player.get(2).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(2));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
						//check the ball within paddle on the bottom side
					}else if(posY>(Controls.MODEL_HEIGHT-radius) && Math.abs(posX-this.player.get(3).getPaddle().getPosition().cartesian(0))<=(this.player.get(3).getPaddle().getLength()/2+radius)){
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						b.setLastHit(player.get(3));
						b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
					}else{
						if(posY<radius){
							this.player.get(2).increaseMiss();
							
						}else if(posY> (Controls.MODEL_HEIGHT-radius)){
							this.player.get(3).increaseMiss();
						}
						try{
							if(b.getLastHit()!=null){
								b.getLastHit().increaseScore();
							}
						}catch(Exception e){
							System.err.println("fail to increase score of 2");
						}
						remove=true;
						
					}			
				}
				if(remove==true){
					this.gamesound.Explosion();
					this.ball.remove(b);
					this.createDefaultball();	
					this.controller.SidePanelRepaint();
					i--;
					remove=false;
				}
					
				
			}
			
		}catch(Exception e){
				//System.err.println("the ball pointer is " + e.getMessage());
		}
			
			/*
			 * Checking for Collisions
			 */
			//CollisionDetector.checkCollisions(this);
			
//			for (Ball c : balls) {
//				if (b.equals(c)) continue;
//				if (b.intersects(c)) {
//					collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//					System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//				}
//			}
			
			
		
		
	}
	public void start(){
		this.timer.start();
	}
	public void stop(){
		this.timer.stop();
	}
}
