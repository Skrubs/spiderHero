package entities;

import application.Main;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import utils.Animate;
import utils.Direction;
import utils.Id;
import utils.ImageLoader;
import utils.Movement;

public class Player extends Creature {
	
	private Image[] idleUp;
	private Image[] idleDown;
	private Image[] idleRight;
	private Image[] idleLeft;
	private Direction dir = Direction.up;
	private double duration = .1;
	private Movement movement;

	public Player(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		super(spriteImage, posX, posY, velX, velY, id);
		idleUp = new Image[4];
		idleDown = new Image[4];
		idleRight = new Image[4];
		idleLeft = new Image[4];
		init();
	}
	
	public void init() {
		
		//initialize movement
		movement = new Movement(this,Main.getScene());
		
		//idleUp
		idleUp = new Image[4];
		idleUp[0] = ImageLoader.idle_player_up_1;
		idleUp[1] = ImageLoader.idle_player_up_2;
		idleUp[2] = ImageLoader.idle_player_up_3;
		idleUp[3] = ImageLoader.idle_player_up_4;
		
		//idleDown
		idleDown[0] = ImageLoader.idle_player_down_1;
		idleDown[1] = ImageLoader.idle_player_down_2;
		idleDown[2] = ImageLoader.idle_player_down_3;
		idleDown[3] = ImageLoader.idle_player_down_4;
		
		//idleRight
		idleRight[0] = ImageLoader.idle_player_right_1;
		idleRight[1] = ImageLoader.idle_player_right_2;
		idleRight[2] = ImageLoader.idle_player_right_3;
		idleRight[3] = ImageLoader.idle_player_right_4;
		
		//idleLeft
		idleLeft[0] = ImageLoader.idle_player_left_1;
		idleLeft[1] = ImageLoader.idle_player_left_2;
		idleLeft[2] = ImageLoader.idle_player_left_3;
		idleLeft[3] = ImageLoader.idle_player_left_4;
	}

	@Override
	public void move() {
		posX += velX;
		posY += velY;
		
	}

	@Override
	public void move(double velX, double velY) {
		this.posX += velX;
		this.posY += velY;
		
	}

	@Override
	public void update(double timer) {
		
		//updateMovement
		movement.movePlayer();
		
		if(velX > 0) dir = Direction.right;
		if(velX < 0) dir = Direction.left;
		if(velY > 0) dir = Direction.down;
		if(velY < 0) dir = Direction.up;
		
		if(dir == Direction.up) {
			this.spriteImage = Animate.animateCharacter(idleUp, duration);
		}else if(dir == Direction.right) {
			this.spriteImage = Animate.animateCharacter(idleRight, duration);
		}else if(dir == Direction.down) {
			this.spriteImage = Animate.animateCharacter(idleDown, duration);
		}else if(dir == Direction.left) {
			this.spriteImage = Animate.animateCharacter(idleLeft, duration);
		}
		
				
		//update move
		this.move();
		
			
		
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(posX+20, posY+20, width-12, height-5);
	}

	public Image[] getIdleUp() {
		return idleUp;
	}

	public void setIdleUp(Image[] idleUp) {
		this.idleUp = idleUp;
	}

	public Image[] getIdleDown() {
		return idleDown;
	}

	public void setIdleDown(Image[] idleDown) {
		this.idleDown = idleDown;
	}

	public Image[] getIdleRight() {
		return idleRight;
	}

	public void setIdleRight(Image[] idleRight) {
		this.idleRight = idleRight;
	}

	public Image[] getIdleLeft() {
		return idleLeft;
	}

	public void setIdleLeft(Image[] idleLeft) {
		this.idleLeft = idleLeft;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}
	
	

}
