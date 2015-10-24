package test.collision;

import java.awt.*;
import java.awt.event.*;

public class CollisionResizeController extends ComponentAdapter {
	private CollisionModel model;
	private CollisionView view;
	
	public CollisionResizeController(CollisionModel model, CollisionView view) {
		this.model = model;
		this.view = view;
	}
	
	public void componentResized(ComponentEvent event) {
		Dimension size  = view.getCollisionPanelSize();
		if (size.width != model.getWidth() || size.height != model.getHeight()) {
			model.setSize(size.width, size.height);
		}
	}
}
