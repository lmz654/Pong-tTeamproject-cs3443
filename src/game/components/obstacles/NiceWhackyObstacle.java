package game.components.obstacles;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.Controls;
import game.core.Ball;
import game.math.structures.Vector;

public class NiceWhackyObstacle extends Obstacle {
	
	private ArrayList<Ball> ball;

	public NiceWhackyObstacle(Point position, BufferedImage image, int timer) {
		super(position, image, timer);
		ball = new ArrayList<Ball>();
		// TODO Auto-generated constructor stub
	}
	public void checkballout(){
		for(int i=0;i<this.ball.size();i++){
			if(ball.get(i)!=null){
				if(Math.abs(ball.get(i).getPosition().cartesian(0)- super.getPosition().x)>Controls.WHACKY_OBSTACLE_WIDTH+ball.get(i).getRadius() ||
					Math.abs(ball.get(i).getPosition().cartesian(1)- super.getPosition().y)>Controls.WHACKY_OBSTACLE_HEIGHT+ball.get(i).getRadius()){
						ball.get(i).setInobstacle(null);
						ball.remove(i);
						i--;
				}
			}
		}
	}
	@Override
	public void Effect(Ball b) {
		try{
			for(int i=0;i<this.ball.size();i++){
				if(this.ball.get(i)!=null){
					if(ball.get(i).equals(b)){
						return;
					}
				}
			}
			b.setInobstacle(this);
			ball.add(b);
			b.setVelocity(Vector.getRand(Controls.BALL_MIN_SPEED, Controls.BALL_MAX_SPEED));
		}catch(Exception e){
			System.out.println("fail in effect in nicewhackyobstacle");
		}
	}
	

}
