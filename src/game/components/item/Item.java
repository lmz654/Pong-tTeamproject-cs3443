package game.components.item;

import java.awt.Point;
import java.awt.image.BufferedImage;

import MVC.vbhitModel;
import game.core.Player;

public abstract class Item {
	private Point point;
	private BufferedImage image;
	private Player player;
	private vbhitModel model;
	
	public Item(Point point, BufferedImage image, vbhitModel model){
		this.point=point;
		this.image=image;
		this.player=null;
		this.model=model;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public vbhitModel getModel() {
		return model;
	}

	public void setModel(vbhitModel model) {
		this.model = model;
	}

	abstract void effect();
	
}
