package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {//rule 1:create seperate pom class for all pages
	
	//rule 2:identify all the webelements using annotation
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement createOrgBTN;
	

	//rule 3:initialize all elements using constructor
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	//rule 4:create getters method to all webelements to access
	public WebElement getCreateOrgBTN() {
		return createOrgBTN;
	}
	
	//buisness logic :generic method
	public void clickCreateOrg()
	{
		createOrgBTN.click();
	}
}
