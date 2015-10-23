package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BTView extends JFrame {
	private BTModel model;
	private BTPanel ballPanel;

	public BTView(BTModel model) {
		super("Ball Tester");
		this.model = model;
		
		ballPanel = new BTPanel(model, this);
		add(ballPanel, BorderLayout.CENTER);
		//ballPanel.
	}

	public void repaint() {
		// TODO Auto-generated method stub
		
	}

}
