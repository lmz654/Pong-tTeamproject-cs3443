package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.Controls;
import game.core.Player;

public class ItemPExtended extends Item {

	public ItemPExtended(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
	}

	@Override
	public void effect(Player player) {
		super.setPlayer(player);
		if(super.getPlayer()!=null&&player.getPlayerStatus()==Controls.PLAYER_PLAY){
			super.getPlayer().enlargePaddle(10);
		}
	}

}
