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
	private BufferedImage image;
	private PlayerPanel playertop, playerbottom;
	private KeyMap	playertopkey,playerbottomkey;
	private vbhitController controller;
	
	public SidePanel(vbhitController controller, int side){
		this.controller=controller;
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("leftpanel image input fail");
		}
		if(side==1){
			playertop=new PlayerPanel(this.controller.getModel().getPlayer(0));
			playerbottom=new PlayerPanel(this.controller.getModel().getPlayer(3));
			playertopkey = new KeyMap(playertop.getPlayer());
			playerbottomkey= new KeyMap (playerbottom.getPlayer());
		}else if(side == 2){
			playertop=new PlayerPanel(this.controller.getModel().getPlayer(2));
			playerbottom=new PlayerPanel(this.controller.getModel().getPlayer(1));
			playertopkey = new KeyMap(playertop.getPlayer());
			playerbottomkey= new KeyMap (playerbottom.getPlayer());
		}
		
	}
	
	public void update(){
		playertop.update();
		playerbottom.update();
	}
	
	public void showPlayer(){
		this.remove(playertopkey);
		this.remove(playerbottomkey);
		this.add(playertop);
		this.add(playerbottom);
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
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, -200,0,null);
	}

}
