import java.util.ArrayList;


public class UpdateValues {
	public static void updateMissiles(ArrayList msList){
		for (int i = 0; i < msList.size(); i++) {
			Missile m = (Missile) msList.get(i);
			if (m.isVisible())
				m.move();
			else
				msList.remove(i);
		}
	}
	public static void updateEnemyCraft(ArrayList enemyList){
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
	public static void updateBackground(ArrayList bgList,int speed){
		for (int i = 0; i < bgList.size(); i++) {
			Background bg = (Background) bgList.get(i);
			bg.move();
			if(bg.getX() == -bg.getWidth())
				bg.setX(bg.getWidth());
		}
	}
}
