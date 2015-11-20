package test;

import javax.swing.JFrame;

import MVC.action.InstructionsMenu;
import MVC.action.PauseMenu;
import MVC.action.SetupMenu;
import MVC.action.TitleMenu;
import MVC.side.PlayerPanel;

public class testpanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("trying");
		frame.setSize(400,400);
		//frame.add(new PauseMenu()); // menu when user hits the pause button
		//frame.add(new TitleMenu()); // menu when the user first starts the game
		frame.add(new SetupMenu()); // sub menu of main menu that lets user customize settings
		frame.add(new InstructionsMenu()); // sub menu of main menu that explains the rules of the game to the player
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
