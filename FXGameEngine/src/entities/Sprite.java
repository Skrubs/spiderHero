package entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Id;
import utils.ImageLoader;

public abstract class Sprite {
	
	
	
	protected double posX;
	protected double posY;
	protected double width;
	protected double height;
	protected double velX;
	protected double velY;
	protected boolean isAlive;
	protected Image spriteImage;
	protected Id id;
	
	public Sprite(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		if(spriteImage != null) {
			this.spriteImage = spriteImage;
		}else {
			this.spriteImage = ImageLoader.missImage;
		}
		
		width = this.spriteImage.getWidth();
		height = this.spriteImage.getHeight();
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.id = id;
		isAlive = true;
	}
	
	public abstract void move();
	public abstract void move(double velX, double velY);
	public abstract void update(double timer);
	
	
	/**
	 * returns the bounds of the game object
	 * @return
	 */
	public abstract Rectangle2D getBoundary();
		
	
	/**
	 * determines collision between two sprites
	 * @param s
	 * @return
	 */
	public boolean collision(Sprite s) {
		return this.getBoundary().intersects(s.getBoundary());
	}
	
	/**
	 * determines collision between sprite and any Rectangle2D
	 * @param rect
	 * @return
	 */
	public boolean collision(Rectangle2D rect) {
		return this.getBoundary().intersects(rect);
	}
	
		
	/**
	 * sets the position of the game object
	 * @param posX
	 * @param posY
	 */
	public void setPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * sets the velocity of the game object
	 * @param velX
	 * @param velY
	 */
	public void setVelocity(double velX, double velY) {
		this.velX = velX;
		this.velY = velY;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Image getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(Image spriteImage) {
		this.spriteImage = spriteImage;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
	

}
