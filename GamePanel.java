package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Player;
import terrain.TerrainHandler;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	public final int screenWidth = 672; // 224 pixels
	public final int screenHeight = 768; // 256 pixels
	
	public final int scale = 3; // Increases the size of sprite
	
	// FPS
	int FPS = 60;
	
	// SYSTEM
	//TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	TerrainHandler terrainH = new TerrainHandler(this);
	//Sound music = new Sound(); // Music
	//Sound se = new Sound(); // Sound effects
	//public CollisionChecker cChecker = new CollisionChecker(this);
	//public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread; // Game timer
	
	// ENTITY AND OBJECT
	public Player player = new Player(this,keyH);
	
	// IMAGES
	BufferedImage track;

	public GamePanel() {
		
		// Sets up canvas for images to be drawn
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		try {
			track = ImageIO.read(getClass().getResourceAsStream("/terrain/track.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setupGame() {
		
		// Creates all the objects
		//aSetter.setObject();
		
		//playMusic(0);
		
	}
	
	public void startGameThread() {
		
		// Starts the game timer
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run() {
		// 1000000000 is 1 second in nanoseconds
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		// GAME LOOP
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				// 1 UPDATE: update info such as player position				
				update();
				
				// 2 DRAW: draw the screen with the updated info						
				repaint();
				
				delta--;
				drawCount++;
			}	
			
			if(timer >= 1000000000) { // Every second the timer and drawCount is reset
				
				//System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}	
		}
	}
	
	public void update() {
		
		player.update();
		terrainH.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);				
		Graphics2D g2 = (Graphics2D)g;	
		
		// TILES
		//tileM.draw(g2); // Tiles first because thats the farthest layer
		
		// OBJECTS
		//for(int i = 0; i < obj.length; i++) {
			
			//if(obj[i] != null) { // Avoids NullPointer error
				
				//obj[i].draw(g2, this); // Draws objects on screen
				
			//}
		//}
		
		// TRACK
		g2.drawImage(track, 0, 0, 672, 672, null);
		
		// PROJECTILES
		//ProjectileHandler.draw(g2);
		
		// WALL
		terrainH.draw(g2);
		
		// PLAYER
		player.draw(g2);				
		
		// UI
		ui.draw(g2);

		g2.dispose(); // saves memory
	}
	
	public void playMusic(int i) {
		
		//music.setFile(i);
		//music.play();
		//music.loop();
		
	}
	
	public void stopMusic() {
		
		//music.stop();
	}
	
	public void playSE(int i) {
		
		//se.setFile(i);
		//se.play();
		
	}
}
