//package sudokusolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Extraction {
	public int[][] getgrid() throws FileNotFoundException{
		Scanner con=new Scanner(new File("sudoku.txt"));//Scanner for file
		int[][] grid= new int[9][9];// a 2D array

		while(con.hasNextLine()) {// goes till the end of the file
			for(int i=0;i<grid.length;i++) {
				String []line=con.nextLine().trim().split("");// it splits each character in the line and trim removes the spaces
				for(int k=0;k<line.length;k++) {// it goes through eacah character in line and replaces '.' with a "0"
					if(line[k].equals(".")) {
						line[k]="0";
					}
				}
				for(int j=0;j<line.length;j++) {
					grid[i][j]= Integer.parseInt(line[j]);
				}
			} 
		}
		con.close();
		return grid;  // the grid is ready

	}
	
}
