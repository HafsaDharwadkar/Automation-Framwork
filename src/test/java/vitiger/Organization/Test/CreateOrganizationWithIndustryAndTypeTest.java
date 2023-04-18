package vitiger.Organization.Test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtigerUtitlity.BaseClass;
@Listeners(vtigerUtitlity.ListenersImplementation.class)
public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass
{
	@Test (groups = "regressionsuite")
	public void createOgWithIndustry() throws Exception
	{
		//step 1:read required data from excel
		String ORGNAME=eUtile.readDataFromExcel("Organization", 7, 2)+jUtile.getRandomNumber();
		String INDUSTRY=eUtile.readDataFromExcel("Organization", 7, 3);
		String TYPE=eUtile.readDataFromExcel("Organization", 7, 4);
		
		
		//step 4:click on organization link
				HomePage hp=new HomePage(driver);
				hp.clickOrg();
				
				//step 5:click on create organization
				OrganizationPage op=new OrganizationPage(driver);
				op.clickCreateOrg();
				
				//step 6:crete organization with madatory fields with industry
				CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
				cnop.CreateOrganization(ORGNAME, INDUSTRY,TYPE);
				
				//step 7:vallidation
				OrgInfoPage org=new OrgInfoPage(driver);
				String ORGHEADER=org.getOrgHeaderText();
				assertTrue(ORGHEADER.contains(ORGNAME));
		
		
		
		
		
	}
	
	
}
