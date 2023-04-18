package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {//Rule 1:create seprate pom class for allmpages
	//Rule 2:identify all webelemnts using annotation
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement creatContactBTN;
	
	//Rule 3:initialize webelements using constructor
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	
	//rule 4:create getters method for ellements to access
	public WebElement getCreatContactBTN() {
		return creatContactBTN;
	}
	//buisness logic:generic method
	public void clickCreateContactBTN()
	{
		creatContactBTN.click();
	}
	

}
