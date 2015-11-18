package MVC.player;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;



public class SaveKeyMapPanel extends JPanel{
	private vbhitController controller;
	private JButton savekeymap;
	private JButton skipkeymap;
	public SaveKeyMapPanel(vbhitController controller){
		this.controller = controller;
		savekeymap = new JButton("savekeymap");
		savekeymap.setText("SAVE");
		skipkeymap = new JButton("skipkeymap");
		skipkeymap.setText("DON'T SAVE");
		savekeymap.addActionListener(this.controller);
		skipkeymap.addActionListener(this.controller);
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBackground(null);
		this.setOpaque(false);
		savekeymap.setOpaque(false);
		savekeymap.setBackground(null);
		savekeymap.setForeground(Color.green);
		savekeymap.setContentAreaFilled(false);
		skipkeymap.setOpaque(false);
		skipkeymap.setBackground(null);
		skipkeymap.setForeground(Color.green);
		skipkeymap.setContentAreaFilled(false);
		savekeymap.setFocusable(false);
		skipkeymap.setFocusable(false);
		this.add(savekeymap);
		this.add(skipkeymap);
	}
	

}
