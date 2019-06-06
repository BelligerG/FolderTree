import java.util.*;

/**
 * Creates a way to store the folders in a convenent way.
 */
class FileTree {
	FileTree() {}

	private String parent;
	private ArrayList<String> children;
	private int level = 0;

	public void setParent(String parent_in){ 
		parent = parent_in; 
		setLevel();
	}
	public String getParent(){ return parent; }

	public void setChildren(ArrayList<String> children_in){ children = children_in; }
	public ArrayList<String> getChildren(){ return children; }

	public void setLevel(){
		for (int i=0; i<parent.length(); i++){
			if (parent.charAt(i) == '/'){
				level++;
			}
		}
	}
	public int getLevel(){ return level; }


	/*public static void main(String[] args){
		String parent = "AC/ABC/HHAH/";
		FileTree ft = new FileTree();
		ft.setParent(parent);

		System.out.println(ft.getLevel());

	}*/

}
