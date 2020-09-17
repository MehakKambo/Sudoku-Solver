//package sudokusolver;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class SolveButton extends JButton implements ActionListener{
	SudokuCellPanel sp;
		public SolveButton(SudokuCellPanel sp) { //creates a solve button
			super("Solve");
			this.sp = sp;
			addActionListener(this);
			this.setLayout(new FlowLayout());
			
		}

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			sp.solve(); // solves sudoku

		}
	}

	


