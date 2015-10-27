package game.math;

import java.util.ArrayList;

import game.core.Paddle;

public class CollidableRect extends Collidable {
	private int width, height;

	public CollidableRect(Object object) {
		super(object);
		// TODO Auto-generated constructor stub
		if (object instanceof Paddle) {
			this.position = ((Paddle)object).getPosition();
			this.width = ((Paddle)object).getLength();
			this.height = ((Paddle)object).getHeight();
		}
	}
	
	@Override
	public ArrayList<Bound> getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
