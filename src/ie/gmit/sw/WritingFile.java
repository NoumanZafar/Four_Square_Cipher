package ie.gmit.sw;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * This is the class which is used to write the text into external file.
 * 
 * @author Nouman
 *
 */
public class WritingFile {
	/**
	 * This method is used to write the text into file and the file format is UTF_8
	 * because windows does not support many characters instead of writing the
	 * actual character it writes ? which creates the problem in Encryption and
	 * Decryption. OutputStreamWriter and FileOutputStream is used to write the
	 * file.
	 * 
	 * @param fileName
	 * @param text
	 * @throws Exception
	 */
	public void writer(String fileName, StringBuilder text) throws Exception {
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
		writer.write(text.toString());
		writer.close();
	}
}
