package driver;

import java.util.ArrayList;

public class RmDir extends Command {//Cases: user wants to remove root, shouldn't allow
	//User chooses to remove current working directory
	// Path is invalid 
	public void removeDir(Node target) {
		Node parent = target.parent;
		
			parent.children.remove(target);
			
			//Didn't check if it was a file or a directory
			//Since file has zero children by design
			if(target.children != null) {
				for(int i = 0; i<target.children.size(); i++) {
					removeDir(target.children.get(i));
				}
			}
		}
	
	public void execute(ArrayList<String> input) {
		if(input.size() == 1) {
			Node target = Finder.returnDir(input.get(0));
			
			//Errors may happen
			//Checking if the target is the root node
			if(target instanceof DirectoryNode) {
				if(target != Command.cwd &&
						target != Command.root){
					removeDir(target);
				}else {
					ErrorHandling.errorPrint("rmdir", "invalid input");
					//System.out.println("Cannot delete current/root directory.");
				}
			}else if(target == null){
				ErrorHandling.errorPrint("rmdir", "invalid input");
			}else {
				ErrorHandling.errorPrint("rmdir", "invalid type");
				//System.out.println("Cannot remove a file as it is not a directory.");
			}
		}
		else {
			ErrorHandling.errorPrint("rmdir", "too many parameters");
		}
	} 
}
