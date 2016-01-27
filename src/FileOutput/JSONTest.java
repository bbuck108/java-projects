package FileOutput;

import org.json.JSONObject;

import components.Test;

public class JSONTest {
	public static JSONObject createJSONObject(Test p_1){
		JSONObject json = new JSONObject();
		json.put("name", p_1.getName());
		
		return json;
	}
}
