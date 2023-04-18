package vitiget.Vendor.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorPage;
import vtigerUtitlity.BaseClass;
@Listeners(vtigerUtitlity.ListenersImplementation.class)
public class CreateVendorTest extends BaseClass {

	@Test
	public void createvendor() throws Exception {
		String VENDOR=eUtile.readDataFromExcel("Vendor", 1, 2)+jUtile.getRandomNumber();
	//create vendor
	HomePage hp=new HomePage(driver);
	hp.clickVendor(driver);
	
	VendorPage vp=new VendorPage(driver);
	vp.clickCreateVendorBTN();
	
	CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
	cnvp.createVendor(VENDOR);
	
	VendorInfoPage vip=new VendorInfoPage(driver);
	String VENDORHEADER=vip.getVendorHeaderText();
	Assert.assertTrue(VENDORHEADER.contains(VENDOR));
	}
	
}
