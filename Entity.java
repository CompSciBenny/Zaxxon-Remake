package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	// Universal variables for all entities.
	public int x, y, speed;
	public double altitude;
	public int scale = 3;
	
	public BufferedImage up, down, neutral, shadow, projectile;
	public String direction;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
	
}
