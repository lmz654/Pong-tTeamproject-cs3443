package MVC.side;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MVC.vbhitController;
import game.Controls;
import game.components.item.Item;
import game.core.Player;

public class PlayerPanel extends JPanel {
	private BufferedImage bg;
	private Player player;
	private JLabel name;
	private JLabel score, miss;
	private JLabel ballimage;
	private JButton statusbutton;
	private vbhitController controller;
	private int playernuber;

	public PlayerPanel(Player player,vbhitController controller,int playernumber){
		bg=null;
		this.playernuber=playernumber;
		this.controller=controller;
		this.player=player;
		this.setLayout(new BorderLayout());
		this.setBackground(null);
		this.setOpaque(false);
		this.setFocusable(false);
		
		JLabel label;
		name = new JLabel(this.player.getName(),SwingConstants.CENTER);
		name.setBackground(null);
		name.setOpaque(false);
		name.setForeground(Color.green);
		name.setFont(Controls.MID_FONT_DEFAULT);
		this.add(name,BorderLayout.NORTH);
		JPanel centercontainer = new JPanel(new GridLayout(2,0));
		centercontainer.setBackground(null);
		centercontainer.setOpaque(false);
		
		JPanel scorepanel = new JPanel();
		scorepanel.setOpaque(false);
		scorepanel.setBackground(null);
		//scorepanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.green));
		scorepanel.setLayout(new GridLayout(2,2));
		
		//show score
		label= new JLabel("Score:",SwingConstants.CENTER);
		label.setForeground(Color.blue);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		score= new JLabel(""+this.player.getScore().getScore(),SwingConstants.CENTER);
		score.setForeground(Color.GREEN);
		score.setBackground(null);
		score.setOpaque(false);
		score.setFont(Controls.LARGE_FONT_DEFAULT);
		scorepanel.add(score);
		
		//show miss
		label= new JLabel("Miss:",SwingConstants.CENTER);
		label.setForeground(Color.blue);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		miss= new JLabel("" + this.player.getScore().getMiss(),SwingConstants.CENTER);
		miss.setForeground(Color.red);
		miss.setBackground(null);
		miss.setOpaque(false);
		miss.setFont(Controls.LARGE_FONT_DEFAULT);
		scorepanel.add(miss);
		centercontainer.add(scorepanel);
		
		//jlabel
		
		ballimage= new JLabel();
		ballimage.setBackground(null);
		ballimage.setOpaque(false);
		centercontainer.add(ballimage);
		
		this.add(centercontainer, BorderLayout.CENTER);
		
		//playerstatus button
		this.statusbutton = new JButton("Join");
		this.statusbutton.setFont(Controls.LARGE_FONT_DEFAULT);
		this.statusbutton.setBackground(null);
		this.statusbutton.setForeground(Color.red);
		this.setOpaque(false);
		this.statusbutton.setContentAreaFilled(false);
		this.statusbutton.addActionListener(this.controller);
		this.statusbutton.setFocusable(false);
		this.add(statusbutton,BorderLayout.SOUTH);
		
		
	}
	
	public void resetPanel(){
		this.statusbutton.setEnabled(true);
		this.statusbutton.setText("Join");
		this.statusbutton.setForeground(Color.red);
	}

	public BufferedImage getBG() {
		return bg;
	}

	public void setBG(BufferedImage background) {
		this.bg = background;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	public void update(){
		
		score.setText(""+this.player.getScore().getScore());
		miss.setText(""+this.player.getScore().getMiss());
	}
	public void setPlaystatus(){
		this.statusbutton.setForeground(Color.green);
		this.statusbutton.setText("Give Up");
		this.player.setPlayerstatus(Controls.PLAYER_PLAY);
	}
	
	public void setGiveupStatus(){
		this.statusbutton.setForeground(Color.gray);
		this.statusbutton.setText("Give Up");
		this.statusbutton.setEnabled(false);
		this.player.setPlayerstatus(Controls.PLAYER_GIVE_UP);
	}
	
	public int getPlayerNumber(){
		return this.playernuber;
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		//arg0.drawImage(this.player.getBallimage().get(0), 0, 0,this.getWidth(),this.getHeight(), null);
		if(this.ballimage.getIcon()==null){
			ImageIcon icon = new ImageIcon(
			player.getBallimage().get(0).getScaledInstance(this.ballimage.getHeight(),this.ballimage.getHeight(), FRAMEBITS));
			ballimage.setIcon(icon);
			ballimage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		super.paintComponent(arg0);
	}
	
	
}
