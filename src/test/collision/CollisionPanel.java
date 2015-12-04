package test.collision;

import java.awt.*;
import javax.swing.*;

import game.core.Ball;
import game.core.Paddle;

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
				
		for (Ball b : model.getBalls()) {
			this.fillBall(b, g);
			if (model.showPositionVectors)
				this.drawPositionVector(b, g);
			if (model.showVelocityVectors)
				this.drawVelocityVector(b, g);
			if (model.showProjections)
				this.drawProjections(b, g);
			if (model.showMoreInfo)
				this.fillBallInfo(b, g);
		}
		
		for (Paddle p: model.getPaddles()) {
			this.fillPaddle(p, g);
		}
		
		StringBuilder cT = new StringBuilder().append(model.collisionTime);
		StringBuilder mT = new StringBuilder().append(model.modelTime);
		StringBuilder rT = new StringBuilder().append(model.repaintTime);
		g.setColor(Color.BLACK);
		g.drawString(cT.toString(), 5, 15);
		g.drawString(mT.toString(), 5, 25);
		g.drawString(rT.toString(), 5, 35);
		
	}
	
	private void drawProjections(Ball b, Graphics g) {
		int prjWidth = b.getRadius()*2;
		int prjHeight = 3;
		
		// X Projection
		g.setColor(Color.RED);
		g.fillRect((int)b.getPosition().cartesian(0)-prjWidth/2, model.getHeight()-prjHeight, prjWidth, prjHeight);
		
		// Y Projection
		g.setColor(Color.BLUE);
		g.fillRect(0, (int)b.getPosition().cartesian(1)-prjWidth/2, prjHeight, prjWidth);
		
	}

	private void fillBall(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		int radius = ball.getRadius();
		
		g.setColor(Color.BLACK);
		g.fillOval(posX-radius, posY-radius, radius*2, radius*2);
	}
	
	private void fillPaddle(Paddle paddle, Graphics g) {
		int posX = (int)paddle.getPosition().cartesian(0);
		int posY = (int)paddle.getPosition().cartesian(1);
		int width = paddle.getLength();
		int height = paddle.getHeight();
		
		g.setColor(Color.RED);
		g.fillRect(posX-(width/2), posY-(height/2), width, height);
	}
	
	private void fillBallInfo(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		int radius = ball.getRadius();
		
		g.setColor(Color.BLACK);
		g.drawString("Pos:" + ball.getPosition().toString(), posX+10, posY-20);
		g.drawString("Vel:" +ball.getVelocity().toString(), posX+10, posY-10);
		g.drawString("Radius: " + radius, posX+10, posY);		
	}
	
	private void drawPositionVector(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		
		g.setColor(Color.BLUE);
		g.drawLine(0, 0, posX, posY);
		
	}
	
	private void drawVelocityVector(Ball ball, Graphics g) {
		int x1 = (int)ball.getPosition().cartesian(0);
		int y1 = (int)ball.getPosition().cartesian(1);
		int x2 = (int)ball.getPosition().plus(ball.getVelocity().times(10)).cartesian(0);
		int y2 = (int)ball.getPosition().plus(ball.getVelocity().times(10)).cartesian(1);
		
		g.setColor(Color.GREEN);
		g.drawLine(x1, y1, x2, y2);
	}
}


