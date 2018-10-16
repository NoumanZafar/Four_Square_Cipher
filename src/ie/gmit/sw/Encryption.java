package ie.gmit.sw;

/**
 * This class used to Encrypt the data using Four Square Cipher.
 * 
 * @author Nouman
 *
 */
public class Encryption {
	SetKey k = new SetKey();

	/**
	 * This method takes the StringBuilder text and encrypt it using four square
	 * cipher. where it takes the bigrams and the first character in the plain text
	 * frame is swapped with the character in the randomly generated square and the
	 * second character is treated the same.
	 * 
	 * @param plainText
	 * @return StringBuilder which is Encrypted text.
	 */
	public StringBuilder getEncryptedCharacters(StringBuilder plainText) {
		long startTime = System.nanoTime();
		int xRow = 0, xCol = 0, yRow = 0, yCol = 0;
		StringBuilder sb = new StringBuilder();
		String[] big = new Bigrams().bigrams(plainText);
		/**
		 * @BIG_O_NOTATION : This loop runs in linear time because it has to go through
		 *                 each a every single character in the given file in order to
		 *                 encrypt it.
		 */
		for (String c : big) {
			GetRowCol result = spot(c, 0);
			xRow = result.getRow();
			xCol = result.getCol();
			GetRowCol result1 = spot(c, 1);
			yRow = result1.getRow();
			yCol = result1.getCol();
			sb.append(k.k1[xRow][yCol]).append(k.k2[yRow][xCol]);
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Encryption Time (nt): " + totalTime);
		return sb;
	}

	/**
	 * @BIG_O_NOTATION : This method runs in the constant time O(1) because the
	 *                 position of the character is calculated by the algorithm
	 *                 where character value in ASCII table is subtracted by the
	 *                 first character in the list or square. and the the row number
	 *                 is calculated by the dividing the actual spot of the
	 *                 character in the square by the matrixSize which is 20 in this
	 *                 case.Column number would be calculated by getting the modules
	 *                 of spot of the character by the matrixSiz. which will give
	 *                 the exact spot of the character in the required
	 *                 table(square).
	 * @param c
	 * @param num
	 * @return It return the row and column number of the given character.
	 */
	public GetRowCol spot(String c, int num) {
		int character = (int) c.charAt(num);
		int spot = character - k.start;
		int row = spot / k.matrixSize;
		int column = spot % k.matrixSize;
		return new GetRowCol(row, column);
	}
}
