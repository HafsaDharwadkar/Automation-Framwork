package vtiger.practice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {

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
			//step 3:Navigate to Contacts link
				driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
			//step 4:Click on Create contact look up image
				driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
			//step 5:Create contact with manadatory fields
				Random r=new Random();
				int value = r.nextInt(10000);
				driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("bye"+value);
			//step 6:Select the Organization from organization look up image
				String parent = driver.getWindowHandle();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']"));
				Set<String> child = driver.getWindowHandles();
				for(String b:child)
				{
					driver.switchTo().window(b);
				}
				driver.findElement(By.xpath("//a[@id='1']")).click();
			//step 7:Save 
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
				//step 7:verify
				String verify = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				if(verify.contains("bye"+value))
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
