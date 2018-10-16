package ie.gmit.sw;

import java.awt.*;

/**
 * This class is used to choose the file from the system and get the path of the
 * files and this class is also used to save the file at the chosen path and the
 * chosen name.
 * 
 * @author Nouman
 *
 */
public class FilePath {
	String filePath;

	public String writeFilePath() {
		FileDialog dialog = new FileDialog(new Frame(), "Save Encrypted Or Decrypted File...(Path To Save File)",
				FileDialog.SAVE);
		dialog.setVisible(true);
		String fileName = dialog.getFile() + ".txt";
		String path = dialog.getDirectory();
		if (path == null) {
			System.out.println("No Path Chosen...!!!\nProgram is terminated");
			System.exit(0);
		} else {
			filePath = path + fileName;
		}
		return filePath;
	}

	public String readFilePath() {
		FileDialog dialog = new FileDialog(new Frame(), "Choose a File To Encrypt Or Decrypt...(Path To Choose File)",
				FileDialog.LOAD);
		dialog.setVisible(true);
		String fileName = dialog.getFile();
		String path = dialog.getDirectory();
		if (path == null) {
			System.out.println("No Path Chosen...!!!\nProgram is terminated");
			System.exit(0);
		} else {
			filePath = path + fileName;
		}
		return filePath;
	}
}
