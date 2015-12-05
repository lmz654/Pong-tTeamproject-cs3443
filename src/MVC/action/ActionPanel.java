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
import game.Controls;
import game.components.item.Item;
import game.core.Ball;
import game.core.Player;

public class ActionPanel extends JPanel {
	
	private vbhitController	controller;
	private float ratio;
	private BufferedImage center,topleft,topright,bottomleft,bottomright;
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
			//center = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\background1.jpeg"));
			topleft = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\topleft.png"));
			topright = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\topright.png"));
		} catch (Exception e) {
			System.err.println("actionpanel image input fail in actionpanel");
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try{
			g.drawImage(center, 0, 0, null);
			g.drawImage(this.topleft,-10,-10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			g.drawImage(this.topright,Math.round(850*this.ratio)+10,-10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			//g.drawImage(image.getSubimage((image.getWidth()-this.getWidth())/2, (image.getHeight()-this.getHeight())/2, this.getWidth(), this.getWidth()), 0, 0, this.getWidth(), this.getHeight(), null);
			
		}catch(Exception e){
			System.err.println("draw actionpanel background fail in actionpanel");
		}
			float radius;
			float px,py;
			float length,height;
			g.setColor(Color.CYAN);
		try{
			for(Item item: this.controller.getModel().getItem()){
				if(item!=null){
					px=(float) (item.getPoint().x-Controls.ITEM_WIDTH/2)*this.ratio;
					py=(float) (item.getPoint().y-Controls.ITEM_HEIGTH/2)*this.ratio;
					g.drawImage(item.getImage(),Math.round(px),Math.round(py),
							Math.round((float)Controls.ITEM_WIDTH*this.ratio),Math.round((float)Controls.ITEM_HEIGTH*this.ratio), null);
				}
			}
		}catch(Exception e){
			System.err.println("fail to draw power up in actionpanel");
		}
			//calculate paddles from real to display screen then draw paddles
		try{
			for(Player p:this.controller.getModel().getAllPlayer()){
				if(p!=null){
					length=(p.getPaddle().getLength()*this.ratio);
					height=(p.getPaddle().getHeight()*this.ratio);
					px=(float)p.getPaddle().getPosition().cartesian(0)*this.ratio;
					py=(float)p.getPaddle().getPosition().cartesian(1)*this.ratio;
					
					if(p.getMotionAxis()=='x'||p.getMotionAxis()=='X'){
						g.drawImage(p.getPaddleimage().get(0), Math.round(px-length/2),Math.round(py-height/2)-12 ,
								Math.round(length), Math.round(height)+25, null);
					
					}else{
						g.drawImage(p.getPaddleimage().get(0), Math.round(px-height/2)-12,Math.round(py-length/2) ,
								Math.round(height)+25 ,Math.round(length), null);
						
					}
				}	
			}
		}catch(Exception e){
			System.err.println("draw paddleimage fail in actionpanel");
		}
			//calculate balls from real to display screen then draw balls
		try{
			for(Ball b:controller.getModel().getBall()){
				if(b!=null){
					radius=b.getRadius()*this.ratio;
					px=(b.getPosition().toPoint().x*this.ratio)-(radius/2);
					py=(b.getPosition().toPoint().y*this.ratio)-(radius/2);
					g.drawImage(b.getimage(),Math.round(px),Math.round(py),Math.round(radius),Math.round(radius), null);
				}
			}
		}catch(Exception e){
			System.err.println("draw ballimage fail in actionpanel");
		}
		
		
	}
	public void update(){
		this.ratio= (float)this.getHeight()/1000;
		this.titlemenu.setBounds(
				Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),
				Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		
		this.setupmenu.setBounds(
				Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),
				Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		
		this.pausemenu.setBounds(
				Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),
				Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		
		this.savekeymappanel.setBounds(
				Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),
				Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		
		this.instruction.setBounds(
				Math.round(this.getWidth()/2-this.getWidth()/8),Math.round(this.getHeight()/2-this.getHeight()/8),
				Math.round(this.getWidth()/4),Math.round(this.getHeight()/4));
		
		this.center=this.controller.getView().getBackgroundImage().getSubimage(
				this.controller.getView().getActpanelpos(),0,this.getWidth(),this.getHeight());
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
	public SaveKeyMapPanel getSaveKeyMapPanel(){
		return this.savekeymappanel;
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
