package vtiger.practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {

	public static void main(String[] args) {
		//step 1:Launch Browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//step 2:Login to application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		//step 3:Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4:Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		//step 5:Create Organization with Mandatoryfields
		Random r=new Random();
		int ran=r.nextInt();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("sad"+ran);
		
		
		//step 6:Select "Energy" in the industry drop down
		WebElement ele2 = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
		Select s=new Select(ele2);
		s.selectByValue("Energy");
		
		//step 7:Select "Customer" in the Type Drop down 
		WebElement ele3 = driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
		Select s2=new Select(ele3);
		s2.selectByValue("Customer");
		//step 8:Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step 9:Verify
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("sad"+ran))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		
		}
		
		//step 10:logout of Application
		WebElement ele4 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(ele4).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		//step 11:close the browser
		driver.close();


	}

}
