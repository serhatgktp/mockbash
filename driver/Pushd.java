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

public class Pushd extends CD {
	/*
	 * adds current working directory path 
	 * to top of directory stack following LIFO.
	 * Changes directories to user input path
	 * @param Array list of strings that includes
	 * user input
	 */
    public void push(ArrayList<String> input)
    {
      if(Finder.returnDir(input.get(0)) instanceof DirectoryNode) {
        Command.stack.add(Command.cwd.address);//Stack current working directory
        super.execute(input);                  //CD to the input path
      }
    }
    /*
     * Checks to make sure user input is valid
     * calls the push method
     */
    public void execute(ArrayList<String> input) {
      if(input.size() == 1) {
          push(input);
      }
      else {
        driver.ErrorHandling.errorPrint("pushd", " only one parameter is"
            + "expected");
      }
      
  }
}
