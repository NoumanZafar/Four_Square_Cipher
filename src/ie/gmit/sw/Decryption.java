package ie.gmit.sw;

/**
 * This class used to Decrypt the Encrypted data back to readable text.
 * 
 * @author Nouman
 *
 */
public class Decryption {
	SetKey key = new SetKey();

	/**
	 * This method takes the StringBuilder text and and Decrypt the data using Four
	 * Square Cipher.
	 * 
	 * @BIG_O_NOTATION : The run time of this method is linear time because the for
	 *                 loop has to iterate over all the data and the Collection
	 *                 method indexOf(character) runs in linear O(n) time as well.
	 *                 Because it has to go in the list or array and check the
	 *                 position of the actual character and there could be n
	 *                 characters in the n characters in the list or array and the
	 *                 worst case would be if the character is not on the list.
	 * @param cipher
	 * @return StringBuilder text
	 */
	public StringBuilder getDecryptedCharacters(StringBuilder cipher) {
		long startTime = System.nanoTime();
		int xRow = 0, xCol = 0, yRow = 0, yCol = 0;
		StringBuilder sb = new StringBuilder();
		String[] big = new Bigrams().bigrams(cipher);
		for (String c : big) {
			int ind = key.keys1.indexOf(c.charAt(0));
			xRow = ind / key.matrixSize;
			xCol = ind % key.matrixSize;

			int ind1 = key.keys2.indexOf(c.charAt(1));
			yRow = ind1 / key.matrixSize;
			yCol = ind1 % key.matrixSize;

			sb.append(key.k[xRow][yCol]).append(key.k[yRow][xCol]);

		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Decryption Time  (nt): " + totalTime);
		return sb;
	}
}
