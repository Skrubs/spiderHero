package entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Id;

public class YellowHouse extends House {

	public YellowHouse(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(double velX, double velY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(this.posX+45, this.posY+230, width - 100, height-270);
	}

}
