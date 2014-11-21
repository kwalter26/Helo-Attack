import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Craft {

	private String craft = "helicopter.png";

	private int dx;
	private int dy;
	private int x;
	private int y;
	private BufferedImage plane;
	private boolean visible;
	private int missileCount;

	private ArrayList missiles;

	private final int CRAFT_WIDTH = 160;
	private final int CRAFT_HEIGHT = 70;

	public Craft() {
		
		try {
			plane = ImageIO.read(ResourceLoader.load(craft));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		missiles = new ArrayList();
		x = 40;
		y = 60;
		visible = true;
		missileCount = 0;
	}

	public void move() {
		x += dx;
		y += dy;
		if (x < 1)
			x = 1;
		if (y < 1)
			y = 1;
		if (x > 1200 - CRAFT_WIDTH)
			x = 1200 - CRAFT_WIDTH;
		if (y > 700 - CRAFT_HEIGHT)
			y = 700 - CRAFT_HEIGHT;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getHeight(){
		return CRAFT_HEIGHT;
	}
	
	public int getWidth(){
		return CRAFT_WIDTH;
	}

	public Image getImage() {
		return plane;
	}
	
	public void setVisible(boolean v){
		visible = v;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,CRAFT_WIDTH,CRAFT_HEIGHT);
	}
	
	public boolean checkVisible(){
		return visible;
	}

	public ArrayList getMissiles() {
		return missiles;
	}
	
	public int getMissilesUsed(){
		return missileCount;
	}
	
	public void resetMissiles(){
		missileCount = 0;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE)
			fire();
		if (key == KeyEvent.VK_LEFT)
			dx = -5;
		if (key == KeyEvent.VK_RIGHT)
			dx = 5;
		if (key == KeyEvent.VK_UP)
			dy = -5;
		if (key == KeyEvent.VK_DOWN)
			dy = 5;
	}

	public void fire() {
			missiles.add(new Missile(x + 83, y +(CRAFT_HEIGHT - 28)));
			missileCount ++;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;
		if (key == KeyEvent.VK_RIGHT)
			dx = 0;
		if (key == KeyEvent.VK_UP)
			dy = 0;
		if (key == KeyEvent.VK_DOWN)
			dy = 0;
	}
}
