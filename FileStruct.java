import java.io.File;
import java.util.*;

/**
 * Uses a recursive function to find all the terminal folders 
 * and returns them in an arrayList of Strings.
 */

class FileStruct {
	FileStruct() {}

	public static void main(String[] args){ 
		String str = System.getProperty("user.dir");
		ArrayList<FileTree> dirs = new ArrayList<FileTree>();
		dirs = getFilePath(str);
		//Set<String> set = new HashSet<String>(dirs);

		//System.out.println(set);
		System.out.println(dirs.size());
		for (int i=0; i<dirs.size(); i++){
			System.out.println(dirs.get(i).getChildren());
		}
	}
	
	public static ArrayList<FileTree> getFilePath(String dir){
		File path = new File(dir);
		File[] files = path.listFiles();
		FileTree ft = new FileTree();

		ft.setParent(dir);

		ArrayList<String> children = new ArrayList<String>();
		ArrayList<FileTree> trees = new ArrayList<FileTree>();

		for (File file : files){
			if (file.isDirectory()){

				children.add(file.toString());
				trees.addAll(getFilePath(file.toString()));
			}
		}

		ft.setChildren(children);
		trees.add(ft);
		return trees;
	}
}
