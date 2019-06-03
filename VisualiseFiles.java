import java.util.*;
import javax.swing.*;

class VisualiseFiles{
	public static void main(String[] args){
		ArrayList<String> dirs = new ArrayList<String>();

		String str = System.getProperty("user.dir");

		FileStruct filestruct = new FileStruct();
		dirs = filestruct.getFilePath(str);

		//System.out.println(dirs); 

		JFrame frame = new JFrame();
		//Set this dynamically?
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
