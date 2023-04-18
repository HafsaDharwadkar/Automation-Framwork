package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerUtitlity.WebdriverUtility;

public class CreateNewProductPage extends WebdriverUtility{

	

	@FindBy(xpath ="//input[@name='productname']")
	private WebElement productNameEDT;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement vendorLookUpBTN;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchEDT;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBTN;

	public WebElement getProductNameEDT() {
		return productNameEDT;
	}

	public WebElement getVendorLookUpBTN() {
		return vendorLookUpBTN;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	public WebElement getSearchEDT() {
		return searchEDT;
	}

	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	
	public CreateNewProductPage(WebDriver driver)      
	{
		PageFactory.initElements(driver, this);
	}
	
	//buisness logic
	public void CreateProduct(String PRODUCTNAME)
	{
		productNameEDT.sendKeys(PRODUCTNAME);
		saveBTN.click();
	}
	
	public void CreateProduct(String PRODUCTNAME,String VENDOR,WebDriver driver)
	{
		productNameEDT.sendKeys(PRODUCTNAME);
		vendorLookUpBTN.click();
		switchToWindow(driver, "Vendors");    
		searchEDT.sendKeys(VENDOR);
		searchEDT.click();
		driver.findElement(By.xpath("//a[text()='"+VENDOR+"']")).click();
		switchToWindow(driver,"Products");
		saveBTN.click();
	}
}
