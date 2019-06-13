//steps in the program
/* the rules of game of life
 * This is a cell automation game 
 * If a cell has exactly 2 or 3 neighbours this means that they will live
 * if a cell has less that 2 that current cell will die 
 * if a cell has more than 3 then they will die because of over population
 * 
 * Steps to create
 * Create the GUI
 * set the look and feel
 * 
 * Create the constants to the following 
 * the label of the generations 
 * the file menu and its contents
 * the buttons that will be the start and reset which will be in the toolbar 
 * this will contain the preset frame size and the column and rows for the grid
 * 
 * Create the main board
 * containing the array of the cells 
 * the cells will have their own borders and colours
 * the colour of an alive cell will be green
 * the colour of a dead cell wll be white 
 * 
 * The game logic
 * the game will cycle through each cell in the table and then check the neighbours 
 * before that the user will be need to click a cell and then change the state of the boolean 
 * once this is changed the background of the cell will change 
 * the cell will change depending on the cells that are alive around it 
 * Each cell will have a listener attactched
 * 
 * Because we need to know whether the app will run multiple threads at once 
 * there will need to be a volatile variable that will decide 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
 