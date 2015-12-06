package MVC.side;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import MVC.vbhitController;

public class SidePanel extends JPanel{
	private BufferedImage imageleft,imageright;
	private PlayerPanel playertop, playerbottom;
	private KeyMap	playertopkey,playerbottomkey;
	private vbhitController controller;
	private int side;//1 left 2 right
	
	public SidePanel(vbhitController controller, int side){
		this.controller=controller;
		this.side=side;
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		/*try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("leftpanel image input fail");
		}*/
		if(side==1){
			try {
				imageleft= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftsidebackground.jpg"));
			} catch (IOException e) {
				System.err.println("leftpanel image input fail");
			}
			playertop=new PlayerPanel(this.controller.getModel().getPlayer(0),this.controller,0);
			playerbottom=new PlayerPanel(this.controller.getModel().getPlayer(3),this.controller,3);
			playertopkey = new KeyMap(playertop.getPlayer(),this.controller,0);
			playerbottomkey= new KeyMap (playerbottom.getPlayer(),this.controller,3);
		}else if(side == 2){
			try {
				imageright= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\rightsidebackground.jpg"));
			} catch (IOException e) {
				System.err.println("leftpanel image input fail");
			}
			playertop=new PlayerPanel(this.controller.getModel().getPlayer(2),this.controller,2);
			playerbottom=new PlayerPanel(this.controller.getModel().getPlayer(1),this.controller,1);
			playertopkey = new KeyMap(playertop.getPlayer(),this.controller,2);
			playerbottomkey= new KeyMap (playerbottom.getPlayer(),this.controller,1);
		}
		
	}
	
	public void update(){
		playertop.update();
		playerbottom.update();
		this.repaint();
	}
	
	public void showPlayer(){
		this.remove(playertopkey);
		this.remove(playerbottomkey);
		this.add(playertop);
		this.add(playerbottom);
	}
	
	public void ResetPlayer(){
		this.playertop.resetPanel();
		this.playerbottom.resetPanel();
	}
	public void showPlayerkey(){
		this.remove(playertop);
		this.remove(playerbottom);
		this.add(playertopkey);
		this.add(playerbottomkey);
	}
	
	public void saveKeyMap(){
		this.playerbottomkey.savekey();
		this.playertopkey.savekey();
	}
	@Override
	protected void paintComponent(Graphics g) {
		
		
		if(this.side==1){
			g.drawImage(imageleft.getSubimage(
					Math.round((imageleft.getWidth()-this.getWidth())/2),Math.round((imageleft.getHeight()-this.getHeight())/2),
					this.getWidth(),this.getHeight()), 
					0, 0,null);
		}else if(this.side==2){
			g.drawImage(imageright.getSubimage(
					Math.round((imageright.getWidth()-this.getWidth())/2),Math.round((imageright.getHeight()-this.getHeight())/2),
					this.getWidth(),this.getHeight()), 
					0, 0,null);
		}
		super.paintComponent(g);		
	}

}
