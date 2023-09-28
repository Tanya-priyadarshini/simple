package com.sales.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of method to fetch common data from property file
 * @author TANYA
 */
public class FileUtility {
	/**
	 * This method is use to fetch the common data present inside the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathconstants.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	

}
