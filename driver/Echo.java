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

public class Echo extends Command {
	/*
	 * Creates a new file if the name does not already exist
	 * @param String parentPath, stores parent path of the file 
	 * we want to create
	 * @param String name, stores desired name of the file
	 */
	public void outFileNotExist(String parentPath, String name
			, String content) //Creates new file in desired directory
							  // When Outfile doesn't exist in directory
	{
		String abspath = AbsPathFinder.getAbsPath(Finder.
				returnDir(parentPath));
		FileNode file1 = new FileNode(name,abspath +"/" +name);
		file1.content = quoteParse(content);
		file1.setParent(Finder.returnDir(abspath));
		DirectoryNode tempNode = (DirectoryNode)Finder.returnDir(abspath);
		tempNode.setChild(file1);//set children for the parent node
	}
	/*
	 * Gets rid of the quotes around String inputed
	 * @param String input, stores user inputed string with quotes
	 * @Return String that contains the inputed string without quotes
	 */
	public String quoteParse(String input) { // gets ride of quotes in user
											//input
		String content = ""; 
			for(int i =1; i<input.length()-1;i++) {
				content = content + input.charAt(i);
			}
			return content;
		}
	
	/*
	 *Makes sure user enters valid string
	 *Specifically with two quotes at start and end of string
	 *@String input, stores user inputed string with quotes
	 *@return boolean based on weather or not the input was valid
	 */
	public boolean isValidString(String input) {
		if(input.charAt(0) == '"'&& input.charAt(input.length()-1)
				== '"') {
			return true;
		}
		return false;
	}
	/*
	 * Gets path of the parent directory of the user input path
	 * @param String Array, consisting of the user input parameters
	 * @return String, storing the path of the parent directory
	 */
	public String getParentPath(String[] input) {
		String parentAddress = "";
		String[] temp;
		parentAddress = "";
		temp = input;
		if(temp.length == 1) { //case where user input is length 1
			parentAddress = cwd.address;
	}
		
		else {
			//gets parent address
			for( int i =0;i<temp.length;i++) {
				if(i<= temp.length-2) {
					parentAddress = parentAddress + temp[i]+"/"; 
				}
			}
		}
		return parentAddress;
	}
	/*
	 * Runs case where user only inputs one parameter
	 * Runs case where user wants to create new file
	 * Runs case where user wants to overwrite existing file
	 * Runs case where user wants to append existing file
	 * Covers case where user inputs invalid number of parameters
	 * Covers case where file name if invalid
	 * covers case where String input is invalid
	 * @param ArrayList of strings that consists of all user input parameters
	 */
	public void execute(ArrayList<String> input) {
		String name = "";
		//Case where user only input echo String
		if(input.size()== 1 && isValidString(input.get(0)) == true) {
			System.out.println(quoteParse(input.get(0)));
		}
		//Case where user implements all parameters for echo
		else if(input.size()==3 && input.get(2).length()>0 && 
				isValidString(input.get(0)) == true) {
			String[] temp = input.get(2).split("/");
			name = temp[temp.length-1];
			String parentPath = "";
			parentPath = getParentPath(temp);
			//Overwrite version of echo
			if( input.get(1).equals(">")&& 
					IsValidName.checkValidName(name)==false) {		
				 //no duplicate Outfile case, so creates new file
				if(Finder.isDuplicateName(name, parentPath) == 1 ) {
					outFileNotExist(parentPath, name, input.get(0));
					}
				//Overwrites existing file
				else if(Finder.isDuplicateName(name, parentPath) == 0)
				{
					if(Finder.returnDir(input.get(2)) instanceof FileNode)
					{
					FileNode tempNode = (FileNode)
					Finder.returnDir(input.get(2));	
					tempNode.content = quoteParse(input.get(0));
					}
					else {
						ErrorHandling.errorPrint("CD", "invalid path");
					}
				}
			}
		//Append version of echo
		else if(input.get(1).equals(">>")
				&& IsValidName.checkValidName(name) == false) 
			{
				if(Finder.isDuplicateName(name, parentPath) == 1) 
				{ //no duplicate Outfile case, so creates new file
					outFileNotExist(parentPath, name, input.get(0));
				}
				  //Appends to existing file
				else if(Finder.isDuplicateName(name, parentPath) == 0) 
				{
					if(Finder.returnDir(input.get(2)) 
							instanceof FileNode)
					{
					FileNode tempNode = (FileNode)Finder.
							returnDir(input.get(2));	
					tempNode.content = tempNode.content + 
							quoteParse(input.get(0));
					}
					else {
						ErrorHandling.errorPrint("echo", "invalid path");
					}
				}
			}
		}
		//Invalid name case
		else if(IsValidName.checkValidName(name)==true) {
			ErrorHandling.errorPrint("echo", "invalid naming convention");
		}
		else {
			ErrorHandling.errorPrint("echo", "invalid input");
		}
	}
}