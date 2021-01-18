package driver;

import java.util.ArrayList;

public class Search extends Command{
	public void search(Node current, String type, String name) {
		if(current.name.equals(name)) {
			System.out.println(current.getAddress());
		}
		for(int i =0; i<current.children.size(); i++) {
			if (current.children.get(i) instanceof DirectoryNode) {
				search(current.children.get(i), type, name);
			}
		}
	}
	
	
	
	public void execute(ArrayList<String> input) {
		int i = input.size();
		Echo temp = new Echo();
		
		//Checks if required arguments are inputed
		if(i > 4) {
			if(!(input.get(i-4).equals("-type"))) {
				System.out.println(input.get(i-4));
				ErrorHandling.errorPrint("search", "invalid arguements1");
			}
			else if(!(input.get(i-3).equals("f") || input.get(i-3).
					equals("d"))) {
				System.out.println(input.get(i-3));
				ErrorHandling.errorPrint("search", "invalid arguements2");
			}
			else if(!(input.get(i-2).equals("-name"))) {
				System.out.println(input.get(i-2));
				ErrorHandling.errorPrint("search", "invalid arguements3");
			}
			else if((!temp.isValidString(input.get(i-1)))){
				System.out.println(input.get(i-1));
				ErrorHandling.errorPrint("search", "invalid arguements4");
			}
			else {
				String name = temp.quoteParse(input.get(i-1));
				for(int j =0;j < input.size()-4;j++) {
					Node target = Finder.returnDir(input.get(j));
					if(target != null) {
						System.out.println("Results in " + input.get(j));
						search(target,input.get(i-3),name);
					}else {
						ErrorHandling.errorPrint("search", input.get(j)
								+ "is an invalid path");
					}
				}
			}
		}else {
			ErrorHandling.errorPrint("search", "missing arguments");
		}
	}
}
