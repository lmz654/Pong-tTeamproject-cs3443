package test.collision;

import java.awt.*;
import javax.swing.*;

public class CollisionView extends JFrame {
	private CollisionModel model;
	private CollisionPanel cPanel;

	public CollisionView(CollisionModel model) {
		super("Collision Simulation");
		this.model = model;
		
		cPanel = new CollisionPanel(model, this);
		add(cPanel, BorderLayout.CENTER);
		cPanel.setBackground(Color.WHITE);
		Dimension size = cPanel.getSize();
		model.setSize(size.width, size.height);
		
		cPanel.requestFocus();
	}
	
	public void registerListeners(CollisionResizeController c) {
		cPanel.addComponentListener(c);
	}

	public Dimension getCollisionPanelSize() {
        return cPanel.getSize();
    }

}
