package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import MVC.view.vbhitView;
import game.core.Ball;
import game.core.Player;

public class vbhitController implements KeyListener, ActionListener, ComponentListener  {
	private vbhitModel model;
	private vbhitView view;
	private Timer time;
	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
	}
	public class updategame implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar()=='q'){
			System.exit(1);
		}else if(arg0.getKeyChar()=='r'){
			model.start();
			view.start();
		}else if(arg0.getKeyChar()=='t'){
			model.stop();
			view.stop();
		}
		else if(arg0.getKeyChar()=='n'){
			model.createball();
		}
		else{
			for(Player temp:model.getPlayer()){
				if(temp.getKeydecrease()==arg0.getKeyChar())
					temp.setkeydecreasepress(1);
				if(temp.getKeyincrease()==arg0.getKeyChar())
					temp.setkeydecreasepress(1);
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		for(Player temp:model.getPlayer()){
			if(temp.getKeydecrease()==arg0.getKeyChar())
				temp.setkeydecreasepress(0);
			if(temp.getKeyincrease()==arg0.getKeyChar())
				temp.setKeyincreasepress(0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		view.updateratio();
		
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
