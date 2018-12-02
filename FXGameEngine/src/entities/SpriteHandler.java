package entities;

import java.util.ArrayList;
import java.util.Random;

import game.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import utils.GameTimer;
import utils.Id;
import utils.ImageLoader;
import world.Wave;

public class SpriteHandler {

	private Player player;
	private Game game;
	private double housePlacementX = 0;
	private double housePlacementY = 0;
	private double count = 0;
	AudioClip a = new AudioClip("file:assets/sounds/web.wav");
	private int villagerSpawnCount = 0;
	private final int MAX_VILLAGERS = 20;
	public static ArrayList<Sprite> spriteList = new ArrayList<>();
	private Wave wave;

	public SpriteHandler(Game game) {
		this.game = game;

	}

	public void init() {
		// initialize player
		player = new Player(ImageLoader.missImage, 700, 800, 0, 0, Id.player);
		spriteList.add(player);

		// spawn yelllow houses
		int count = 0;

		for (int i = 0; i < 15; i++) {
			spriteList.add(new YellowHouse(ImageLoader.house_1, 300 + housePlacementX, 300 + housePlacementY, 0, 0,
					Id.yellowHouse));
			if (count < 4) {
				housePlacementX += 400;
				count++;

			} else if (count >= 4) {
				housePlacementX = 0;
				housePlacementY += 400;
				count = 0;
			}

		}

		// spawn villagers
		for (int i = villagerSpawnCount; i < MAX_VILLAGERS; i++) {
			YellowHouse spawnHouse = null;

			for (Sprite s : spriteList) {
				if (s.getId() == Id.yellowHouse) {
					if (new Random().nextBoolean()) {
						spawnHouse = (YellowHouse) s;
					}
				}
			}

			double x = spawnHouse.getBoundary().getMaxX() - 20;
			double y = spawnHouse.getBoundary().getMaxY() + 20;
			spriteList.add(new Villager(ImageLoader.missImage, x, y, 0, 0, Id.villager));
		}

		// Wave initialize
		wave = new Wave(game);

	}

	/**
	 * update spriteHandler
	 * 
	 * @param timer
	 */
	public void update(double timer) {

		// Player web shot functionality
		if (player.getMovement().getInputList().contains("SPACE")) {

			if (GameTimer.getTimer() - count > .4) {
				spriteList.add(new WebShot(ImageLoader.webshot, player.getPosX(), player.getPosY(),
						player.getVelX() * 3, player.getVelY() * 3, Id.web));

				a.play();

				count = GameTimer.getTimer();
			}
		}

		// move villagers
		for (Sprite s : spriteList) {
			if (s.getId() == Id.villager) {
				Villager v = (Villager) s;
				v.move(spriteList);
			}
		}

		for (Sprite s : spriteList) {
			if (s.getId() != Id.player && s.getId() != Id.web) {
				if (player.collision(s.getBoundary())) {

					if (player.getVelX() > 0) {
						player.setPosX(player.getPosX() - 3);
						player.setVelX(0);
					} else if (player.getVelX() < 0) {
						player.setPosX(player.getPosX() + 3);
						player.setVelX(0);
					}

					if (player.getVelY() > 0) {
						player.setPosY(player.getPosY() - 3);
						player.setVelY(0);
					} else if (player.getVelY() < 0) {
						player.setPosY(player.getPosY() + 3);
						player.setVelY(0);
					}
				}
			}
		}

		// spawn enemies
		wave.getNextWave();
		for (Enemy e : wave.getEnemyList()) {
				e.update(timer);
			for (Sprite s : spriteList) {
				if (s.getId() == Id.villager) {
					e.aggression((Villager) s);
				}
			}
		}

		// TEST code for damage enemies and removal
		for (Sprite s : spriteList) {
			if (s.getId() == Id.web) {
				for (Enemy e : wave.getEnemyList()) {
					if (s.collision(e.getBoundary())) {
						s.setSpriteImage(ImageLoader.webshotLanded);
						s.setVelocity(0, 0);
						e.damageCreature(10);
						if(e.getHealth() <= 0) {
							
						}
					}
				}
			}
		}
		
		removeCreature(wave.getEnemyList());
		
		for(Enemy e : wave.getEnemyList()) {
			
		}

	}

	/**
	 * spriteHandler rendering
	 * 
	 * @param gc
	 * @param offsetX
	 * @param offsetY
	 */
	public void render(GraphicsContext gc, double offsetX, double offsetY) {
		for (Enemy e : wave.getEnemyList()) {
			gc.setFill(Color.RED);
			gc.fillRect(e.getPosX() - game.getCamera().getOffsetX(), e.getPosY() - game.getCamera().getOffsetY(),
					e.getWidth(), e.getHeight());
		}
	}

	/**
	 * removes creatures from enemy lsit
	 * 
	 * @param creatureList
	 */
	public void removeCreature(ArrayList<Enemy> creatureList) {
		for (int i = creatureList.size()-1; i > 0; i--) {
			if (!creatureList.get(i).isAlive) {
				creatureList.remove(i);
			}
		}
	}

	// SETTERS AND GETTERS
	public static ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}
	
	

	public Wave getWave() {
		return wave;
	}

	public void setWave(Wave wave) {
		this.wave = wave;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public double getHousePlacementX() {
		return housePlacementX;
	}

	public void setHousePlacementX(double housePlacementX) {
		this.housePlacementX = housePlacementX;
	}

	public double getHousePlacementY() {
		return housePlacementY;
	}

	public void setHousePlacementY(double housePlacementY) {
		this.housePlacementY = housePlacementY;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public AudioClip getA() {
		return a;
	}

	public void setA(AudioClip a) {
		this.a = a;
	}

	public int getVillagerSpawnCount() {
		return villagerSpawnCount;
	}

	public void setVillagerSpawnCount(int villagerSpawnCount) {
		this.villagerSpawnCount = villagerSpawnCount;
	}

	public int getMAX_VILLAGERS() {
		return MAX_VILLAGERS;
	}

	public static void setSpriteList(ArrayList<Sprite> spriteList) {
		SpriteHandler.spriteList = spriteList;
	}

}
