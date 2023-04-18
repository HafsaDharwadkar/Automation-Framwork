package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1:create a seperate pom class for every page
	//rule 2:identify all elements using annotation 
	@FindBy(name = "user_name")
	private WebElement usernameEDT;
	
	@FindBy(name = "user_password")
	private WebElement passwordEDT;
	
	@FindBy(id = "submitButton")
	private WebElement submitBTN;
     //rule 3:Initialize the element using the constructor
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//rule 4:provide getters method to access webelements
	public WebElement getUsernameEDT() {
		return usernameEDT;
	}

	public WebElement getPasswordEDT() {
		return passwordEDT;
	}

	public WebElement getSubmitBTN() {
		return submitBTN;
	}
	
	//rule 5:Buiseness logic.generic method
	public void login(String USERNAME,String PASSWORD)
	{
		usernameEDT.sendKeys(USERNAME);
		passwordEDT.sendKeys(PASSWORD);
		submitBTN.click();
	}

}
