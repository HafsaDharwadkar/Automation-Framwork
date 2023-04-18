package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorBTN;

	public WebElement getCreateProductBTN() {
		return createVendorBTN;
	}
	
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this );
	}
	//buisness logic 
	public void clickCreateVendorBTN()
	{
		createVendorBTN.click();
	}
}
