package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class vbhitView extends JFrame{
	private vbhitModel model;
	private vbhitController controller;
	private Timer time;
	public JPanel[] panel;
	public ActionPanel actionpanel;
	public int i,j;
	public vbhitView(){
		super();
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionpanel =new ActionPanel(model);
		//this.add(panel);
		j=1;
		i=50;
		controller = new vbhitController();
		this.addKeyListener(controller);
		this.setFocusableWindowState(true);
		//this.pack();
		//this.setResizable(false);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel = new JPanel[5];
		panel[0]=new JPanel ();
		//panel[0].setLayout(null);
		panel[0].setBounds(0, 0,300, 700);
		//panel[0].setSize(1000, 100);
		panel[0].setBackground(Color.blue);
		this.add(panel[0]);
		
		
		//actionpanel=new ActionPanel(model);
		actionpanel.setBounds(300, 0, 700, 700);
		this.add(actionpanel);
		
		panel[1]=new JPanel ();
		//panel[1].setLayout(null);
		//panel[1].setSize(250, 500);
		panel[1].setBounds(1000, 0, 300, 700);
		panel[1].setBackground(Color.yellow);
		this.add(panel[1]);
		this.pack();
		
		
	}
	public Point tranferPos(Point p){
		Point point=new Point();
		return point;
	}
	public vbhitView(vbhitModel model){
		/*this.model=model;
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
			
		});*/
		//time.start();
		
	}
	
	
	
}
