

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JPanel;

 

public class Board extends JPanel {
	private Random rand = new Random();
	private static final long serialVersionUID = 1L;
	//create the array of the cells
	private Cell[] cells;
	//these can contain duplicate elements therefore hashsets were better to use
	//this will contain the cells that are going to die and the cells that are going to live
	private Set<Integer> cellsToDie = new HashSet<>();
	private Set<Integer> cellsToBorn = new HashSet<>();
	//setting the neighbour count
	private int countLiveNeighbours=0;
	//creating the timer
	private TimePanel timePanel;
	
	public Board(TimePanel timePanel){
		this.timePanel = timePanel;
		
		initializeLayout();
		paintBoard();
	}

	private void initializeLayout() {
		//setting the content of the board to the size of the cols and rows
		cells = new Cell[Constatns.NUM_OF_ROWS*Constatns.NUM_OF_COLS];
		GridLayout gridLayout = new GridLayout(Constatns.NUM_OF_ROWS,Constatns.NUM_OF_COLS);
		setLayout(gridLayout);
	}

	public void refreshBoard(int id) {
		//if a cell is alive then it is set to green
		cells[id].setAlive(true);
		cells[id].setBackground(Color.green);
	}
	
	public void newIteration(){
		
		for(int i=0;i<Constatns.NUM_OF_ROWS*Constatns.NUM_OF_COLS;i++){
			//count the neighbours if the user has clicked outside the bounds.
			countLiveNeighbours=0;
			
			if( i<=Constatns.NUM_OF_ROWS-1 || i>((Constatns.NUM_OF_ROWS-1)*Constatns.NUM_OF_COLS-1) || (i % Constatns.NUM_OF_ROWS)-(Constatns.NUM_OF_ROWS-1)==0 || i%Constatns.NUM_OF_ROWS==0  ) continue;
			//if they are inside the content then count the neighbours. 
			if( cells[i-1].isAlive() ) countLiveNeighbours++;
			if( cells[i+1].isAlive() ) countLiveNeighbours++;
			//checking the rows above and below for whether they are alive or not
			if( cells[i-Constatns.NUM_OF_ROWS+1].isAlive() ) countLiveNeighbours++;
			if( cells[i-Constatns.NUM_OF_ROWS-1].isAlive() ) countLiveNeighbours++;
			if( cells[i-Constatns.NUM_OF_ROWS].isAlive() ) countLiveNeighbours++;
			if( cells[i+Constatns.NUM_OF_ROWS+1].isAlive() ) countLiveNeighbours++;
			if( cells[i+Constatns.NUM_OF_ROWS].isAlive() ) countLiveNeighbours++;
			if( cells[i+Constatns.NUM_OF_ROWS-1].isAlive() ) countLiveNeighbours++;
			
			// cell with exactly 3 neighbors --> becomes a live cell
			if( countLiveNeighbours == 3 && !cells[i].isAlive()) cellsToBorn.add(i);
			
			// underpopulation and overpopulation
			if( countLiveNeighbours < 2 || countLiveNeighbours > 3){
				cellsToDie.add(i);
			}
			
			// any live cell with 2 or 3 neighbors lives on to the next generation
			if( countLiveNeighbours == 3 || countLiveNeighbours == 2 && cells[i].isAlive() ) cellsToBorn.add(i);
		}
		
		repaintBoard();
		timePanel.refresh();
	}

	public void repaintBoard(){
		//setting the cells that will be alive 
		for(Integer integer : cellsToBorn){
			cells[integer].setBackground(Color.green);
			cells[integer].setAlive(true);
		}
		
		for(Integer integer : cellsToDie){
			cells[integer].setBackground(Color.WHITE);
			cells[integer].setAlive(false);
		}
		
		cellsToBorn.clear();
		cellsToDie.clear();
	}
	
	public void paintBoard(){
		for(int i=0;i<Constatns.NUM_OF_ROWS*Constatns.NUM_OF_COLS;i++){
			cells[i]=new Cell(i,this);
			cells[i].setAlive(false);
			add(cells[i]);
		}	
	}
	
	public void resetBoard() {
		//when resetting the board it will count each row and column and set each cell to dead 
		for(int i=0;i<Constatns.NUM_OF_ROWS*Constatns.NUM_OF_COLS;i++){
			cells[i].setAlive(false);
			cells[i].setBackground(Color.WHITE);
		}
	}
}
