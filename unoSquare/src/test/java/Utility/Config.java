package Utility;

import java.util.HashMap;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Config {

	public static String baseWindowsURL = "https://www.microsoft.com/en-us/";
	public static String baseAmazonURL = "https://www.amazon.com/";
	
	public static String generalPassword = "$#123Contra";

	public static HashMap<String, String> getData() {
		String jsonData = "http://dummy.restapiexample.com/api/v1/employee/1";
		HashMap<String, String> data = new HashMap<String, String>();

		try {
			JsonNode body = Unirest.get(jsonData).asJson().getBody();
			JSONObject jsonObject = body.getObject().getJSONObject("data");
			data.put("id", String.valueOf(jsonObject.getInt("id")));
			data.put("employee_name", jsonObject.getString("employee_name"));
			data.put("employee_salary", String.valueOf(jsonObject.getDouble("employee_salary")));
			data.put("employee_age", String.valueOf(jsonObject.getInt("employee_age")));
			data.put("profile_image", jsonObject.getString("profile_image"));
		} catch (UnirestException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		return data;
	}
}