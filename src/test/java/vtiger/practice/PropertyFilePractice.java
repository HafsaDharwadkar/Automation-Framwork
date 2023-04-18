package vtiger.practice;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws Exception {
		
		//step 1:Load the property file into java readable format using file input stream
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create an object of properties from java.util
				Properties p=new Properties();
				
		//step 3:load the the file input stream into property file
				p.load(fis);
				
		//step 4:using the keys read the value
				String Browser=p.getProperty("browser");
				System.out.println(Browser);

	}

}
