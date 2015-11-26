package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;



public class SaveKeyMapPanel extends JPanel{
	private JButton backorresume;
	private JButton soundcontrol;
	private vbhitController controller;
	
	public SaveKeyMapPanel(vbhitController controller){
		this.controller = controller;
		this.setLayout(new GridLayout(2,1,10,10));
		this.setBackground(null);
		this.setOpaque(false);
		
		//Main Menu
		backorresume = new JButton("Main Menu");
		backorresume.addActionListener(this.controller);
		backorresume.setOpaque(false);
		backorresume.setBackground(null);
		backorresume.setForeground(Color.green);
		backorresume.setContentAreaFilled(false);
		backorresume.setFocusable(false);
		this.add(backorresume);
		
		//Sound
		this.soundcontrol = new JButton("Sound: Off");
		this.soundcontrol.addActionListener(this.controller);
		this.soundcontrol.setOpaque(false);
		this.soundcontrol.setBackground(null);
		this.soundcontrol.setForeground(Color.green);
		this.soundcontrol.setContentAreaFilled(false);
		this.soundcontrol.setFocusable(false);
		
		this.add(this.soundcontrol);
	}
	public JButton getBackorResume(){
		return this.backorresume;
		
	}
	

}
