package MVC;

import game.Controls;
import game.core.Player;

public class vbhitMain {
	public static void creatwindow(){
		//ActionPanel actionpanel = new ActionPanel(new vbhitModel());
		//actionpanel.setVisible(true);
		vbhitModel model = new vbhitModel();
		model.addPlayer(new Player("huu",Controls.getPaddle(1),'w','s','x'));
		model.addPlayer(new Player("huu",Controls.getPaddle(1),'w','s','x'));
		vbhitView view = new vbhitView(model);
		vbhitController controller = new vbhitController(model, view);
		
		
		//frame.pack();
		view.setSize(1000, 700);
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
