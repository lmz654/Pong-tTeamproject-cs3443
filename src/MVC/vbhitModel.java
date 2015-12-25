package MVC;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
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
	private ArrayList<BufferedImage> shadowball;
	private ArrayList<BufferedImage> shadowball1;
	private ArrayList<BufferedImage> shadowball2;
	private ArrayList<BufferedImage> shadowball3;
	private ArrayList<BufferedImage> shadowball4;
	private BufferedImage explose;
	private LinkedList<Vector> ballgone;
	private Timer timer;
	private BufferedImage defaultballimage;
	private vbhitController controller;
	private int gamestate;
	private int itemcounttime, nwobstaclecounttime, cwobstaclecoundtime;
	private long gametimer;
	private ExecutorService ex;
	
	public vbhitModel() {
		super();
		
		this.ballgone = new LinkedList<Vector>();
		this.itemcounttime=Controls.TIME_ITEM_POP_UP/2;
		this.nwobstaclecounttime=Controls.TIME_OBSTACLE_POP_UP/3;
		this.cwobstaclecoundtime=Controls.TIME_OBSTACLE_POP_UP/4;
		gamesound = new Sound();
		this.obstacleimagelist = new ArrayList<BufferedImage>();
		this.item = new ArrayList<Item>();
		this.itemimagelist=new ArrayList<BufferedImage>();
		this.obstacle = new ArrayList<Obstacle>();
		this.ball = new ArrayList<Ball>();
		this.player= new ArrayList<Player>();
		this.gamestate=Controls.GAME_STOP;
		this.gametimer=Controls.GAME_TIMER_DEFAULT;
		this.shadowball=new ArrayList<BufferedImage>();
		this.shadowball1=new ArrayList<BufferedImage>();
		this.shadowball2=new ArrayList<BufferedImage>();
		this.shadowball3=new ArrayList<BufferedImage>();
		this.shadowball4=new ArrayList<BufferedImage>();
		try {
			this.explose= ImageIO.read(new File("src\\MVC\\imagecontainer\\explose\\exploseball.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("fail to load exploseballimage");
		}
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if(vbhitModel.this.gametimer>0){
					vbhitModel.this.gametimer-=Controls.MODEL_TIME;
				}else{
					vbhitModel.this.controller.GameEnd();
				}
				vbhitModel.this.update();
			}
			
		};
		this.loadItemImage();
		this.loadObstacleImage();
		try {
			BufferedImage shadowball;
			//this.shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\ball_shadow.png"));
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball6.png"));
			this.shadowball.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball5.png"));
			this.shadowball.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball4.png"));
			this.shadowball.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball3.png"));
			this.shadowball.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball2.png"));
			this.shadowball.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball1.png"));
			this.shadowball.add(shadowball);
			//shadow ball 1
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p116.png"));
			this.shadowball1.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p115.png"));
			this.shadowball1.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p114.png"));
			this.shadowball1.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p113.png"));
			this.shadowball1.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p112.png"));
			this.shadowball1.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p111.png"));
			this.shadowball1.add(shadowball);
			//shadow ball 2
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p216.png"));
			this.shadowball2.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p215.png"));
			this.shadowball2.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p214.png"));
			this.shadowball2.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p213.png"));
			this.shadowball2.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p212.png"));
			this.shadowball2.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p211.png"));
			this.shadowball2.add(shadowball);
			//shadowball3
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p316.png"));
			this.shadowball3.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p315.png"));
			this.shadowball3.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p314.png"));
			this.shadowball3.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p313.png"));
			this.shadowball3.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p312.png"));
			this.shadowball3.add(shadowball);
			shadowball= ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\p311.png"));
			this.shadowball3.add(shadowball);
			//this.shadowball1.add(shadowball);
			defaultballimage = ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\defaultball.png"));
		} catch (IOException e) {
			System.err.println("defautballimage input is fail in vbhitModel");
		}
		this.createdefaultplayer();
		//this.createball();
		timer = new Timer(Controls.MODEL_TIME, action);
	}
	public BufferedImage getExplose(){
		return this.explose;
	}
	public LinkedList<Vector> getBallGone(){
		return this.ballgone;
	}
	public ArrayList<BufferedImage> getShadowball(){
		return this.shadowball;
	}
	public int totalObject(){
		return this.ball.size()+this.player.size()+this.item.size()+this.obstacle.size();
	}
	public Sound getGameSound(){
		return this.gamesound;
	}
	
	public void resetgame(){
		this.ball.clear();
		this.obstacle.clear();
		this.item.clear();
		this.gametimer=Controls.GAME_TIMER_DEFAULT;
		for(Player pl:this.player){
			pl.resetPlayer();
		}
		//this.player.clear();
		//this.createdefaultplayer();
	}
	
	/*public BufferedImage getShadowball() {
		return shadowball;
	}
	public void setShadowball(BufferedImage shadowball) {
		this.shadowball = shadowball;
	}*/
	public long getGametimer() {
		return gametimer;
	}
	public void setGametimer(long gametimer) {
		this.gametimer = gametimer;
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
		p.setLocation(50+Math.random()*900, 50+Math.random()*900);
		this.obstacle.add(new NiceWhackyObstacle (p, this.obstacleimagelist.get(1),30));
	}
	public void CreatRandomCZWObstacle(){
		Point p= new Point();
		p.setLocation(50+Math.random()*900, 50+Math.random()*900);
		this.obstacle.add(new CrazyWhackyObstacle (p, this.obstacleimagelist.get(0),30));
	
	}
	public void CreatRandomItem(){
		Point point= new Point();
		point.setLocation(50+Math.random()*900, 50+Math.random()*900);
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
					b.setVelocity(Vector.getRand(Controls.BALL_MIN_SPEED+2,Controls.BALL_MAX_SPEED-5));
					if(player!=null){
						b.setLastHit(player);
						b.setimage(player.getBallimage().get(0));
						b.setShadowimage(player.getBallShaddow());
					}else{
						b.setimage(this.defaultballimage);
						b.setShadowimage(this.shadowball);
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
		ball.setShadowimage(this.shadowball);
		this.ball.add(ball);
	}
	public void createdefaultplayer(){
			this.player.clear();
			this.player.add(0, Controls.player1default());
			this.player.get(0).setBallShaddow(this.shadowball1);
			this.player.add(1,Controls.player2default());
			this.player.get(1).setBallShaddow(this.shadowball2);
			this.player.add(2,Controls.player3default());
			this.player.get(2).setBallShaddow(this.shadowball3);
			this.player.add(3,Controls.player4default());
			this.player.get(3).setBallShaddow(this.shadowball4);
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
		for(int z=0;z<this.ball.size();z++){
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
		ex = Executors.newCachedThreadPool();
		Thread thread;
		thread = new Thread(new Runnable(){

			public void run() {
				for(Player p: player){
					if(p.getPlayerStatus()==Controls.PLAYER_PLAY){
						p.movePaddle();
					}
					
				}
				
			}
			
		});
		ex.execute(thread);
		
		
		
		
		thread = new Thread(new Runnable(){

			public void run() {
				
				vbhitModel.this.BallsVelocityAdjust();
			}
			
		});
		ex.execute(thread);
		
		
		thread = new Thread(new Runnable(){

			public void run() {
				
				vbhitModel.this.MoveBall();
			}
			
		});
		ex.execute(thread);
		
		thread = new Thread(new Runnable(){
			
			public void run() {
				vbhitModel.this.cwobstaclecoundtime+=Controls.MODEL_TIME;
				vbhitModel.this.nwobstaclecounttime+=Controls.MODEL_TIME;
				
				if(vbhitModel.this.cwobstaclecoundtime>=Controls.TIME_OBSTACLE_POP_UP){
					vbhitModel.this.CreatRandomCZWObstacle();
					vbhitModel.this.cwobstaclecoundtime=0;
				}
				if(vbhitModel.this.nwobstaclecounttime>=Controls.TIME_OBSTACLE_POP_UP){
					vbhitModel.this.CreatRandomNWObstacle();
					vbhitModel.this.nwobstaclecounttime=0;
				}
				
				
				for(int i=0;i<vbhitModel.this.obstacle.size();i++){
					if(vbhitModel.this.obstacle.get(i)!=null){
						if(vbhitModel.this.obstacle.get(i).isLast()==false){
							vbhitModel.this.obstacle.remove(i);
							i--;
						}
					}
				}
				
				for(int i=0;i<vbhitModel.this.obstacle.size();i++){
					if(vbhitModel.this.obstacle.get(i)!=null && vbhitModel.this.obstacle.get(i) instanceof NiceWhackyObstacle){
						NiceWhackyObstacle t = (NiceWhackyObstacle) vbhitModel.this.obstacle.get(i);
						t.checkballout();
					}
				}
				vbhitModel.this.BallinWObstacle();
			}
			
		});
		ex.execute(thread);
		
		thread=new Thread(new Runnable(){

			public void run() {
				vbhitModel.this.itemcounttime+=Controls.MODEL_TIME;
				if(vbhitModel.this.itemcounttime>=Controls.TIME_ITEM_POP_UP){
					vbhitModel.this.CreatRandomItem();
					vbhitModel.this.itemcounttime=0;
				}
				vbhitModel.this.BallHitItem();
			}
			
		});
		ex.execute(thread);
		ex.shutdown();
		while(!ex.isTerminated()){}
		
		
			
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
			b.setShadowimage(player.getBallShaddow());
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
								this.ballgone.add(this.ball.get(i).getPosition());
								this.ball.remove(i);
								size--;
								if(this.ball.size()<8){
									this.createDefaultball();
								}	
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
								this.ballgone.add(this.ball.get(i).getPosition());
								this.ball.remove(i);
								if(this.ball.size()<8){
									this.createDefaultball();
								}	
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
								this.ballgone.add(this.ball.get(i).getPosition());
								this.ball.remove(i);
								size--;
								if(this.ball.size()<8){
									this.createDefaultball();
								}
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
								this.ballgone.add(this.ball.get(i).getPosition());
								this.ball.remove(i);
								size--;
								if(this.ball.size()<8){
									this.createDefaultball();
								}
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
