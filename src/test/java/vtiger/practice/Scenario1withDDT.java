package vtiger.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1withDDT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			//step 1: Read all the necessary data 
			/*read the data from property file */
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties p=new Properties();
			p.load(fis);
			String browser = p.getProperty("browser");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			String url = p.getProperty("url");
	/*read the data from excel sheet*/
			
			Random ran=new Random();
			int num = ran.nextInt(1000);
			FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fes);
			String value = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue()+num;
			  //step 1:Launch Browser
			WebDriver driver=null;
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();

				
			}
			else
			{
				System.out.println("invalid browser name");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
			//step 2:Login to application
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			//step 3:Click on contact link
			driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
			//step 4:click on create contact icon
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			//step 5: Create Contact with Mandatory fields
			
			driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(value);
			//step 6:save
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			//step 7:verify
			String verify = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			if(verify.contains(value))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
			//step 8:logout
			Actions a=new Actions(driver);
			WebElement icon = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			a.moveToElement(icon).perform();
			driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
			
			//step 9:close the browser 
			driver.close();
	
	
	
	}
	

}
