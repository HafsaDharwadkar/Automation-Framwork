package vtigerUtitlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	
	//step1 :create object for required utility class
	public JavaUtility jUtile=new JavaUtility();
	public WebdriverUtility wUtile=new WebdriverUtility();
	public ExcelFileUtility eUtile=new ExcelFileUtility();
	public PropertyFileUtility pUtile=new PropertyFileUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("---Database connection---");
	}
	@BeforeTest
	//@BeforeClass(alwaysRun = true)
	public void bcConfig() throws Exception
	{
		Thread.sleep(3000);
		String BROWSER = pUtile.readDataFromPropertyFile("browser");
		String URL = pUtile.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("check browser name in property file");
		}
		
		wUtile.maximize(driver);
		wUtile.waitForPageLoad(driver);
		driver.get(URL);
		sdriver=driver;
	}

    @BeforeMethod(alwaysRun = true)
    public void bmConfig() throws Exception
    {	Thread.sleep(3000);
    	String USERNAME = pUtile.readDataFromPropertyFile("username");
    	String PASSWORD = pUtile.readDataFromPropertyFile("password");
    	LoginPage lp=new LoginPage(driver);
    	lp.login(USERNAME, PASSWORD);
    }


    @AfterMethod(alwaysRun = true)
    public void amConfig() throws Exception
    {	Thread.sleep(3000);
    	HomePage hp=new HomePage(driver);
    	hp.logOutOfApp(driver);
    }
    @AfterTest
   // @AfterClass(alwaysRun = true)
    public void acConfig()
    {
    	driver.close();
    }

	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("---Database close----");
	}


}