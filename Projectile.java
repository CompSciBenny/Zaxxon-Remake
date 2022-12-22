package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Projectile extends Entity {

	GamePanel gp;
	KeyHandler keyH;
	BufferedImage playerLaser;
	
	public int originalWidth = 16, originalHeight = 9;

	public int width = originalWidth * scale;
	public int height = originalHeight * scale;
		
	public Projectile(int x, int y, double altitude, GamePanel gp, KeyHandler keyH) {
		
		this.x = x;
		this.y = y;
		this.altitude = altitude;
		speed = 16;
		
		this.gp = gp;
		this.keyH = keyH;
		
		try {
			
			playerLaser = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLaser.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void update() {
		
		x += speed;
		y -= speed / 2;
		
	}
	
	public void draw(Graphics2D g2) {
		
		if (gp.player.direction == "up") {
			
			g2.drawImage(playerLaser, x - 12, y - 21, width, height, null);
			
		} else {
			
			g2.drawImage(playerLaser, x - 12, y - 21, width, height, null);
			
		}		
	}
}
