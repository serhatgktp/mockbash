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

/*
* Runs main shell as well as initialize hashmap helps run shell
*/
public class JShell {

  public static void main(String[] args) {
	
	//Calls necessary classes
	UserInputHandling ui = new UserInputHandling();
	Menu call = new Menu();
	
	//Creates hashmap for classes
    HashMap<String, String> commandHashMap = new HashMap<String, String>();
	initializeHashMap(commandHashMap);
	
	//Creates scanner object
	Scanner sc = new Scanner(System.in);
	
	//Gets user input continuously
	while (true){
		System.out.print(Command.cwd.address + ">");
		String userInput = sc.nextLine();
		//Passes user inputs to helper classes and history to run commands
		History.insert(userInput);
		ArrayList<String> inputList = ui.interpret(userInput);
		call.nav(inputList, commandHashMap);
	}
  }
  /*
  C:>mkdir a b
  C:>ls
  a
  b
  C:>cd a
  C:/a>mkdir j
  C:/a>cd j
  C:/a/j>mkdir g p o
  C:/a/j>echo "hi" > 1
  C:/a/j>echo "bye" > 2
  C:/a/j>ls
  g
  p
  o
  1
  2
  C:/a/j>C:/a/j C:
  Error in Menu. Reason: invalid command. 
  C:/a/j>cp C:/a C:
  Error in cp. Reason: invalid path. 
  C:/a/j>cd ..
  C:/a>cd ..
  C:>cp C:/a/j C:
  
  /*
  *Hash map initialization that maps all valid commands to class
  *@Param hashmap, hashmap that maps strings(command) to strings(class)
  */
  private static void initializeHashMap(HashMap<String, String> hashmap){
	hashmap.put("mkdir", "driver.Mkdir");
	hashmap.put("ls", "driver.Ls");
	hashmap.put("cd", "driver.CD");
	hashmap.put("pwd", "driver.Pwd");
	hashmap.put("history", "driver.History");
	hashmap.put("pushd", "driver.Pushd");
	hashmap.put("popd", "driver.Popd");
	hashmap.put("cat", "driver.Cat");
	hashmap.put("exit", "driver.Exit");
	hashmap.put("man", "driver.Man");
	hashmap.put("echo", "driver.Echo");
	hashmap.put("rmdir", "driver.RmDir");
	hashmap.put("cp", "driver.Cp");
	hashmap.put("mv", "driver.Move");
	hashmap.put("curl", "driver.Curl");
	hashmap.put("tree", "driver.Tree");
	hashmap.put("search", "Search.Tree");
	hashmap.put("saveJShell","drive.SaveJShell" );
	hashmap.put("loadJShell","drive.LoadJShell" );
	

	
	
  }
}
