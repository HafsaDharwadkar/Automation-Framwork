package vtiger.practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {

	public static void main(String[] args) {
		//step 1:launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//step2:Login to application with valid credentials
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//step 3:Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4:Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		//step 5: Create Organization with Mandatory fields
		Random r=new Random();
		int ran = r.nextInt(10000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("sense"+ran);
		
		
		//step 6:Select "Chemicals" in the industry drop down
		WebElement drop = driver.findElement(By.name("industry"));
		Select s=new Select(drop);
		s.selectByValue("Chemicals");
		//step 7:Save 
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		//step 8:Verify
		String header = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(header.contains("sense"+ran))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		//step 9:logout of Application
		WebElement ele2 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		//step 10:close the browser
		driver.close();
		

	}

}
