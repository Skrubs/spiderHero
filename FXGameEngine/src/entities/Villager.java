package entities;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.GameTimer;
import utils.Id;

public class Villager extends Creature {

	private Random gen;
	private int cooldownStart = 0;

	public Villager(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		gen = new Random();
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

	public void move(ArrayList<Sprite> spriteList) {
		
		int cooldown = (int) (GameTimer.getTimer() - cooldownStart);
		
		if (cooldown > 1) {
			switch (gen.nextInt(5)) {
			case 1:
				velX = 2;
				velY = 0;
				break;
			case 2:
				velX = -2;
				velY = 0;
				break;
			case 3:
				velY = 2;
				velX = 0;
				break;
			case 4:
				velY = -2;
				velX = 0;
				break;
			case 5:
				velX = 0;
				velY = 0;
				break;
			default:
				velX = 0;
				velY = 0;
				break;

			}
			cooldownStart = (int) GameTimer.getTimer();
		}

		for (Sprite s : spriteList) {
			if (s.getId() != Id.villager && this.getBoundary().intersects(s.getBoundary())) {

				if (this.velX > 0) {
					velX *= -1;
					posX -= 1;
				} else if (this.velX < 0) {
					velX *= -1;
					posX += 1;
				}
				if (this.velY > 0) {
					velY *= -1;
					posY -= 1;
				} else if (this.velY < 0) {
					velY *= -1;
					posY += 1;
				}
			}
		}
	}

	@Override
	public void update(double timer) {
		move();

	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(posX, posY, width, height);
	}

}
