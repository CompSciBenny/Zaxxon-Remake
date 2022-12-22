package terrain;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TerrainHandler {

	GamePanel gp;
	
	private LinkedList<Wall> w = new LinkedList<Wall>();
	
	Wall wall;
	
	private Wall[][] wallGenerator = new Wall[4][6];
		
	int wallTimer = 241;
	int rdmHeight;
	int rdmGap;
	
	public TerrainHandler(GamePanel gp) {
		
		this.gp = gp;
	}
	
	public synchronized void update() {
		
		wallTimer++;
		updateWalls();
		
		if (wallTimer > 390) { // Every 5.5 seconds
			
			rdmHeight = (int)(Math.random() * 4);
			rdmGap = (int)(Math.random() * 6);
			
			generateWall(rdmHeight, rdmGap);
			
			wallTimer = 0;
		}		
	}
	   
	public void generateWall(int rdmHeight, int rdmGap) {
		
		//System.out.println("Wall created!");
		
		w.add(new Wall(true, 705, -162, 1, gp));
		
		for (int r = wallGenerator.length - 1; r > -1; r--) {
			
			for (int c = 0; c < wallGenerator[r].length; c++) {
				
				if (r >= rdmHeight) {
					
					if (c == rdmGap && r == rdmHeight) {
												
					} else {
						
						wallGenerator[r][c] = new Wall(false, (72 * c) + 789, (36 * c) + (r * 48) - 144, 1, gp);
						w.add(wallGenerator[r][c]);						
					}																				
				}
			}
		}
	}
	
	public void updateWalls() {
		
		for (int i = 0; i < w.size(); i ++) {
			
			wall = w.get(i);
			
			wall.update();
			
			if (wall.x < -wall.width && wall.border == false) {
				
				removeWall(wall);
				//System.out.println("removed wall");
				
			} else if (wall.x < -wall.widthB && wall.border == true) {
				
				removeWall(wall);
				//System.out.println("removed wall");
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
		drawWalls(g2);
	
	}
	
	public void drawWalls(Graphics2D g2) {
		
		for (int i = 0; i < w.size(); i ++) {
			
			wall = w.get(i);
			
			wall.draw(g2);
			
		}
	}
	
	public void addWall(Wall wall) {
		w.add(wall);
	}
	
	public void removeWall(Wall wall) {
		w.remove(wall);
	}
}
