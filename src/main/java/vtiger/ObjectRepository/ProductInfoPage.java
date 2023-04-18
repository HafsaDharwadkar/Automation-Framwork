package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeadertext;

	public WebElement getVendorHeadertext() {
		return productHeadertext;
	}
	
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getProductHeaderText()
	{
		
			String HEADER=	productHeadertext.getText();
			return HEADER;
	}
	
	
	
}
