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

public class Cat extends Command {
  private String combined = ""; // stores the contents of the files
  private String invalid = ""; //for telling user which path
  							   // entered was invalid
  
  /*
   * Takes in an ArrayList of Strings which are expected to be paths to files.
   * Paths may be relative or full paths. Concatenates the content of each file
   * into one String, with three blank spaces between the content of each file.
   * 
   * Checks each String in the ArrayList to see if they lead to a valid file.
   * If an element does not point to a valid file, it will stop concatenating
   * and will prepare a "not a valid file" message that will be used in 
   * method execute().
   * 
   * @param files, an ArrayList of Strings
   */
  public void concatenate(ArrayList<String> files) {

    for(int i=0; i<files.size(); i++) {
      Node temp = Finder.returnDir(files.get(i));//check if path exists
      if(temp instanceof FileNode) {             //check if the input is a file
        FileNode temp2 = (FileNode) temp;        //cast Node to FileNode
        if(i!=files.size()-1) {
          combined = combined + temp2.content + "\n\n\n";  //Add 3 blank lines
       }
        else if(i ==files.size()-1) {            //Check if i is the last index
        	combined = combined + temp2.content;
        }
      }
      else{
        invalid= files.get(i) + " is not a valid file."; //Input is not a file
        break;
      }
    }
  }
  
  
  /*
   * Takes in an ArrayList of Strings.
   * 1) Check if the ArrayList is empty. If empty, print an error message. If
   *    not, proceed with the following steps.
   * 2) Concatenates the Strings inside of the ArrayList into a single String.
   * 3) Prints the concatenated String.
   * 4) Checks if there were any invalid paths/files inside the given ArrayList.
   * 4.1) If there were any invalid elements, print a message explaining which
   *      element was invalid.
   * @param files, ArrayList of Strings
   */
  public void execute(ArrayList<String> files) {
    if(files.size()>0) {
      concatenate(files);
      System.out.println(combined);
      if(invalid.isEmpty() == false) {          //Check for invalid parameters
        System.out.println(invalid);
      }
    }
    else {                                       //Check for invalid input
      driver.ErrorHandling.errorPrint("cat", "invalid number of parameters");
    }
  }
}
