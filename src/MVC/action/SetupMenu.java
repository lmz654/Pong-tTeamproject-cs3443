package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import MVC.vbhitController;

public class SetupMenu extends JPanel {
	
	private String[] gameModes = { "Lives", "Time" };
	private String[] playerModes = { "Team Battle", "FFA" };
	private String[] sceneryModes = { "space", "desert", "jungle", "ocean" };
	
	private JButton button;
	private JComboBox box;
	
	public SetupMenu(){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0));
		
		// First combo box, 1st item
		box = new JComboBox(gameModes);
		box.setEditable(false);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		//button.addActionListener(control);
		this.add(box);
		
		// Second combo box, 2nd item
		box = new JComboBox(playerModes);
		box.setEditable(false);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		//button.addActionListener(control);
		this.add(box);
		
		// Third combo box, 3rd item
		box = new JComboBox(sceneryModes);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		//button.addActionListener(control);
		this.add(box);
		
		// First button, 4th item
		button = new JButton("Start Game!");
		button.setForeground(Color.red);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
		
		// Second button, 5th item
		button = new JButton("Main Menu");
		button.setForeground(Color.red);
		button.setBackground(null);
		button.setOpaque(false);
		//button.addActionListener(control);
		this.add(button);
	}
	public SetupMenu(vbhitController control){
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new GridLayout(5,0,10,10));
		
		// First combo box, 1st item
		box = new JComboBox(gameModes);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		box.addActionListener(control);
		this.add(box);
		
		// Second combo box, 2nd item
		box = new JComboBox(playerModes);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		box.addActionListener(control);
		this.add(box);
		
		// Third combo box, 3rd item
		box = new JComboBox(sceneryModes);
		box.setForeground(Color.red);
		box.setBackground(null);
		box.setOpaque(false);
		box.addActionListener(control);
		this.add(box);
		
		// First button, 4th item
		button = new JButton("Start Game!");
		button.setForeground(Color.red);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setContentAreaFilled(false);
		this.add(button);
		
		// Second button, 5th item
		button = new JButton("Main Menu");
		button.setForeground(Color.red);
		button.setBackground(null);
		button.setOpaque(false);
		button.addActionListener(control);
		button.setContentAreaFilled(false);
		this.add(button);
	}
}