package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;
		
	public int originalWidth = 24, originalHeight = 24;

	public int width = originalWidth * scale;
	public int height = originalHeight * scale;
	
	public int minAltitude, maxAltitude;
	public int minX = 42, maxX = 368;
	
	private LinkedList<Projectile> p = new LinkedList<Projectile>();
	
	Projectile playerLaser;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
						
		setDefaultValues();
		getPlayerImage();
		
	}
	

	public void setDefaultValues() {
		
		x = 205;
		y = (int)((0.5 * x) + 435); // minimum altitude
		
		direction = "neutral";		
		speed = 4;
		altitude = 1;
	}
	
	public void getPlayerImage() {
		
		try {
			
			up = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDown.png"));
			neutral = ImageIO.read(getClass().getResourceAsStream("/player/PlayerNeutral.png"));
			shadow = ImageIO.read(getClass().getResourceAsStream("/player/PlayerShadow.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void update() {
		
		System.out.println((int)altitude);
		updateProjectiles();	
		
		minAltitude = (int)((0.5 * x) + 435);
		maxAltitude = (int)((0.5 * x) + 242);
		
		if (keyH.upPress == true || keyH.downPress == true || keyH.leftPress == true || keyH.rightPress == true) {
			
			// Updates player position
			if (keyH.upPress == true && y > maxAltitude) {
				
				if (y == maxAltitude) { // Shows neutral image when at max altitude
					
					direction = "neutral";
					
				} else {
					
					direction = "up";
				}
								
				if (keyH.leftPress == true) {
					
					y -= speed / 2; // Prevents speed stack when two buttons are pressed simultaneously
					altitude += 0.69;
					
				} else {
					
					y -= speed;
					altitude += 1.38;

				}	
			}
			
			if (keyH.downPress == true && y < minAltitude) {
					
				if (y == minAltitude) { // Shows neutral image when at min altitude
					
					direction = "neutral";
					
				} else {
					
					direction = "down";
				}
				
				if (keyH.rightPress == true) {
					
					y += speed / 2; // Prevents speed stack when two buttons are pressed simultaneously
					altitude -= 0.69;
					
				} else {
					
					y += speed;						
					altitude -= 1.38;

				}				
			}
			
			if (keyH.leftPress == true && x > minX) {
				x -= speed;
				y -= speed / 2; 
				
				if (!keyH.upPress == true && !keyH.downPress == true) {
					
					direction = "neutral";					
				}
			}
			
			if (keyH.rightPress == true && x < maxX) {
				x += speed;
				y += speed / 2;
				
				if (!keyH.upPress == true && !keyH.downPress == true) {
					
					direction = "neutral";					
				}
			}
			
		} else {
			
			direction = "neutral";
		}
		
		if (keyH.shoot == true) {
			
			addProjectile(new Projectile(x, y, altitude, gp, keyH));
			keyH.shoot = false;
		}
	}
	
	public void updateProjectiles() {
		
		for (int i = 0; i < p.size(); i ++) {
			
			playerLaser = p.get(i);
			
			playerLaser.update();
			
			if (playerLaser.x > gp.screenWidth) {
				
				removeProjectile(playerLaser);
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		drawProjectiles(g2);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":

			image = up;
			
			break;
		case "down":

			image = down;
			
			break;
		case "neutral":

			image = neutral;
			
			break;
		}
		
		g2.drawImage(shadow, x - width / 2, minAltitude - 18, width, height, null);
		g2.drawImage(image, x - width / 2, y - height / 2, width, height, null);		
	}
	
	public void drawProjectiles(Graphics2D g2) {
		
		for (int i = 0; i < p.size(); i ++) {
			
			playerLaser = p.get(i);
			
			playerLaser.draw(g2);
			
		}
	}
	
	public void addProjectile(Projectile laser) {
		p.add(laser);
	}
	
	public void removeProjectile(Projectile laser) {
		p.remove(laser);
	}
}
