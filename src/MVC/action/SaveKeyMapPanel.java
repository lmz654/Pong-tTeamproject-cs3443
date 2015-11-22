package MVC.action;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;



public class SaveKeyMapPanel extends JPanel{
	private JButton backorresume;
	private vbhitController controller;
	
	public SaveKeyMapPanel(vbhitController controller){
		this.controller = controller;
		this.setLayout(new GridLayout(1,1,10,10));
		this.setBackground(null);
		this.setOpaque(false);
		
		//save button
		backorresume = new JButton("Main Menu");
		backorresume.addActionListener(this.controller);
		backorresume.setOpaque(false);
		backorresume.setBackground(null);
		backorresume.setForeground(Color.green);
		backorresume.setContentAreaFilled(false);
		backorresume.setFocusable(false);
		this.add(backorresume);
		
		//Don't Save
		/*button = new JButton("Don't Save");
		button.addActionListener(this.controller);
		button.setOpaque(false);
		button.setBackground(null);
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		
		this.add(button);*/
	}
	public JButton getBackorResume(){
		return this.backorresume;
		
	}
	

}
