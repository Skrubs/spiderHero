package game;

import application.Main;
import entities.Border;
import entities.Enemy;
import entities.Player;
import entities.Sprite;
import entities.SpriteHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import userinterface.Hud;
import utils.Camera;
import utils.Id;
import utils.ImageLoader;
import world.Map;
import world.Spawnpoint;

public class Game {

	/*
	 * Functionality 1. Bite 2. web 3. swarm <--- requires sacrifice of innocent 4.
	 * sacrifice
	 * 
	 * To Do: 1. create player character -abilities -animation --walk animation
	 * --death animation --bite animation --web animation
	 * 
	 * 2. create map - 1 single small town in the center -small town -trees -grass
	 * -dirt 3. add enemies -waves
	 * 
	 * 4. Evil / Good meter -The more enemies you kill = good -The more innocent
	 * sacrifice = evil
	 */

	private SpriteHandler spriteHandler;
	private Camera camera;
	private Hud hud;
	private Map map;

	public Game() {

	}

	/**
	 * initiate game objects
	 */
	public void init() {

		// initialize sprite Handler
		spriteHandler = new SpriteHandler(this);
		spriteHandler.init();

		// initialize camera
		camera = new Camera(400, 400);

		// initialize hud
		hud = new Hud();

		// initialize map
		map = new Map();
		map.createSpawnPoints();

	}

	/**
	 * update game objects
	 * 
	 * @param tiemr
	 */
	public void udpate(double timer) {

		//update spriteHandler
		spriteHandler.update(timer);

		//update for spriteList
		for (Sprite s : spriteHandler.spriteList) {
			s.update(timer);

			// center camera on player
			if (s.getId() == Id.player) {
				camera.centerCamera((Player) s);

				// player collision
				for (Sprite e : spriteHandler.spriteList) {
					if (e.getId() != Id.player && e.getId() != Id.web) {
						if (s.collision(e.getBoundary())) {
							System.out.println("Collision");
						}
					}

				}

			}

			// Collision for webshot
			if (s.getId() == Id.web) {
				for (Sprite c : spriteHandler.getSpriteList()) {
					if (c.getId() != Id.web && c.getId() != Id.player) {
						if (s.collision(c.getBoundary())) {
							s.setSpriteImage(ImageLoader.webshotLanded);
							s.setVelocity(0, 0);
						}
					}
				}

			}

		}

		// update hud
		hud.updateHud();

		//border collision
		for (Sprite s : spriteHandler.getSpriteList()) {
			if (s.getId() != Id.web) {
				for (Border b : map.getMap()) {
					b.borderInteraction(s);
				}
			}
		}
		
		for(Enemy e : spriteHandler.getWave().getEnemyList()) {
			for(Border b : map.getMap()) {
				b.borderInteraction(e);
			}
		}

	}

	/**
	 * render game objects
	 * 
	 * @param gc
	 */
	public void render(GraphicsContext gc) {

		//background fill
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

		// Render sprites
		for (Sprite s : SpriteHandler.spriteList) {
			gc.drawImage(s.getSpriteImage(), s.getPosX() - camera.getOffsetX(), s.getPosY() - camera.getOffsetY());

			// DEBUG MODE RENDER BORDERS
			if (Main.getIsDebug()) {

				if (s.getId() == Id.player) {
					s.setVelocity(s.getVelX() * 10, s.getVelY() * 10);
				}

				gc.strokeRect(s.getBoundary().getMinX() - camera.getOffsetX(),
						s.getBoundary().getMinY() - camera.getOffsetY(), s.getBoundary().getWidth(),
						s.getBoundary().getHeight());

				// DEBUG MODE RENDER X AND Y COORDINATE OF PLAYER
				if (s.getId() == Id.player) {
					gc.strokeText("X: " + s.getPosX(), 10, 100);
					gc.strokeText("Y: " + s.getPosY(), 10, 125);
				}

				// DEBUG MODE FOR BORDERS
				for (Border b : map.getMap()) {
					gc.strokeRect(b.getBoundary().getMinX() - camera.getOffsetX(),
							b.getBoundary().getMinY() - camera.getOffsetY(), b.getBoundary().getWidth(),
							b.getBoundary().getHeight());
				}
				
				// spawnpoint
				for (Spawnpoint spawn : map.getSpawnPoints()) {
					gc.setFill(Color.LIGHTGRAY);
					gc.fillRect(spawn.getX() - camera.getOffsetX(), spawn.getY() - camera.getOffsetY(), spawn.getWidth(),
							spawn.getHeight());
				}

			}
			

		}

		//render for spriteHandler
		spriteHandler.render(gc, camera.getOffsetX(), camera.getOffsetY());
		
		//render for border
		for (Border b : map.getMap()) {
			gc.drawImage(b.getBorderImage(), b.getX() - camera.getOffsetX(), b.getY() - camera.getOffsetY());
		}

		// render hud
		hud.renderHud(gc);

		

	}

	public SpriteHandler getSpriteHandler() {
		return spriteHandler;
	}

	public void setSpriteHandler(SpriteHandler spriteHandler) {
		this.spriteHandler = spriteHandler;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Hud getHud() {
		return hud;
	}

	public void setHud(Hud hud) {
		this.hud = hud;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}
