// **********************************************************
// Assignment2:
// Student1: Efkan Serhat Goktepe
// UTORID user_name: goktepee
// UT Student #: 1005939166
// Author: Efkan Serhat Goktepe
//
// Student2:Justin Ding
// UTORID user_name:Dingjust
// UT Student #:1006443145
// Author: Justin ding
//
// Student3: Artem Petrishchev
// UTORID user_name: petrish1
// UT Student #: 1002575260
// Author: Artem Petrishchev
//
// Student4: 
// UTORID user_name: linpeng1
// UT Student #: 10061092398
// Author:Peng Jie Lin (Bob)
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;
import java.util.ArrayList;

public class CD extends Command {
	
    /*
     * Takes an ArrayList of type String as a parameter. This ArrayList is
     * expected to contain a single string which is either ".", "..", or the 
     * full path of a directory.
     * 
     * If the String inside the ArrayList is ".", this method will not change
     * the current working directory.
     * 
     * If it is "..", this method will change the current working directory to
     * the parent of the current working directory. If the current working
     * directory is the root, this method will not change the current working
     * directory.
     * 
     * If it is a full path, the current working directory will be changed to
     * that path.
     * 
     * If the given path is invalid, this method will print an appropriate error
     * message.
     * 
     * If there are multiple paths in the ArrayList, this method will print an 
     * appropriate error message.
     * 
     * @param ArrayList of Strings
     */
	public void execute(ArrayList<String> path)
	{

		//Insures path entered exists
		Node temp =  Finder.returnDir(path.get(0));
		//Checks if the node is an directory node and runs cases respectively
	      if(path.size()==1) {
	        
		if(temp instanceof DirectoryNode) {
			
			Command.cwd = (DirectoryNode)Finder.returnDir(path.get(0)); 
		}
		else if(path.get(0).equals("..")) {
			//Covers case where User wants to move to parent directory
			if(Command.cwd.name.equals("C:") == false) {
				Command.cwd = (DirectoryNode) Command.cwd.getparent();
			}
			
		}
		else {
			ErrorHandling.errorPrint("cd", "invalid input");
			 
		}
	  }
	      else {
	        ErrorHandling.errorPrint("cd", "too many parameters");
	      }
	}
	
}
