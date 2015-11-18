package MVC.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;
import MVC.vbhitModel;
import MVC.player.KeyMap;

public class LeftPanel extends JPanel{
	private BufferedImage image;
	private PlayerPanel[] player;
	private KeyMap[]	keymap;
	private vbhitController controller;
	public LeftPanel(vbhitController controller){
		this.controller=controller;
		this.setLayout(new GridLayout(2,0,10,10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		player = new PlayerPanel[2];
		keymap =new KeyMap[2];
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("leftpanel image input fail");
		}
		player[0]=new PlayerPanel(this.controller.getModel().getPlayer(0));
		player[1]=new PlayerPanel(this.controller.getModel().getPlayer(3));
		keymap[0] = new KeyMap(player[0].getPlayer());
		keymap[1]= new KeyMap (player[1].getPlayer());
		
		this.add(player[0]);
		this.add(player[1]);
		/*this.add(keymap[0]);
		this.add(keymap[1]);*/
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, -200,0,null);
	}
	

}
