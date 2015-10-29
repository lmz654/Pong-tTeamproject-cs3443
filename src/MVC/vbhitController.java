package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import MVC.view.vbhitView;
import game.core.Ball;
import game.core.Player;

public class vbhitController implements KeyListener, ActionListener, ComponentListener  {
	private vbhitModel model;
	private vbhitView view;
	private Timer time;
	public vbhitController(vbhitModel model, vbhitView view) {
		super();
		this.model = model;
		this.view = view;
		//time = new Timer(25,this);
	}
	public class updategame implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyChar()=='q'){
			//view.setUndecorated(true);
			System.exit(1);
		}else if(arg0.getKeyChar()=='t'){
			model.checkCollisions();
			for(Ball b:model.getBall()){
				b.move();
			}
			view.repaint();
			System.out.println(model.getBall().get(0).getPosition().toPoint());
		}
		else{
			/*for(Player temp:model.getPlayer()){
				if(temp.getKeydownleft()==arg0.getKeyChar())
					temp.setKeydownleftpress(1);
				if(temp.getKeyupright()==arg0.getKeyChar())
					temp.setKeydownleftpress(1);
			}*/
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		/*for(Player temp:model.getPlayer()){
			if(temp.getKeydownleft()==arg0.getKeyChar())
				temp.setKeydownleftpress(0);
			if(temp.getKeyupright()==arg0.getKeyChar())
				temp.setKeydownleftpress(0);
		}*/
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		model.checkCollisions();
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		view.updateratio();
		
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
