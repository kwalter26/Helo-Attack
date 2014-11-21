import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * @author Kyle Walter
 * Project: HelicopterGame
 * Data Created: Nov 21, 2014
 */
public class Render {

	public static void renderBackground(Graphics2D g2d, ArrayList<Background> bgList) {
		for (int i = 0; i < bgList.size(); i++) {
			Background bg = (Background) bgList.get(i);
			g2d.drawImage(bg.getImage(), bg.getX(), bg.getY(), bg.getWidth(),
					bg.getHeight(), null);
		}
	}

	public static void renderStats(Graphics g2d, int score, int missilesUsed,
			int kills, int shipsLeft) {
		g2d.drawString("Ships Left " + shipsLeft, 0, 30);
		g2d.drawString("Missiles Used " + missilesUsed, 300, 30);
		g2d.drawString("Kills " + kills, 600, 30);
		g2d.drawString("Score  " + score, 900, 30);
	}

	public static void renderCraft(Graphics2D g2d, Craft craft) {
		g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(),
				craft.getWidth(), craft.getHeight(), null);
	}

	public static void renderMissiles(Graphics g2d, Craft craft) {
		ArrayList<Missile> ms = craft.getMissiles();

		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), m.getWidth(),
					m.getHeight(), null);
		}
	}

	public static void renderEnemyCraft(Graphics2D g2d, ArrayList<EnemyCraft> eCraft) {
		for (int i = 0; i < eCraft.size(); i++) {
			EnemyCraft en = (EnemyCraft) eCraft.get(i);
			g2d.drawImage(en.getImage(), en.getX(), en.getY(), en.getWidth(),
					en.getHeight(), null);
		}
	}
	
	public static void renderGameOver(Graphics2D g2d,int score){
		g2d.setBackground(Color.DARK_GRAY);
		g2d.drawString("Game Over", 530, 300);
		g2d.drawString("Score " + score, 540, 330);
	}

}
