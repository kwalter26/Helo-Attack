import java.util.ArrayList;


/**
 * @author Kyle Walter
 * Project: HelicopterGame
 * Data Created: Nov 21, 2014
 */
public class UpdateValues {
	public static void updateMissiles(ArrayList<Missile> msList){
		for (int i = 0; i < msList.size(); i++) {
			Missile m = (Missile) msList.get(i);
			if (m.isVisible())
				m.move();
			else
				msList.remove(i);
		}
	}
	public static void updateEnemyCraft(ArrayList<EnemyCraft> enemyList){
		for (int i = 0; i < enemyList.size(); i++) {
			EnemyCraft en = (EnemyCraft) enemyList.get(i);
			if (en.isVisible()) {
				en.move();
			} else
				enemyList.remove(i);
		}
	}
	public static void updateCraft(Craft craft){
		craft.move();
	}
	public static void updateBackground(ArrayList<Background> bgList,int speed){
		for (int i = 0; i < bgList.size(); i++) {
			Background bg = (Background) bgList.get(i);
			bg.move();
			if(bg.getX() == -bg.getWidth())
				bg.setX(bg.getWidth());
		}
	}
}
