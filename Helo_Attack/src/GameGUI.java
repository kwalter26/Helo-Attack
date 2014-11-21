import javax.swing.JFrame;


/**
 * @author Kyle Walter
 * Project: HelicopterGame
 * Data Created: Nov 21, 2014
 */
public class GameGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameGUI(){
		add(new Game());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,700);
		setLocationRelativeTo(null);
		setTitle("Helicopter");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args){
		new GameGUI();
	}
}
