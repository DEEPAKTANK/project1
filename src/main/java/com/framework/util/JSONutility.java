package com.framework.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONutility {
	public String fetchJSON(String pathKey, String key) {
		PropertyUtility du = new PropertyUtility();
		String path = null;
		try {
			path = du.fetchProperty(pathKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		FileReader read = null;
		try {
			read = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Object obj = null;
		try {
			obj = parser.parse(read);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject jobj = (JSONObject) obj;
		return (String) jobj.get(key);
	}
	public String[] fetchArrayJSON(String pathKey, String key) throws IOException, ParseException {
		PropertyUtility du = new PropertyUtility();
		String path = du.fetchProperty(pathKey);
		JSONParser parser = new JSONParser();
		FileReader read = new FileReader(path);
		Object obj = parser.parse(read);
		JSONObject jobj = (JSONObject) obj;
		JSONArray login = (JSONArray) jobj.get(key);
		String value[] = new String[login.size()];
		for (int i = 0; i < login.size(); i++) {
			JSONObject ob = (JSONObject) login.get(i);
			String username = (String) ob.get("username");
			String password = (String) ob.get("password");
			value[i] = username + "," + password;
		}
		return value;
	}

}
