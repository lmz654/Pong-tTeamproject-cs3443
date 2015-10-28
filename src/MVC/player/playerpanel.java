package MVC.player;

import javax.swing.JPanel;

import game.core.Player;

public abstract class playerpanel extends JPanel {
	private Player player;
	
	public playerpanel(Player player) {
		super();
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	public abstract void paint();
}
