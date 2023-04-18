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
public class CreateOrgnization extends BaseClass{

	@Test(groups = "regressionsuite",retryAnalyzer = vtigerUtitlity.IRetryAnalyserImplementation.class)
	public void createOrg() throws Exception
	{
	
		String ORGNAME = eUtile.readDataFromExcel("Organization", 1, 2)+jUtile.getRandomNumber();

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
		}	
		
	}
	

