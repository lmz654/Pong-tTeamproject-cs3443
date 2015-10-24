package game.math;

public class CollidableCircle extends Collidable {

	public CollidableCircle(Object object, Vector position) {
		super(object, position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collidable intersects(Collidable object) {
		if (object instanceof CollidableCircle) {
			
		} else if (object instanceof CollidableRect) {
			// TODO Figure out math for Collision of Circle and Rectangle
		}
		
		return null;
	}

}
