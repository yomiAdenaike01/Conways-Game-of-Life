import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameofLife {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	try {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	}catch(UnsupportedLookAndFeelException  e) {
		e.printStackTrace();
	}
	//setting the look and feel of the app to the windows look and feel 
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new MainFrame();
			//run the whole application thread
		}
	});
}
}
