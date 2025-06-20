package com.b2b.stuman.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream  fis = new FileInputStream("./src/main/resources/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		fis.close();
		return p.getProperty(key);
		
	}
}
