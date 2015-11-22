package MVC.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MVC.vbhitController;
import MVC.vbhitModel;
import game.core.Ball;
import game.core.Player;

public class ActionPanel extends JPanel {
	/*private vbhitModel model;
	private vbhitView view;*/
	private vbhitController	controller;
	private float ratio;
	private BufferedImage image,image1;
	//subpanel
	private PauseMenu pausemenu;
	private SaveKeyMapPanel savekeymappanel;
	private SetupMenu setupmenu;
	private TitleMenu titlemenu;
	private InstructionsMenu instruction;
	public ActionPanel(vbhitController controller){
		super();
		this.controller=controller;
		this.instruction = new InstructionsMenu(this.controller);
		this.pausemenu = new PauseMenu(this.controller);
		this.savekeymappanel = new SaveKeyMapPanel(this.controller);
		this.setupmenu = new SetupMenu(this.controller);
		this.titlemenu = new TitleMenu(this.controller);
		this.pausemenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.setupmenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.savekeymappanel.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.instruction.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		//this.view.getActionPanel().showPauseMenu();
		this.add(this.titlemenu);
		this.add(this.pausemenu);
		this.add(this.savekeymappanel);
		this.add(this.setupmenu);
		this.add(this.instruction);
		this.titlemenu.setVisible(false);
		this.pausemenu.setVisible(false);
		this.savekeymappanel.setVisible(false);
		this.setupmenu.setVisible(false);
		this.instruction.setVisible(false);
		this.setBackground(null);
		this.ratio=(float)this.getSize().width/1000;
		try {
			image = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\actionbg.jpeg"));
		} catch (Exception e) {
			System.err.println("actionpanel image input fail in actionpanel");
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try{
			g.drawImage(image.getSubimage((image.getWidth()-this.getWidth())/2, (image.getHeight()-this.getHeight())/2, this.getWidth(), this.getWidth()), 0, 0, this.getWidth(), this.getHeight(), null);
		}catch(Exception e){
			System.err.println("draw actionpanel background fail in actionpanel");
		}
			float radius;
			float px,py;
			float length,height;
			g.setColor(Color.CYAN);
			//calculate paddles from real to display screen then draw paddles
		try{
			for(Player p:this.controller.getModel().getAllPlayer()){
				length=(p.getPaddle().getLength()*this.ratio);
				height=(p.getPaddle().getHeight()*this.ratio);
				px=(float)p.getPaddle().getPosition().cartesian(0)*this.ratio;
				py=(float)p.getPaddle().getPosition().cartesian(1)*this.ratio;
				
				if(p.getMotionAxis()=='x'||p.getMotionAxis()=='X'){
					g.drawImage(p.getPaddleimage().get(0), Math.round(px-length/2),Math.round(py-height/2)-12 ,Math.round(length), Math.round(height)+25, null);
					//g.fillRect(Math.round(px-length/2),Math.round(py-height/2) ,Math.round(length), Math.round(height) );
				}else{
					g.drawImage(p.getPaddleimage().get(0), Math.round(px-height/2)-12,Math.round(py-length/2) ,Math.round(height)+25 ,Math.round(length), null);
					//g.fillRect(Math.round(px-height/2),Math.round(py-length/2) ,Math.round(height) ,Math.round(length));
				}
					
			}
		}catch(Exception e){
			System.err.println("draw paddleimage fail in actionpanel");
		}
			//calculate balls from real to display screen then draw balls
		try{
			for(Ball b:controller.getModel().getBall()){
				radius=b.getRadius()*this.ratio;
				px=(b.getPosition().toPoint().x*this.ratio)-(radius/2);
				py=(b.getPosition().toPoint().y*this.ratio)-(radius/2);
				g.drawImage(b.getimage(),Math.round(px),Math.round(py),Math.round(radius),Math.round(radius), null);
			}
		}catch(Exception e){
			System.err.println("draw ballimage fail in actionpanel");
		}
		
		
	}
	public void update(){
		this.titlemenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.setupmenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.pausemenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.savekeymappanel.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.instruction.setBounds(Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		this.ratio= (float)this.getHeight()/1000;
	}
	
	public void hideAllSubMenu(){
		this.instruction.setVisible(false);
		this.pausemenu.setVisible(false);
		this.setupmenu.setVisible(false);
		this.titlemenu.setVisible(false);
		this.savekeymappanel.setVisible(false);
	}
	
	public PauseMenu getPauseMenu(){
		return this.pausemenu;
	}
	public void showInstruction(){
		this.instruction.setVisible(true);
	}
	
	public void showSaveMenu(){
		this.savekeymappanel.setVisible(true);
	}
	
	public void showPauseMenu(){
		this.pausemenu.setVisible(true);
	}
	
	public void showTitleMenu(){
		this.titlemenu.setVisible(true);
	}
	
	public void showSetupMenu(){
		this.setupmenu.setVisible(true);
	}
	
	
	
}