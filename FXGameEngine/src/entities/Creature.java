package entities;

import java.util.ArrayList;

import javafx.scene.image.Image;
import utils.Id;

public abstract class Creature extends Sprite{
	
	private final double MAX_HEALTH = 100;
	private double health = 100;

	public Creature(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * applies damage to creature
	 * @param dmg
	 */
	public void damageCreature(double dmg) {
		if((health - dmg) >= 0) {
			health -= dmg;
		}else {
			health = 0;
		}
		deadCreature();
	}
	
	/**
	 * flips isAlive boolean to false marking object for removal
	 */
	public void deadCreature() {
		if(health <= 0) {
			this.isAlive = false;
		}
	}
	
	
	
	public void removeVillager(ArrayList<Sprite> spriteList) {
		
	}

	@Override
	public abstract void move();

	@Override
	public abstract void move(double velX, double velY);

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getMAX_HEALTH() {
		return MAX_HEALTH;
	}
	
	

}
