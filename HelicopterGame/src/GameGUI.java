import javax.swing.JApplet;
import javax.swing.JFrame;


public class GameGUI extends JFrame {
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
