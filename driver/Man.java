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
import java.util.HashMap;

/*
 * Contains the descriptions of each command
 * as well as a method that prints them prompted
 */
public class Man extends Command{
  
  private HashMap<String, String> directory = new HashMap<String, String>();
  private ArrayList<String> commandList = new ArrayList<String>();
  
  private String exitMan = "exit\n\nQuit the program";
  private String mkdirMan = "mkdir DIR1 DIR2\n\nThis command takes in two "
      + "arguments only. Create directories, each of which\r\n"
      + "may be relative to the current directory or may be a full path. "
      + "If creating DIR1\r\n"
      + "results in any kind of error, do not proceed with creating DIR 2. "
      + "However, if\r\n"
      + "DIR1 was created successfully, and DIR2 creation results in an error, "
      + "then give\r\n"
      + "back an error speci:ic to DIR2.";
  private String cdMan = "cd DIR\n\nChange directory to DIR, which may be "
      + "relative to the current directory or\r\n"
      + "may be a full path. As with Unix, .. means a parent directory and "
      + "a . means\r\n"
      + "the current directory. The directory must be /, the forward slash. "
      + "The foot of\r\n"
      + "the file system is a single slash: /.";
  private String lsMan = "ls [-R] [PATH . . . ]\n\nif {R is present, recursively"
      + " list all subdirectories.\r\n"
      + "If no paths are given, print the contents (file or directory) "
      + "of the current directory, with a new line following\r\n"
      + "each of the content (file or directory).\r\n"
      + "Otherwise, for each path p, the order listed:\r\n"
      + "If p speci\fes a file, print p\r\n"
      + "If p speci\fes a directory, print p, a colon, "
      + "then the contents of that directory, then an extra new line.\r\n"
      + "If p does not exist, print a suitable message.";
  private String pwdMan = "pwd\n\nPrint the current working directory"
      + " (including the whole path).";
  private String pushdMan = "pushd DIR\n\nSaves the "
      + "current working directory by "
      + "pushing onto directory stack and then\r\n"
      + "changes the new current working directory to DIR. The push must be\r\n"
      + "consistent as per the LIFO behavior of a stack. "
      + "The pushd command saves\r\n"
      + "the old current working directory in directory stack "
      + "so that it can be returned\r\n"
      + "to at any time (via the popd command). "
      + "The size of the directory stack is\r\n"
      + "dynamic and dependent on the pushd and the popd commands..";
  private String popdMan = "popd\n\nRemove the top entry from the "
      + "directory stack, and cd into it. The removal\r\n"
      + "must be consistent as per the LIFO behavior of a stack. "
      + "The popd command\r\n"
      + "removes the top most directory from the "
      + "directory stack and makes it the\r\n"
      + "current working directory. If there is no directory onto the stack, "
      + "then give\r\n"
      + "appropriate error message.";
  private String historyMan = "history [number]\n\nThis command will "
      + "print out recent commands, one command per line. i.e.\r\n"
      + "1. cd ..\r\n"
      + "2. mkdir textFolder\r\n"
      + "3. echo “Hello World”\r\n"
      + "4. fsjhdfks\r\n"
      + "5. history\r\n"
      + "The above output from history has two columns. The:first\r\n"
      + " column is numbered such that the line with the highest number "
      + "is the most recent command.\r\n"
      + "The most recent command is history. "
      + "The second column contains the actual\r\n"
      + "command. Note: Your output should also contain as "
      + "output any syntactical errors\r\n"
      + "typed by the user as seen on line 4.\r\n"
      + "We can truncate the output by specifying a number (>=0) after "
      + "the command.\r\n"
      + "For instance, if we want to only see the last 3 commands typed,"
      + " we can type the\r\n"
      + "following on the command line:\r\n"
      + "history 3\r\n"
      + "And the output will be as follows:\r\n"
      + "4. fsjhdfks\r\n"
      + "5. history\r\n"
      + "6. history 3";
  private String catMan = "cat FILE1 [FILE2 …]\n\nDisplay the "
      + "contents of FILE1 "
      + "and other files (i.e. File2 ….) concatenated in\r\n"
      + "the shell. You may want to use three line breaks to"
      + " separate the contents of one file\r\n"
      + "from the other file.";
  private String echoMan = "echo STRING [> OUTFILE]\n\nIf OUTFILE "
      + "is not provided,"
      + " print STRING on the shell. Otherwise, put\r\n"
      + "STRING into :ile OUTFILE. STRING is a "
      + "string of characters surrounded by double\r\n"
      + "quotation marks. This creates a new file "
      + "if OUTFILE does not exists and erases the\r\n"
      + "old contents if OUTFILE already exists. "
      + "In either case, the only thing in OUTFILE\r\n"
      + "should be STRING.\n\n"
      + "echo STRING >> OUTFILE\n\nLike the previous command, but appends "
      + "instead of overwrites.";
  private String manMan = "man CMD\n\nPrint "
  		+ "documentation for CMD";
  private String rmMan = "rm DIR\n\nremoves the DIR from the file system.  "
      + "This also removes all the children of DIR (i.e.  it actsrecursively).";
  private String mvMan = "mv OLDPATH NEWPATH\n\n"
      + "Move item OLDPATH to NEWPATH. Both OLD-\r\n"
      + "PATH and NEWPATH may be relative "
      + "to the current directory or may be full paths. If NEWPATH is a\r\n"
      + "directory, move the item into the directory.";
  private String cpMan = "cp OLDPATH NEWPATH\n\n"
      + "Like mv, but don't remove OLDPATH. If OLDPATH\r\n"
      + "is a directory, recursively copy the contents.";
  private String curlMan = "curl URL\n\n"
      + "Retrieve the file at that URL\r\n"
      + "and add it to the current working directory.";
  private String saveJShellMan = "saveJShell FileName\n\n"
      + "Addition:The above command will interact with your "
      + "real file system on your computer. When the\r\n"
      + "above command is typed, you must ensure that the entire "
      + "state of the program is written to the file FileName.\r\n"
      + "The file FileName is some file that is stored on the "
      + "actual filesystem of your computer. The purpose of this\r\n"
      + "command is to save the session of the JShell before the "
      + "user closes it down. You must ensure that the entire\r\n"
      + "mock filesystem including any state of any of the commands "
      + "is written to FileName so that the next time the\r\n"
      + "JShell is started, the user can type in the command "
      + "loadJShell FileName to reinitialize the last saved\r\n"
      + "session and begin from where they left o. For instance, "
      + "if the user types in the command saveJShell\r\n"
      + "/Users/User1/Desktop/save.txt, then you will create a "
      + "file save.txt on your computer that will\r\n"
      + "save the session of the JShell. If the above file exists "
      + "on your computer, then you must overwrite the file\r\ncompletely.";
  private String loadJShellMan = "loadJShell FileName\n\n"
      + "load the contents of the FileName\r\nand reinitialize everything "
      + "that was saved previously into the file FileName. This allows for"
      + "the user to restore a previous JShell session.";
  private String searchMan = "search path ... -type [f|d] -name expression\n\n"
      + "Search the given path(s) for a file or directory (determined by"
      + "input)\r\n with the exact name given by 'expression'."
      + " The paths may be relative or full paths.";
  private String treeMan = "tree\n\n"
      + "Display the entire file system as a tree, starting from the root.";

