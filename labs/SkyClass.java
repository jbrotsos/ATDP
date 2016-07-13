package telescope_lab;

public class SkyClass {

	// a rectangular array that holds the data representing a rectangular area
	// of the sky
	private double[][] view;
	
	// constructs a SkyClass object from a 1-dimensional array of scan data
	// @param: numRows - the number of rows represented in the view
	//		   PRECONDITION: numRows > 0
	// @param: numCols - the number of columns represented in the view
	//         PRECONDITION: numCols > 0
	// @param: scanned - the scan data received from the telescope, stored in
	//         telescope order
	// POSTCONDITION: view has been created as a rectangular 2-dimensional
	//                array with numRows and numCols columns and the values
	//                in scanned have been copied to view and are ordered as 
	//                in the original rectangular area of sky.
	public SkyClass (int numRows, int numCols, double[] scanned) {
		// to be implemented in part (a)
	}
	
	// returns the average of the values in a rectangular section of view
	// @param: startRow - the first row index of the section
	// @param: endRow - the last row index of the section
	// @param: startCol - the first column index of the section
	// @param: endCol - the last column index of the section
    // PRECONDITION: 0 <= startRow <= endRow < view.length
	// PRECONDITION: 0 <= startCol <= endCol < view[0].length
	// @return: the average of the values specified in the view
	public double getAverage (int startRow, int endRow, int startCol, int endCol) {
		// to be implemented in part (b)
	}
	
}
