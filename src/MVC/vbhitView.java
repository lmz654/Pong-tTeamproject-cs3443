package MVC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	private int actpanelpos;
	private int leftpanelpos;
	private int rightpanelpos;
	private BufferedImage backgroundImage;
	
	
	public vbhitView(vbhitModel model){
		super();
		//load background Image
		try {
			backgroundImage = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\background2.jpg"));
		} catch (IOException e) {
			System.err.println("fail to load background Image in view");
		}
		
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
		this.setFocusableWindowState(true);
		//this.setOpacity((float) 0.8);
		
		//add listener to view
		this.addComponentListener(controller);
		this.addWindowStateListener(controller);
		this.addKeyListener(controller);
		
		
		//setup for actionpanel
		actionpanel.setLayout(null);
		actionpanel.setBorder(null);
		actpanelpos=(this.getContentPane().getWidth()-this.getContentPane().getHeight())/2;
		actionpanel.setBounds(actpanelpos, 0, this.getContentPane().getHeight(), this.getContentPane().getHeight());
		actionpanel.setVisible(true);
		this.actionpanel.setFocusable(false);
		this.actionpanel.showTitleMenu();
		this.actionpanel.setOpaque(false);
		this.add(actionpanel);
		
		//leftpanel setup
		leftpanelpos=0;
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		this.leftpanel.setOpaque(false);
		this.leftpanel.setFocusable(false);
		this.leftpanel.showPlayer();
		this.leftpanel.setBorder(null);
		this.add(leftpanel);
		
		//rightpanel setup
		rightpanelpos=actpanelpos+this.getContentPane().getHeight();
		this.rightpanel.setOpaque(false);
		rightpanel.setBounds(rightpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		this.rightpanel.setFocusable(false);		
		this.rightpanel.showPlayer();
		this.rightpanel.setBorder(null);
		this.getContentPane().add(rightpanel);
		
		time = new Timer(Controls.VIEW_TIME,new ActionListener(){	
			public void actionPerformed(ActionEvent arg0) {
				vbhitView.this.actionpanel.repaint();
			}		
		});
	}
	
	
	
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}



	public void setBackgroundImage(BufferedImage backgroundImage) {
		this.backgroundImage = backgroundImage;
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
		this.leftpanel.repaint();
		this.rightpanel.repaint();
	}
	
	public void showPlayerKey(){
		this.leftpanel.showPlayerkey();
		this.rightpanel.showPlayerkey();
		this.leftpanel.repaint();
		this.rightpanel.repaint();
	}
	
	public void savePlayerKey(){
		this.leftpanel.saveKeyMap();
		this.rightpanel.saveKeyMap();
	}
	
	public void updatesidepanel(){
		this.leftpanel.update();
		this.rightpanel.update();
		this.leftpanel.repaint();
		this.rightpanel.repaint();
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
	
	public int getActpanelpos() {
		return actpanelpos;
	}

	public void setActpanelpos(int actpanelpos) {
		this.actpanelpos = actpanelpos;
	}

	public int getLeftpanelpos() {
		return leftpanelpos;
	}

	public void setLeftpanelpos(int leftpanelpos) {
		this.leftpanelpos = leftpanelpos;
	}

	public int getRightpanelpos() {
		return rightpanelpos;
	}

	public void setRightpanelpos(int rightpanelpos) {
		this.rightpanelpos = rightpanelpos;
	}

	public void updateratio(){
		
		leftpanelpos=0;
		actpanelpos= Math.round((this.getContentPane().getWidth()-this.getContentPane().getHeight())/2);
		rightpanelpos=actpanelpos+this.getContentPane().getHeight();
		
		leftpanel.setBounds(leftpanelpos, 0, actpanelpos, this.getContentPane().getHeight());
		actionpanel.setBounds(actpanelpos, 0, this.getContentPane().getHeight(), this.getContentPane().getHeight());
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
