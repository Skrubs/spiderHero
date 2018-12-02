package utils;

import application.Main;
import entities.Player;

public class Camera {
	
	private double offsetX;
	private double offsetY;
	
	public Camera(double offsetX, double offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	public void moveCamera(double offsetX, double offsetY) {
		this.offsetX += offsetX;
		this.offsetY += offsetY;
	}
	
	public void centerCamera(Player player) {
		offsetX = (player.getPosX() - (Main.WINDOW_WIDTH/2));
		offsetY = (player.getPosY() - (Main.WINDOW_HEIGHT/2));
	}

	public double getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(double offsetX) {
		this.offsetX = offsetX;
	}

	public double getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(double offsetY) {
		this.offsetY = offsetY;
	}
	
	

}
