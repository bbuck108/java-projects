package FileOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class CreateFile {
	public static void createFile(JSONObject p_1) throws IOException{
		File file = new File("text.json");
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file);
	}
}
