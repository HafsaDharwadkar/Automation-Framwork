package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerUtitlity.WebdriverUtility;

public class CreateNewOrgPage extends WebdriverUtility {//Rule 1:create seperate POM clas for all pages
	
	//Rule 2:identify all web elemnts using annotation
	@FindBy(name = "accountname")
	private WebElement orgNameEDT;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDD;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDD;
	
	@FindBy (xpath ="//input[@title='Save [Alt+S]']")
	private WebElement orgSaveBTN;
	
	


	//Rule 3:intialize the webelements by constructor
	public CreateNewOrgPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	

	//Rule 4:create getters method for all webelemnts to access
	public WebElement getOrgNameEDT() {
		return orgNameEDT;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	public WebElement getOrgSaveBTN() {
		return orgSaveBTN;
	}

	//buisness logic:generic method
	/**
	 * this method willcreate organization with mandatory field
	 * @param ORGNAME
	 */
	public void CreateOrganization(String ORGNAME)
	{
		orgNameEDT.sendKeys(ORGNAME);
		orgSaveBTN.click();
	}
	/**
	 * this method will cearte organization with industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void CreateOrganization(String ORGNAME,String INDUSTRY)
	{
		orgNameEDT.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, industryDD);
		orgSaveBTN.click();
	}
	/**
	 * this method will create organization with industry and type
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void CreateOrganization(String ORGNAME,String INDUSTRY,String TYPE)
	{
		orgNameEDT.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, industryDD);
		handleDropDown(TYPE, typeDD);
		orgSaveBTN.click();
	}
}
