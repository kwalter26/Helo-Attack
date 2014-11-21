import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Kyle Walter
 * Project: HelicopterGame
 * Data Created: Nov 21, 2014
 */
public class Background {
	private String backgroundFile ="bground.png";
	private int x;
	private int y;
	private final int BACKGROUND_HEIGHT = 700;
	private final int BACKGROUND_WIDTH = 2460;
	private boolean visible;
	private BufferedImage bgImage;
	
	public Background(int startingX,int startingY){
		x = startingX;
		y = startingY;
		visible = true;
		try {
			bgImage = ImageIO.read(ResourceLoader.load(backgroundFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int newX){
		x = newX;
	}
	
	public void setY(int newY){
		y = newY;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public BufferedImage getImage(){
		return bgImage;
	}
	
	public int getHeight(){
		return BACKGROUND_HEIGHT;
	}
	
	public int getWidth(){
		return BACKGROUND_WIDTH;
	}
	
	public void move(){
		x -= 1; 
	}
	
}
