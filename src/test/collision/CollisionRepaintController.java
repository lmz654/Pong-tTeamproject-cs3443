package test.collision;

import java.awt.event.*;

public class CollisionRepaintController implements ActionListener{
	private CollisionModel model;
	private CollisionView view;
	
	public CollisionRepaintController(CollisionModel model, CollisionView view) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent event) {
		model.moveBalls();
		
		view.repaint();
	}

}
