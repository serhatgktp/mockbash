package driver;

import java.util.ArrayList;

public class Cp extends Command {
	
	public void copy(Node target, DirectoryNode targetLoc) {
		String path = targetLoc.getAddress(); 
		if(target instanceof DirectoryNode) {
			Mkdir dir = new Mkdir();
			dir.createDir(targetLoc, target.getName(), path + "/" + target.getName());
			for(int i =0; i< target.children.size();i++){
						copy(target.children.get(i), 
								(DirectoryNode)Finder.returnDir(path + "/" + target.getName()));
						
						

					}
		}
		else if(target instanceof FileNode){
			Echo file = new Echo();
			file.outFileNotExist(path, target.getName(), '"'+((FileNode) target).content + '"');
		}
		/*for(int i =0; i< target.children.size();i++){
	//		System.out.println(Finder.returnDir(path + "/" + target.getName()).address);
			System.out.println(Finder.returnDir(path + "/" + target.getName()).address+ "/"+target.children.get(i).name);
			System.out.println(target.children.get(i).address);
			copy(target.children.get(i), 
					(DirectoryNode)Finder.returnDir(path + "/" + target.getName()+  "/"+target.children.get(i).name));
			


		}
		*/
		
		
	}
	public boolean validForCp(Node target, Node targetLoc){
		
		if(target != null && targetLoc !=null  && 
				targetLoc instanceof DirectoryNode  && 
				Finder.isDuplicateName(target.name, targetLoc.address)==1
				&& target.equals(root) == false) {
			

			return true;
		}
		return false; 
	}
	public void execute(ArrayList<String> input) {
		if(input.size()==2) {
			Node target = Finder.returnDir(input.get(0));
			Node targetLoc = Finder.returnDir(input.get(1));
			if(validForCp(target,targetLoc) == true){
				
				if(target instanceof DirectoryNode) {
					copy(target, (DirectoryNode)targetLoc);
				}
				else if(target instanceof FileNode){
					copy(target, (DirectoryNode)targetLoc );
				}
					
				}
			else {
				ErrorHandling.errorPrint("cp", "invalid path" );
			}
		}
		else 
		{
			ErrorHandling.errorPrint("cp", "invalid input size");
		}
	}

}
	

