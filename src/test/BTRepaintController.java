package test;

import java.awt.event.*;

public class BTRepaintController implements ActionListener{
	private BTModel model;
	private BTView view;
	
	public BTRepaintController(BTModel model, BTView view) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent event) {
		model.moveBalls();
		
		view.repaint();
	}

}
