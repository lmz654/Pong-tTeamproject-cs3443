package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MVC.vbhitModel;
import game.core.Ball;

public class allballspeedup extends Item {
	private ArrayList<Ball> ball;
	
	
	public allballspeedup(Point point, BufferedImage image, ArrayList<Ball>ball) {
		super(point, image);
		this.ball=ball;
		
	}

	void effect(){
		
	}
}

