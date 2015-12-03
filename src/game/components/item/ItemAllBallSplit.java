package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.core.Player;

public class ItemAllBallSplit extends Item {

	public ItemAllBallSplit(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
		
	}

	@Override
	public void effect(Player player) {
		super.setPlayer(player);
		super.getModel().createCoresponseBall(super.getPlayer());
		
	}

}
