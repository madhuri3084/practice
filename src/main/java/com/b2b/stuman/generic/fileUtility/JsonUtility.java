package com.b2b.stuman.generic.fileUtility;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJson(String key) throws Exception
	{
		File file = new File("./src/main/resources/commondata.json");
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader(file));
		JSONObject map = (JSONObject) object;
		return (String)map.get(key);
	}
}
