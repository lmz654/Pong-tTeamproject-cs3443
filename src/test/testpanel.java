package test;

import javax.swing.JFrame;

import MVC.view.PlayerPanel;
import MVC.view.menu.PauseMenu;

public class testpanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("trying");
		frame.setSize(400,400);
		frame.add(new PauseMenu());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	}

}
