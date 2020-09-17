//package sudokusolver;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.BevelBorder;


public class SudokuCellPanel extends JPanel {
	JLabel[][] label;
	Sudoku sudoku;
	boolean fill3x3SquareGrid;
	int[][]copy;



	public SudokuCellPanel() throws FileNotFoundException {
		

		label = new JLabel[Sudoku.boardlength][Sudoku.boardlength];// initialize a 2D array of type Jlabel
		Extraction gridgetter= new Extraction();    // it's time to get the grid
		int[][]gridtosolve= new int[Sudoku.boardlength][Sudoku.boardlength] ;
		gridtosolve=gridgetter.getgrid();    // the grid is ready
		sudoku = new Sudoku(gridtosolve);      // creates a new Sudoku object
		this.setLayout(new GridLayout(Sudoku.boardlength, Sudoku.boardlength));// approach to create a 3x3 grid starts

		fill3x3SquareGrid = true;
		for (int row = 0; row < Sudoku.boardlength; row++) {// go through
			for (int col = 0; col < Sudoku.boardlength; col++) {// and column
				label[row][col] = new JLabel(Integer.toString(gridtosolve[row][col]));// it initializes JLabel and passes each value from grid to JLabel
				label[row][col].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));// I found it to make the game more appealing
				fill3x3SquareGrid(row, col);// fills the 3x3
				if ((col + 1) % 3 == 0) {
					fill3x3SquareGrid = !fill3x3SquareGrid;// it checks the end of the 3x3grid
				}
				label[row][col].setHorizontalAlignment(JLabel.CENTER); //  it aligns the numbers in the grid to the center of the JLabel
				this.add(label[row][col]); // adds JLabel to the SudokuPanel
			}
			if ((row +1)/3 == 1) {
				fill3x3SquareGrid = false; //it marks the end of the 3x3 squaregrid
			} else {
				fill3x3SquareGrid = true;
			}
		}
	}

	private boolean isNumberInRange(int number) {//  First thing First, a method to check if the number is between 0 and 9
		return number >= 0 && number <= 9;
	}



	public void solve() {
		int[][] sudokuNumbers = new int[Sudoku.boardlength][Sudoku.boardlength];// My approach to stop the program from breaking    
		boolean isAString = false;                                  //when I enter a String or a double digit number to the grid 
		boolean restrictedNumber = false;
		for (int r = 0; r < Sudoku.boardlength; r++) {
			for (int c = 0; c < Sudoku.boardlength; c++) {
				String currentNumber = label[r][c].getText();
				int number = 0;
				try {
					if (!currentNumber.equals("")) {
						number = Integer.parseInt(currentNumber);
						if (!isNumberInRange(number)) {
							restrictedNumber = true;
						}
					}
				} catch (NumberFormatException e) {
					isAString = true;
				}
			}
		}
		if (isAString) {
			JOptionPane.showMessageDialog(this, "Please enter numbers only to the grid");
		} else if (restrictedNumber) {
			JOptionPane.showMessageDialog(this,
					"Please check for a double digit or a negative number on your grid");
		} else {
			boolean solved = sudoku.solve(); 
			if (solved) { // adds the values from the grid to JLabel iff solved
				sudokuNumbers = sudoku.getGrid();
				for (int r = 0; r < Sudoku.boardlength; r++) {
					for (int c = 0; c < Sudoku.boardlength; c++) {
						label[r][c].setText("" + sudokuNumbers[r][c]);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"Opps!! This grid has no solution");
			}
		}
	}

	private void fill3x3SquareGrid(int r, int c) {// it makes the border of the 3x3 boxes darker.
		if (fill3x3SquareGrid) {
			this.setBackground(Color.WHITE);
			label[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		}
	}
}









