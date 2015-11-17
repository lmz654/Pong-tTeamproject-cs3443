package MVC.view.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;

public class PauseMenu extends JPanel {
	public PauseMenu(){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(4,0));
		JButton button;
		button = new JButton("Full Screen");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		button = new JButton("Main Menu");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		button = new JButton("Resume");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		button = new JButton("Quit");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
	}
	public PauseMenu(vbhitController control){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(4,0));
		JButton button;
		button = new JButton("Full Screen");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		button = new JButton("Main Menu");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		button = new JButton("Resume");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		button = new JButton("Quit");
		button.setForeground(Color.green);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
	}
}
