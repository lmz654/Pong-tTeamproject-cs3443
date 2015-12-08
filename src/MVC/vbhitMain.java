package MVC;

import javax.swing.JFrame;

public class vbhitMain {
	public static void creatwindow(){
		vbhitModel model = new vbhitModel();
		vbhitView view = new vbhitView(model);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
