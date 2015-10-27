package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class vbhitView extends JFrame{
	private vbhitModel model;
	private Timer time;
	public ActionPanel panel;
	public int i;
	public vbhitView(vbhitModel model){
		this.setSize(500, 500);
		this.model=model;
		panel =new ActionPanel(model);
		this.add(panel);
		i=50;
		time = new Timer(5,new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (i==800)
					i=50;
				else
					i=i+1;;
				panel.paint1(i);
				//System.out.println(i);
			}
			
		});
		time.start();
		
	}
	
	
	
}
