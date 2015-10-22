package test.basicGame;

import javax.swing.*;

public class BasicGame {

	public static void main(String[] args) {

		BasicModel model = new BasicModel();
		BasicView view = new BasicView(model);
		
		BasicRepaintController repaintController = new BasicRepaintController(model, view);
		
		
		new Timer(25, repaintController).start();

	}

}
