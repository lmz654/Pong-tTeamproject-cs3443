package MVC.view;

import java.awt.BorderLayout;
import java.awt.Color;
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

import game.components.item.Item;
import game.core.Player;

public class PlayerPanel extends JPanel {
	private BufferedImage bg;
	//private Queue<Item> item;
	private Player player;
	private JPanel itempanel;
	private JLabel score, miss;
	private JLabel[] item;
	public PlayerPanel(Player player){
		bg=null;
		this.player=player;
		this.setLayout(new BorderLayout());
		this.setBackground(null);
		this.setOpaque(false);
		item = new JLabel[6];
		JLabel label;
		label = new JLabel(this.player.getName(),SwingConstants.CENTER);
		label.setBackground(null);
		label.setOpaque(false);
		label.setForeground(Color.green);
		this.add(label,BorderLayout.NORTH);
		JPanel centercontainer = new JPanel(new GridLayout(2,0));
		centercontainer.setBackground(null);
		centercontainer.setOpaque(false);
		itempanel = new JPanel();
		itempanel.setBackground(null);
		itempanel.setOpaque(false);
		//BorderFactory.createem
		itempanel.setBorder(BorderFactory.createEmptyBorder(10,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2), 0,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2)));
		itempanel.setLayout(new GridLayout(3,3,10,0));
		try{
			int i;
			for(i=0;i<this.player.getItem().size();i++){
				this.item[i]=new JLabel(new ImageIcon(this.player.getItem().get(i).getImage()));
				itempanel.add(this.item[i]);
			}
			for(int j=i;j<6;j++){
				item[j]=new JLabel("emty" + j,SwingConstants.CENTER);
				item[j].setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.CYAN));
				item[j].setBackground(Color.BLUE);
				item[j].setBackground(null);
				item[j].setOpaque(false);
				itempanel.add(item[j]);
			}
			
		}catch(Exception e){
			System.err.println("can not load item int playerpanel");
		}
		centercontainer.add(itempanel);
		//this.add(itempanel);
		JPanel scorepanel = new JPanel();
		scorepanel.setOpaque(false);
		scorepanel.setBackground(null);
		//scorepanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.green));
		scorepanel.setLayout(new GridLayout(2,2));
		label= new JLabel("Score:",SwingConstants.CENTER);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		score= new JLabel(""+this.player.getScore().getScore(),SwingConstants.CENTER);
		score.setForeground(Color.GREEN);
		score.setBackground(null);
		score.setOpaque(false);
		scorepanel.add(score);
		label= new JLabel("Miss:",SwingConstants.CENTER);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		miss= new JLabel("" + this.player.getScore().getMiss(),SwingConstants.CENTER);
		miss.setForeground(Color.red);
		miss.setBackground(null);
		miss.setOpaque(false);
		scorepanel.add(miss);
		centercontainer.add(scorepanel);
		this.add(centercontainer, BorderLayout.CENTER);
		
		
		
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
		itempanel.setBorder(BorderFactory.createEmptyBorder(10,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2), 0,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2)));
		
		try{
			int i;
			for(i=0;i<this.player.getItem().size();i++){
				this.item[i].setIcon(new ImageIcon(this.player.getItem().get(i).getImage()));
			}
			for(int j=i;j<6;j++){
				this.item[j].setIcon(null);
			}
			
		}catch(Exception e){
			System.err.println("can not load item int playerpanel");
		}
		score.setText(""+this.player.getScore().getScore());
		miss.setText(""+this.player.getScore().getMiss());
	}
	
}
