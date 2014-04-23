import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;


public class Driver {
	
	// Initialize buffer reader
	static BufferedReader br = null;

	public static void main(String[] args) throws IOException {
		
		TaskManager mySched = new TaskManager();
		mySched.setBounds(40,40,400,300);
		mySched.setVisible(true);
		
		// Try to read from text file provided
		try
		{
			//Path path = Paths.get("test.txt");
			Path path = Paths.get("C:\\Users/elJeffeh/Documents/Github/SmithAllen/src/test.txt");
			String fileToRead = path.toAbsolutePath().toString();
			System.out.println(fileToRead);
			
			br = new BufferedReader(new FileReader(fileToRead));
		
			// If found, keep truckin by putting this data in a string array
			String stringCurrentLine;
			String[] dataArray = new String[10];
			int iterator = 0;
			
			while ((stringCurrentLine = br.readLine()) != null) {
				dataArray[iterator] = stringCurrentLine;
				mySched.MainPanel.add(new JButton(dataArray[iterator]));
				iterator++;
			}
			
			mySched.MainPanel.revalidate();
		    mySched.setVisible(true);
			
		}
		
		// Catch the case no file is found
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("I'm fuckin up");
			mySched.setVisible(true);
		}

	
	}
}
