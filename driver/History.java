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

import java.util.*;

public class History extends Command {
	
	private static ArrayList<String> prevInputs = new ArrayList<String>();
	
	/*
	 * A function 
	 * @param input, an array list of strings as our history of commands
	 */
	public void execute(ArrayList<String> input){
	  if(input.size() == 1) {
		//Checks if parameter value is valid
		if(Integer.parseInt(input.get(0)) >= 0){
			try{ 
				int num = Integer.parseInt(input.get(0));
				if (num > prevInputs.size()){ //num too large
					num = prevInputs.size(); //Made assumption
				}
				//Prints items
				for (int i = 1; i <= num ; i++){
					System.out.println((prevInputs.size()-num+i) + 
							". " + prevInputs.get(num-i));
				}
			}catch (NumberFormatException e){ //Case: string param
				ErrorHandling.errorPrint("history", "invalid parameter type"); 
			}
		}else{
			//Case: param has negative value
			ErrorHandling.errorPrint("history", "invalid parameter value"); 
		}
	  }else {
		//Case: 2 or more params
	    ErrorHandling.errorPrint("history", "too many parameters"); 
	  }
	} 
	
	public void execute(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(((Integer)prevInputs.size()).toString());
		execute(temp);
	}

	public static void insert(String input){
        prevInputs.add(0, input);
	}
}
