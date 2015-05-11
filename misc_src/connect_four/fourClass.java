
import java.util.*;
 
public class fourClass {
	
	static int ROWS = 6;
	static int COLUMNS = 7;
	
	public static void main(String args[]) {
  
		// Array
		String[][] fourGrid = new String[ROWS][COLUMNS];
		
		// Console
		Scanner console    = new Scanner (System.in);
		
		// winner?
		boolean noWinner = true;
		
		printHeader ();
		
		// Initialize the Board to 'O'
		
		for (int i = 0; i < fourGrid.length; i++) {
			for (int j = 0; j < fourGrid[i].length; j++) {
				fourGrid[i][j] = "O";
			}
		}
		
		printBoard (fourGrid); System.out.println();
		
		while (noWinner) {
			if (!isBoardFull(fourGrid)) {
				System.out.print ("Player 1 (Red) Turn> ");
				String turn = console.nextLine();
				System.out.println();
				playGame (fourGrid, turn, "R");
			} else {
				System.out.println("Tie game, you both lose");
				System.exit(0);
			}
			
			System.out.println();
			
			if (!isBoardFull(fourGrid)) {
				System.out.print ("Player 2 (BLACK) Turn> ");
				String turn = console.nextLine();
				System.out.println();
				playGame (fourGrid, turn, "B");
				System.out.println();
			} else {
				System.out.println("Tie game, you both lose");
				System.exit(0);
			}
		}
		
		console.close();
	}
	
	/*
	 * playGame - main part of game used by both Red & Black
	 * 
	 * parameters: 	2D String array, the input from console, whose turn it is
	 * return: 		void
	 * 
	 */
	public static void playGame (String [][] fourGrid, String turn, String coin) {
		
		if (containsComma(turn)) {
		
			String[] turnSplit = turn.split(",");
			
			if (isInteger(turnSplit[0]) && isInteger(turnSplit[1])) {
				int row = Integer.parseInt (turnSplit[0]);
				int column = Integer.parseInt (turnSplit[1]);
				
				System.out.println ("This is like coding:  grid[" + row + "][" + column + "] = \"" + coin + "\";");
				System.out.println();
				
				if ((verifyValid (row, column) == true) &&
					(verifyBottom(fourGrid, row, column) == true) && 
					(verifyEmpty(fourGrid, row, column) == true)) {
					
					updateGrid(fourGrid, row, column, coin);
					
					if ((checkColumn (fourGrid, row, column, coin) == true) || 
						(checkRow (fourGrid, row, column, coin) == true) ||
						(checkBackwardsDiagonal (fourGrid, row, column, coin) == true) ||
						(checkForwardDiagonal (fourGrid, row, column, coin) == true)) {
						printBoard(fourGrid);
						System.out.println (coin + " wins but James is still World Champion");
						System.exit(0);
					}
				} else {
					System.out.println ("INVALID CHOICE.  LOSS OF TURN");
				}
			} else {
				System.out.println ("INVALID CHOICE.  LOSS OF TURN");
			}
		} else {
			System.out.println ("INVALID CHOICE.  LOSS OF TURN");
		}
		
		printBoard(fourGrid);
	}
	
