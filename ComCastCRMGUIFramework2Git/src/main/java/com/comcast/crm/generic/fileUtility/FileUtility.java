package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws Exception {
		FileInputStream fisp =new FileInputStream(".\\configAppData\\CommonData.property");
		Properties pObj=new Properties();
		pObj.load(fisp);
		String value=pObj.getProperty(key);
		
		return value;
	}
}
