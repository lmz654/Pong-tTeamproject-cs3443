package MVC.view.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;

public class InstructionsMenu extends JPanel {
	
	private JButton button;
	
	public InstructionsMenu(){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// 1st button, 1st item
		button = new JButton("1. Move left or right");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 2nd button, 2nd item
		button = new JButton("2. Click the sticky key to hold the ball");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("3. Release the sticky key to throw the ball");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("4. Don't let the ball get passed your paddle!");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// 5th button, 5th item
		button = new JButton("Main Menu");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
	}
	public InstructionsMenu(vbhitController control){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// 1st button, 1st item
		button = new JButton("1. Move left or right");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 2nd button, 2nd item
		button = new JButton("2. Click the sticky key to hold the ball");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 3rd button, 3rd item
		button = new JButton("3. Release the sticky key to throw the ball");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 4th button, 4th item
		button = new JButton("4. Don't let the ball get passed your paddle!");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
		
		// 5th button, 5th item
		button = new JButton("Main Menu");
		button.setForeground(Color.yellow);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setFocusable(false);
		this.add(button);
	}
}