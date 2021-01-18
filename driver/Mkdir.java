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
* Stores method that creates 2 children directories
* that returns errors when given invalid names for directories
* or non-existant paths along with its helper methods
*/
public class Mkdir extends Command{
	
	/*
	* Creates a directory and sets its parent as instructed by path
	* @Param temperoryParent, a directory node that stores the parent
	* @Param tempName1, a String that stores the name of the parent
	* @Param input, a String that stores the name of the child
	*/
	public  void createDir(DirectoryNode temperoryParent, 
			String tempName1,
			String input) {
		DirectoryNode dir1 = new 
		DirectoryNode(tempName1,input);//creates new directory
		dir1.setParent(temperoryParent); //sets parent for new directory
		temperoryParent.setChild(dir1);//sets new child for parent
		dir1.address = AbsPathFinder.getAbsPath(dir1);
	}
	
	/*
	* Separates user input and gets the name of the directory to be created
	* @Param input, a String that stores (one part) of user input 
	* @Return tempName1, the name of the directory to be created
	*/
	public  String getName(String input) {
		String tempName1 = ""; // name of directory
		String[] t;
		tempName1 = "";
		t = input.split("/");
		if(t.length == 1) { //case where user input is length 1
			tempName1 = t[0];
	}
		else {
			// gets name of directory	
			for(int i =0; i<t.length; i++) {
				if(i== t.length-1) {
					tempName1 = t[i]; 
				}
			}		
		}
		return tempName1;
	}
	
	/*
	* Separates user input and gets the path of the parent node
	* @Param input, a String that stores (one part) of user input
	* @Return parentAddress, a String that stores the path of the parent node
	*/
	public  String getParentPath(String input) {
		String parentAddress = ""; //stores parentAddress
		String[] t;
		parentAddress = "";
		t = input.split("/");
		if(t.length == 1) { //case where user input is length 1
			parentAddress = cwd.address;
	}
		else {
			//gets parent address
			for( int i =0;i<t.length;i++) {
				if(i<= t.length-2) {
					parentAddress = parentAddress + t[i]+"/"; 
					
				}
			}
		}
		return parentAddress;
	}
	
	/*
	* Calls helper methods to create 2 children directories named by input
	* in the parent node given by input. This method also catches any errors
	* (i.e invalid name, parent directory DNE, etc.)
	* @Param input, ArrayList of strings that stores the user input
	*/
	public  void execute(ArrayList<String> input) {
		if(input.size() >0) {
			
			//checks that path is valid, and has a temporary node
			//point to parent of desired Node
			int i = 0;
			while(i<input.size()) {
				
				Node tempParent = Finder.returnDir(getParentPath(input.get(i)));
				//AbsPathFinder.getAbsPath(tempParent);

				if(tempParent !=null && tempParent instanceof DirectoryNode &&
						IsValidName.checkValidName(getName(input.get(i))) 
						== false&&Finder.isDuplicateName
						(getName(input.get(i)),getParentPath(input.get(i)))== 1) 
					{
					
					//sets temporary directory to point to parent directory
					DirectoryNode temperoryParent = (DirectoryNode) tempParent; 
					createDir(temperoryParent, getName(input.get(i)), 
							input.get(i));
					
					//repeats same process for second directory
					
				}
				
				//ensures name is valid, and not duplicate
				else if(IsValidName.checkValidName(getName(input.get(i))) == true
						||Finder.isDuplicateName(getName(input.get(i)), 
								getParentPath(input.get(i)))== 0){
					ErrorHandling.errorPrint("mkdir", "invalid naming convention at input " + i+1);
					i = input.size();
;				}
				else {
					ErrorHandling.errorPrint("mkdir", "first path is invalid");
					i = input.size();

				}
				i++;
			}
		}
		else {
			ErrorHandling.errorPrint("mkdir", "invalid input");
		}
	}
}
	

