package MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

import MVC.action.ActionPanel;
import MVC.side.SidePanel;
import game.Controls;

public class vbhitView extends JFrame{
	private vbhitModel model;
	private vbhitController controller;
	private Timer time;
	private ActionPanel actionpanel;
	private SidePanel leftpanel,rightpanel;
	public int i,j;
	private int actpanelpos;
	private int leftpanelpos;
	private int rightpanelpos;
	
	
	public vbhitView(vbhitModel model){
		super();
		//setup line between model, view, and controller
		this.model=model;
		controller=new vbhitController(this.model,this);
		this.model.addController(controller);
		
		//create panels
		this.actionpanel =new ActionPanel(this.controller);
		this.leftpanel=new SidePanel(this.controller,1);
		this.rightpanel=new SidePanel(this.controller,2);
		//setup for view
		this.addKeyListener(controller);
		this.setName("vbhit-pong");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setSize(1200, 700);
		this.setUndecorated(false);//set fullscreen
		//add listener for view
		this.addComponentListener(controller);
		this.addWindowStateListener(controller);
		this.addKeyListener(controller);
		//setup for submenu
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
		
		this.actionpanel.setFocusable(false);
		this.leftpanel.setFocusable(false);
		this.rightpanel.setFocusable(false);
		this.setFocusableWindowState(true);
	
		this.leftpanel.showPlayer();
		this.rightpanel.showPlayer();
		this.actionpanel.showTitleMenu();
		
		time = new Timer(Controls.VIEW_TIME,new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) {
				vbhitView.this.actionpanel.repaint();
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
	public void showPlayer(){
		this.leftpanel.showPlayer();
		this.rightpanel.showPlayer();
		this.repaint();
	}
	public void showPlayerKey(){
		this.leftpanel.showPlayerkey();
		this.rightpanel.showPlayerkey();
		this.repaint();
	}
	public void savePlayerKey(){
		this.leftpanel.saveKeyMap();
		this.rightpanel.saveKeyMap();
	}
	public void udatesidepanel(){
		this.leftpanel.update();
		this.rightpanel.update();
	}
	public vbhitController getcontroller(){
		return this.controller;
	}
	public SidePanel getLeftpanel(){
		return this.leftpanel;
	}
	public SidePanel getRightpanel(){
		return this.rightpanel;
	}
	public void updateratio(){
		
		leftpanelpos=0;
		actpanelpos= Math.round((this.getContentPane().getWidth()-this.getContentPane().getHeight())/2);
		rightpanelpos=actpanelpos+this.getContentPane().getHeight();
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		actionpanel.setBounds(actpanelpos, 0,this.getContentPane().getHeight(), this.getContentPane().getHeight());
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		leftpanel.update();
		rightpanel.update();
		actionpanel.update();
		if(this.isFocusableWindow()==false){
			this.setFocusableWindowState(true);
		}
		this.repaint();
		
	}
	
	
	
}
