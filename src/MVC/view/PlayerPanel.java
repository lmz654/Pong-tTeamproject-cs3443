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
	private Queue<Item> item;
	private Player player;
	private JPanel itempanel;
	public PlayerPanel(Player player){
		bg=null;
		this.player=player;
		this.setLayout(new BorderLayout());
		this.setBackground(null);
		this.setOpaque(false);
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
		item = new PriorityQueue<Item>();
		
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
		centercontainer.add(scorepanel);
		this.add(centercontainer, BorderLayout.CENTER);
		
		
		
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
	public void update(){
		itempanel.setBorder(BorderFactory.createEmptyBorder(10,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2), 0,Math.abs((itempanel.getWidth()-itempanel.getHeight())/2)));
	}
	
}
