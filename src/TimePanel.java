import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePanel extends JPanel{
	//creating the bottom of the frame containing the amount of generatinons
	private JLabel timeLabel;
	public int count = 0;
	
	public TimePanel() {
		initializeLayout();
	}
	private void initializeLayout() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		//setting the entire label and content to the center
		timeLabel = new JLabel("Generations: 0 ");
		add(timeLabel);
	}
	
	public void refreshCounter() {
		count = 0;
		refresh();
	}
	public void refresh() {
		//Setting the label to how many generations there are 
		timeLabel.setText("Generations: "+count++);
		//the count is incremented by one each time
	}
}
