package ie.gmit.sw;

import java.util.*;

/**
 * * This is a class which makes the keys in order to Encrypt or Decrypt There
 * are four squares in which Top right and Bottom left square are plain
 * characters and the Top left and bottom right are the randomly generated.
 * 
 * @author Nouman
 *
 */
public class SetKey {
	/**
	 * These are the list of characters which holds all the characters
	 */
	List<Character> keys = new ArrayList<Character>();
	List<Character> keys1 = new ArrayList<Character>();
	List<Character> keys2 = new ArrayList<Character>();
	/**
	 * martixSize is a variable which decides the size of one square whether its a
	 * plain square or random start is a variable which decides where to start in
	 * ASCII table. means which character is going to be the first character in the
	 * list.
	 */
	int matrixSize = 20;
	int start = 10;
	/**
	 * 2D array of characters holds all the values of the lists but in the square
	 * that means these arrays place all the characters in rows and columns. And
	 * size of the array depends upon the matrixSize variable.
	 */
	char[][] k = new char[matrixSize][matrixSize];
	char[][] k1 = new char[matrixSize][matrixSize];
	char[][] k2 = new char[matrixSize][matrixSize];
	int x = 0;

	/**
	 * SetKey is a constructor which calls the generateKeys method.
	 */
	SetKey() {
		generateKeys();
	}

	/**
	 * generateKeys is a function which makes the keys in the lists and then
	 * transfer the characters in the array and makes the keys randomly placed in
	 * the top left and bottom right square.
	 */
	public void generateKeys() {
		/**
		 * This for loop is used to generate the characters form ASCII table
		 * 
		 * @BIG_O_NOTATION : This is processed in linear O(n) time because in order to
		 *                 get the character loop has to iterate over all the number in
		 *                 the ASCII table one by one.
		 */
		for (int i = start; i < (matrixSize * matrixSize) + start; i++) {
			char c = (char) i;
			keys.add(c);
		}
		/**
		 * @BIG_O_NOTATION : Where add method in arrayList is O(1) time. addAll method
		 *                 is O(n) time because it has to iterate over all the element
		 *                 of the second Collection O(Collection.size).
		 */
		keys1.addAll(keys);
		keys2.addAll(keys);
		/**
		 * This long number generates the random numbers and it generates the same
		 * number every time program runs.
		 */
		long pass1 = 567;
		long pass2 = 566;

		Random rand = new Random(pass1);
		Random rand1 = new Random(pass2);
		/**
		 * @BIG_O_NOTATION : Colection.shuffle method runs in linear time.
		 */
		Collections.shuffle(keys1, rand);
		Collections.shuffle(keys2, rand1);

		/**
		 * @BIG_O_NOTATION : Assigning the values into rows and columns would be
		 *                 Quadratic O(n2) time complexity because there could be n
		 *                 number of rows and n number of columns.And there is nested
		 *                 loop.
		 */
		for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < k[i].length; j++) {
				k[i][j] = keys.get(x);
				k1[i][j] = keys1.get(x);
				k2[i][j] = keys2.get(x);
				x++;
			}
		}
	}
}
