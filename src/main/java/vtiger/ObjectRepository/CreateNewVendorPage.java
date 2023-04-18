package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement vendoeNmeEDT;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;

	public WebElement getVendoeNmeEDT() {
		return vendoeNmeEDT;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//buisness logic
	public void createVendor(String VENDOR)
	{
		vendoeNmeEDT.sendKeys(VENDOR);
		saveBTN.click();
	}
}
