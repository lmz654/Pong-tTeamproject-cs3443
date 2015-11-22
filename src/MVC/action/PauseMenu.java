package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;

public class PauseMenu extends JPanel {
	
	
	private vbhitController control;
	private JButton screensetbutton;
	public PauseMenu(vbhitController control){
		JButton button;
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(4,0,10,10));
		this.control=control;
		//this.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.blue));
		
		// 1st button, 1st item
		this.screensetbutton = new JButton("Full Screen");
		screensetbutton.setForeground(Color.green);
		screensetbutton.setContentAreaFilled(false);
		screensetbutton.setBackground(null);
		screensetbutton.setOpaque(false);
		screensetbutton.addActionListener(this.control);
		screensetbutton.setFocusable(false);
		this.add(screensetbutton);
		
		// 2nd button, 2nd item
		button = new JButton("Options");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("Resume");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("Quit");
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(this.control);
		button.setFocusable(false);
		this.add(button);
	}
	public JButton getScreenButton(){
		return this.screensetbutton;
	}
}
