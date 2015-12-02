package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.core.Player;

public class ItemPShrinked extends Item {

	public ItemPShrinked(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
		
	}

	@Override
	void effect() {
		for(Player player: super.getModel().getAllPlayer()){
			if(!player.equals(super.getPlayer())){
				player.shrinkPaddle(5);
			}
		}
		
	}

}
