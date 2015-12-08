package MVC.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import MVC.vbhitController;
import game.Controls;
import game.core.Player;

public class ReportMenu extends JPanel {
	
	private vbhitController control;
	private JButton mainmenu;
	private JPanel center;
	
	public ReportMenu(vbhitController control){
		JButton button;
		this.setBackground(null);
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.control=control;
		this.center = new JPanel();
		this.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
		center.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
		center = new JPanel(new GridLayout(1,4));
		center.setBackground(null);
		center.setOpaque(false);
		this.add(center, BorderLayout.CENTER);
		
		//this.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.blue));
		
		JLabel label = new JLabel("Score Report");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(false);
		label.setFont(Controls.LARGE_FONT_DEFAULT);
		label.setForeground(Color.CYAN);
		this.add(label,BorderLayout.NORTH);
		
		//this.add(center, BorderLayout.CENTER);
		this.mainmenu = new JButton("Quit");
		this.mainmenu.setForeground(Color.MAGENTA);
		this.mainmenu.setFont(Controls.MID_FONT_DEFAULT);
		this.mainmenu.setOpaque(false);
		this.mainmenu.setContentAreaFilled(false);
		this.mainmenu.addActionListener(this.control);
		this.mainmenu.setFocusable(false);
		this.add(this.mainmenu, BorderLayout.SOUTH);
		
	}
	public void ShowPanel(){
		this.center.removeAll();
		JPanel score;
		JLabel label;
		JPanel overallscore;
		JPanel scorepanel;
		String winner="";
		int currentscore,bestscore;
		bestscore=Integer.MIN_VALUE;
		for(Player player: this.control.getModel().getAllPlayer()){
			currentscore = player.getScore().getScore()-player.getScore().getMiss();
			if(bestscore< currentscore){
				bestscore = currentscore;
				winner = player.getName();
			}
		}
		for(Player player: this.control.getModel().getAllPlayer()){
			if(player.getPlayerStatus()!=Controls.PLAYER_NOT_PLAY){
				overallscore = new JPanel();
				overallscore.setOpaque(false);
				overallscore.setBackground(null);
				overallscore.setLayout(new BorderLayout());
				label = new JLabel(player.getName());
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setOpaque(false);
				label.setFont(Controls.MID_FONT_DEFAULT);
				label.setForeground(Color.white);
				overallscore.add(label, BorderLayout.NORTH);
				scorepanel = new JPanel();
				scorepanel.setOpaque(false);
				scorepanel.setBackground(null);
				//scorepanel.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY, Color.green));
				scorepanel.setLayout(new GridLayout(3,2));
				
				//show score
				label= new JLabel("Score:",SwingConstants.CENTER);
				label.setForeground(Color.blue);
				label.setBackground(null);
				label.setOpaque(false);
				scorepanel.add(label);
				label= new JLabel(""+ player.getScore().getScore(),SwingConstants.CENTER);
				label.setForeground(Color.GREEN);
				label.setBackground(null);
				label.setOpaque(false);
				label.setFont(Controls.LARGE_FONT_DEFAULT);
				scorepanel.add(label);
				
				//show miss
				label= new JLabel("Miss:",SwingConstants.CENTER);
				label.setForeground(Color.blue);
				label.setBackground(null);
				label.setOpaque(false);
				scorepanel.add(label);
				label= new JLabel("" + player.getScore().getMiss(),SwingConstants.CENTER);
				label.setForeground(Color.red);
				label.setBackground(null);
				label.setOpaque(false);
				label.setFont(Controls.LARGE_FONT_DEFAULT);
				scorepanel.add(label);
				overallscore.add(scorepanel, BorderLayout.CENTER);
				
				//score - miss
				label= new JLabel("Total:",SwingConstants.CENTER);
				label.setForeground(Color.blue);
				label.setBackground(null);
				label.setOpaque(false);
				scorepanel.add(label);
				label= new JLabel("" + (player.getScore().getScore()-player.getScore().getMiss()),SwingConstants.CENTER);
				label.setForeground(Color.red);
				label.setBackground(null);
				label.setOpaque(false);
				label.setFont(Controls.LARGE_FONT_DEFAULT);
				scorepanel.add(label);
				overallscore.add(scorepanel, BorderLayout.CENTER);
				
				if(player.getName().equals(winner)){
					label= new JLabel("WIN!",SwingConstants.CENTER);
					label.setForeground(Color.yellow);
					label.setBackground(null);
					label.setOpaque(false);
					label.setFont(Controls.LARGE_FONT_DEFAULT);
					overallscore.add(label, BorderLayout.SOUTH);
				}else{
					label= new JLabel("LOST",SwingConstants.CENTER);
					label.setForeground(Color.lightGray);
					label.setBackground(null);
					label.setOpaque(false);
					label.setFont(Controls.LARGE_FONT_DEFAULT);
					overallscore.add(label, BorderLayout.SOUTH);
				}
				center.add(overallscore);
			}
			
		}
		this.add(center,BorderLayout.CENTER);
		this.setVisible(true);
	}
}
