package MVC.view;

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
		this.setName("vbhit-pong");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 700);
		this.setUndecorated(true);
		controller=new vbhitController(model,this);
		this.addKeyListener(controller);
		this.addComponentListener(controller);
		actionpanel =new ActionPanel(model,this);
		leftpanel=new LeftPanel();
		rightpanel=new RightPanel();
		actionpanel.setLayout(null);
		leftpanel.setLayout(null);
		rightpanel.setLayout(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		model.createplayer(4);
		model.createball();
		//this.setResizable(false);
		actionpanel.setSize(this.getHeight(),this.getHeight());
		leftpanelpos=0;
		
		actpanelpos=(this.getWidth()-this.getWidth())/2;
		rightpanelpos=actpanelpos+this.getHeight()+1;
		leftpanel.setSize((this.getWidth()-this.getWidth())/2,this.getHeight());
		rightpanel.setSize((this.getWidth()-this.getWidth())/2,this.getHeight());
		rightpanel.setBackground(Color.BLUE);
		leftpanel.setBackground(Color.CYAN);
		actionpanel.setBackground(Color.GREEN);
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getHeight());
		actionpanel.setBounds(actpanelpos, 0, this.getHeight(), this.getHeight());
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getHeight());
		this.add(leftpanel);
		this.add(actionpanel);
		this.add(rightpanel);
		this.addKeyListener(controller);
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
	
	public void updateratio(){
		
		
		actionpanel.setRatiox((float)actionpanel.getSize().width/1000);
		actionpanel.setRatioy((float)actionpanel.getSize().height/1000);
		leftpanelpos=0;
		actpanelpos=(int) ((this.getSize().getWidth()-this.getSize().height)/2);
		rightpanelpos=actpanelpos+this.getHeight();
		rightpanel.setBackground(Color.BLUE);
		leftpanel.setBackground(Color.CYAN);
		actionpanel.setBackground(Color.GREEN);
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getSize().height);
		actionpanel.setBounds(actpanelpos, 0, this.getHeight(), this.getSize().height);
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getHeight());
		this.repaint();
	}
	
	
	
}
