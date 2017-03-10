package maze;

import java.util.ArrayList;

public class Maze {
	private char direction; //'n','e','w','s'
    private int r;  // y position of the mouse
    private int c;  // x position of the mouse
    private boolean exitFound = false;

    private ArrayList<ArrayList<String>>theMaze = new ArrayList<>(); // Formatted maze    
    
    private ArrayList<ArrayList<String>> thePath = new ArrayList<>(); // Formatted maze with path
    private ArrayList<MazePoint> illegalMoves = new ArrayList<>(); // Persistent list of invalid moves
    private MazePointStack stepsTaken = new MazePointStack(); // List of correct moves taken
    

    public Maze(int[][] arrMaze) {
        this.direction = 'n';
        this.r = arrMaze.length - 1;
        this.c = 0;
        
        for (int i = 0; i < arrMaze.length; i++) {
        	ArrayList<String> mazeRow = new ArrayList<>();
        	
        	for (int j = 0; j < arrMaze[i].length; j++) {
        		if (arrMaze[i][j] == 1) {
        			mazeRow.add(" ");
        		}
        		else if (arrMaze[i][j] == 0) {
        			mazeRow.add("#");
        		}
        	}
        	
        	this.theMaze.add(mazeRow);
        	this.thePath.add(mazeRow);
        }
     }

    //Prints out the maze without solution
    public void displayMaze() {
    	for (int i = 0; i < theMaze.size(); i++) {
    		for (int j = 0; j < theMaze.get(i).size(); j++) {
    			System.out.print(theMaze.get(i).get(j));
    		}
    		System.out.println();
    	}    	
    }

