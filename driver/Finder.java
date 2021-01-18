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

public class Finder{
	
	/*
	 * 
	 */
	public static Node returnDir(String path){
		String[] path_list = path.split("/");
		//Checks whether we are working with a full path or a relative path
		if (path_list[0].equals(Command.root.address) ){
			return pathTraversal(1, path_list);
		}else{
			return pathTraversal(0, path_list);
		}
		
	}
	
	//Helper function that tries to traverse the path
	//Return node if it reaches the end of path and null o/w.
	private static Node pathTraversal(int mode, String[] path_list){
		Node temp = new Node();
		int i;
		if (mode == 0){
			temp = Command.cwd;
		}else {
			temp = Command.root;
		}
		for (i=mode; i < path_list.length; i++){ 
			//Denoting the progress of the path 
			//(i.e how many slashes we passed)
			if(temp.getChild().contains(path_list[i])){
				
				//Updates the node as we move through the path
				for(int j = 0;j<temp.getChild().size();j++) {
					if(path_list[i].equals(temp.getChild().get(j))){
						temp = temp.children.get(j);
						break;
					}
				}
			}else{
				//Exits the for loop
				i = path_list.length+1;
			}
		}
		//Checks if the end of path has been reached
		if (i == path_list.length){

			return temp;
		}else{

			return null;
		}
	}
	
	public  static int isDuplicateName(String name, String path) {
		
		if(Finder.returnDir(path) instanceof DirectoryNode) { 
			DirectoryNode temp= (DirectoryNode) Finder.returnDir(path);
			
			if(temp.getChild().indexOf(name)!= -1) {
				return 0 ; // duplicate name!
			}
			
			else return 1; // no duplicate
			
		}
		return 2; // path doesn't exist, or it isn't directory
			
		}
}
