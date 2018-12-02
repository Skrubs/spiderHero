package entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import utils.Id;

public class Border {

	private Image borderImage;
	private double x;
	private double y;
	private double width;
	private double height;
	private Id id;

	public Border(Image borderImage, double x, double y, Id id) {
		this.borderImage = borderImage;
		this.x = x;
		this.y = y;
		this.width = borderImage.getWidth();
		this.height = borderImage.getHeight();
		this.id = id;
	}

	public Rectangle2D getBoundary() {
		return new Rectangle2D(x, y, width, height);
	}

	public boolean collision(Sprite s) {
		return this.getBoundary().intersects(s.getBoundary());
	}

	public void borderInteraction(Sprite s) {
		if (this.collision(s)) {
			if (s.getId() == Id.player) {
				if (s.getVelX() > 0) {
					s.setPosX(s.getPosX() - 3);
					s.setVelX(0);
				} else if (s.getVelX() < 0) {
					s.setPosX(s.getPosX() + 3);
					s.setVelX(0);
				}

				if (s.getVelY() > 0) {
					s.setPosY(s.getPosY() - 3);
					s.setVelY(0);
				} else if (s.getVelY() < 0) {
					s.setPosY(s.getPosY() + 3);
					s.setVelY(0);
				}
			}

			if (s.getId() == id.villager) {
				s.setVelocity(s.getVelX() * (-1), s.getVelY() * (-1));
			}

		}
		
		if(s.getId() == Id.enemy) {
			s.setVelocity(s.getVelX() * (-1), s.getVelY() * (-1));
		}

	}

	public void debugRenderBorder(GraphicsContext gc) {
		gc.strokeRect(this.getBoundary().getMinX(), this.getBoundary().getMinY(), this.getBoundary().getWidth(),
				this.getBoundary().getHeight());
	}

	public Image getBorderImage() {
		return borderImage;
	}

	public void setBorderImage(Image borderImage) {
		this.borderImage = borderImage;
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

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

}
