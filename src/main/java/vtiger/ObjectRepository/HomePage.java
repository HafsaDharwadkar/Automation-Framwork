package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerUtitlity.WebdriverUtility;

public class HomePage extends WebdriverUtility {//Rule1: create separate pom class for  every page
	//Rule 2:identify all elements by using annotation
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminhover;
	
	@FindBy(xpath = "//a[text()=\"Sign Out\"]")
	private WebElement signOutBTN;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productLink;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreBTN;
	
	@FindBy(xpath = "//a[text()='Vendors']")
	private WebElement vendorLink;
	
	
	

	//Rule3:intialize all webelement using constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	//rule wirte getters method to webelemnts to access
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getAdminhover() {
		return adminhover;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	

	public WebElement getSignOutBTN() {
		return signOutBTN;
	}
	public WebElement getProductLink() {
		return productLink;
	}


	public WebElement getMoreBTN() {
		return moreBTN;
	}


	public WebElement getVendorLink() {
		
		return vendorLink;
	}

	//buisness logic :generic method
	/**
	 * this method will click on organization link
	 */
	public void clickOrg()
	{
		orgLink.click();
	}
	/**
	 * this method will click on contact link
	 */
	public void clickContact()
	{
		contactLink.click();
	}
	/** this method will log out from the application
	 * 
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		mouseHover(driver, adminhover);
		signOutBTN.click();
	}
	
	public void clickProduct()
	{
		productLink.click();
	}
	
	public void clickVendor(WebDriver driver)
	{
		mouseHover(driver, moreBTN);
		vendorLink.click();
		
	}
	
	
}
