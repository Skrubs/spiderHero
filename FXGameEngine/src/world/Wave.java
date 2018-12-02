package world;

import java.util.ArrayList;
import java.util.Random;

import entities.Enemy;
import game.Game;
import utils.Id;
import utils.ImageLoader;

public class Wave {
	
	private static final int MAX_WAVE = 10;
	private static int enemyCount = 0;
	private static int waveNum = 1;
	private ArrayList<Enemy> enemyList = new ArrayList<>();
	private Game game;
	
	public Wave(Game game) {
		this.game = game;
	}
	
	public void getNextWave() {
		if(enemyCount == 0 && waveNum <= MAX_WAVE) {
			spawnNewEnemies();
			waveNum++;
		}
	}
	
	public void spawnNewEnemies() {
		for(int i = 0; i < (10*waveNum);i++) {
			int cap = game.getMap().getSpawnPoints().size();
			Spawnpoint spawn = game.getMap().getSpawnPoints().get(new Random().nextInt(cap));
			double x = spawn.getX();
			double y = spawn.getY();
			enemyList.add(new Enemy(ImageLoader.missImage,x,y,0,0,Id.enemy));
		}
	}

	public static int getEnemyCount() {
		return enemyCount;
	}

	public static void setEnemyCount(int enemyCount) {
		Wave.enemyCount = enemyCount;
	}

	public static int getWaveNum() {
		return waveNum;
	}

	public static void setWaveNum(int waveNum) {
		Wave.waveNum = waveNum;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static int getMaxWave() {
		return MAX_WAVE;
	}
	
	

}
