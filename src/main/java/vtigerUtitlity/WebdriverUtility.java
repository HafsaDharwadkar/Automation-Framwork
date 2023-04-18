package vtigerUtitlity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/**
	 * this method maximizes the browser
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method minimizes the browser
	 * @param driver
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will wait until the page is loaded
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * this method will wait until particular element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method wait until particular element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this mathod will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDwon(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * this method will handle drop down by value
	 * @param element
	 * @param value
	 */
	 public void handleDropDown(WebElement element, String value)
	 {
		 Select s=new Select(element);
		 s.selectByValue(value);
	 }
	 
	 /**
	  * this method will handledropdown by visible text
	  * @param text
	  * @param element
	  */
	 public void handleDropDown(String text, WebElement element)
	 {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	 }
	 /**
	  * this method will hover on particular element
	  * @param driver
	  * @param ele
	  */
	 public void mouseHover(WebDriver driver ,WebElement ele)
		{
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
		}
	 
	 /**
	  * this method will right click on particular element
	  * @param driver
	  * @param ele
	  */
		public void rightClick(WebDriver driver,WebElement ele)
		{
			Actions a=new Actions(driver);
			a.contextClick(ele).perform();
		}
		
		/**
		 * this method will drag and drop a particular element source to destination
		 * @param driver
		 * @param src
		 * @param dest
		 */
		public void drapAnddrop(WebDriver driver,WebElement src ,WebElement dest)
		{
			Actions a=new Actions(driver);
			a.dragAndDrop(src, dest).perform();
		}
		
		/**
		 * this method will double click any where on the webpage
		 * @param driver
		 */
		public void doubleClick(WebDriver driver)
		{
			
		}
		/**this method will double click the particular element
		 * 
		 * @param driver
		 * @param ele
		 */
		public void doubleClick(WebDriver driver,WebElement ele)
		{
			Actions a=new Actions(driver);
			a.doubleClick(ele).perform();
		}
		
		/**
		 * this method will press enter key
		 * @param driver
		 * @param ele
		 * @throws AWTException
		 */
		public void  pressEnter(WebDriver driver,WebElement ele) throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		}
		
		/**
		 * this method will release the enter key
		 * @param driver
		 * @param ele
		 * @throws AWTException
		 */
		public  void releaseEnter(WebDriver driver, WebElement ele) throws AWTException 
		{
			Robot r=new Robot();
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		
		/**
		 * this method will handle the frame by index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver,int index)
		{
		  driver.switchTo().frame(index);
		}
		
		/**
		 * this method will handle the frame by name or id
		 * @param driver
		 * @param nameOrId
		 */
		public void handleFrame(WebDriver driver,String nameOrId)
		{
		  driver.switchTo().frame(nameOrId);
		}
		
		/**
		 * this method will handle the frame by element
		 * @param driver
		 * @param ele
		 */
		public void handleFrame(WebDriver driver,WebElement ele)
		{
		  driver.switchTo().frame(ele);
		}
		
		/**
		 * this method will switch to parent frame
		 * @param driver
		 */
		public void handleParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 *this method will switch to defualt frame
		 * @param driver
		 */
		public void handleDefaultFrame(WebDriver driver)
		{
		  driver.switchTo().defaultContent(); 
		}
		
		/**
		 * this method will accept the alert popup
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
		  driver.switchTo().alert().accept();
		}
		
		/**
		 * this method will dismiss alert popup
		 * @param driver
		 */
		public void dimissAlert(WebDriver driver)
		{
		  driver.switchTo().alert().dismiss();                             
		}
		
	  /**
	   * this method will scroll randomly downwords
	   * @param driver
	   */
	  public void scrollBy(WebDriver driver )
	  {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)", "");
	  }
	  
	  /**
	   * this method will scroll until particular element
	   * @param driver
	   * @param ele
	   */
	  public void scrollBy(WebDriver driver,WebElement ele)
	  {
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  Point loc = ele.getLocation();
		  int x = loc.x;
		  int y = loc.y;
		  js.executeScript("window.scrollBy("+x+","+y+")", ele);
	  }
	  
	  /**
	   * this method will switch the window based on partial window title
	   * @param driver
	   * @param PartialWinTitle
	   */
	  public void switchToWindow(WebDriver driver, String PartialWinTitle)
	  {
		  //step 1:capture all window IDs
		  Set<String> winid = driver.getWindowHandles();
		  //step 2:use for each loop switching to each window
		  for(String win:winid)
		  {
			  //step 3: switch th window and get the title of window
			  String currentwinTitle=driver.switchTo().window(win).getTitle();
			  
			  //step 4:compare the current window title with partial window title
			  if(currentwinTitle.contains(PartialWinTitle))
			  {
				  break;
			  }
		  }
	  }
	  
	  public String takeScreenshot(WebDriver driver,String screenshotName) throws IOException
	  {
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File src=ts.getScreenshotAs(OutputType.FILE);
		  File dst=new File(".\\Screenshots\\"+screenshotName+".png");
		  FileUtils.copyFile(src, dst);
		  return dst.getAbsolutePath();
		  
	  }
}
