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
import game.Controls;
import game.core.Player;

public class KeyMap extends JPanel {
	
	private Player player;
	private	JTextField	name;
	private	JTextField keydecrease;
	private	JTextField keyincrease;
	private	JTextField keyhold;
	private	JButton savekey, reset;
	private	vbhitController controller;
	private int playernumber;
	
	public KeyMap(Player player,vbhitController controller, int playernumber){
		this.playernumber=playernumber;
		this.player= player;
		this.controller = controller;
		//this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new GridLayout(5,2,10,10));
		this.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
		this.setBackground(null);
		this.setOpaque(false);
		
		JLabel label;
		
		//name
		this.name = new JTextField();
		name.setName("Name");
		name.setOpaque(false);
		name.setBackground(null);
		name.setHorizontalAlignment(JTextField.CENTER);
		this.name.setText(player.getName());
		this.name.setFont(Controls.MID_FONT_DEFAULT);
		name.setForeground(Color.green);
		label = new JLabel("Name:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.name);
		
		//keydecrease
		this.keydecrease = new JTextField();
		keydecrease.setName("keydecrease");
		keydecrease.setOpaque(false);
		keydecrease.setBackground(null);
		keydecrease.setHorizontalAlignment(JTextField.CENTER);
		keydecrease.setForeground(Color.green);
		keydecrease.setFont(Controls.LARGE_FONT_DEFAULT);
		this.keydecrease.addFocusListener(this.controller);
		this.keydecrease.setText(""+player.getKeydecrease());
		label = new JLabel("Key Decrease:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keydecrease);
		
		//keyincrease
		this.keyincrease = new JTextField();
		keyincrease.setName("keyincrease");
		keyincrease.setOpaque(false);
		keyincrease.setBackground(null);
		keyincrease.setForeground(Color.green);
		keyincrease.setFont(Controls.LARGE_FONT_DEFAULT);
		keyincrease.setHorizontalAlignment(JTextField.CENTER);
		this.keyincrease.setText(""+player.getKeyincrease());
		label = new JLabel("Key Increase:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyincrease);
		
		//keyhold
		this.keyhold = new JTextField();
		keyhold.setName("keyhold");
		keyhold.setHorizontalAlignment(JTextField.CENTER);
		keyhold.setForeground(Color.green);
		keyhold.setOpaque(false);
		keyhold.setBackground(null);
		keyhold.setFont(Controls.LARGE_FONT_DEFAULT);
		this.keyhold.setText(""+player.getKeyhole());
		label = new JLabel("Key Hold:",SwingConstants.CENTER);
		label.setForeground(Color.green);
		this.setBackground(null);
		this.setOpaque(false);
		this.add(label);
		this.add(this.keyhold);
		
		//savekey button		
		this.savekey = new JButton("Save Key");
		//button.setIcon(new ImageIcon(player.getPaddleimage().get(0)));
		this.savekey.addActionListener(this.controller);
		this.savekey.setOpaque(false);
		this.savekey.setBackground(null);
		this.savekey.setFocusable(false);
		this.savekey.setForeground(Color.green);
		this.savekey.setContentAreaFilled(false);
		this.add(this.savekey);
		
		//default button
		this.reset = new JButton("Reset");
		//button.setIcon(new ImageIcon(player.getPaddleimage().get(0)));
		this.reset.addActionListener(this.controller);
		this.reset.setOpaque(false);
		this.reset.setBackground(null);
		this.reset.setFocusable(false);
		this.reset.setForeground(Color.green);
		this.reset.setContentAreaFilled(false);
		this.add(this.reset);
		
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
	public void Updatepanel(){
		this.keydecrease.setText(""+this.player.getKeydecrease());
		this.keyincrease.setText(""+this.player.getKeyincrease());
		this.keyhold.setText(""+this.player.getKeyhole());
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
	public int getPlayerNumber(){
		return this.playernumber;
	}
	
}
