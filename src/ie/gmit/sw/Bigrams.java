package ie.gmit.sw;

/**
 * This class used to split the text into pair of characters e.g Hello is the
 * word and this class split it into pair of characters like this He ll o
 * 
 * @author Nouman
 *
 */
public class Bigrams {
	/**
	 * This is the actual method which is used to split the text into pair of
	 * characters
	 * 
	 * @BIG_O_NOTATION : This method runs in linear O(n) time because the loop has
	 *                 to iterate over all the characters in given text
	 * @param plainText
	 *            which is type of StringBuilder
	 * @return pair of the characters.
	 */
	public String[] bigrams(StringBuilder plainText) {
		if (plainText.length() % 2 != 0) {
			plainText = plainText.append("");
		}
		String[] characterPairs = new String[plainText.length() / 2];
		int xCharacter = 0;
		for (int i = 0; i < (plainText.length() / 2); i++) {
			characterPairs[i] = plainText.substring(xCharacter, xCharacter + 2);
			xCharacter = xCharacter + 2;
		}
		return characterPairs;
	}
}
