package MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
/*import javax.swing.Timer;*/

import MVC.side.KeyMap;
import MVC.side.PlayerPanel;

import javax.swing.JButton;

import game.Controls;
import game.core.Ball;
import game.core.Player;

public class vbhitController implements KeyListener, ActionListener, ComponentListener,WindowStateListener,FocusListener  {
	private vbhitModel model;
	private vbhitView view;
	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void SidePanelRepaint(){
		new Thread(new Runnable(){

			public void run() {
				vbhitController.this.view.updatesidepanel();
		}
			
		}).start();
		
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar()==KeyEvent.VK_ESCAPE && this.model.getGameState()==Controls.GAME_PLAY ){
			//this.model.getGameSound().BGstop();
			this.model.setGameState(Controls.GAME_PAUSE);
			this.model.getGameSound().stopBGsound();
			model.stop();
			view.stop();
			this.view.getActionPanel().showPauseMenu();
		}else if(arg0.getKeyChar()=='h'){
			this.model.CreatRandomItem();
		}else if(arg0.getKeyChar()=='n'){
			model.createDefaultball();
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
		//this.model.getGameSound().ButtonClick();
		//this.model.getGameSound().Explosionsound();
		
		//KeyMap panel
		if(e.getActionCommand().equals("Save Key")){
			this.model.getGameSound().ButtonClick();
			JButton button;
			button = (JButton) e.getSource();
			KeyMap parent=(KeyMap) button.getParent();
			parent.savekey();
			
		}else if(e.getActionCommand().equals("Reset")){
			this.model.getGameSound().ButtonClick();
			JButton button = (JButton) e.getSource();
			KeyMap keymap = (KeyMap) button.getParent();
			keymap.getPlayer().resetkey();
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
			//this.model.getGameSound().ButtonClick();
			this.view.dispose();
			this.view= new vbhitView(this.model);
			this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.view.setUndecorated(true);
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showPauseMenu();
			this.view.getActionPanel().getPauseMenu().getScreenButton().setText("Normal Screen");
			this.view.setVisible(true);
		
		}else if(e.getActionCommand().equals("Normal Screen")){
			//this.model.getGameSound().ButtonClick();
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
			//this.model.getGameSound().ButtonClick();
			this.model.getGameSound().BGsound();
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.showPlayer();
			this.view.requestFocus();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Quit")){
			this.model.getGameSound().stopBGsound();
			this.model.getGameSound().ButtonClick();
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
			this.model.getGameSound().ButtonClick();
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showSetupMenu();
		}
		else if(e.getActionCommand().equals("Instructions")){
			this.model.getGameSound().ButtonClick();
			this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().showInstruction();
			
		}else if(e.getActionCommand().equals("Options")){
			this.model.getGameSound().ButtonClick();
			this.view.getActionPanel().hideAllSubMenu();
			this.view.showPlayerKey();
			this.view.getActionPanel().showSaveMenu();
		}else if(e.getActionCommand().equals("Start")){
			this.model.getGameSound().BGsound();
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.view.getActionPanel().getSaveKeyMapPanel().getBackorResume().setText("Resume");
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.requestFocus();
			model.createDefaultball();
			this.view.updateratio();
			model.start();
			view.start();
		}else if(e.getActionCommand().equals("Exit")){
			System.exit(1);
		}
		//savekeypanel
		else if(e.getActionCommand().equals("Sound: Off")){
			
			this.model.getGameSound().Off();
			JButton button = (JButton) e.getSource();
			button.setText("Sound: On");
			button.setForeground(Color.red);
			
			
			
		}else if(e.getActionCommand().equals("Sound: On")){
			
			this.model.getGameSound().On();
			this.model.getGameSound().ButtonClick();
			JButton button = (JButton) e.getSource();
			button.setText("Sound: Off");
			button.setForeground(Color.green);
		}
		//instruction menu
		else if(e.getActionCommand().equals("Main Menu")){
			this.model.getGameSound().ButtonClick();
			this.view.getActionPanel().hideAllSubMenu();
			this.view.showPlayer();
			this.view.getActionPanel().showTitleMenu();
		}
		//SetupMenu
		else if(e.getActionCommand().equals("Start Game!")){
			this.model.getGameSound().BGsound();
			vbhitController.this.view.getActionPanel().hideAllSubMenu();
			this.model.setGameState(Controls.GAME_PLAY);
			this.view.requestFocus();
			model.createDefaultball();
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

	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField textfield = (JTextField) arg0.getSource();
		textfield.selectAll();
		
		
	}

	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	

}
