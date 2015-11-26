package MVC;

import java.awt.Color;
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

import MVC.side.KeyMap;
import MVC.side.PlayerPanel;

import javax.swing.JButton;

import game.Controls;
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
		if(arg0.getKeyChar()==KeyEvent.VK_ESCAPE && this.model.getGameState()==Controls.GAME_PLAY ){
			//this.model.getGameSound().BGstop();
			this.model.setGameState(Controls.GAME_PAUSE);
			model.stop();
			view.stop();
			this.view.getActionPanel().showPauseMenu();
		}
		else if(arg0.getKeyChar()=='n'){
			model.createball();
		}else if(arg0.getKeyChar()=='2'){
			model.setPlayerStatus(1, Controls.PLAYER_PLAY);
		}else if(arg0.getKeyChar()=='3'){
			model.setPlayerStatus(2, Controls.PLAYER_PLAY);
		}else if(arg0.getKeyChar()=='4'){
			model.setPlayerStatus(3, Controls.PLAYER_PLAY);
		}else if(arg0.getKeyChar()=='1'){
			model.setPlayerStatus(0, Controls.PLAYER_PLAY);
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
		
		//sound when click any button
		this.model.getGameSound().ButtonClick();
		//this.model.getGameSound().Explosionsound();
		
		//KeyMap panel
		if(e.getActionCommand().equals("Save Key")){
			JButton button;
			button = (JButton) e.getSource();
			KeyMap parent=(KeyMap) button.getParent();
			parent.savekey();
			
		}else if(e.getActionCommand().equals("Reset")){
			JButton button = (JButton) e.getSource();
			KeyMap keymap = (KeyMap) button.getParent();
			this.model.resetkey(keymap.getPlayerNumber());
			keymap.Updatepanel();
			
		}
		//player panel
		else if(e.getActionCommand().equals("Join")){
			JButton button;
			button = (JButton) e.getSource();
			PlayerPanel parent=(PlayerPanel) button.getParent();
			parent.setPlaystatus();
			this.view.updateratio();
			
		}else if(e.getActionCommand().equals("Give Up")&& this.model.getGameState()==Controls.GAME_PLAY){
			JButton button;
			PlayerPanel parent;
			button = (JButton) e.getSource();
			parent = (PlayerPanel) button.getParent();
			parent.setGiveupStatus();
			this.view.updateratio();
		}
			
		//pausemenu panel
		else if(e.getActionCommand().equals("Full Screen")){
			this.view.dispose();
			this.view= new vbhitView(this.model);
			this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.view.setUndecorated(true);
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showPauseMenu();
			this.view.getActionPanel().getPauseMenu().getScreenButton().setText("Normal Screen");
			this.view.setVisible(true);
		
		}else if(e.getActionCommand().equals("Normal Screen")){
			this.view.dispose();
			this.view= new vbhitView(this.model);
			this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.view.setUndecorated(false);
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showPauseMenu();
			this.view.getActionPanel().getPauseMenu().getScreenButton().setText("Full Screen");
			this.view.setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Resume")){
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.showPlayer();
			this.view.requestFocus();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Quit")){
			this.model.setGameState(Controls.GAME_STOP);
			this.model.resetgame();
			this.view.getLeftpanel().ResetPlayer();
			this.view.getRightpanel().ResetPlayer();
			this.view.getActionPanel().getSaveKeyMapPanel().getBackorResume().setText("Main Menu");
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			vbhitController.this.view.getActionPanel().showTitleMenu();
		}
		//TitleMenu panel
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
			//this.model.getGameSound().BGstart();
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().getSaveKeyMapPanel().getBackorResume().setText("Resume");
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.requestFocus();
			model.createball();
			this.view.updateratio();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		//savekeypanel
		else if(e.getActionCommand().equals("Sound: Off")){
			this.model.SoundOff();
			JButton button = (JButton) e.getSource();
			button.setText("Sound: On");
			button.setForeground(Color.red);
			
			
			
		}else if(e.getActionCommand().equals("Sound: On")){
			this.model.SoundOn();
			JButton button = (JButton) e.getSource();
			button.setText("Sound: Off");
			button.setForeground(Color.green);
		}
		//instruction menu
		else if(e.getActionCommand().equals("Main Menu")){
			this.view.getActionPanel().hideAllSubMenu();
			this.view.showPlayer();
			this.view.getActionPanel().showTitleMenu();
		}
		//SetupMenu
		else if(e.getActionCommand().equals("Start Game!")){
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.requestFocus();
			model.createball();
			this.view.updateratio();
			model.start();
			view.start();
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
