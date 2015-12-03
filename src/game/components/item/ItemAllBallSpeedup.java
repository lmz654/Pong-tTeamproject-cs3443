package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import MVC.vbhitModel;
import game.core.Ball;
import game.core.Player;

public class ItemAllBallSpeedup extends Item {
		
	public ItemAllBallSpeedup(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
	}

	public void effect(Player player){
		super.setPlayer(player);
		for(Ball ball: super.getModel().getBall()){
			ball.IncreaseSpeed(0.1);
		}
	}
}