    //displays the Maze with the path taken
    public void displayPath() {
    	for (ArrayList<String> row : thePath) {
    		for (String point : row) {
    			System.out.print(point);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }


    public boolean takeStep() {
        //complete the code here
    	// Placeholder for next move to make
    	MazePoint nextMove;
            	
    	// Create a collection of coordinate pairs availableMoves
    	ArrayList<MazePoint> availableMoves = new ArrayList<>();
    	
    	// Fill availableMoves list with a MazePoint for each possible direction
    	availableMoves.add(new MazePoint(r - 1, c, 'n'));
    	availableMoves.add(new MazePoint(r, c + 1, 'e'));
    	availableMoves.add(new MazePoint(r + 1, c, 's'));
    	availableMoves.add(new MazePoint(r, c - 1, 'w'));    	
    	    	
    	/**
    	 * 
    	 * Thinking Out Loud Here!
    	 * 
    	 * This could be adjusted based on position, for efficiency
    	 * if current position is on the left side of the maze, moves to the east should be prioritized.
    	 * if current position is on the bottom, moves to the north should be priority.
    	 * if current position is farther south than west, then moves to the north are higher priority than moves to the east
    	 * which also means that moves to the south would be lower priority than moves to the west    	 * 
    	 * 
    	 */
    	
    	// Sort availableMoves so that the order is always clockwise, but beginning with the current direction
    	// e.g., if direction == 's', this will reorganize availableMoves so that the MazePoints are in order of (S, W, N, E)    	
    	this.sortMoves(availableMoves);
    	
    	// Filter out invalid and/or illegal moves
    	this.filterMoves(availableMoves);
    	
    	// initialize nextMove based on the remaining availableMoves
    	if (availableMoves.size() > 0) {
    		// If there are moves available, nextMove becomes the first of those remaining moves
    		nextMove = availableMoves.get(0);
    		// Then push the nextMove onto our stack of stepsTaken
    		stepsTaken.push(nextMove);
    		// Set the current position to a "~"
    		thePath.get(r).set(c, "~");
    	}
    	else {
    		// If there are no remaining moves, pop the previous move off the top of stepsTaken
    		nextMove = stepsTaken.pop();
    		// Add that move to the list of illegalMoves, so we don't make the same move again
    		illegalMoves.add(nextMove);
    		/**
    		 * The direction of the move on the top of the stack references the direction FROM the previous point TO the current position
    		 * In order to take a step backwards, we invert the direction
    		 * --AFTER adding it to the list of illegalMoves--
    		 * this allows us to use one switch statement to call a move method
    		 */
    		nextMove.invertDirection();
    		// Set the current position back to a blank space, since we're backtracking
    		thePath.get(r).set(c, " ");
    	}
    	
    	// Select direction to move based on nextMove
    	switch (nextMove.direction) {
    	case ('n'):
    		moveNorth();
    		break;
    	case ('e'):
    		moveEast();
    		break;
    	case ('s'):
    		moveSouth();
    		break;
    	case ('w'):
    		moveWest();
    		break;
    	}    			
    	
    	// After the move is made, we display the path again (per original spec)
    	this.displayPath();
    	
        return isAnExit();
    }
    
    private void sortMoves(ArrayList<MazePoint> list) {
    	int sortCounter = 0;
    	
    	switch (this.direction) {
    	case ('n'):
    		sortCounter = 0;
    		break;
    	case ('e'):
    		sortCounter = 1;
    		break;
    	case ('s'):
    		sortCounter = 2;
    		break;
    	case ('w'):
    		sortCounter = 3;
    		break;
    	}
    	
    	while (sortCounter > 0) {
    		MazePoint temp = list.get(0);
    		list.remove(0);
    		list.add(temp);
    	}
    }
    
    private void filterMoves(ArrayList<MazePoint> list) {
    	for (int i = 0; i < list.size(); i++) {
    		// Remove MazePoints that represent characters we can't move to
    		if (list.get(i).value == "#" || list.get(i).value == "~") {
    			list.remove(i--);
    		}
    		// Remove MazePoints that have been marked as illegal
    		else if (list.get(i).isIllegal()) {
    			list.remove(i);
    			i--;
    		}
    	}
    }
        
    private void moveNorth() {
        //complete the code here
        r -= 1;
        thePath.get(r).set(c, "@");
    }

    private void moveSouth() {
        //complete the code here
    	this.r += 1;
    	thePath.get(r).set(c, "@");
    }

    private void moveEast() {
        //complete the code here
    	this.c += 1;
    	thePath.get(r).set(c,  "@");
    }

    private void moveWest() {
        //complete the code here
    	this.c -= 1;
    	thePath.get(r).set(c,  "@");
    }


    private boolean isAnExit() {
        //complete the code here
        this.exitFound = this.c == theMaze.get(r).size() - 1;
        return this.exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here
    	while (!this.exitFound) {
    		this.takeStep();
    	}
    }
    
    class MazePoint implements Comparable<MazePoint>{
    	protected int x;
    	protected int y;
    	protected char direction;
    	protected String value;
    	
    	MazePoint(int x, int y, char direction) {
    		this.x = x;
    		this.y = y;   
    		this.direction = direction;
    		setValue();
    	}
    	
    	protected Boolean isIllegal() {
    		for (int i = 0; i < illegalMoves.size(); i++) {
    			if (this.compareTo(illegalMoves.get(i)) == 0) {
    				return true;
    			}
    		}
    		return false;
    	}
    	
    	// The try/catch block here handles IndexOutOfBoundsExceptions
    	// which are thrown when the current position is at the beginning or end of a row or column
    	
    	protected void setValue() {
    		try {
    			this.value = thePath.get(this.x).get(this.y);
    		}
    		catch (IndexOutOfBoundsException ex) {
    			this.value = "#";
    		}
    	}
    	
    	protected void invertDirection() {
        	switch (this.direction) {
        	case ('n'):
        		this.direction = 's';
        	break;
        	case ('e'):
        		this.direction = 'w';
        	break;
        	case ('s'):
        		this.direction = 'n';
        	break;
        	case ('w'):
        		this.direction = 'e';
        	break;
        	}
        }
    	
    	@Override
    	public int compareTo(MazePoint point) {
    		if (point.x == this.x) {
    			if (point.y == this.y) {
    				return 0;
    			}
    		}   
    		
    		return 1;
    	}
    }
    
    class MazePointStack {
    	private ArrayList<MazePoint> list = new ArrayList<>();
    	
    	public Boolean isEmpty() {
    		return list.size() < 1;
    	}
    	
    	public void push(MazePoint move) {
    		list.add(move);
    	}
    	
    	public MazePoint peek() {
    		return list.get(list.size() - 1);
    	}
    	
    	public MazePoint pop() {
    		MazePoint popped = peek();
    		list.remove(popped);
    		
    		return popped;
    	}
    	
    	public int size() {
    		return list.size();
    	}
    	
    	public ArrayList<MazePoint> getStack() {
    		return this.list;
    	}
    	
    }
}
