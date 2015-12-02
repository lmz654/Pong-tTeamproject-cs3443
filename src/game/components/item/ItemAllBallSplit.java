package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;

public class ItemAllBallSplit extends Item {

	public ItemAllBallSplit(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
		
	}

	@Override
	void effect() {
		super.getModel().createCoresponseBall(super.getPlayer());
		
	}

}
