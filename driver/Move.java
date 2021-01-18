package driver;

import java.util.ArrayList;

public class Move extends Command {
	
	
	private Cp test_copy = new Cp();
	private RmDir remove = new RmDir();
	
	
	public Move() {
		
	}
	
	/*
	 * 
	 */
	public void execute(ArrayList<String> paths) {
	
	
	if (paths.size() == 2) {
		
		Node old_node, new_node;
		old_node = Finder.returnDir(paths.get(0));
		new_node = Finder.returnDir(paths.get(1));
		System.out.println("BOB IM WITH YOU1");	
		if (old_node != null && new_node != null) {
			System.out.println("BOB IM WITH YOU2");
			if(Finder.isDuplicateName(old_node.name, paths.get(1)) == 1) {
				System.out.println("BOB IM WITH YOU3");
				if(old_node instanceof DirectoryNode && new_node instanceof DirectoryNode) {
					System.out.println("BOB IM WITH YOU4");
				
					if (old_node != Command.cwd && old_node != Command.root) {
						test_copy.copy(old_node, (DirectoryNode) new_node);
						remove.removeDir(old_node);
						System.out.println("BOB IM WITH YOU foreva");
						
					} else {
						ErrorHandling.errorPrint("mv", "Cannot move root and current directories");
					}
				} else {
					ErrorHandling.errorPrint("mv", "Must enter directories");
				}
			} else {
				ErrorHandling.errorPrint("mv", "Duplicate directory");
			}
		} else {
			ErrorHandling.errorPrint("mv", "Directories not found"); 
		}
				
	} else {
		ErrorHandling.errorPrint("mv", "Invalid number of arguments");
		}
	}
	
}
