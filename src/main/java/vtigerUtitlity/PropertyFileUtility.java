package vtigerUtitlity;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * this class consist fo generic method related to property file
 * @author ADMIN
 *
 */

public class PropertyFileUtility {
	/**
	 * this methos will read data from property file and return the value
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(Iconstant.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
