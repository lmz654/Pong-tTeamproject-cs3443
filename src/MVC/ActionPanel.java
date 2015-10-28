package MVC;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ActionPanel extends JPanel {
	vbhitModel model;
	public int i;
	public int j;
	BufferedImage image1,image2,image3,image4;
	public ActionPanel(vbhitModel model){
		super();
		this.model=model;
		this.setBackground(Color.GRAY);
		i=50;
		j=0;
		try {
			//the current path at src level or files that the same with folder that src folder in
			image1 = ImageIO.read(new File("src\\MVC\\imagecontainer\\back1.png"));
			image2 = ImageIO.read(new File("src\\MVC\\imagecontainer\\fire2.png"));
			image3 = ImageIO.read(new File("src\\MVC\\imagecontainer\\black1.png"));
			image4 = ImageIO.read(new File("src\\MVC\\imagecontainer\\green2.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public void paint1(int i,int j){
		this.i=i;
		this.j=j;
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image1,j-100,j-100, null);
		//g.drawImage(image3, 0, 0, null);
		g.drawImage(image2, i,100, 50, 50, null);
		g.drawImage(image4,200,i, 50, 50, null);
		g.drawImage(image3, i, i, 50, 50, null);
		//gg.setBackground(this.getBackground());
		
		
		
	}
	
}
