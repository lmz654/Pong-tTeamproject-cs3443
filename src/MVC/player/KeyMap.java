package MVC.player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.vbhitController;
import game.core.Player;

public class KeyMap extends JPanel {
	
	private Player player;
	private KeyPanel keypanel;
	
	public KeyMap(Player player){
		this.player= player;
		keypanel = new KeyPanel(this.player);
		this.setLayout(new BorderLayout());
		this.add(new JLabel(player.getName()),BorderLayout.NORTH);
		this.add(keypanel, BorderLayout.CENTER);
		
		
	}
	public class KeyPanel extends JPanel{
		JTextField keydecrease;
		JTextField keyincrease;
		JTextField keyhold;
		public KeyPanel(Player player){
			this.keydecrease = new JTextField();
			this.keyincrease = new JTextField();
			this.keyhold = new JTextField();
			keydecrease.setOpaque(false);
			keydecrease.setBackground(null);
			keyincrease.setOpaque(false);
			keyincrease.setBackground(null);
			this.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.green));
			this.setBackground(null);
			this.setOpaque(false);
			keyhold.setOpaque(false);
			keyhold.setBackground(null);
			this.keydecrease.setText(player.getKeydecrease()+"");
			this.keyincrease.setText(player.getKeyincrease()+"");
			this.keyhold.setText(player.getKeyhole()+"");
			this.setLayout(new GridLayout(3,3));
			this.add(new JLabel("Key Decrease: "));
			this.add(this.keydecrease);
			this.add(new JLabel("Key Increase: "));
			this.add(this.keyincrease);
			this.add(new JLabel("Key Hold: "));
			this.add(this.keyhold);		
		}
		public JTextField getKeydecrease() {
			return keydecrease;
		}
		public void setKeydecrease(JTextField keydecrease) {
			this.keydecrease = keydecrease;
		}
		public JTextField getKeyincrease() {
			return keyincrease;
		}
		public void setKeyincrease(JTextField keyincrease) {
			this.keyincrease = keyincrease;
		}
		public JTextField getKeyhold() {
			return keyhold;
		}
		public void setKeyhold(JTextField keyhold) {
			this.keyhold = keyhold;
		}
		
	}
}
