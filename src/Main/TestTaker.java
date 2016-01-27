package Main;

import org.json.JSONObject;

import FileInput.File;
import components.Test;
import guis.testWindow;

public class TestTaker {
	public static void main(String[] args){	
		new testWindow(new Test(new JSONObject(File.parseFile("src/JSON/test.json"))));
	}
}
