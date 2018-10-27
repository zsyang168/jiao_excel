package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class tools {

	@SuppressWarnings("resource")
	public static void copy_file(String source, String dest)
	{
		File file = new File(dest);  
		File fileParent = file.getParentFile();  
		if(!fileParent.exists()){  
		    fileParent.mkdirs();  
		}  
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FileChannel input = null;
		FileChannel output = null;
 
		try {
			input = new FileInputStream(source).getChannel();
			output = new FileOutputStream(dest).getChannel();
			output.transferFrom(input, 0, input.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
