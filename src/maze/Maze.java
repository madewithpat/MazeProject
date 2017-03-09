package maze;

import java.util.ArrayList;

public class Maze {
	private char direction; //'n','e','w','s'
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;


    private ArrayList<ArrayList<String>> formattedMaze = new ArrayList<>();
    
    
    private ArrayList<Move> path = new ArrayList<>();
    private ArrayList<Move> illegalMoves = new ArrayList<>();
    
    private Move prevPoint;


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
        	
        	this.formattedMaze.add(mazeRow);
        }
     }

    //Prints out the maze without solution
    public void displayMaze() {
    	for (int i = 0; i < this.formattedMaze.size(); i++) {
    		System.out.print("\n" + this.formattedMaze.get(i).toString());
    	}
    	
    	formattedMaze.forEach
    }

    //displays the Maze with the path taken
    public void displayPath() {
    	
    	//arrMaze[this.r][this.c] = '@';

    }


    public boolean takeStep() {
        //complete the code here
        
        // Iterate through availableMoves
        //      if (availableMoves[i] == '~') {
        //          temp = availableMoves[0];
        //          availableMoves[0] = availableMoves[i];
        //          availableMoves[i] = temp;
        //      }
        //      else if (availableMoves[i] == '#') {
        //          availableMoves.remove(availableMoves[i]);
        //      }
        //      else {
        //          if (illegalMoves.contains(availableMoves[i])) {
        //              availableMoves.remove(availableMoves[i]);
        //          }
        //      }

        // Check availableMoves.size() > 1
        //      if true, move to availableMoves[1]
        //      if false
        //          illegalMoves.add(currentPosition);
        //          currentPosition = ' ';
        //          move${direction of availableMoves[0]}
    	
    	// Create a collection of coordinate pairs availableMoves
    	ArrayList<Move> availableMoves = new ArrayList<>();
    	
    	// Fill availableMoves list with values.
    	availableMoves.add(new Move(r - 1, c));
    	availableMoves.add(new Move(r, c + 1));
    	availableMoves.add(new Move(r + 1, c));
    	availableMoves.add(new Move(r, c - 1));
    	    	    	
    	for (Move temp : availableMoves) {    		
    		if (temp.value == "#") {
    			availableMoves.set(availableMoves.indexOf(temp), null);
//    			availableMoves.remove(availableMoves.indexOf(temp));
    		}
    		else if (temp.value == "~") {
//    			availableMoves.remove(availableMoves.indexOf(temp));
    			availableMoves.set(availableMoves.indexOf(temp), null);
    		}
    		else if (temp.isIllegal()) {
//    			availableMoves.remove(availableMoves.indexOf(temp));
    			availableMoves.set(availableMoves.indexOf(temp), null);
    		}
    	}
    	
    	
        return isAnExit();
    }

    private void moveNorth() {
        //complete the code here
        // maze[r][c] = '~';
        // this.r -= 1;
        // maze[r][c] = '@';
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
    
    class Move implements Comparable<Move>{
    	protected int x;
    	protected int y;
    	protected String value;
    	
    	protected Move(int x, int y) {
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
    	public int compareTo(Move anotherMove) {
    		if (anotherMove.x == this.x) {
    			if (anotherMove.y == this.y) {
    				return 0;
    			}
    		}   
    		
    		return 1;
    	}
    }
    
//    class Stack {
//    	private ArrayList<Object> list = new ArrayList<>();
//    	
//    }
}
