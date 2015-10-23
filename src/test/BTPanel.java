package test;

import java.awt.*;
import javax.swing.*;

import game.core.Ball;

public class BTPanel extends JPanel {
	private BTModel model;
	private BTView view;
	
	public BTPanel(BTModel model, BTView view) {
		this.model = model;
		this.view = view;
		
		this.setFocusable(true);
	}
	
	public void paintComponents(Graphics g) {
		g.setColor(Color.BLACK);
		
		//for (Ball b : model) {
			//fillBall(b, g);
		//}
	}
	
	private void fillBall(Ball ball, Graphics g) {
		g.fillOval((int)ball.getPosition().cartesian(0)-ball.getRadius(), 
				   (int)ball.getPosition().cartesian(1)-ball.getRadius(), 
				   ball.getRadius()*2, ball.getRadius()*2);
	}
}


