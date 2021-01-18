package driver;

public class Tree extends Command{
	public String spaces(int depth){
		String temp ="";
		for(int i =0;i<depth;i++) {
			temp = temp + " ";
		}
		return temp;
	}
	
	public void systemTraversal(Node current, int depth) {
		System.out.println(spaces(depth)+ current.getName());
		if(current instanceof DirectoryNode) {
			for(int i = 0; i<((DirectoryNode)current).children.size();i++) {
				systemTraversal(((DirectoryNode)current).children.get(i),depth+1);
			}
		}
	}
	public void execute() {
		systemTraversal(Command.root,0);
	}
}