	/*
	 * printHeader - print some instructions
	 * 
	 * parameters: 	void
	 * return: 		void
	 * 
	 */
	public static void printHeader () {		
		System.out.println("Welcome toConnect Four game");
		System.out.println("(true gamers just call it 'four')");
		System.out.println();
		System.out.println("To play, type in the array element on where you want to play your coin:");
		System.out.println("Use the format 2,3 to correspond with [2][3]");
		System.out.println();
		System.out.println("If you mess up, you lose a turn!");
		System.out.println();
		System.out.println("Good luck, but remember, I'm still the World Champion");
		System.out.println();
		
	}

	
	/*
	 * printBoard - print the whole board
	 * 
	 * parameters: 	2D String array
	 * return: 		void
	 * 
	 * Go through the grid and print the element and a space after
	 */
	public static void printBoard (String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print (grid[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	/*
	 * isBoardFull - make sure there isn't a tie
	 * 
	 * parameters: 	2D String array
	 * return: 		true/false
	 * 
	 * Go through the grid and make sure there is a "O"
	 */
	public static boolean isBoardFull (String[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].equals("O")) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/*
	 * verifyValid - make sure row & column is in range
	 * 
	 * parameters: 	row element, column element
	 * return: 		true/false
	 * 
	 * Go through the grid and make sure there is a "O"
	 */
	public static boolean verifyValid (int rows, int columns) {
		if ((rows >= ROWS) || (columns >= COLUMNS) || (rows < 0) || (columns < 0)) {
			return false;
		}
		
		return true;
		
		
	}

	/*
	 * updateGrid - valid play, now update the 2D array
	 * 
	 * parameters: 	2D String array, row position, column position, color of coin
	 * return: 		void
	 *
	 */
	public static void updateGrid (String[][] grid, int row, int column, String coin) {
		
		grid[row][column] = coin; 
	}

	/*
	 * verifyBottom - checks to see if there is a coin underneath the position they are 
	 *                playing
	 * 
	 * parameters: 	2D String array, row position, column position
	 * return: 		void
	 *
	 */
	public static boolean verifyBottom (String[][] grid, int row, int column) {
		
		if (row == 5) {
			return true;
		} else {
			while (row != 5) {
				row++;
				
				if (grid[row][column].equals("O")) {
					return false;
				} 
			}
		}
		
		return true;
	}

	/*
	 * verifyEmpty - checks to see if someone already played a coin there
	 * 
	 * parameters: 	2D String array, row position, column position
	 * return: 		true/false
	 *
	 */
	public static boolean verifyEmpty (String[][] grid, int row, int column) {
		
		if (!grid[row][column].equals("O")) {
			return false;
		}
		
		return true;
	}

	/*
	 * checkRow - checks to see if there is 4 in a row left to right
	 * 
	 * parameters: 	2D String array, row position, column position, color of coin
	 * return: 		true/false
	 *
	 */
	public static boolean checkRow (String[][] grid, int row, int column, String coin) {

		int count = 0;
		int original_position = row;
		
		// go down
		while ((row < ROWS) && grid[row][column].equals(coin)) {
			count++;
			row++;
		}
		
		//go up.  we already got the original so decrement
		
		row = original_position - 1;
		
		while ((row >= 0) && grid[row][column].equals(coin)) {
			count++;
			row--;
		}
		
		if (count == 4) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * checkColumn - checks to see if there is 4 in a row up/down
	 * 
	 * parameters: 	2D String array, row position, column position, color of coin
	 * return: 		true/false
	 *
	 */
	public static boolean checkColumn (String[][] grid, int row, int column, String coin) {
		int count = 0;
		int original_position = column;
		
		// go down
		while ((column < COLUMNS) && grid[row][column].equals(coin)) {
			count++;
			column++;
		}
		
		
		column = original_position - 1;
		
		while ((column >= 0 && grid[row][column].equals(coin) )) {
			count++;
			column--;
		}
		
		if (count == 4) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * checkBackwardsDiagonal - checks to see if there is 4 in a row diagonally
	 * 
	 * parameters: 	2D String array, row position, column position, color of coin
	 * return: 		true/false
	 *
	 *
	 *  x  0  0
	 *  0  x  0
	 *  0  0  x
	 */
	public static boolean checkBackwardsDiagonal (String[][] grid, int row, int column, String coin) {
		int count = 0;
		int original_row_position = row;
		int original_column_position = column;
		 
		while ((column < COLUMNS) && (row < ROWS) && grid[row][column].equals(coin)) {
			count++;
			column++;
			row++;
		}
		
		row = original_row_position - 1;
		column = original_column_position - 1;
		
		while ((column >= 0) && (row >= 0) && (grid[row][column].equals(coin))) {
			count++;
			row--;
			column--;
		}
		
		if (count == 4) {
			return true;
		}
		
		return false;
	}
	
	
	/*
	 * checkForwardDiagonal - checks to see if there is 4 in a row diagonally
	 * 
	 * parameters: 	2D String array, row position, column position, color of coin
	 * return: 		true/false
	 *
	 *
	 *  0  0  x
	 *  0  x  0
	 *  x  0  0
	 */
	public static boolean checkForwardDiagonal (String[][] grid, int row, int column, String coin) {
		int count = 0;
		int original_row_position = row;
		int original_column_position = column;
		
		while ((column < COLUMNS) && (row >= 0) && grid[row][column].equals(coin)) {
			count++;
			row--;
			column++;
		}
		
		row = original_row_position + 1;
		column = original_column_position - 1;
		
		while ((column >= 0) && (row < ROWS) && (grid[row][column].equals(coin))) {
			count++;
			row++;
			column--;
		}
		
		if (count == 4) {
			return true;
		}
		
		return false;
	}
	
	/*	
	 * isInteger - See if the string is valid number
	 * 
	 * parameters: 	String (an element, example: "1")
	 * return: 		true/false
	 */
	public static boolean isInteger (String input) {
	
		// always the first
		if (!input.equals(null)) {
			char ch = input.charAt(0);
			
			if (!Character.isDigit(ch)) {
				return false;
			}
		} else {
			return false;
		}
		
		return true;
	}
	
	/*
	 * containsComma - See if the string has ,
	 * 
	 * parameters: 	String (ex. "1,2")
	 * return: 		true/false
	 */
	public static boolean containsComma (String input) {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if (ch == ',') {
				return true;	// found comma
			}
		}
		
		return (false);
	}
}