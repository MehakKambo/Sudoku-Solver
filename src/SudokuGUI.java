//package sudokusolver;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class SudokuGUI {
	
	JFrame frame;
	ActionPanel actionpanel;
	SudokuCellPanel scellpanel;

	public SudokuGUI() throws FileNotFoundException {
		
		frame = new JFrame("Sudoku Solver");// creates a frame with a title
		scellpanel = new SudokuCellPanel(); //creates a new SudokuPanel
		actionpanel = new ActionPanel(scellpanel);// it adds the  solve button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(scellpanel, BorderLayout.CENTER);
		frame.add(actionpanel, BorderLayout.SOUTH);
		frame.setPreferredSize(new Dimension(200,200));
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
		frame.setEnabled(true);
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Extraction gui = new Extraction();
		int[][] letsplay = gui.getgrid();// the grid is ready
		Sudoku sudoku= new Sudoku(letsplay);
		System.out.println("Grid to solve");
		sudoku.displayResults();
		if(sudoku.solve()) {
			System.out.println("Solved Board");// displays the board iff solved
			System.out.println();
			sudoku.displayResults();}
		else {
			System.out.println("Opps!! This grid is unsolveable");
		}
		new SudokuGUI();
	}
}