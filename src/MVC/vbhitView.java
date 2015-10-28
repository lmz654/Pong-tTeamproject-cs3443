package MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class vbhitView extends JFrame{
	private vbhitModel model;
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
		time = new Timer(25,new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (i<=0){
					j=-1*j+1;
				} else if(i>=450){
					j=-j;
				}
				i+=j;
				
				actionpanel.paint1(i,j);
				System.out.println(i);
			}
			
		});
		time.start();
		//this.pack();
		//this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		panel = new JPanel[5];
		panel[0]=new JPanel ();
		//panel[0].setLayout(null);
		panel[0].setBounds(0, 0, 1000, 100);
		//panel[0].setSize(1000, 100);
		panel[0].setBackground(Color.blue);
		this.add(panel[0]);
		panel[1]=new JPanel ();
		//panel[1].setLayout(null);
		//panel[1].setSize(250, 500);
		panel[1].setBounds(0, 100, 250, 500);
		panel[1].setBackground(Color.yellow);
		this.add(panel[1]);
		
		//actionpanel=new ActionPanel(model);
		actionpanel.setBounds(250, 100, 500, 500);
		this.add(actionpanel);
		/*panel[2]=new JPanel ();
		//panel[2].setLayout(null);
		//panel[2].setSize(500, 500);
		panel[2].setBounds(250, 100, 500, 500);
		panel[2].setBackground(Color.gray);
		this.add(panel[2]);*/
		
		panel[3]=new JPanel ();
		//panel[3].setLayout(null);
		//panel[3].setSize(250, 500);
		panel[3].setBounds(750, 100, 250, 500);
		panel[3].setBackground(Color.CYAN);
		this.add(panel[3]);
		
		panel[4]=new JPanel ();
		//panel[4].setLayout(null);
		//panel[4].setSize(1000, 100);
		panel[4].setBounds(0, 600, 1000, 100);
		panel[4].setBackground(Color.GREEN);
		this.add(panel[4]);
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
