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

import game.core.Player;

public class vbhitController implements KeyListener, ActionListener, ComponentListener,WindowStateListener  {
	private vbhitModel model;
	private vbhitView view;
	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void repaintall(){
		//this.view.repaint();
		/*this.view.getLeftpanel().repaint();
		this.view.getRightpanel().repaint();*/
		/*this.view.start();
		this.model.start();*/
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar()==KeyEvent.VK_ESCAPE){
			model.stop();
			view.stop();
			this.view.getActionPanel().showPauseMenu();
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
		//actionmenu
		if(e.getActionCommand().equals("Full Screen")){
			
		}else if(e.getActionCommand().equals("Main Menu")){
			vbhitController.this.view.getActionPanel().hidePauseMenu();
			vbhitController.this.view.getActionPanel().showTitleMenu();
			
		}else if(e.getActionCommand().equals("Resume")){
			vbhitController.this.view.getActionPanel().hidePauseMenu();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Quit")){
			System.exit(1);
		}
		//TitleMenu
		else if(e.getActionCommand().equals("Game Setup")){
			
		}
		else if(e.getActionCommand().equals("Instructions")){
			
			
		}else if(e.getActionCommand().equals("Options")){
			this.view.getActionPanel().hiddAllSubMenu();
			this.view.showPlayerKey();
			this.view.getActionPanel().showSaveMenu();
		}else if(e.getActionCommand().equals("Start")){
			vbhitController.this.view.getActionPanel().hideTitleMenu();
			model.createball();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		//savekeypanel
		else if(e.getActionCommand().equals("savekeymap")){
			System.exit(1);
		}
		else if(e.getActionCommand().equals("skipkeymap")){
			this.view.getActionPanel().hiddAllSubMenu();
			this.view.getActionPanel().showTitleMenu();
		}
		
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
		view.updateratio();
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
