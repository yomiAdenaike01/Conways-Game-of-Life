
public class Controller implements Runnable {
	//creating the board
	private Board board;
	//control whehter the code will contiune or not
	private volatile static boolean keepGoing = true;

	public Controller(Board board) {
		this.board = board;
	}

	@Override
	public void run() {

		while (!Thread.currentThread().isInterrupted() && keepGoing) {
			//the new iteration will run after the thread
			board.newIteration();
			
			try {
				//the thread will not run until the timelag is complete
				Thread.sleep(Constatns.TIME_LAG);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}

	public static void startThread() {
		keepGoing = true;
	}

	public static void stopThread() {
		Thread.currentThread().interrupt();
		keepGoing = false;
	}
}
