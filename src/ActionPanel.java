

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ActionPanel extends JPanel { // it adds button to a JPanel, which later is added to the frame in SudokuGUI class
	private SolveButton sButton;          // I did this to make the code look cleaner
	

	
	public ActionPanel(SudokuCellPanel sp) {
		sButton = new SolveButton(sp);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(sButton);
		
	}

}
