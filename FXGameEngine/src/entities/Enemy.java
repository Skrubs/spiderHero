package entities;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Distance;
import utils.Id;
import world.Spawnpoint;

public class Enemy extends Creature {
	
	private double agressionRange = 20;
	private ArrayList<Sprite> aggroList = new ArrayList<>();

	public Enemy(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		
	}

	@Override
	public void move() {
		velX = new Random().nextInt(2);
		velY = new Random().nextInt(2);
			
		posX += velX;
		posY += velY;
		
	}
	
	/**
	 * spawn placement of ememies
	 * @param spawn
	 */
	public void spawnEnemey(Spawnpoint spawn) {
		this.posX = spawn.getX();
		this.posY = spawn.getY();
	}
	
	public void aggression(Villager v) {
		double range = Distance.calculateDistance(this.posX, this.posY, v.getPosX(), v.getPosY());
		if(range < 100) {
			
		}
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
		return new Rectangle2D(posX,posY,width,height);
	}
	
	public boolean collision(Rectangle2D rect) {
		return this.getBoundary().intersects(rect);
	}
	
	

}
