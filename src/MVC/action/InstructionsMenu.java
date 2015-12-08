package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MVC.vbhitController;

public class InstructionsMenu extends JPanel {
	
	private vbhitController control;
	
	public InstructionsMenu(vbhitController control){
		JButton button;
		JTextArea text;
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// 1st button, 1st item
		text = new JTextArea(
				"1. Move left or right\n"
				+ "2. Click the sticky key to hold the ball\n3. "
				+ "Release the sticky key to throw the ball\n4. "
				+ "Don't let the ball get passed your paddle!", 4, 1);
		text.setBackground(null);
		text.setFocusable(false);
		this.add(text);
		
		// 5th button, 5th item
		button = new JButton("Main Menu");
		button.setContentAreaFilled(false);
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
	}
}