package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeadertext;

	public WebElement getVendorHeadertext() {
		return vendorHeadertext;
	}
	
	
	public VendorInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getVendorHeaderText()
	{
		return vendorHeadertext.getText();
		
	}
}
