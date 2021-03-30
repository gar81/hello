package com.automation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

public class Helper
{
	public static InputStream fis;
	public static Properties prop;
	static Map<Object, Object> m1;
	
	@BeforeSuite
	public static void setDatainMap() {

		m1 = new HashMap<Object, Object>();
		try
		{
			fis= new FileInputStream("data.properties");

			prop= new Properties();
			prop.load(fis);
			for(Object k : prop.keySet()) {
				m1.put(k, prop.get(k));
			}
			//			if(prop.containsKey(key)) {
			//				value= prop.getProperty(key);	
			//				System.out.println(value);
			//				
			//			}


		} catch (FileNotFoundException e)
		{		
			e.printStackTrace();
		} catch (IOException e)
		{		
			e.printStackTrace();
		}
		
	}
	
	public static Object getValue(String key) {
		if(m1.containsKey(key))
		{
			return m1.get(key);
		}
		return null;
	}

}


