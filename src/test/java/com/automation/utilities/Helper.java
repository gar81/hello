package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper
{
	public static InputStream fis;
	public static Properties prop;

	public static void loadPropertiesData() {	
		try
		{
			fis= new FileInputStream("data.properties");
			prop= new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e)
		{		
			e.printStackTrace();
		} catch (IOException e)
		{		
			e.printStackTrace();
		}	
	}

	public static String getValue(String key) {
		String value="";
		if(prop.containsKey(key)) {
			value= prop.getProperty(key);	
		}
		return value;
	}

}


