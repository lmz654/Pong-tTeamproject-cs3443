package test.collision;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollisionView extends JFrame {
	private CollisionModel model;
	private CollisionPanel ballPanel;

	public CollisionView(CollisionModel model) {
		super("Ball Tester");
		this.model = model;
		
		ballPanel = new CollisionPanel(model, this);
		add(ballPanel, BorderLayout.CENTER);
		//ballPanel.
	}

	public void repaint() {
		// TODO Auto-generated method stub
		
	}

}
