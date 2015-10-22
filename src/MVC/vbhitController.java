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
	private Timer time;
	private ActionListener action;
	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
		action = new ActionListener( implementgame());
	}

	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		for(Player temp:model.getPlayer()){
			if(temp.getKeydownleft()==arg0.getKeyChar())
				temp.setKeydownleftpress(1);
			if(temp.getKeyupright()==arg0.getKeyChar())
				temp.setKeydownleftpress(1);
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		for(Player temp:model.getPlayer()){
			if(temp.getKeydownleft()==arg0.getKeyChar())
				temp.setKeydownleftpress(0);
			if(temp.getKeyupright()==arg0.getKeyChar())
				temp.setKeydownleftpress(0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	

}
