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
	BufferedImage image1,image2,image3,image4;
	public ActionPanel(vbhitModel model){
		super();
		this.model=model;
		this.setBackground(Color.GRAY);
		i=50;
		try {
			image1 = ImageIO.read(new File("C:\\Users\\Buffalo\\git\\Pong-tTeamproject-cs3443\\back1.png"));
			image2 = ImageIO.read(new File("C:\\Users\\Buffalo\\git\\Pong-tTeamproject-cs3443\\black1.png"));
			image3 = ImageIO.read(new File("C:\\Users\\Buffalo\\git\\Pong-tTeamproject-cs3443\\back2.png"));
			image4 = ImageIO.read(new File("C:\\Users\\Buffalo\\git\\Pong-tTeamproject-cs3443\\green2.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	public void paint1(int i){
		this.i=i;
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image1, 0, 0, null);
		g.drawImage(image3, 0, 0, null);
		g.drawImage(image2, i,100, 50, 50, null);
		g.drawImage(image4, i,200, 50, 50, null);
		//gg.setBackground(this.getBackground());
		
		
		
	}
	
}
