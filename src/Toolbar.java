import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{
	private JButton startButton;
	private JButton resetButton;
	private ButtonListener buttonListener;
	public Toolbar() {
		initializeLayout();
	}
	private void initializeLayout() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//creating a border around it
		setBorder(BorderFactory.createEtchedBorder());
		//adding the buttons to the tool bar
		startButton = new JButton(Constatns.START);
		resetButton = new JButton(Constatns.RESTART);
		//setting the content of the buttons
		resetButton.setEnabled(false);
		//at the beginning the reset button is set to false 
		
		startButton.addActionListener(this);
		resetButton.addActionListener(this);
		add(startButton);
		add(resetButton);
		
	}
	public void setButtonListener(ButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}
	
	public void actionPerformed(ActionEvent e) {
		//decide which button is clicked if start button then call that 
		if((JButton)e.getSource() == startButton && buttonListener != null) {
			buttonListener.startClicked();
		}else if((JButton)e.getSource() == resetButton && buttonListener != null) {
			buttonListener.restartClicked();
		}
	}
	public void setStartButton(boolean bool) {
		//They need to be different because they will be enabled and disabled at different times
		//This will enable them to be changed to true and false
		startButton.setEnabled(bool);
	}
	
	public void setRestartButton(boolean bool) {
		resetButton.setEnabled(bool);

	}
}
