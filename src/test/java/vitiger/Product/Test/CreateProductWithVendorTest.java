package vitiger.Product.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.CreateNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductPage;
import vtiger.ObjectRepository.VendorInfoPage;
import vtiger.ObjectRepository.VendorPage;
import vtigerUtitlity.BaseClass;
@Listeners(vtigerUtitlity.ListenersImplementation.class)
public class CreateProductWithVendorTest extends BaseClass {

	@Test
	public void cerateProductWithVendor() throws Exception
	{
		String PRODUCT=eUtile.readDataFromExcel("Product", 1, 2)+jUtile.getRandomNumber();
		String VENDOR=eUtile.readDataFromExcel("Product", 1, 3)+jUtile.getRandomNumber();
		
		
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
		
		//create product with vendor
		hp.clickProduct();
		
		ProductPage pp=new ProductPage(driver);
		pp.clickCreateProductBTN();
		
		
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.CreateProduct(PRODUCT, VENDOR, driver);
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String PRODUCTHEADER=pip.getProductHeaderText();
		Assert.assertTrue(PRODUCTHEADER.contains(PRODUCT));
		
	}
}
