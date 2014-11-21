import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class EnemyCraft {
	private String enemyCraftImage = "enemy.png";
	
	
	private int x;
	private int y;
	private final int ECRAFT_HEIGHT = 40;
	private final int ECRAFT_WIDTH = 107;
	private boolean visible;
	private int craftSpeed;
	private BufferedImage eCraftImage;

	private ArrayList enemies;

	public EnemyCraft(int s, int counter){
		craftSpeed = s;
		visible = true;
		randX(counter);
		randY();
		
		try {
			eCraftImage = ImageIO.read(ResourceLoader.load(enemyCraftImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList getEnemies() {
		return enemies;
	}

	public void randY() {
		y = (int) ((Math.random() * 600) + 30);
	}

	public void randX(int counter) {
		x = (int) (Math.random() * 400) + ECRAFT_WIDTH +(counter * 400) + 1200;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getHeight(){
		return ECRAFT_HEIGHT;
	}
	
	public int getWidth(){
		return ECRAFT_WIDTH;
	}
	
	public Image getImage(){
		return eCraftImage;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void confirmedHit(){
		visible = false;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,ECRAFT_WIDTH,ECRAFT_HEIGHT);
	}

	public void move() {
		x -= craftSpeed;
		if (x < -50)
			x = 1500;
	}
}
