package MVC;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import game.components.obstacles.CrazyWhackyObstacle;
import game.components.obstacles.NiceWhackyObstacle;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.Player;
import game.math.CollisionDetector;
import game.math.structures.Vector;

public class vbhitModel {
	private Sound gamesound;
	//0:allballspeedup, 1: allballsplit, 2:pextended, 3:pfaster, 4:pshrinked, 5:pslower
	private ArrayList<BufferedImage> itemimagelist;
	private ArrayList<BufferedImage> obstacleimagelist;
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
		this.obstacleimagelist = new ArrayList<BufferedImage>();
		this.item = new ArrayList<Item>();
		this.itemimagelist=new ArrayList<BufferedImage>();
		this.obstacle = new ArrayList<Obstacle>();
		this.ball = new ArrayList<Ball>();
		this.player= new ArrayList<Player>();
		this.gamestate=Controls.GAME_STOP;
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				vbhitModel.this.update();
			}
			
		};
		this.loadItemImage();
		this.loadObstacleImage();
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
		this.player.get(player).setPlayerstatus(status);
	}
	public void loadObstacleImage(){
		try {
			this.obstacleimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\obstacle\\blackhole.png")));
			this.obstacleimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\obstacle\\nicewhacky.png")));
			
		} catch (IOException e) {
			System.err.println("ObstacleImage input is fail loadItemImage in vbhitModel");
		}
	}
	public void loadItemImage(){
		try {
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\ball_speed_inc_active.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\num_balls_inc_glow.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\paddle_longer_alpha_glow.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\fire_ball_glow.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\paddle_shorter_glow.png")));
			this.itemimagelist.add(ImageIO.read(new File("src\\MVC\\imagecontainer\\powerups_actives\\ice_ball_glow.png")));
			
		} catch (IOException e) {
			System.err.println("Itemimage input is fail loadItemImage in vbhitModel");
		}
	}
	public void CreatRandomNWObstacle(){
		Point p= new Point();
		p.setLocation(200+Math.random()*600, 200+Math.random()*600);
		this.obstacle.add(new NiceWhackyObstacle (p, this.obstacleimagelist.get(1),30));
	}
	public void CreatRandomCZWObstacle(){
		Point p= new Point();
		p.setLocation(200+Math.random()*600, 200+Math.random()*600);
		this.obstacle.add(new CrazyWhackyObstacle (p, this.obstacleimagelist.get(0),30));
	
	}
	public void CreatRandomItem(){
		Point point= new Point();
		point.setLocation(200+Math.random()*600, 200+Math.random()*600);
		int itemtype= new Random().nextInt(6);//Math.round((float)Math.round(Math.random()*5));
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
			int size=this.getBall().size();
			ArrayList<Ball> temp = new ArrayList<Ball>();
			for(int i=0;i<size;i++){
				//if(this.ball.get(i).getLastHit().equals(player)){
					b=ball.get(i).clone();
					b.setVelocity(Vector.getRand(new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}, 
									   new int[]{Controls.BALL_MAX_SPEED, -Controls.BALL_MIN_SPEED}));
					if(player!=null){
						b.setLastHit(player);
						b.setimage(player.getBallimage().get(0));
					}else{
						b.setimage(this.defaultballimage);
					}
					temp.add(b);
				//}
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
	public void BallHitItem (){
		Point b,i;
		int size = this.ball.size();
		for(int z=0;z<size;z++){
			if(ball.get(z)!=null){
				try{
					for(int t=0;t<this.item.size();t++){
						b=ball.get(z).getPosition().toPoint();
						i=this.item.get(t).getPoint();
						if((Math.abs(i.x- b.x)<=Controls.ITEM_WIDTH/2) &&
							(Math.abs(i.y- b.y)<=Controls.ITEM_HEIGTH/2)){
							//if(ball.getLastHit()!=null){
								this.item.get(t).effect(ball.get(z).getLastHit());
								this.item.remove(this.item.get(t));
								t--;
							//}
						}
								
					}
				}catch(Exception e){
					System.err.println("fail to remove item in BallHitItem vbhitmodel");
				}
			}
		}
	}
	public void BallinWObstacle(){
		Point b,i;
		int size = this.ball.size();
		for(int z=0;z<size;z++){
			if(ball.get(z)!=null){
				try{
					for(int t=0;t<this.obstacle.size();t++){
						b=ball.get(z).getPosition().toPoint();
						i=this.obstacle.get(t).getPosition();
						if((Math.abs(i.x- b.x)<=Controls.WHACKY_OBSTACLE_WIDTH/2) &&
							(Math.abs(i.y- b.y)<=Controls.WHACKY_OBSTACLE_HEIGHT/2)){
							//if(ball.getLastHit()!=null){
								this.obstacle.get(t).Effect(this.ball.get(z));
							//}
						}
								
					}
				}catch(Exception e){
					System.err.println("fail to effect item in ballinwobstacle vbhitmodel");
				}
			}
		}
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
		
		vbhitModel.this.BallsVelocityAdjust();
		
		new Thread(new Runnable(){

			public void run() {
				
				vbhitModel.this.MoveBall();
			}
			
		}).start();
		new Thread(new Runnable(){

			public void run() {
				for(int i=0;i<vbhitModel.this.obstacle.size();i++){
					if(vbhitModel.this.obstacle.get(i)!=null && vbhitModel.this.obstacle.get(i) instanceof NiceWhackyObstacle){
						NiceWhackyObstacle t = (NiceWhackyObstacle) vbhitModel.this.obstacle.get(i);
						t.checkballout();
					}
				}
				vbhitModel.this.BallinWObstacle();
			}
			
		}).start();
		/*new Thread(new Runnable(){

			public void run() {
				
				vbhitModel.this.BallinWObstacle();
			}
			
		}).start();*/
		
		new Thread(new Runnable(){

			public void run() {
				
				vbhitModel.this.BallHitItem();
			}
			
		}).start();
		
		
			
	}
	public void MoveBall(){
		
		for(int i=0;i<this.ball.size();i++){
			if(this.ball.get(i)!=null && this.ball.get(i).getHolded()==null){
				this.ball.get(i).move();
			}
		}
	}
	public void SpecialVelocityAdjust(Ball b, Player p, int axis){
		double percent;
		double vlength;
		double degree;//in pi
		double x,y;
		if(axis==1){
			vlength=b.getVelocity().magnitude();
			percent=Math.abs((p.getPaddle().getPosition().cartesian(1)-b.getPosition().cartesian(1))/p.getPaddle().getLength()*2);
			if(percent>0.9){
				percent=0.9;
			}
			
			if(b.getVelocity().cartesian(0)<0){//left side
				if(b.getPosition().cartesian(1)>=p.getPaddle().getPosition().cartesian(1)){//ball>=paddle
					if(b.getVelocity().cartesian(1)>0){//y>0
						y=vlength-b.getVelocity().cartesian(1);
						y=b.getVelocity().cartesian(1)+y*percent;
						x=Math.sqrt(vlength*vlength - y*y);
						if(x<0.5){
							x=0.5;
							y=Math.sqrt(vlength*vlength-x*x);
						}
						
						
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(1)<=0){//y=<0
						y=vlength*percent + b.getVelocity().cartesian(1);
						//y=y+b.getVelocity().cartesian(1);
						x=Math.sqrt(vlength*vlength - y*y);
						if(x<0.5){
							x=0.5;
							y=Math.sqrt(vlength*vlength-x*x);
						}
							b.setVelocity(new Vector(x,y));
					}
				}else if(b.getPosition().cartesian(1)<p.getPaddle().getPosition().cartesian(1)){//ball<paddle
					if(b.getVelocity().cartesian(1)>=0){//y>0
						y=b.getVelocity().cartesian(1)-vlength*percent;
						x=Math.sqrt(vlength*vlength - y*y);
						if(x<0.5){
							x=0.5;
							y=-Math.sqrt(vlength*vlength - x*x);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(1)<0){//y<0
						y=vlength + b.getVelocity().cartesian(1);
						y= b.getVelocity().cartesian(1) - y*percent;
						x=Math.sqrt(vlength*vlength - y*y);
						if(x<0.5){
							x=0.5;
							y=-Math.sqrt(vlength*vlength - x*x);
						}
						b.setVelocity(new Vector(x,y));
					}
				}
			}else if(b.getVelocity().cartesian(0)>0){//right side
				if(b.getPosition().cartesian(1)>=p.getPaddle().getPosition().cartesian(1)){//ball>paddle
					if(b.getVelocity().cartesian(1)>0){//y>0
						y=vlength-b.getVelocity().cartesian(1);
						y=b.getVelocity().cartesian(1) + y*percent;
						x=-Math.sqrt(vlength*vlength - y*y);
						if(x>-0.5){
							x=-0.5;
							y=Math.sqrt(vlength*vlength -x*x);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(1)<=0){//y<0
						y=vlength*percent + b.getVelocity().cartesian(1);
						x = -Math.sqrt(vlength*vlength - y*y);
						if(x>-0.5){
							x=-0.5;
							y=-Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}
				}else if(b.getPosition().cartesian(1)<p.getPaddle().getPosition().cartesian(1)){//ball<paddle
					if(b.getVelocity().cartesian(1)>=0){//y>0
						
						y=b.getVelocity().cartesian(1)-vlength*percent;
						x = -Math.sqrt(vlength*vlength - y*y);
						if(x>-0.5){
							x=-0.5;
							y=-Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
						
					}else if(b.getVelocity().cartesian(1)<0){//y<0
						
						y=vlength+b.getVelocity().cartesian(1);
						y=b.getVelocity().cartesian(1) - y*percent;
						x=-Math.sqrt(vlength*vlength - y*y);
						if(x>-0.5){
							x=-0.5;
							y=Math.sqrt(vlength*vlength -x*x);
						}
						b.setVelocity(new Vector(x,y));
					}
				}
			}
		}else if(axis==2){
			vlength=b.getVelocity().magnitude();
			percent=Math.abs((p.getPaddle().getPosition().cartesian(0)-b.getPosition().cartesian(0))/p.getPaddle().getLength()*2);
			if(percent>0.9){
				percent=0.9;
			}
			if(b.getVelocity().cartesian(1)<0){//top player
				if(b.getPosition().cartesian(0) >= p.getPaddle().getPosition().cartesian(0)){//right
					if(b.getVelocity().cartesian(0)>0){//x>0
						x=vlength-b.getVelocity().cartesian(0);
						x=b.getVelocity().cartesian(0)+x*percent;
						y=Math.sqrt(vlength*vlength - x*x);
						if(y<=0.5){
							y=0.5;
							x=Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(0)<=0){//x<0
						x=vlength*percent+b.getVelocity().cartesian(0);
						y= Math.sqrt(vlength*vlength - x*x);
						if(y<=0.5){
							y=0.5;
							x=Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}
				}else if(b.getPosition().cartesian(0) < p.getPaddle().getPosition().cartesian(0)){//left
					if(b.getVelocity().cartesian(0)>=0){//x>0
						x=b.getVelocity().cartesian(0)-vlength*percent;
						y= Math.sqrt(vlength*vlength - x*x);
						if(y<=0.5){
							y=0.5;
							x=-Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(0)<0){//x<0
						x=vlength+b.getVelocity().cartesian(0);
						x=b.getVelocity().cartesian(0)-x*percent;
						y=Math.sqrt(vlength*vlength - x*x);
						if(y<=0.5){
							y=0.5;
							x=-Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}
				}
				
			}else if(b.getVelocity().cartesian(1)>0){//bottom player
				System.out.println("get bottom");
				if(b.getPosition().cartesian(0) >= p.getPaddle().getPosition().cartesian(0)){//right
					if(b.getVelocity().cartesian(0)>0){//x>0
						x=vlength-b.getVelocity().cartesian(0);
						x=b.getVelocity().cartesian(0) + x*percent;
						y = -Math.sqrt(vlength*vlength - x*x);
						if(y>-0.5){
							y=-0.5;
							x=Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(0)<=0){//x<0
						x=b.getVelocity().cartesian(0) + vlength*percent;
						y=-Math.sqrt(vlength*vlength - x*x);
						if(y>-0.5){
							y=-0.5;
							x=Math.sqrt(vlength*vlength -y*y);
						}
						b.setVelocity(new Vector(x,y));
					}
				}else if(b.getPosition().cartesian(0) < p.getPaddle().getPosition().cartesian(0)){//left
					
					if(b.getVelocity().cartesian(0)>=0){//x>0
						x= b.getVelocity().cartesian(0) - vlength*percent;
						y=-Math.sqrt(vlength*vlength - x*x);
						if(y>-0.5){
							y=-0.5;
							x=-Math.sqrt(vlength*vlength -y*y);
						}
						b.setVelocity(new Vector(x,y));
					}else if(b.getVelocity().cartesian(0)<=0){//x<0
						x=vlength+b.getVelocity().cartesian(0);
						x=b.getVelocity().cartesian(0)-x*percent;
						y=-Math.sqrt(vlength*vlength - x*x);
						if(y>-0.5){
							y=-0.5;
							x=-Math.sqrt(vlength*vlength - y*y);
						}
						b.setVelocity(new Vector(x,y));
					}
				}
			}
		}
		
		
	}
	public void BHPVelocityAdjust(Player player, Ball b,int axis /*1 : y,2 :x*/){
		
		if(player.getPlayerStatus()==Controls.PLAYER_PLAY){
			
			b.setLastHit(player);
			b.setimage(b.getLastHit().getBallimage().get(0));//change image of the ball to player who hit the ball
			
			if(player.isKeyholepress()==true && player.getBallholded()==null){
				
				player.setBallholded(b);
				b.setHolded(player);
			
			}else{//adjust velocity vector in special way
				if(axis==1){
					this.SpecialVelocityAdjust(b, player, axis);
					//b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
				}else if(axis ==2){
					this.SpecialVelocityAdjust(b, player, axis);
					//b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
				}
			}
		}else{//adjust velocity in normal way
			if(axis==1){
				b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
			}else if(axis ==2){
				b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
			}
			
		}
	}
	
	public void BallsVelocityAdjust() {
		
		if (Controls.MODEL_HEIGHT == 0) return;
		int posX, posY;
		int size=this.ball.size();
		//Collision collision;
		try{
			for (int i=0;i<size;i++) {
				Ball b = ball.get(i);
				//ball not null and no player is holding ball
				if(b!=null&& b.getHolded()==null){	
					posX =(int)Math.round(b.getPosition().cartesian(0));
					posY = (int)Math.rint(b.getPosition().cartesian(1));
					//radius = b.getRadius();
					//hit x limit
					
					if(posX<0 && b.getVelocity().cartesian(0)<=0 &&(
						(posY + b.getRadius()< Controls.CONER_LENGTH ||posY - b.getRadius()> Controls.MODEL_HEIGHT-Controls.CONER_LENGTH) ||
						(this.player.get(0).getPlayerStatus()!=Controls.PLAYER_PLAY  ))){
						//adjust velocity vector in normal way
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
					}else if(posX > Controls.MODEL_WIDTH && b.getVelocity().cartesian(0)>0 && (
						(posY + b.getRadius()< Controls.CONER_LENGTH ||posY - b.getRadius()> Controls.MODEL_HEIGHT-Controls.CONER_LENGTH) ||
						(this.player.get(1).getPlayerStatus()!=Controls.PLAYER_PLAY) )){
						//adjust velocity vector in normal way
						b.setVelocity(new Vector(-1*b.getVelocity().cartesian(0), b.getVelocity().cartesian(1)));
					}
						//hit y limit		
					else if(posY <0 && b.getVelocity().cartesian(1)<=0 &&((posX + b.getRadius()< Controls.CONER_LENGTH || 
							posX - b.getRadius()> Controls.MODEL_WIDTH-Controls.CONER_LENGTH)|| 
							(this.player.get(2).getPlayerStatus()!=Controls.PLAYER_PLAY)  )){
						//adjust velocity vector in normal way						
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
					}else if(posY > Controls.MODEL_HEIGHT && b.getVelocity().cartesian(1)>0 && ((posX + b.getRadius()< Controls.CONER_LENGTH || 
							posX - b.getRadius()> Controls.MODEL_WIDTH-Controls.CONER_LENGTH)|| 
							(this.player.get(3).getPlayerStatus()!=Controls.PLAYER_PLAY) )){
						//adjust velocity vector in normal way						
						b.setVelocity(new Vector(b.getVelocity().cartesian(0), -1*b.getVelocity().cartesian(1)));
						// Checking the ball within paddle on leftside
					}else if(posX<b.getRadius() && b.getVelocity().cartesian(0)<0 && 
							this.player.get(0).getPlayerStatus()==Controls.PLAYER_PLAY &&
							Math.abs(posY-this.player.get(0).getPaddle().getPosition().cartesian(1))<=
							(this.player.get(0).getPaddle().getLength()/2+b.getRadius())){
						
						this.BHPVelocityAdjust(this.player.get(0), b,1);	
					//check the ball within paddle on rightside
					}else if(posX > (Controls.MODEL_WIDTH-b.getRadius()) && b.getVelocity().cartesian(0)>0&&
							this.player.get(1).getPlayerStatus()==Controls.PLAYER_PLAY &&
							Math.abs(posY-this.player.get(1).getPaddle().getPosition().cartesian(1))<=
							(this.player.get(1).getPaddle().getLength()/2+b.getRadius())){
						
						this.BHPVelocityAdjust(this.player.get(1), b,1);
					//check the ball within paddle on top
					}else if(posY<b.getRadius() && b.getVelocity().cartesian(1)<0 &&
							this.player.get(2).getPlayerStatus()==Controls.PLAYER_PLAY &&
							Math.abs(posX-this.player.get(2).getPaddle().getPosition().cartesian(0))<=
						(this.player.get(2).getPaddle().getLength()/2+b.getRadius())){
					
						this.BHPVelocityAdjust(this.player.get(2), b,2);
					//check the ball within paddle on bottom	
					}else if(posY>(Controls.MODEL_HEIGHT-b.getRadius()) && b.getVelocity().cartesian(1)>0 &&
							this.player.get(3).getPlayerStatus()==Controls.PLAYER_PLAY &&
							Math.abs(posX-this.player.get(3).getPaddle().getPosition().cartesian(0))<=
							(this.player.get(3).getPaddle().getLength()/2+b.getRadius())){
					
						this.BHPVelocityAdjust(this.player.get(3), b,2);
					
					}else{// ball go out of the panel
						//increase player score
						
						
						if(posX<0 && b.getVelocity().cartesian(0)<0){
							if(b.getLastHit()!=null && b.getLastHit().equals(this.player.get(0))==false){
								
								b.getLastHit().increaseScore();
							}
							this.player.get(0).increaseMiss();
							try{
								this.gamesound.Explosion();
								this.ball.remove(i);
								size--;
								this.createDefaultball();	
								this.controller.SidePanelRepaint();
								
							}catch(Exception e){
								System.err.println("fail to remove ball in ballvelocityadjust");
							}
							
						}else if(posX> (Controls.MODEL_WIDTH) && b.getVelocity().cartesian(0)>0){
							if(b.getLastHit()!=null && b.getLastHit().equals(this.player.get(1))==false){
								
								b.getLastHit().increaseScore();
							}
							this.player.get(1).increaseMiss();
							try{
								this.gamesound.Explosion();
								this.ball.remove(i);
								this.createDefaultball();	
								this.controller.SidePanelRepaint();
								size--;
							}catch(Exception e){
								System.err.println("fail to remove ball in ballvelocityadjust");
							}
						
						}else if(posY<0 && b.getVelocity().cartesian(1)<0){
							if(b.getLastHit()!=null && b.getLastHit().equals(this.player.get(2))==false){
								
								b.getLastHit().increaseScore();
							}
							this.player.get(2).increaseMiss();
							try{
								this.gamesound.Explosion();
								this.ball.remove(i);
								size--;
								this.createDefaultball();	
								this.controller.SidePanelRepaint();
								
							}catch(Exception e){
								System.err.println("fail to remove ball in ballvelocityadjust");
							}
							
						}else if(posY>Controls.MODEL_HEIGHT && b.getVelocity().cartesian(1)>0){
							if(b.getLastHit()!=null && b.getLastHit().equals(this.player.get(3))==false){
								
								b.getLastHit().increaseScore();
							}
							this.player.get(3).increaseMiss();
							try{
								this.gamesound.Explosion();
								this.ball.remove(i);
								size--;
								this.createDefaultball();	
								this.controller.SidePanelRepaint();
								
							}catch(Exception e){
								System.err.println("fail to remove ball in ballvelocityadjust");
							}
						}		
					}
				}	
			}					
		}catch(Exception e){
			System.err.println("the ball pointer is " + e.getMessage());
		}
		/*
		 * Checking for Collisions
		 */
		//CollisionDetector.checkCollisions(this);
		
//		for (Ball c : balls) {
//			if (b.equals(c)) continue;
//			if (b.intersects(c)) {
//				collision = new Collision(new CollidableCircle(b), new CollidableCircle(c));
//				System.out.println(b.getPosition().toString() + ":" + c.getPosition().toString() + "@" + collision.getCollisionPoint().toString());
//			}
//		}
	}
					
			
		
			
			
		
		
	
	public void start(){
		this.timer.start();
	}
	public void stop(){
		this.timer.stop();
	}
}
