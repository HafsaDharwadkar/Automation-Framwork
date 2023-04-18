package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {//Rule 1:create seperate POM class for all pages
	
	//Rule 2:Identify elements by using annotation
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeader;
	
	
	
	//Rule 3:initialize the elements by using constructor
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//Rule 4:create getters method for webelements to access

	public WebElement getOrgHeader() {
		return orgHeader;
	}
	
	//Buisness logic:generic method
	public String getOrgHeaderText()
	{
		return orgHeader.getText();
	}
	
}
