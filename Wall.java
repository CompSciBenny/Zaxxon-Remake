package terrain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Wall {

	GamePanel gp;
	BufferedImage wall, wallBorder;
	
	int x, y, altitude, speed;
	boolean border;
		
	int originalWidth = 32, originalHeight = 32;
	public int width = originalWidth * 3, height = originalHeight * 3;
	
	int originalWidthB = 180, originalHeightB = 154;
	public int widthB = originalWidthB * 3, heightB = originalHeightB * 3;
		
	public Wall(boolean border, int x, int y, int altitude, GamePanel gp) {
		
		this.border = border;
		this.x = x;
		this.y = y;
		this.altitude = altitude;
		speed = 2;
		
		this.gp = gp;
		
		try {
			
			wall = ImageIO.read(getClass().getResourceAsStream("/terrain/wall1.png"));
			wallBorder = ImageIO.read(getClass().getResourceAsStream("/terrain/wallBorder.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void update() {
		
		x -= speed;
		y += speed / 2;
		
	}
	
	public void draw(Graphics2D g2) {
		
		if (border == true) {
			
			g2.drawImage(wallBorder, x, y, widthB, heightB, null);
			
		} else {
			
			g2.drawImage(wall, x, y, width, height, null);
		}				
	}
}
