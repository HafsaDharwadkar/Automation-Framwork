package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {//rule 1:cerate separate pom class for all pages
	//rule 1:identify all webelements using annotation
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeader;

	//rule 2:create getters method for webelemnts to access
	public WebElement getContactHeader() {
		return ContactHeader;
	}
	
	//rule 3:initialize element using constructor
	public ContactInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//rule 4:business logic
	public  String ContactHeader()
	{
		return ContactHeader.getText();
	}
	
	

}
