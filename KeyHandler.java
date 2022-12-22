package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPress, downPress, leftPress, rightPress, shoot;
	private boolean spacePressed = false;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); // instantiates integer of key pressed
		
		if (code == KeyEvent.VK_UP) {
			upPress = true;
		}
		
		if (code == KeyEvent.VK_DOWN) {
			downPress = true;
		}	

		if (code == KeyEvent.VK_LEFT) {
			leftPress = true;
		}	

		if (code == KeyEvent.VK_RIGHT) {
			rightPress = true;
		}
		
		if (code == KeyEvent.VK_SPACE) {
			
			if (spacePressed == true) {
				shoot = false;
			} else {
				shoot = true;
				spacePressed = true;
			}
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode(); // instantiates integer of key pressed
		
		if (code == KeyEvent.VK_UP) {
			upPress = false;
		}
		
		if (code == KeyEvent.VK_DOWN) {
			downPress = false;
		}	

		if (code == KeyEvent.VK_LEFT) {
			leftPress = false;
		}	

		if (code == KeyEvent.VK_RIGHT) {
			rightPress = false;
		}	
				
		if (code == KeyEvent.VK_SPACE) {
			spacePressed = false;
			shoot = false;
		}
	}
}
