package world;

import entities.Sprite;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Id;

public abstract class Tile {
	
	
	private Image tileImage;
	private double x;
	private double y;
	private double width;
	private double height;
	private boolean solid;
	private static int tileId = 0;
	private Id id;
	
	public Tile(Image tileImage,double x, double y,boolean solid, Id id) {
		width = 32;
		height = 32;
		this.tileImage = tileImage;
		this.x = x;
		this.y = y;
		this.id = id;
		tileId++;
		
		
	}
	
	public Rectangle2D getBoundary() {
		return new Rectangle2D(x, y, width, height);
	}
	
	public boolean collision(Sprite s) {
		return this.getBoundary().intersects(s.getBoundary());
	}

	public Image getTileImage() {
		return tileImage;
	}

	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
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

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public static int getTileId() {
		return tileId;
	}

	public static void setTileId(int tileId) {
		Tile.tileId = tileId;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
	
	

}
