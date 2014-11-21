import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Kyle Walter Project: HelicopterGame Data Created: Nov 21, 2014
 */
public class Game extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer;

	private Craft helicopter;

	private ArrayList<EnemyCraft> eCraft;

	private ArrayList<Background> bgList;

	private boolean running;

	private int gameStatus;

	@SuppressWarnings("unused")
	private static final int GAME_WIDTH = 1200;

	@SuppressWarnings("unused")
	private static final int GAME_HEIGHT = 700;

	private int level;

	private int enemySpeed;

	private int enemyNumber;

	private int score;

	private int kills;

	public Game() {

		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		setSize(1200, 700);
		running = true;
		gameStatus = 0;
		level = 1;
		score = 0;
		enemySpeed = 1;
		enemyNumber = 10;
		kills = 0;
		helicopter = new Craft();
		eCraft = new ArrayList<EnemyCraft>();
		bgList = new ArrayList<Background>();
		bgList.add(new Background(0, 0));
		bgList.add(new Background(2460, 0));
		initEnemy();
		timer = new Timer(5, this);
		timer.start();
	}

	public void paint(Graphics g) { // Render method

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		if (running) {
			switch (gameStatus) {
			case 0:
				Render.renderBackground(g2d, bgList);
				Render.renderStats(g2d, score, helicopter.getMissilesUsed(),
						kills, eCraft.size());
				Render.renderCraft(g2d, helicopter);
				Render.renderMissiles(g2d, helicopter);
				Render.renderEnemyCraft(g2d, eCraft);
				break;
			case 1: // End of level
				g2d.drawString("Level " + level + " Complete!", 560, 300);
				break;
			case 2: // Paused
				break;
			case 3: // Game Over
				Render.renderGameOver(g2d, score);
				break;
			}
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (running) {
			switch (gameStatus) {
			case 0: // In Game
				collisionCheck();
				UpdateValues.updateBackground(bgList, enemySpeed);
				UpdateValues.updateMissiles(helicopter.getMissiles());
				UpdateValues.updateEnemyCraft(eCraft);
				UpdateValues.updateCraft(helicopter);
				checkLevelCompletion(); // Checks eCraft size, if =0 end level
				scoreAdjust(); //
				break;
			case 1: // End level
				levelUp();
				initEnemy();
				break;
			case 2: // Pause
				break;
			case 3: // Menu
				break;
			}
			repaint(); // Renders all graphics
		}
	}

	public void initEnemy() {

		for (int i = 0; i < enemyNumber; i++) {
			eCraft.add(new EnemyCraft((int) enemySpeed, i + 1));
		}
	}

	public void levelUp() {

		level++;
		enemyNumber = level * 10;
		enemySpeed += 1;
		repaint();
		gameStatus = 0;
	}

	public void checkLevelCompletion() {

		if (eCraft.size() == 0) {
			gameStatus = 1;
		}
	}

	public void scoreAdjust() {

		score = (kills * 50) - (helicopter.getMissilesUsed() * 10);
	}

	public void collisionCheck() {

		Rectangle helicopterRec = helicopter.getBounds();
		for (int i = 0; i < eCraft.size(); i++) {
			EnemyCraft ec = (EnemyCraft) eCraft.get(i);
			Rectangle enRec = ec.getBounds();
			if (helicopterRec.intersects(enRec)) {
				running = false;
			}
		}
		ArrayList<Missile> ms = helicopter.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			Rectangle msRec = m.getBounds();
			for (int j = 0; j < eCraft.size(); j++) {
				EnemyCraft ec = (EnemyCraft) eCraft.get(j);
				Rectangle enRec = ec.getBounds();
				if (enRec.intersects(msRec)) {
					kills++;
					m.confirmedHit();
					ec.confirmedHit();
				}
			}
		}
	}

	public class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {

			helicopter.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {

			helicopter.keyPressed(e);
		}
	}
}
