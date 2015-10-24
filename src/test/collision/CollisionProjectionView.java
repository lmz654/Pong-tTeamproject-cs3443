package test.collision;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CollisionProjectionView extends JFrame {
	private CollisionModel model;
	private CollisionProjectionPanel cPanel;

	public CollisionProjectionView(CollisionModel model) {
		super("Collision Simulation");
		this.model = model;
		
		cPanel = new CollisionProjectionPanel(model, this);
		add(cPanel, BorderLayout.CENTER);
		cPanel.setBackground(Color.WHITE);
		Dimension size = cPanel.getSize();
				
		cPanel.requestFocus();
	}
	
	public void registerListeners(CollisionResizeController c) {
		cPanel.addComponentListener(c);
	}

	public Dimension getCollisionPanelSize() {
        return cPanel.getSize();
    }
}
