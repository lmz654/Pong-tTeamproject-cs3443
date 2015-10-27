package MVC.player;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.components.Item;
import game.core.Player;

public class sideplayer extends playerpanel {
	private itempanel item;
	private scorepanel score;
	public sideplayer(Player player) {
		super(player);
		GridLayout grid = new GridLayout(2,1);
		itempanel item = new itempanel (player.getItem());
		scorepanel score = new scorepanel();
	}
	public void paint(){
		
	}
	public void updatescore(){
		
		score.setScore(super.getPlayer().getScore().getScore());
		score.setMiss(super.getPlayer().getScore().getMiss());
	}
	public void updateitem(){
		
	}
	public class itempanel extends JPanel{
		ArrayList<Item> item;
		ArrayList<JLabel> label;
		public itempanel(ArrayList<Item> item){
			this.item=item;
			this.setLayout(new GridLayout(3,3));
			label=new ArrayList();
		}
		public void update(){
			label.clear();
		}
	}
	
	public class scorepanel extends JPanel{
		private JTextField score;
		private JTextField miss;
		public scorepanel(){
			score.setText("0");
			miss.setText("0");
			score.setEditable(false);
			miss.setEditable(false);
			this.setLayout(new GridLayout(2,2));
			this.add(new JLabel("Score:"));
		}
		public void setScore(int score) {
			this.score.setText(""+score);
		}
		public void setMiss(int miss) {
			this.miss.setText(""+miss);
		}
		
	}
}