  /*
  * Initalizes hashmap that maps command to their descriptions
  */
  private void initializeDirectory() {
    directory.put("exit", exitMan);
    directory.put("mkdir", mkdirMan);
    directory.put("cd", cdMan);
    directory.put("ls", lsMan);
    directory.put("pwd", pwdMan);
    directory.put("pushd", pushdMan);
    directory.put("popd", popdMan);
    directory.put("history", historyMan);
    directory.put("cat", catMan);
    directory.put("echo", echoMan);
    directory.put("man", manMan);
    directory.put("rm", rmMan);
    directory.put("mv", mvMan);
    directory.put("cp", cpMan);
    directory.put("curl", curlMan);
    directory.put("saveJShell", saveJShellMan);
    directory.put("loadJShell", loadJShellMan);
    directory.put("search", searchMan);
    directory.put("tree", treeMan);
  }
  
  /*
  * Initliazes list that stores all valid commands
  */
  private void initializeCommandList() {
    commandList.add("exit");
    commandList.add("mkdir");
    commandList.add("cd");
    commandList.add("ls");
    commandList.add("pwd");
    commandList.add("pushd");
    commandList.add("popd");
    commandList.add("history");
    commandList.add("cat");
    commandList.add("echo");
    commandList.add("man");

    commandList.add("rm");
    commandList.add("mv");
    commandList.add("cp");
    commandList.add("curl");
    commandList.add("saveJShell");
    commandList.add("loadJShell");
    commandList.add("tree");
    commandList.add("search");
  }
  
  /*
  * Prints the descriptions of the corresponding commands
  * Gives appropriate error when an invalid command is passed as a parameter.
  * @Param inputList, ArrayList
  */
  public void execute(ArrayList<String> inputList) {
    initializeDirectory();
    initializeCommandList();
      if(inputList.size()==1) {
        if(commandList.contains(inputList.get(0))) {
          System.out.println(directory.get(inputList.get(0)));
        }
        else {
	      ErrorHandling.errorPrint("Man", "invalid command");
        }
      }
      else {
        ErrorHandling.errorPrint("Man", "only 1 parameter was expected.");
      }
  }
  

}

