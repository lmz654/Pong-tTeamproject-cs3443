package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import game.core.player.Player;

public class vbhitController implements KeyListener, ActionListener  {
	private vbhitModel model;
	private vbhitView view;
	

	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		for(Player temp:model.getPlayer()){
			
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	

}
