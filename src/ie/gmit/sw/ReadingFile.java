package ie.gmit.sw;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class is used to read the data from files.
 * 
 * @author Nouman
 *
 */
public class ReadingFile {
	/**
	 * @BIG_O_NOTATION : The Time complexity of this method is O(n) because it has
	 *                 to read all the data line by line and there could be n lines
	 *                 in the file.
	 * @param res
	 * @param url
	 * @param isClearText
	 * @return It takes in the String text and return StringBuilder
	 * @throws Exception
	 */
	public StringBuilder reading(String res, boolean url, boolean isClearText) throws Exception  {
		StringBuilder sb = new StringBuilder();
		if (url) {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(res), StandardCharsets.UTF_8));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				if (isClearText) {
					sb.append(System.lineSeparator());
				}
			}
			br.close();
		}
		return sb;
	}
}
