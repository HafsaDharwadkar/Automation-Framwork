package vitiger.Organization.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewOrgPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgInfoPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtigerUtitlity.BaseClass;


@Listeners(vtigerUtitlity.ListenersImplementation.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {
	
	@Test(groups = "regressionsuite",retryAnalyzer = vtigerUtitlity.IRetryAnalyserImplementation.class)
	public void createOrgWithIndustry() throws Exception
	{
		//step1://read the required from excel
		String INDUSTRY=eUtile.readDataFromExcel("Organization", 4, 3);
		String ORGNAME=eUtile.readDataFromExcel("Organization", 4, 2)+jUtile.getRandomNumber();
		
		//step 4:click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickOrg();
		
		//step 5:click on create organization
		OrganizationPage op=new OrganizationPage(driver);
		op.clickCreateOrg();
		
		//step 6:crete organization with madatory fields with industry
		CreateNewOrgPage cnop=new CreateNewOrgPage(driver);
		cnop.CreateOrganization(ORGNAME, INDUSTRY);
		
		//step 7:vallidation
		OrgInfoPage org=new OrgInfoPage(driver);
		String ORGHEADER=org.getOrgHeaderText();
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
	}

}
