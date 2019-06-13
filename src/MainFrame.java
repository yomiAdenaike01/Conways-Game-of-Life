import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame implements ButtonListener{
	private TimePanel timePanel;
	private Toolbar toolbar;
	private Board board;
	private ExecutorService executor;
	
	public MainFrame() {
		super(Constatns.APP_NAME);
		intializeMenu();
		intializeMainLayout();
		
	}

	private void intializeMainLayout() {
		//creating teh toolbar and the timepanel in the frame 
		toolbar = new Toolbar();
		timePanel = new TimePanel();
		board = new Board(timePanel);
		toolbar.setButtonListener(this);
		//setting the location of the created elements the top middle and bottom of the frame
		add(board, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(timePanel, BorderLayout.SOUTH);
		//setting the size of the frame as well as the closing operations
		setSize(Constatns.FRAME_WIDTH, Constatns.FRAME_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set the location of the window to the center at default
		setLocationRelativeTo(null);
	}

	private void intializeMenu() {
		//creating the menubar
		JMenuBar menuBar = createMenuBar();
		setJMenuBar(menuBar);
		
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		//creating the menuBar and adding the exit and file menu
		JMenu fileMenu = new JMenu(Constatns.MENU_FILE);
		JMenuItem exitMenuitem = new JMenuItem("Exit");
		fileMenu.add(exitMenuitem);
		menuBar.add(fileMenu);
		exitMenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this will match the name of the button and excecute the command
				String command = e.getActionCommand();
				if(command == "Exit") {
					System.exit(0);
				}
			}
		});
		return null;
	}

	@Override
	public void startClicked() {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				toolbar.setStartButton(false);
				toolbar.setRestartButton(true);
			}
		});
		
		Controller.startThread();
		executor = Executors.newSingleThreadExecutor();
		executor.execute(new Controller(board));
	}

	@Override
	public void restartClicked() {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				toolbar.setStartButton(true);
				toolbar.setRestartButton(false);
			}
		});
		
		executor.shutdown();
	    Controller.stopThread();
	    board.resetBoard();
	    timePanel.refreshCounter();
	    
	    toolbar.setRestartButton(false);
	}

}

