package MVC;

public class vbhitMain {
	public static void creatwindow(){
		//ActionPanel actionpanel = new ActionPanel(new vbhitModel());
		//actionpanel.setVisible(true);
		vbhitView frame = new vbhitView();
		//frame.pack();
		frame.setSize(1000, 700);
		//frame.setUndecorated(false);
		frame.setVisible(true);
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
