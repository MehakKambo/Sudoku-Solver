//package sudokusolver;

public class Sudoku {

	private int[][] grid;
	public final static int boardlength = 9;


	public Sudoku() {
		grid = new int[boardlength][boardlength];// 9x9 board

	}


	public Sudoku(int[][]grid) { // Initialization
		this.grid=new int [9][9];
		for (int i= 0;i<boardlength ;i++) {
			for(int j=0;j<boardlength;j++) {
				this.grid[i][j]=grid[i][j];
			}
		}
	}

	public boolean solve() { //solves the sudoku
		return solve(0, 0);
	}
	private boolean isSafeToPlace(int row, int col, int num) { // checks all 3 rules of the Sudoku game
		return row(row,col, num )&& col(row,col, num)&& isIn3x3Grid(row,col,num);
	}

	private boolean solve(int r, int c) {
		for (int row=0;row<boardlength;row++) {// checks row
			for(int col=0;col<boardlength;col++) {// checks column
				if(grid[row][col]==0) {// if the number is '0' it tries numbers from 1 -9
					for(int num=1;num<=boardlength;num++) {
						if(isSafeToPlace(row,col,num)) {
							grid[row][col]=num;
							if(solve()) { // recursive backtracking
								return true;
							}else {
								grid[row][col]=0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean row(int r, int c, int value) { // checks for the number in each row
		for(int i=0;i<boardlength;i++) {
			if( grid[r][i]==value) {
				return false;

			}

		}
		return true;
	}
	public void displayResults() { // display the results
		for(int i=0; i<boardlength;i++) {
			for(int j=0;j<boardlength;j++) {
				System.out.print(" "+ grid[i][j]);

			}
			System.out.println();
		}
		System.out.println();
	}
	public int[][] getGrid() { 
		return grid;
	}

	private boolean col(int r, int c, int value) {// checks for the number in  each column
		for(int i=0;i<boardlength;i++) {
			if(grid[i][c]==value){
				return false;
			}
		}
		return true;
	}


	private boolean isIn3x3Grid(int r, int c, int value) { // checks for the number in  each 3x3 grid
		int row = r - r % 3; // it places the cursor at the initial position for a 3x3 matrix  
		int col = c - c % 3;
		for(int i = row; i < row + 3; i++) { // stop once you reach the third row of the 3x3 matrix
			for(int j = col; j < col + 3; j++) { //stop once you reach the third column of the 3x3 matrix
				if(grid[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}
