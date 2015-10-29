package MVC;

import javax.swing.JFrame;

import MVC.view.vbhitView;
import game.Controls;
import game.core.Player;

public class vbhitMain {
	public static void creatwindow(){
		//ActionPanel actionpanel = new ActionPanel(new vbhitModel());
		//actionpanel.setVisible(true);
		vbhitModel model = new vbhitModel();
		vbhitView view = new vbhitView(model);
		vbhitController controller = new vbhitController(model, view);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.pack();
		//frame.setUndecorated(false);
		view.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				creatwindow();
			}
			
		});
	}

}
