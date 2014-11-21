import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Kyle Walter
 * Project: HelicopterGame
 * Data Created: Nov 21, 2014
 */
public class Missile {
	private int x, y;
	private BufferedImage image;
	boolean visible;
	private String missileImage = "missile.png";

	private final int BOARD_WIDTH = 1200;
	private final int MISSLE_SPEED = 4;
	private final int MISSILE_HEIGHT = 12;
	private final int MISSILE_WIDTH = 40;

	public Missile(int x, int y) {
		
		try {
			image = ImageIO.read(ResourceLoader.load(missileImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		visible = true;
		this.x = x;
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return MISSILE_WIDTH;
	}

	public int getHeight() {
		return MISSILE_HEIGHT;
	}

	public boolean isVisible() {
		return visible;
	}

	public void confirmedHit() {
		visible = false;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, MISSILE_WIDTH, MISSILE_HEIGHT);
	}

	public void move() {
		x += MISSLE_SPEED;
		if (x > BOARD_WIDTH)
			visible = false;

	}

}
