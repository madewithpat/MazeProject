package maze;

import java.util.ArrayList;

public class Maze {
	private char direction; //'n','e','w','s'
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;


    private ArrayList<ArrayList<String>>theMaze = new ArrayList<>();
    
    
    private ArrayList<ArrayList<String>> thePath = new ArrayList<>();
    private ArrayList<MazePoint> illegalMoves = new ArrayList<>();
    private MazePointStack moves = new MazePointStack();
    

    public Maze(int[][] arrMaze) {
        this.direction = 'n';
        this.c = 0;
        this.r = 0;
        
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
    	
    }


    public boolean takeStep() {
        //complete the code here
            	
    	// Create a collection of coordinate pairs availableMoves
    	ArrayList<MazePoint> availableMoves = new ArrayList<>();
    	
    	// Fill availableMoves list with values.
    	availableMoves.add(new MazePoint(r - 1, c));
    	availableMoves.add(new MazePoint(r, c + 1));
    	availableMoves.add(new MazePoint(r + 1, c));
    	availableMoves.add(new MazePoint(r, c - 1));
    	    	    	
    	for (MazePoint temp : availableMoves) {    		
    		if (temp.value == "#") {
//    			availableMoves.set(availableMoves.indexOf(temp), null);
    			availableMoves.remove(availableMoves.indexOf(temp));
    		}
    		else if (temp.value == "~") {
    			availableMoves.remove(availableMoves.indexOf(temp));
//    			availableMoves.set(availableMoves.indexOf(temp), null);
    		}
    		else if (temp.isIllegal()) {
    			availableMoves.remove(availableMoves.indexOf(temp));
//    			availableMoves.set(availableMoves.indexOf(temp), null);
    		}
    	}
    	
    	if (availableMoves.size() == 0) {
    		MazePoint prev = moves.peek();
    		illegalMoves.add(new MazePoint(r, c));
    		
    		switch (this.r - prev.x) {
    		case (1):
    			direction = 'n';
    			break;
    		case (-1):
    			direction = 's';
    			break;
    		case (0):
    			if (c > prev.y) {
    				direction = 'w';
    			}
    			else if (c < prev.y) {
    				direction = 'e';
    			}
    			break;
    		}
    	}
    	else {
    		MazePoint next = availableMoves.get(0);
    		
    		switch (this.r - next.x) {
    		case (1)
    		}
    	}
    	
    	
        return isAnExit();
    }

    private void moveNorth() {
        //complete the code here
        thePath.get(r).set(c, "~");
        moves.push(new MazePoint(r, c));
        r -= 1;
        thePath.get(r).set(c, "@");
    }

    private void moveSouth() {
        //complete the code here
        // maze[r][c] = '~';
        // this.r += 1;
        // maze[r][c] = '@';
    }

    private void moveEast() {
        //complete the code here
        // maze[r][c] = '~';
        // this.c += 1;
        // maze[r][c] = '@';
    }

    private void moveWest() {
        //complete the code here
        // maze[r][c] = '~';
        // this.c -= 1;
        // maze[r][c] = '@';
    }


    private boolean isAnExit() {
        //complete the code here
        //exitFound = this.r == ( maze.size() - 1 ) || this.r == 0 || this.c == 0;
        return exitFound;
    }

    //finds the path without stopping at every step
    public void findExit() {
        //complete the code here

    }
    
    class MazePoint implements Comparable<Move>{
    	protected int x;
    	protected int y;
    	protected String value;
    	
    	protected MazePoint(int x, int y) {
    		this.x = x;
    		this.y = y;    		
    		this.value = formattedMaze.get(x).get(y);
    	}
    	
    	protected Boolean isIllegal() {
    		for (int i = 0; i < illegalMoves.size(); i++) {
    			if (this.compareTo(illegalMoves.get(i)) == 0) {
    				return true;
    			}
    		}
    		return false;
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
    		MazePoint popped = this.peek();
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
