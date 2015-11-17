package MVC.view;

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
	private Queue<Item> item;
	private Player player;
	
	public PlayerPanel(){
		bg=null;
		player=null;
		this.setLayout(new GridLayout(2,0));
		this.setBackground(null);
		this.setOpaque(false);
		JPanel itempanel = new JPanel();
		itempanel.setBackground(null);
		itempanel.setOpaque(false);
		itempanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		itempanel.setLayout(new GridLayout(3,3,10,10));
		item = new PriorityQueue<Item>();
		JLabel label;
		try{
			for(Item t:item){
				itempanel.add(new JLabel(new ImageIcon(t.getImage())));
			}
			for(int i=item.size();i<6;i++){
				label=new JLabel("emty" + i,SwingConstants.CENTER);
				label.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.CYAN));
				label.setBackground(Color.BLUE);
				label.setBackground(null);
				label.setOpaque(false);
				itempanel.add(label);
			}
			
		}catch(Exception e){
			System.err.println("can not load player");
		}
		
		this.add(itempanel);
		JPanel scorepanel = new JPanel();
		scorepanel.setOpaque(false);
		scorepanel.setBackground(null);
		//scorepanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.green));
		scorepanel.setLayout(new GridLayout(2,2));
		label= new JLabel("Score:",SwingConstants.CENTER);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		label= new JLabel("0",SwingConstants.CENTER);
		label.setForeground(Color.GREEN);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		label= new JLabel("Miss:",SwingConstants.CENTER);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		label= new JLabel("0",SwingConstants.CENTER);
		label.setForeground(Color.red);
		label.setBackground(null);
		label.setOpaque(false);
		scorepanel.add(label);
		this.add(scorepanel);
		
		
		
	}

	public BufferedImage getBG() {
		return bg;
	}

	public void setBG(BufferedImage background) {
		this.bg = background;
	}

	public Item getItem() {
		return item.remove();
	}

	public void pushItem(Item item) {
		if(this.item.add(item)){
			System.out.println("can not add item into queue in player panel");
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
