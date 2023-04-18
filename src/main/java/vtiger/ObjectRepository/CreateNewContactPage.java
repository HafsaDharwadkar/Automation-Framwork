package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerUtitlity.WebdriverUtility;

public class CreateNewContactPage extends WebdriverUtility {//rule 1:create seperate pom class for every webpage
	//rule 2:identify all webelement by using annotation
	@FindBy(name = "lastname")
	private WebElement lastNameEDT;
	
	@FindBy (xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgnameLookupimg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;

	@FindBy(name="search_text")
	private WebElement searchEDT;
	
	@FindBy (name="search")
	private WebElement searchBTN;
	//rule 3;create getter methods to access webelement
	public WebElement getLastNameEDT() {
		return lastNameEDT;
	}

	public WebElement getOrgnameLookupimg() {
		return orgnameLookupimg;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	//rule 4:intialize webelement using constructor
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//buisness logic
	/**
	 * this method will create will contact using mandatory feild
	 * @param LASTNAME
	 */
   public void CreateNewContact(String LASTNAME)
   {
	   lastNameEDT.sendKeys(LASTNAME);
	   saveBTN.click();
   }
	
   /**
    * this method will create contact with organization
    * @param driver
    * @param LASTNAME
    * @param ORGNAME
    */
	public void CreateNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		lastNameEDT.sendKeys(LASTNAME);
		orgnameLookupimg.click();
		switchToWindow(driver,"Accounts");
		searchEDT.sendKeys(ORGNAME);
		searchBTN.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBTN.click();
		
	}
	
}
