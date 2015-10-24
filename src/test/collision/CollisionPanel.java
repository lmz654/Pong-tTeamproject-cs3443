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
		}
	}
	
	private void fillBall(Ball ball, Graphics g) {
		int posX = (int)ball.getPosition().cartesian(0);
		int posY = (int)ball.getPosition().cartesian(1);
		int radius = ball.getRadius();
		
		g.drawString(ball.getPosition().toString(), posX, posY);
		
		g.fillOval(posX-radius, posY-radius, radius*2, radius*2);
	}
}


