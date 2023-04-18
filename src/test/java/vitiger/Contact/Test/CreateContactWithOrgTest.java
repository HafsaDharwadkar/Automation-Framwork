package vitiger.Contact.Test;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;

import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtigerUtitlity.BaseClass;
@Listeners(vtigerUtitlity.ListenersImplementation.class)

public class CreateContactWithOrgTest extends BaseClass
{
    @Test(groups = "smokesuite")
   public void createContactWithOrg() throws Exception
	{
    	
    			//step 2:read required data from files
    			
    			String LASTNAME=eUtile.readDataFromExcel("Contact", 4, 2)+jUtile.getRandomNumber();
    			String ORGNAME=eUtile.readDataFromExcel("Contact",4 , 3)+jUtile.getRandomNumber();
    			//step 4:click on organization link
    			HomePage hp=new HomePage(driver);
    			hp.clickOrg();
    			
    			//step 5:click on create organization
    			OrganizationPage op=new OrganizationPage(driver);
    			op.clickCreateOrg();
    			
    			//step 6:crete organization with madatory fields
    			CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
    			cnop.CreateOrganization(ORGNAME);
    			
    			//step 7:verify
    			OrgInfoPage oip=new OrgInfoPage(driver);
    			String ORGHEADER = oip.getOrgHeaderText();
    			Assert.assertTrue(ORGHEADER.contains(ORGNAME));
    			
    			
    			//step 8:click on contacts link
    			hp.clickContact();
    			
    			//step 9:click on create contact look up image
    			ContactPage cp=new ContactPage(driver);
    			cp.clickCreateContactBTN();
    			
    			//step 10: create contact with organization
    			CreateNewContactPage cncp=new CreateNewContactPage(driver);
    			cncp.CreateNewContact(driver, LASTNAME, ORGNAME);
    			
    			//step 11:verify
    			ContactInfoPage cip=new ContactInfoPage(driver);
    			String contactHeader=cip.ContactHeader();
    			Assert.assertTrue(contactHeader.contains(LASTNAME));
    			
    			
    			
	}
}
