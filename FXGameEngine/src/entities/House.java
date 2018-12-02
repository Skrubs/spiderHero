package entities;

import javafx.scene.image.Image;
import utils.Id;

public abstract class House extends Sprite {

	public House(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void move();
		
	@Override
	public abstract void move(double velX, double velY);

	@Override
	public abstract void update(double timer);

}
