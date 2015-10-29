package MVC.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RightPanel extends JPanel {
	BufferedImage image;
	public RightPanel(){
		try {
			image= ImageIO.read(new File("src\\MVC\\imagecontainer\\background\\rightblackhole.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, -200,0,800,800,null);
	}
	

}

