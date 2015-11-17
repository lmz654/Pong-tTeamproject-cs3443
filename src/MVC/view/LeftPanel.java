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

public class LeftPanel extends JPanel{
	BufferedImage image;
	PlayerPanel[] player;
	public LeftPanel(){
		this.setLayout(new GridLayout(2,0));
		this.setBorder(BorderFactory.createEtchedBorder(Color.green, Color.blue));
		player = new PlayerPanel[2];
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\leftblackhole.jpg"));
		} catch (IOException e) {
			System.err.println("leftpanel image input fail");
		}
		player[0]=new PlayerPanel();
		player[1]=new PlayerPanel();
		//player[0].setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(player[0]);
		this.add(player[1]);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, -200,0,null);
	}
	

}
