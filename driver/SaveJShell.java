package driver;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
public class SaveJShell extends Command {

	public void createFile(String input) {
	    try {
	        File myObj = new File(input);
	        if (myObj.createNewFile()) {
	          System.out.println("File created: " + myObj.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }

	}
	public void execute(ArrayList<String> input) {
		createFile(input.get(0));
	}
}

  
