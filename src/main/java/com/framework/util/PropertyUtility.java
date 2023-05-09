package com.framework.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	public String fetchProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/property.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}

}
