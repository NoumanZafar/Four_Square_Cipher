package ie.gmit.sw;

public class GetRowCol {
	private int row;
	private int col;

	/**
	 * This class is used to determine the row and column number of the given
	 * character.
	 * 
	 * @param row
	 * @param col
	 * @author Nouman
	 */
	public GetRowCol(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Getters and setter
	 */
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
}
