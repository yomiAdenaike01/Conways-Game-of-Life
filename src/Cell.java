import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cell extends JPanel {
//this will be the coding for each individual cell
//a cell can either be alive or dead when they are clicked 
//this JPANEL is given an ID
	private int id;
	//this will be the entire board containing the cells
	private Board board;
	//will track whether the cell is alive or not
	private boolean alive = false;
	public Cell(final int id, final Board board) {
		this.id = id;
		this.board = board;
		
		intitializeLayout();
		//this will make each cell listened to
		initializeListener(id);
	}
	private void initializeListener(final int id) {
		//once clicked they will turn green and they will set to alive
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				setAlive(true);
				//The board will be refreshed and repainted once there has been a change
				Cell.this.board.refreshBoard(id);
			}
			
		});
		
	}
	private void intitializeLayout() {
		//set each background of the cell and the border to black and white 
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.white);
		
	}
	public boolean isAlive(){
		return alive;
		
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
