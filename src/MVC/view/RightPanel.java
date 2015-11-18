package MVC.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import MVC.vbhitController;
import MVC.vbhitModel;
import MVC.player.KeyMap;
import javazoom.jl.player.Player;

public class RightPanel extends JPanel {
	private BufferedImage image;
	private PlayerPanel[] player;
	private KeyMap[] keymap;
	private vbhitController controller;
	public RightPanel(vbhitController controller){
		player = new PlayerPanel[2];
		keymap = new KeyMap[2];
		this.controller=controller;
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new GridLayout(2,0,10,10));
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("rightpanel image input fail");
		}
		player[0]=new PlayerPanel(this.controller.getModel().getPlayer(2));
		player[1]=new PlayerPanel(this.controller.getModel().getPlayer(1));
		this.keymap[0]= new KeyMap(player[0].getPlayer());
		this.keymap[1]=new KeyMap(player[1].getPlayer());
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

