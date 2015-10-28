package MVC.player;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.player.sideplayer.itempanel;
import MVC.player.sideplayer.scorepanel;
import game.components.Item;
import game.core.Player;

public class TBplayerpanel extends playerpanel {
	private itempanel item;
	private scorepanel score;
	public TBplayerpanel(Player player) {
		super(player);
		GridLayout grid = new GridLayout(1,2);
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
