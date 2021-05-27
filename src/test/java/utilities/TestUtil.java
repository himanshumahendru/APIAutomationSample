package utilities;

import org.json.JSONObject;

import listeners.ExtentListeners;

public class TestUtil {
	
	
	public static boolean jsonHasKey(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the presence of a Key " + key);
		
		return jsonObject.has(key);
		
	}

	
	public static String jsonKeyValue(String json, String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the value for the passed key - " + key);
		return jsonObject.get(key).toString();
	}
}
