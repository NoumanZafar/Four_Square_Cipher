package ie.gmit.sw;

import java.util.*;

/**
 * The Menu class Gives the user different options and leads to different parts
 * of the project i.e Encryption,Decryption,Reading and writing to files etc.
 * 
 * @author Nouman
 *
 */
public class Menu {
	ReadingFile readFile = new ReadingFile();
	Encryption enc = new Encryption();
	Decryption dec = new Decryption();
	WritingFile writeFile = new WritingFile();
	FilePath filePath = new FilePath();
	/**
	 * KeepRunning is a boolean variable which decides how many time this program is
	 * going to run if its true it will keep running otherwise stops.
	 */
	boolean keepRunning = true;
	private Scanner s = new Scanner(System.in);
	private String text = "Please select one of the following options.\n\t1. Encryption\n\t2. Decryption\n\t   Any Other Number to end";

	/**
	 * This is show method which keeps running until the keepRunning is true and
	 * calls the method named process
	 */
	public void show() {
		while (keepRunning) {
			System.out.println(text);
			String option = s.next();
			process(option);
		}
	}

	/**
	 * This is the process method which gives different options to the user and ask
	 * their input in order to do different tasks.This is void method
	 * 
	 * @param option
	 *            it is selection of the activity user wants to performs
	 * @throws Exception
	 *             if option is not a number
	 */
	private void process(String option) {
		try {
			int selection = Integer.parseInt(option);
			if (selection == 1) {
				writeFile.writer(filePath.writeFilePath(),
						enc.getEncryptedCharacters(readFile.reading(filePath.readFilePath(), true, true)));
			} else if (selection == 2) {
				writeFile.writer(filePath.writeFilePath(),
						dec.getDecryptedCharacters(readFile.reading(filePath.readFilePath(), true, false)));
			} else {
				System.out.println("Wrong Input");
				System.exit(0);
				keepRunning = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
