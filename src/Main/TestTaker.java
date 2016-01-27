package Main;

import org.json.JSONObject;

import FileInput.ParseFile;
import components.Test;
import guis.testWindow;

public class TestTaker {
	public static void main(String[] args){	
		new testWindow(new Test(new JSONObject(ParseFile.parseFile("src/JSON/test.json"))));
	}
}
