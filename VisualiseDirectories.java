import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

class VisualiseDirectories{
	public static void main(String[] args){
		JFrame window = new JFrame("FileMap");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Find the number of Folders here and use them to set the rows and columns
		String str = System.getProperty("user.dir");
		FileStruct fs = new FileStruct();
		ArrayList<FileTree> dirs = fs.getFilePath(str);

		/////////////////////////////////////////////////////////
		//Put all this into a function to make the code cleaner
		int minLvl = dirs.get(dirs.size()-1).getLevel();
		int maxLvl = 0;
		Hashtable<Integer, Integer> levelCounters = new Hashtable<Integer, Integer>();
		for (int i=0; i<dirs.size(); i++){
			int lvl = dirs.get(i).getLevel();
			if (lvl > maxLvl){
				maxLvl = lvl;
			}
			Integer n = levelCounters.get(lvl);
			if (n != null){
				levelCounters.put(lvl, n+1);
			} else{
				levelCounters.put(lvl, 1);
			}
		}
		int maxWidth=0;
		for (Integer key: levelCounters.keySet()){
			if (levelCounters.get(key)>maxWidth){
				maxWidth = levelCounters.get(key);
			}
		}
		//////////////////////////////////////////////////

		/////////////////////////////////////////////////
		//Sets the frames up
		int rows = maxLvl-minLvl+1;
		int j = maxWidth;
		JPanel[][] panelHolder = new JPanel[rows][j];
		window.setLayout(new GridLayout(rows,j));
		
		for(int m = 0; m < rows; m++) {
		   for(int n = 0; n < j; n++) {
		      panelHolder[m][n] = new JPanel();
		      window.add(panelHolder[m][n]);
		   }
		}


		int currentPos[] = new int[levelCounters.size()];

		for (int i=0; i<dirs.size(); i++){
			int lvl = dirs.get(i).getLevel();

			int inc = maxWidth/(levelCounters.get(lvl));
			int inc2 = (maxWidth%levelCounters.get(lvl)) / 2;
			//System.out.println((double)maxWidth/levelCounters.get(lvl));

			lvl -= minLvl;
			int pos = currentPos[lvl];
			String parent = dirs.get(i).getParent();
	                String[] parentRoot = parent.split("/");
			panelHolder[lvl][pos].add(new JLabel(parentRoot[parentRoot.length-1]));
			currentPos[lvl]+=1;
		}


		//Center the values
		//Make the font bigger
		//Draw lines/arrows between each folder
		//Set the background to white
		//Add in a save as image option



		//TODO
		// Find a way to organise each level to match up the the children near it (or would this already be organised based on the recursive nature of the algorithm)?

		window.pack();
		window.setVisible(true);
	}
}
