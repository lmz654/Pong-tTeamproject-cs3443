package test.collision;

import java.awt.*;
import javax.swing.*;

import game.core.Ball;

@SuppressWarnings("serial")
public class CollisionPanel extends JPanel {
	private CollisionModel model;
	private CollisionView view;
	
	public CollisionPanel(CollisionModel model, CollisionView view) {
		this.model = model;
		this.view = view;
		
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);		
		for (Ball b : model.getBalls()) {
			this.fillBall(b, g);
			this.fillBallInfo(b, g);
		}
		
		g.setColor(Color.BLUE);
		for (Ball b : model.getBalls())
			this.drawPositionVector(b, g);
		
		g.setColor(Color.GREEN);
		for (Ball b : model.getBalls())
			this.drawVelocityVector(b, g);
	}
	
	private void fillBall(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		int radius = ball.getRadius();
		
		g.fillOval(posX-radius, posY-radius, radius*2, radius*2);
	}
	
	private void fillBallInfo(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		int radius = ball.getRadius();
		
		g.drawString("Pos:" + ball.getPosition().toString(), posX, posY);
		g.drawString("Vel:" +ball.getVelocity().toString(), posX, posY+10);
		
		
		
		
	}
	
	private void drawPositionVector(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		
		g.drawLine(0, 0, posX, posY);
		
	}
	
	private void drawVelocityVector(Ball ball, Graphics g) {
		int x1 = (int)ball.getPosition().cartesian(0);
		int y1 = (int)ball.getPosition().cartesian(1);
		int x2 = (int)ball.getPosition().plus(ball.getVelocity().times(10)).cartesian(0);
		int y2 = (int)ball.getPosition().plus(ball.getVelocity().times(10)).cartesian(1);
		
		g.drawLine(x1, y1, x2, y2);
	}
}


