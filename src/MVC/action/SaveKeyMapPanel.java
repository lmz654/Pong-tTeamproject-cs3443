package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;



public class SaveKeyMapPanel extends JPanel{
	private JButton backorreturn;
	private vbhitController controller;
	
	public SaveKeyMapPanel(vbhitController controller){
		JButton button;
		this.controller = controller;
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBackground(null);
		this.setOpaque(false);
		
		//save button
		button = new JButton("Save");
		button.addActionListener(this.controller);
		button.setOpaque(false);
		button.setBackground(null);
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		this.add(button);
		
		//Don't Save
		button = new JButton("Don't Save");
		button.addActionListener(this.controller);
		button.setOpaque(false);
		button.setBackground(null);
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		
		this.add(button);
	}
	

}
