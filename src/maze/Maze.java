package maze;

import java.util.ArrayList;

public class Maze {
	private char direction; //'n','e','w','s'
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;


    private ArrayList<ArrayList<Object>> formattedMaze = new ArrayList<>();
    
    
    private ArrayList<Move> path = new ArrayList<>();
    private ArrayList<Move> illegalMoves = new ArrayList<>();


    public Maze(int[][] arrMaze) {
        this.direction = 'n';
        this.c = 0;
        this.r = 0;
        
        
        for (int i = 0; i < arrMaze.length; i++) {
        	ArrayList<Object> mazeRow = new ArrayList<>();
        	
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
    	ArrayList<char> availableMoves = new ArrayList<>();
    	
    	// indices correspond to direction, 0 = N, 1 = E, etc.
    	availableMoves.add(new Move(r - 1, c));
    	availableMoves.add(new Move(r, c + 1));
    	availableMoves.add(new Move(r + 1, c));    	
    	availableMoves.add(new Move(r, c - 1));
    	
    	while (availableMoves.contains)
    	
    	for (int i = 0; i < availableMoves.size(); i++) {
    		char test = formattedMaze[availableMoves.get(1).x][availableMoves.get(1).y];
    		
    		if (test == "#") {
    			availableMoves.set(i, null);
    		}
    		
    		if (illegalMoves.contains(moves[i])) {
    			moves[i] = null;
    		}
    		
    		if (test == "~") {
    			moves[i] = null;
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
    
    class Move {
    	protected int x;
    	protected int y;
    	
    	protected Move(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
//    class Stack {
//    	private ArrayList<Object> list = new ArrayList<>();
//    	
//    }
}
