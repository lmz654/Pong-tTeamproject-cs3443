package MVC.view.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;

public class TitleMenu extends JPanel {
	
	private JButton button;
	
	public TitleMenu(){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// 1st button, 1st item
		button = new JButton("Game Setup");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 2nd button, 2nd item
		button = new JButton("Instructions");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("Options");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("Start");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 5th button, 5th item
		button = new JButton("Exit");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
	}
	public TitleMenu(vbhitController control){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// 1st button, 1st item
		button = new JButton("Game Setup");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 2nd button, 2nd item
		button = new JButton("Instructions");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("Options");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("Start");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 5th button, 5th item
		button = new JButton("Exit");
		button.setForeground(Color.blue);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
	}
}