package MVC.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.PlainDocument;

import MVC.vbhitController;
import game.core.Player;

public class KeyMap extends JPanel {
	
	private Player player;
	JTextField	name;
	JTextField keydecrease;
	JTextField keyincrease;
	JTextField keyhold;
	
	public KeyMap(Player player){
		JLabel label;
		this.player= player;
		//this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new GridLayout(4,2,10,10));
		this.keydecrease = new JTextField();
		this.keyincrease = new JTextField(1);
		this.keyhold = new JTextField(1);
		this.name = new JTextField(15);
		name.setOpaque(false);
		name.setBackground(null);
		keydecrease.setOpaque(false);
		keydecrease.setBackground(null);
		keyincrease.setOpaque(false);
		keyincrease.setBackground(null);
		name.setHorizontalAlignment(JTextField.CENTER);
		keydecrease.setHorizontalAlignment(JTextField.CENTER);
		keyincrease.setHorizontalAlignment(JTextField.CENTER);
		keyhold.setHorizontalAlignment(JTextField.CENTER);
		name.setForeground(Color.green);
		keydecrease.setForeground(Color.green);
		keyincrease.setForeground(Color.green);
		keyhold.setForeground(Color.green);
		this.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
		this.setBackground(null);
		this.setOpaque(false);
		keyhold.setOpaque(false);
		keyhold.setBackground(null);
		/*this.name.setFocusable(false);
		this.keydecrease.setFocusable(false);
		this.keyincrease.setFocusable(false);
		this.keyhold.setFocusable(false);*/
		this.name.setText(player.getName());
		this.keydecrease.setText(""+player.getKeydecrease());
		this.keyincrease.setText(""+player.getKeyincrease());
		this.keyhold.setText(""+player.getKeyhole());
		label = new JLabel("Name:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.name);
		label = new JLabel("Key Decrease:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keydecrease);
		label = new JLabel("Key Increase:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyincrease);
		label = new JLabel("Key Hold:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyhold);
	}
	public void UpdatePlayerKey(){
		player.setName(name.getText());
		player.setkeydecrease(this.keydecrease.getText().charAt(0));
		player.setKeyincrease(this.keyincrease.getText().charAt(0));
		player.setKeyhole(this.keyhold.getText().charAt(0));
	}
	
}
