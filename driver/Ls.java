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


/*
* Lists the contents of a node (directory or file)
*/
public class Ls extends Command{
	
	/*
	* Lists the contents of the node at the given path
	* @Param path, ArrayList of strings that stores the path(s)
	*/
	public void execute(ArrayList<String> path){
		Node node = new Node();
		
		//Loops through each path
		for (int i = 0; i < path.size(); i++){
			//Gets the node that the path goes to
			node = Finder.returnDir(path.get(i));
			
			//Tries to print the contents of node
			if (node == null){
				//No such file error
				System.out.println("Invalid Path"); 
			}else{
				if (node instanceof DirectoryNode){ 
					//Case: Node is a directory
					ArrayList<String> children = node.getChild();
					System.out.println(path.get(i) + ": ");
					for (int j = 0; j < children.size(); j++){
						System.out.println(children.get(j));
					}
				}else{ //Case: Node is file
					System.out.println(path.get(i));
				}
			}
		}
	}
	
	/*
	* Lists the contents of the current working directory
	*/
	public void execute(){
		Node node = new Node();
		node = Command.cwd;
		
		//Gets and prints the children of cwd
		ArrayList<String> children = node.getChild();
		for (int i = 0; i < children.size(); i++){
			System.out.print(children.get(i) + "\n");
		}			
		
	}
}