package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.core.Player;

public class ItemPSlower extends Item {
	
	public ItemPSlower(Point point, BufferedImage image, vbhitModel model) {
		super(point, image, model);
		
	}
	
	@Override
	public void effect(Player player1) {
		super.setPlayer(player1);
		for(Player player: super.getModel().getAllPlayer()){
			if(player.equals(super.getPlayer())==false && player.getPlayerStatus()==2){
				player.DecreasePaddleSpeed(1);
			}
		}
		
	}
	
}
