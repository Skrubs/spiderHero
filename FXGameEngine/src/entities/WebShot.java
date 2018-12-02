package entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Id;

public class WebShot extends Sprite {

	public WebShot(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
	}

	@Override
	public void move() {
		posX += velX;
		posY += velY;
		
	}

	@Override
	public void move(double velX, double velY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(double timer) {
		move();
		
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(posX+20, posY+20, width-50,height-55);
	}

}
