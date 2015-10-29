package MVC.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MVC.vbhitModel;
import game.core.Ball;
import game.core.Player;

public class ActionPanel extends JPanel {
	private vbhitModel model;
	private vbhitView view;
	private float ratiox,ratioy;
	private BufferedImage image,image1;
	
	public ActionPanel(vbhitModel model,vbhitView view){
		super();
		this.model=model;
		this.view=view;
		this.setBackground(Color.GRAY);
		this.ratiox=(float)this.getSize().width/1000;
		this.ratioy=(float)this.getSize().height/1000;
		System.out.println(this.getSize()+"  "+ratiox);
		try {
			image = ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\actionbg.jpeg"));
			image1 = ImageIO.read(new File("src\\MVC\\imagecontainer\\ball\\fire.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//Graphics2D g2= (Graphics2D)g;
		g.drawImage(image.getSubimage((image.getWidth()-this.getWidth())/2, (image.getHeight()-this.getHeight())/2, this.getWidth(), this.getWidth()), 0, 0, this.getWidth(), this.getHeight(), null);
		Point p1=new Point();
		int length,height;
		g.setColor(Color.CYAN);
		//g.fillRect(100, this.getHeight()-50, 100, 100);
		for(Player p:model.getPlayer()){
			p1.x=(int) (p.getPaddle().getPosition().toPoint().x*this.ratiox);
			p1.y=(int) (p.getPaddle().getPosition().toPoint().y*this.ratioy);
			
			if(p.getMotionAxis()=='x'||p.getMotionAxis()=='X'){
				length=(int) (p.getPaddle().getLength()*this.ratiox);
				height=(int) (p.getPaddle().getHeight()*this.ratioy);
				g.fillRect(p1.x-length/2, p1.y-height/2, length, height);
				System.out.println((p1.x-length/2)+"   " +(p1.y-height/2));
			}else{
				length=(int) (p.getPaddle().getLength()*this.ratioy);
				height=(int) (p.getPaddle().getHeight()*this.ratiox);
				g.fillRect(p1.x-length/2, p1.y-height/2, length, height);
				System.out.println((p1.x-length/2)+"   " +(p1.y-height/2));
			}
				
		}
		//g.drawImage(image1, 100, 100, 50, 50, null);
		for(Ball b:model.getBall()){
			System.out.println("draw one");
			p1.x=(int) (b.getPosition().toPoint().x*this.ratiox);
			p1.y=(int) (b.getPosition().toPoint().y*this.ratioy);
			g.drawImage(image1, p1.x-b.getRadius()/2, p1.y-b.getRadius()/2, (int)(b.getRadius()*this.ratiox), (int)(b.getRadius()*this.ratioy), null);
		}
		
	}
	public float getRatiox() {
		return ratiox;
	}
	public void setRatiox(float ratiox) {
		this.ratiox = ratiox;
	}
	public float getRatioy() {
		return ratioy;
	}
	public void setRatioy(float ratioy) {
		this.ratioy = ratioy;
	}
	
}
