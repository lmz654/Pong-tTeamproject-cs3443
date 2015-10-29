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
import game.core.Player;

public class ActionPanel extends JPanel {
	private vbhitModel model;
	private vbhitView view;
	private float ratiox,ratioy;
	
	public ActionPanel(vbhitModel model,vbhitView view){
		super();
		this.model=model;
		this.view=view;
		this.setBackground(Color.GRAY);
		ratiox=(float)this.getSize().width/1000;
		ratioy=(float)this.getSize().height/1000;
		
	}
	public void paint1(int i,int j){
		
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Point p1=new Point();
		int length,height;
		g.setColor(Color.BLUE);
		g.fillRect(100, 100, 100, 100);
		for(Player p:model.getPlayer()){
			System.out.println(p.getPaddle().getPosition().cartesian(1));
			p1.x=(int) (p.getPaddle().getPositionp().x*this.ratiox);
			p1.y=(int) (p.getPaddle().getPositionp().y*this.ratioy);
			if(p.getMotionAxis()=='x'||p.getMotionAxis()=='X'){
				length=(int) (p.getPaddle().getLength()*this.ratiox);
				height=(int) (p.getPaddle().getHeight()*this.ratioy);
				g.fillRect(p1.x-length/2, p1.y-height/2, length, height);
			}else{
				length=(int) (p.getPaddle().getLength()*this.ratioy);
				height=(int) (p.getPaddle().getHeight()*this.ratiox);
				g.fillRect(p1.x-height/2, p1.y-length/2, height, length);
			}
				
		}
		
	}
	
}
