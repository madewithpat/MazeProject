package maze;

public class Maze {
	private char direction; //'n','e','w','s'
    private int r;  // x position of the mouse
    private int c;  //y position of the mouse
    private boolean exitFound = false;





    public Maze(int[][] arrMaze) {
        this.direction = 'n';
        this.r = maze.size() - 1;
        this.c = 0;
     }

    //Prints out the maze without solution
    public void displayMaze() {
    	for (int i = 0; i < arrMaze.length;i++) {
    		for (int z = 0; z < arrMaze[i].length; z++) {
    		
    			if (1 == arrMaze[i][z]) {
    				System.out.print(" ");
    			}
    			else if (0 == arrMaze[i][z]) {
    				System.out.print("#");
    			}
    		}
    	
    	System.out.println();
    	

    }

    //displays the Maze with the path taken
    public void displayPath() {

    }


    public boolean takeStep() {
        //complete the code here
        // Create a collection of coordinate pairs availableMoves
        // Store the chars of each direction in availableMoves
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
}
