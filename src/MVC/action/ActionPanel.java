package MVC.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MVC.vbhitController;
import MVC.vbhitModel;
import game.Controls;
import game.components.item.Item;
import game.components.obstacles.Obstacle;
import game.core.Ball;
import game.core.Player;
import game.math.structures.Vector;

public class ActionPanel extends JPanel {
	
	private vbhitController	controller;
	private float ratio;
	private BufferedImage centerbackground,topleft,topright,bottomleft,bottomright;
	//subpanel
	private ReportMenu reportmenu;
	private PauseMenu pausemenu;
	private SaveKeyMapPanel savekeymappanel;
	private SetupMenu setupmenu;
	private TitleMenu titlemenu;
	private InstructionsMenu instruction;
	private ExecutorService ex;
	public ActionPanel(vbhitController controller){
		super();
		
		this.controller=controller;
		this.instruction = new InstructionsMenu(this.controller);
		this.pausemenu = new PauseMenu(this.controller);
		this.savekeymappanel = new SaveKeyMapPanel(this.controller);
		this.setupmenu = new SetupMenu(this.controller);
		this.titlemenu = new TitleMenu(this.controller);
		this.reportmenu = new ReportMenu(this.controller);
		this.add(this.reportmenu);
		this.add(this.titlemenu);
		this.add(this.pausemenu);
		this.add(this.savekeymappanel);
		this.add(this.setupmenu);
		this.add(this.instruction);
		this.reportmenu.setVisible(false);
		this.titlemenu.setVisible(false);
		this.pausemenu.setVisible(false);
		this.savekeymappanel.setVisible(false);
		this.setupmenu.setVisible(false);
		this.instruction.setVisible(false);
		this.setBackground(null);
		this.ratio=(float)this.getSize().width/1000;
		try {
			centerbackground = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\background2.jpg"));
			topleft = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\topleft.png"));
			topright = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\topright.png"));
			bottomleft = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\bottmleft.png"));
			bottomright = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\bottomright.png"));
		} catch (Exception e) {
			System.err.println("actionpanel image input fail in actionpanel");
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try{
			
			g.drawImage(this.centerbackground,0,0,null);
			g.drawImage(this.topleft,-10,-10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			g.drawImage(this.topright,Math.round(850*this.ratio)+10,-10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			g.drawImage(this.bottomleft,-10,Math.round(850*this.ratio)+10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			g.drawImage(this.bottomright,Math.round(850*this.ratio)+10,Math.round(850*this.ratio)+10,Math.round(150*this.ratio),Math.round(150*this.ratio),null);
			//g.drawImage(image.getSubimage((image.getWidth()-this.getWidth())/2, (image.getHeight()-this.getHeight())/2, this.getWidth(), this.getWidth()), 0, 0, this.getWidth(), this.getHeight(), null);
			
		}catch(Exception e){
			System.err.println("draw actionpanel background fail in actionpanel");
		}
			int l;
			double radius;
			double px,py;
			double length,height;
			g.setColor(Color.CYAN);
			final Graphics g1=g;
			try{
				l=this.controller.getModel().getObstacle().size();
				for(int i=0;i<this.controller.getModel().getObstacle().size();i++){
					Obstacle o = this.controller.getModel().getObstacle().get(i);
					if(o!=null){
						px=(float) (o.getPosition().x-Controls.WHACKY_OBSTACLE_WIDTH/2)*this.ratio;
						py=(float) (o.getPosition().y-Controls.WHACKY_OBSTACLE_HEIGHT/2)*this.ratio;
						g.drawImage(o.getImage(),(int)Math.round(px),(int)Math.round(py),
							Math.round((float)Controls.WHACKY_OBSTACLE_WIDTH*this.ratio),Math.round((float)Controls.WHACKY_OBSTACLE_HEIGHT*this.ratio), null);
					}
				}
			}catch(Exception e){
				System.err.println("fail to draw power up in actionpanel");
			}
		try{
			l=this.controller.getModel().getItem().size();
			for(int i=0;i<this.controller.getModel().getItem().size();i++){
				Item item = this.controller.getModel().getItem().get(i);
				if(item!=null){
					px=(float) (item.getPoint().x-Controls.ITEM_WIDTH/2)*this.ratio;
					py=(float) (item.getPoint().y-Controls.ITEM_HEIGTH/2)*this.ratio;
					g.drawImage(item.getImage(),(int)Math.round(px),(int)Math.round(py),
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
					px=p.getPaddle().getPosition().cartesian(0)*this.ratio;
					py=p.getPaddle().getPosition().cartesian(1)*this.ratio;
					
					if(p.getMotionAxis()=='x'||p.getMotionAxis()=='X'){
						g.drawImage(p.getPaddleimage().get(0), (int)Math.round(px-length/2),(int) (Math.round(py-height/2)-12) ,
								(int)Math.round(length), (int) (Math.round(height)+25), null);
					
					}else{
						g.drawImage(p.getPaddleimage().get(0), (int)(Math.round(px-height/2)-12),(int)Math.round(py-length/2) ,
								(int)Math.round(height)+25 ,(int)Math.round(length), null);
						
					}
				}	
			}
			
		}catch(Exception e){
			System.err.println("draw paddleimage fail in actionpanel");
		}
			
		try{
			ex = Executors.newCachedThreadPool();
			for(final Ball b:controller.getModel().getBall()){
				
				//c++;
				if(b!=null){
					Thread t=new Thread(new Runnable(){

						public void run() {
							int i;
							double px,py;
							double temp;
							double radius;
							double ratio = ActionPanel.this.ratio;
							//Graphics g1=g;
							radius=b.getRadius()*ratio;
							i=6-b.getBallshaddow().size();
							try{
								for(Vector v : b.getBallshaddow()){
									if(v!=null){
										px=v.cartesian(0)*ratio-(radius/2);
										py=v.cartesian(1)*ratio-(radius/2);
										g1.drawImage(b.getShadowimage().get(i),
											(int)Math.round(px),(int)Math.round(py),(int)Math.round(radius),(int)Math.round(radius),null);
										i++;
									}
								}
							}catch(Exception e){
								System.err.println(e);
							}
							
							radius=b.getRadius()*ratio;
							px=(float) ((b.getPosition().cartesian(0)*ratio)-(radius/2));
							py=(float) ((b.getPosition().cartesian(1)*ratio)-(radius/2));
							g1.drawImage(b.getimage(),(int)Math.round(px),(int)Math.round(py),(int)Math.round(radius),(int)Math.round(radius), null);
							
					}});
					ex.execute(t);
					
				}
			}
			ex.shutdown();
			while(!ex.isTerminated()){
				
			}
			
		}catch(Exception e){
			System.err.println("draw ballimage fail in actionpanel");
		}
		
		try{
			while(this.controller.getModel().getBallGone().isEmpty()==false){
				Vector v = this.controller.getModel().getBallGone().getFirst();
				px=(float) (v.cartesian(0)-Controls.EXPLOSE_IMAGE_WIDTH/2)*this.ratio;
				py=(float) (v.cartesian(1)-Controls.EXPLOSE_IMAGE_HEIGTH/2)*this.ratio;
				g.drawImage(this.controller.getModel().getExplose(),(int)Math.round(px),(int)Math.round(py),
						(int)Math.round(this.ratio*Controls.EXPLOSE_IMAGE_WIDTH),(int)Math.round(this.ratio*Controls.EXPLOSE_IMAGE_HEIGTH), null);
				this.controller.getModel().getBallGone().removeFirst();
			}
		}catch(Exception e){
			System.err.println("in explose image"+e);
		}
		g.drawString(""+this.controller.getModel().getGametimer()/60000 +" : "+
		(this.controller.getModel().getGametimer()%60000)/1000 + " : "+ 
		this.controller.getModel().getGametimer()%1000, this.getWidth()-70 ,20);
		g.drawString("# of Object: "+this.controller.getModel().totalObject(), 10, 20);
		
	}
	public void update(){
		this.ratio= (float)this.getHeight()/1000;
		this.reportmenu.setBounds(Math.round(this.getWidth()/2-this.getWidth()*3/8),Math.round(this.getHeight()/2-this.getHeight()/6),
				Math.round(this.getWidth()*3/4),Math.round(this.getHeight()/3));
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
		
		this.centerbackground=this.controller.getView().getBackgroundImage().getSubimage(
				this.controller.getView().getActpanelpos(),0,this.getWidth(),this.getHeight());
	}
	
	public void hideAllSubMenu(){
		this.instruction.setVisible(false);
		this.pausemenu.setVisible(false);
		this.setupmenu.setVisible(false);
		this.titlemenu.setVisible(false);
		this.savekeymappanel.setVisible(false);
		this.reportmenu.setVisible(false);
	}
	
	
	public PauseMenu getPauseMenu(){
		return this.pausemenu;
	}
	public SaveKeyMapPanel getSaveKeyMapPanel(){
		return this.savekeymappanel;
	}
	public void showReportMenu(){
		this.reportmenu.ShowPanel();
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
