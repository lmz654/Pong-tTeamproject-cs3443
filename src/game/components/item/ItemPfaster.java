package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.Controls;
import game.core.Player;

public class ItemPfaster extends Item{

	public ItemPfaster(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effect(Player player) {
		super.setPlayer(player);
		if(super.getPlayer()!=null&&player.getPlayerStatus()==Controls.PLAYER_PLAY){
			this.getPlayer().IncreasePaddleSpeed(2);
		}
	}

}
