package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class UI {
	
	GamePanel gp;
	Font arcade;
	BufferedImage ui, fuelMeter;
	BufferedImage alt1, alt2, alt3, alt4, alt5, alt6, alt7, alt8, alt9, alt10, alt11, alt12, alt13, alt14, alt15, alt16, alt17, alt18, alt19, alt20, alt21, alt22, alt23, alt24, alt25, alt26, alt27, alt28, alt29, alt30, alt31, alt32, alt33, alt34, alt35, alt36, alt37, alt38, alt39, alt40, alt41, alt42, alt43, alt44, alt45, alt46, alt47, alt48, alt49, alt50, alt51, alt52, alt53, alt54, alt55, alt56, alt57, alt58, alt59, alt60, alt61, alt62, alt63, alt64, alt65, alt66, alt67, alt68, alt69;
	
	int maxFuel = 128;
	int fuel = 128;
	int fuelTimer = 959;
	
	ArrayList<BufferedImage> alt = new ArrayList<BufferedImage>();
	
	public boolean gameFinished = false;
	
	double playTime;
	
	public UI (GamePanel gp) {
		
		this.gp = gp;

		try {

			// UI
			ui = ImageIO.read(getClass().getResourceAsStream("/ui/ui.png"));
			fuelMeter = ImageIO.read(getClass().getResourceAsStream("/ui/FuelMeter.png"));
			
			// ALTITUDE METER
			alt1 = ImageIO.read(getClass().getResourceAsStream("/alt/alt1.png")); alt.add(alt1);
			alt2 = ImageIO.read(getClass().getResourceAsStream("/alt/alt2.png")); alt.add(alt2);
			alt3 = ImageIO.read(getClass().getResourceAsStream("/alt/alt3.png")); alt.add(alt3);
			alt4 = ImageIO.read(getClass().getResourceAsStream("/alt/alt4.png")); alt.add(alt4);
			alt5 = ImageIO.read(getClass().getResourceAsStream("/alt/alt5.png")); alt.add(alt5);
			alt6 = ImageIO.read(getClass().getResourceAsStream("/alt/alt6.png")); alt.add(alt6);
			alt7 = ImageIO.read(getClass().getResourceAsStream("/alt/alt7.png")); alt.add(alt7);
			alt8 = ImageIO.read(getClass().getResourceAsStream("/alt/alt8.png")); alt.add(alt8);
			alt9 = ImageIO.read(getClass().getResourceAsStream("/alt/alt9.png")); alt.add(alt9);
			alt10 = ImageIO.read(getClass().getResourceAsStream("/alt/alt10.png")); alt.add(alt10);
			alt11 = ImageIO.read(getClass().getResourceAsStream("/alt/alt11.png")); alt.add(alt11);
			alt12 = ImageIO.read(getClass().getResourceAsStream("/alt/alt12.png")); alt.add(alt12);
			alt13 = ImageIO.read(getClass().getResourceAsStream("/alt/alt13.png")); alt.add(alt13);
			alt14 = ImageIO.read(getClass().getResourceAsStream("/alt/alt14.png")); alt.add(alt14);
			alt15 = ImageIO.read(getClass().getResourceAsStream("/alt/alt15.png")); alt.add(alt15);
			alt16 = ImageIO.read(getClass().getResourceAsStream("/alt/alt16.png")); alt.add(alt16);
			alt17 = ImageIO.read(getClass().getResourceAsStream("/alt/alt17.png")); alt.add(alt17);
			alt18 = ImageIO.read(getClass().getResourceAsStream("/alt/alt18.png")); alt.add(alt18);
			alt19 = ImageIO.read(getClass().getResourceAsStream("/alt/alt19.png")); alt.add(alt19);
			alt20 = ImageIO.read(getClass().getResourceAsStream("/alt/alt20.png")); alt.add(alt20);
			alt21 = ImageIO.read(getClass().getResourceAsStream("/alt/alt21.png")); alt.add(alt21);
			alt22 = ImageIO.read(getClass().getResourceAsStream("/alt/alt22.png")); alt.add(alt22);
			alt23 = ImageIO.read(getClass().getResourceAsStream("/alt/alt23.png")); alt.add(alt23);
			alt24 = ImageIO.read(getClass().getResourceAsStream("/alt/alt24.png")); alt.add(alt24);
			alt25 = ImageIO.read(getClass().getResourceAsStream("/alt/alt25.png")); alt.add(alt25);
			alt26 = ImageIO.read(getClass().getResourceAsStream("/alt/alt26.png")); alt.add(alt26);
			alt27 = ImageIO.read(getClass().getResourceAsStream("/alt/alt27.png")); alt.add(alt27);
			alt28 = ImageIO.read(getClass().getResourceAsStream("/alt/alt28.png")); alt.add(alt28);
			alt29 = ImageIO.read(getClass().getResourceAsStream("/alt/alt29.png")); alt.add(alt29);
			alt30 = ImageIO.read(getClass().getResourceAsStream("/alt/alt30.png")); alt.add(alt30);
			alt31 = ImageIO.read(getClass().getResourceAsStream("/alt/alt31.png")); alt.add(alt31);
			alt32 = ImageIO.read(getClass().getResourceAsStream("/alt/alt32.png")); alt.add(alt32);
			alt33 = ImageIO.read(getClass().getResourceAsStream("/alt/alt33.png")); alt.add(alt33);
			alt34 = ImageIO.read(getClass().getResourceAsStream("/alt/alt34.png")); alt.add(alt34);
			alt35 = ImageIO.read(getClass().getResourceAsStream("/alt/alt35.png")); alt.add(alt35);
			alt36 = ImageIO.read(getClass().getResourceAsStream("/alt/alt36.png")); alt.add(alt36);
			alt37 = ImageIO.read(getClass().getResourceAsStream("/alt/alt37.png")); alt.add(alt37);
			alt38 = ImageIO.read(getClass().getResourceAsStream("/alt/alt38.png")); alt.add(alt38);
			alt39 = ImageIO.read(getClass().getResourceAsStream("/alt/alt39.png")); alt.add(alt39);
			alt40 = ImageIO.read(getClass().getResourceAsStream("/alt/alt40.png")); alt.add(alt40);
			alt41 = ImageIO.read(getClass().getResourceAsStream("/alt/alt41.png")); alt.add(alt41);
			alt42 = ImageIO.read(getClass().getResourceAsStream("/alt/alt42.png")); alt.add(alt42);
			alt43 = ImageIO.read(getClass().getResourceAsStream("/alt/alt43.png")); alt.add(alt43);
			alt44 = ImageIO.read(getClass().getResourceAsStream("/alt/alt44.png")); alt.add(alt44);
			alt45 = ImageIO.read(getClass().getResourceAsStream("/alt/alt45.png")); alt.add(alt45);
			alt46 = ImageIO.read(getClass().getResourceAsStream("/alt/alt46.png")); alt.add(alt46);
			alt47 = ImageIO.read(getClass().getResourceAsStream("/alt/alt47.png")); alt.add(alt47);
			alt48 = ImageIO.read(getClass().getResourceAsStream("/alt/alt48.png")); alt.add(alt48);
			alt49 = ImageIO.read(getClass().getResourceAsStream("/alt/alt49.png")); alt.add(alt49);
			alt50 = ImageIO.read(getClass().getResourceAsStream("/alt/alt50.png")); alt.add(alt50);
			alt51 = ImageIO.read(getClass().getResourceAsStream("/alt/alt51.png")); alt.add(alt51);
			alt52 = ImageIO.read(getClass().getResourceAsStream("/alt/alt52.png")); alt.add(alt52);
			alt53 = ImageIO.read(getClass().getResourceAsStream("/alt/alt53.png")); alt.add(alt53);
			alt54 = ImageIO.read(getClass().getResourceAsStream("/alt/alt54.png")); alt.add(alt54);
			alt55 = ImageIO.read(getClass().getResourceAsStream("/alt/alt55.png")); alt.add(alt55);
			alt56 = ImageIO.read(getClass().getResourceAsStream("/alt/alt56.png")); alt.add(alt56);
			alt57 = ImageIO.read(getClass().getResourceAsStream("/alt/alt57.png")); alt.add(alt57);
			alt58 = ImageIO.read(getClass().getResourceAsStream("/alt/alt58.png")); alt.add(alt58);
			alt59 = ImageIO.read(getClass().getResourceAsStream("/alt/alt59.png")); alt.add(alt59);
			alt60 = ImageIO.read(getClass().getResourceAsStream("/alt/alt60.png")); alt.add(alt60);
			alt61 = ImageIO.read(getClass().getResourceAsStream("/alt/alt61.png")); alt.add(alt61);
			alt62 = ImageIO.read(getClass().getResourceAsStream("/alt/alt62.png")); alt.add(alt62);
			alt63 = ImageIO.read(getClass().getResourceAsStream("/alt/alt63.png")); alt.add(alt63);
			alt64 = ImageIO.read(getClass().getResourceAsStream("/alt/alt64.png")); alt.add(alt64);
			alt65 = ImageIO.read(getClass().getResourceAsStream("/alt/alt65.png")); alt.add(alt65);
			alt66 = ImageIO.read(getClass().getResourceAsStream("/alt/alt66.png")); alt.add(alt66);
			alt67 = ImageIO.read(getClass().getResourceAsStream("/alt/alt67.png")); alt.add(alt67);
			alt68 = ImageIO.read(getClass().getResourceAsStream("/alt/alt68.png")); alt.add(alt68);
			alt69 = ImageIO.read(getClass().getResourceAsStream("/alt/alt69.png")); alt.add(alt69);
			
			// FONT
			arcade = Font.createFont(Font.TRUETYPE_FONT, new File("PublicPixel-0W5Kv.ttf")).deriveFont(23f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PublicPixel-0W5Kv.ttf")));
			
		} catch(IOException | FontFormatException e) {}
	}
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished == true) {
			
			g2.setFont(arcade);
			g2.setColor(Color.white);
			
			String text;
			int textLength;
			int x;
			int  y;
			
			// Displays messages regarding congratulations and time
			//text = "You found the treasure!";
			//textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();			
			//x = gp.screenWidth/2 - textLength/2;
			//y = gp.screenHeight/2 - (3);
			//g2.drawString(text, x, y);
			
			gp.gameThread = null;
			
			
		} else {
			
			// UI
			g2.setFont(arcade);
			g2.setColor(Color.white);
			g2.drawImage(ui, 0, 0, 672, 768, null);
			g2.drawString("FUEL", 74, 65);
			
			// ALTITUDE METER
			g2.drawImage(alt.get((int)gp.player.altitude), 0, 192, 24, 312, null);
			
			// FUEL METER				
			g2.drawImage(fuelMeter, 171, 719, 384, 24, null);			
		}				
	}
}
