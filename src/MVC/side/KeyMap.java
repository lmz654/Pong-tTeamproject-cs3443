package MVC.side;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		this.setLayout(new GridLayout(5,2,10,10));
		this.keydecrease = new JTextField();
		this.keyincrease = new JTextField(1);
		this.keyhold = new JTextField(1);
		this.name = new JTextField(15);
		this.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
		this.setBackground(null);
		this.setOpaque(false);
		
		name.setOpaque(false);
		name.setBackground(null);
		name.setHorizontalAlignment(JTextField.CENTER);
		this.name.setText(player.getName());
		name.setForeground(Color.green);
		label = new JLabel("Name:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.name);
		
		keydecrease.setOpaque(false);
		keydecrease.setBackground(null);
		keydecrease.setHorizontalAlignment(JTextField.CENTER);
		keydecrease.setForeground(Color.green);
		this.keydecrease.setText(""+player.getKeydecrease());
		label = new JLabel("Key Decrease:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keydecrease);
		
		keyincrease.setOpaque(false);
		keyincrease.setBackground(null);
		keyincrease.setForeground(Color.green);
		keyincrease.setHorizontalAlignment(JTextField.CENTER);
		this.keyincrease.setText(""+player.getKeyincrease());
		label = new JLabel("Key Increase:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyincrease);
		
		
		keyhold.setHorizontalAlignment(JTextField.CENTER);
		keyhold.setForeground(Color.green);
		keyhold.setOpaque(false);
		keyhold.setBackground(null);
		this.keyhold.setText(""+player.getKeyhole());
		label = new JLabel("Key Hold:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyhold);
				
		JButton button = new JButton("Save Key");
		//button.setIcon(new ImageIcon(player.getPaddleimage().get(0)));
		button.setOpaque(false);
		button.setBackground(null);
		button.setFocusable(false);
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		this.add(button);
		
		button = new JButton("default");
		//button.setIcon(new ImageIcon(player.getPaddleimage().get(0)));
		button.setOpaque(false);
		button.setBackground(null);
		button.setFocusable(false);
		button.setForeground(Color.green);
		button.setContentAreaFilled(false);
		this.add(button);
		
	}
	public void setfocusable(boolean b){
		this.name.setFocusable(b);
		this.keydecrease.setFocusable(b);
		this.keyincrease.setFocusable(b);
		this.keyhold.setFocusable(b);
	}
	public Player getPlayer(){
		return this.player;
	}
	public void UpdatePlayerKey(){
		player.setName(name.getText());
		player.setkeydecrease(this.keydecrease.getText().charAt(0));
		player.setKeyincrease(this.keyincrease.getText().charAt(0));
		player.setKeyhole(this.keyhold.getText().charAt(0));
	}
	public void savekey(){
		if(this.keyincrease.getText().length()>0){
			this.player.setKeyincrease(this.keyincrease.getText().charAt(0));
		}
		if(this.keydecrease.getText().length()>0){
			this.player.setKeyincrease(this.keydecrease.getText().charAt(0));
		}
		if(this.keyhold.getText().length()>0){
			this.player.setKeyincrease(this.keyhold.getText().charAt(0));
		}
	}
	
}
