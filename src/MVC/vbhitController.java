package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
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
		if(arg0.getKeyChar()==KeyEvent.VK_ESCAPE ){
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
			if(temp.getKeydecrease()==arg0.getKeyChar()){
				temp.setkeydecreasepress(0);
			}else if(temp.getKeyincrease()==arg0.getKeyChar())
				temp.setKeyincreasepress(0);
		}
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		//actionmenu
		if(e.getActionCommand().equals("Full Screen")){
			this.view.dispose();
			this.view= new vbhitView(this.model);
			this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.view.setUndecorated(true);
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showPauseMenu();
			//this.view.getActionPanel().getPauseMenu().getScreenButton().setName("Normal Screen");
			this.view.getActionPanel().getPauseMenu().getScreenButton().setText("Normal Screen");
			this.view.setVisible(true);
		
		}else if(e.getActionCommand().equals("Normal Screen")){
			this.view.dispose();
			this.view= new vbhitView(this.model);
			this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.view.setUndecorated(false);
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showPauseMenu();
			//this.view.getActionPanel().getPauseMenu().getScreenButton().setName("Full Screen");
			this.view.getActionPanel().getPauseMenu().getScreenButton().setText("Full Screen");
			this.view.setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Resume")){
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.view.requestFocus();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Quit")){
			this.model.setGameStart(false);
			this.model.resetgame();
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			vbhitController.this.view.getActionPanel().showTitleMenu();
		}
		//TitleMenu
		else if(e.getActionCommand().equals("Game Setup")){
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showSetupMenu();
		}
		else if(e.getActionCommand().equals("Instructions")){
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showInstruction();
			
		}else if(e.getActionCommand().equals("Options")){
			this.view.getActionPanel().hideAllSubMenu();
			this.view.showPlayerKey();
			this.view.getActionPanel().showSaveMenu();
		}else if(e.getActionCommand().equals("Start")){
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.model.setGameStart(true);
			this.view.requestFocus();
			model.createball();
			this.view.updateratio();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		//savekeypanel
		else if(e.getActionCommand().equals("Save")){
			this.view.getActionPanel().hideAllSubMenu();
			this.view.savePlayerKey();
			if(this.model.getGameStart()==true){
				this.view.showPlayer();
				this.view.getActionPanel().showPauseMenu();
			}else{
				this.view.showPlayer();
				this.view.getActionPanel().showTitleMenu();
			}
			
			
		}
		else if(e.getActionCommand().equals("Don't Save")){
			this.view.getActionPanel().hideAllSubMenu();
			if(this.model.getGameStart()==true){
				this.view.showPlayer();
				this.view.getActionPanel().showPauseMenu();
			}else{
				this.view.showPlayer();
				this.view.getActionPanel().showTitleMenu();
			}
			
		}
		//instruction menu
		else if(e.getActionCommand().equals("Main Menu")){
			this.view.getActionPanel().hideAllSubMenu();
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
