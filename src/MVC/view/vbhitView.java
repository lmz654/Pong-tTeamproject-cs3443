package MVC.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

import MVC.vbhitController;
import MVC.vbhitModel;
import game.Controls;

public class vbhitView extends JFrame{
	private vbhitModel model;
	private vbhitController controller;
	private Timer time;
	private ActionPanel actionpanel;
	private LeftPanel leftpanel;
	private RightPanel rightpanel;
	public int i,j;
	private int actpanelpos;
	private int leftpanelpos;
	private int rightpanelpos;
	
	
	public vbhitView(vbhitModel model){
		super();
		this.model=model;
		this.setName("vbhit-pong");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1200, 700);
		this.setUndecorated(false);//set fullscreen
		controller=new vbhitController(model,this);
		this.addKeyListener(controller);
		this.addComponentListener(controller);
		this.addWindowStateListener(controller);
		actionpanel =new ActionPanel(model,this);
		leftpanel=new LeftPanel();
		rightpanel=new RightPanel();
		actionpanel.setLayout(null);
		actionpanel.setBorder(null);
		leftpanelpos=0;
		actpanelpos=(this.getContentPane().getWidth()-this.getContentPane().getHeight())/2;
		rightpanelpos=actpanelpos+this.getContentPane().getHeight();
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		actionpanel.setBounds(actpanelpos, 0, this.getContentPane().getHeight(), this.getContentPane().getHeight());
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		this.add(leftpanel);
		this.add(actionpanel);
		this.add(rightpanel);
		actionpanel.setVisible(true);
		this.addKeyListener(controller);
		this.actionpanel.setFocusable(false);
		this.leftpanel.setFocusable(false);
		this.rightpanel.setFocusable(false);
		this.setFocusableWindowState(true);
		time = new Timer(Controls.VIEW_TIME,new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) {
				vbhitView.this.updateratio();
			}		
		});
		
	}
	public void start(){
		this.time.start();
	}
	public void stop(){
		this.time.stop();
	}
	public ActionPanel getActionPanel(){
		return this.actionpanel;
	}
	public vbhitController getcontroller(){
		return this.controller;
	}
	
	public void updateratio(){
		
		//System.out.println(this.getContentPane().getHeight()+ "  " + this.getContentPane().getWidth());
		
		leftpanelpos=0;
		actpanelpos= Math.round((this.getContentPane().getWidth()-this.getContentPane().getHeight())/2);
		rightpanelpos=actpanelpos+this.getContentPane().getHeight();
		rightpanel.setBackground(Color.BLUE);
		leftpanel.setBackground(Color.CYAN);
		actionpanel.setBackground(Color.GREEN);
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		actionpanel.setBounds(actpanelpos, 0,this.getContentPane().getHeight(), this.getContentPane().getHeight());
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		actionpanel.setRatio((float)this.getContentPane().getHeight()/1000);
		this.repaint();
	}
	
	
	
}
