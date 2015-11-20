package test.collision;

import java.awt.event.*;
import java.util.Date;

public class CollisionRepaintController implements ActionListener{
	private CollisionModel model;
	private CollisionView view;
	
	public CollisionRepaintController(CollisionModel model, CollisionView view) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent event) {
		long start = new Date().getTime();
		model.moveBalls();		
		model.modelTime = new Date().getTime() - start;
		
		start = new Date().getTime();
		view.repaint();
		model.repaintTime = new Date().getTime() - start;
	}

}
