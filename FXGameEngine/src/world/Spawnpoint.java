package world;

import javafx.geometry.Rectangle2D;

public class Spawnpoint {
	
	
	private double x;
	private double y;
	private double width = 10;
	private double height = 10;
	
	
	public Spawnpoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Rectangle2D getSpawnPoint() {
		return new Rectangle2D(x,y,width,height);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
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

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
	
	
	

}
