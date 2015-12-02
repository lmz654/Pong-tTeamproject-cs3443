package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;

public class ItemPExtended extends Item {

	public ItemPExtended(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
	}

	@Override
	void effect() {
		super.getPlayer().enlargePaddle(10);
	}

}
