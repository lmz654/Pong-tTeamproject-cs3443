package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.Timer;

import MVC.view.vbhitView;
import game.core.Player;

public class vbhitController implements KeyListener, ActionListener, ComponentListener,WindowStateListener  {
	private vbhitModel model;
	private vbhitView view;
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
			this.view.getActionPanel().getPauseMenu().setVisible(false);
			this.view.getActionPanel().setVisible(true);
			model.start();
			view.start();
		}else if(arg0.getKeyChar()=='t'){
			model.stop();
			view.stop();
			this.view.getActionPanel().getPauseMenu().setVisible(true);
		}
		else if(arg0.getKeyChar()=='n'){
			model.createball();
		}else if(arg0.getKeyChar()=='2'){
			model.activateplayer(1);
		}else if(arg0.getKeyChar()=='3'){
			model.activateplayer(2);
		}else if(arg0.getKeyChar()=='4'){
			model.activateplayer(3);
		}else if(arg0.getKeyChar()=='1'){
			model.activateplayer(0);
		}
		else{
			for(Player temp:model.getAllPlayer()){
				if(temp.getKeydecrease()==arg0.getKeyChar())
					temp.setkeydecreasepress(-1);
				if(temp.getKeyincrease()==arg0.getKeyChar())
					temp.setKeyincreasepress(1);;
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		for(Player temp:model.getAllPlayer()){
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

	public void windowStateChanged(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.view.updateratio();
	}

	public vbhitModel getModel() {
		return model;
	}

	public void setModel(vbhitModel model) {
		this.model = model;
	}

	public vbhitView getView() {
		return view;
	}

	public void setView(vbhitView view) {
		this.view = view;
	}

	

}
