package vitiger.Contact.Test;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

import vtigerUtitlity.BaseClass;

@Listeners(vtigerUtitlity.ListenersImplementation.class)

public class CreateContactTest extends BaseClass{
	@Test(groups = "smokesuite")
	public void createContact() throws Exception
	{
		//step 2:read required data from excel
		String LASTNAME=eUtile.readDataFromExcel("Contact", 1,2)+jUtile.getRandomNumber();
		
		//step 8:click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickContact();
		
		//step 9:click on create contact look up image
		ContactPage cp=new ContactPage(driver);
		cp.clickCreateContactBTN();
		
		//step 10: create contact with organization
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME);
		
		//step 11:verify
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader=cip.ContactHeader();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		
	}

}
