package vitiger.Product.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.ObjectRepository.CreateNewProductPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.ProductInfoPage;
import vtiger.ObjectRepository.ProductPage;
import vtigerUtitlity.BaseClass;
@Listeners(vtigerUtitlity.ListenersImplementation.class)
public class CreateProductTest extends BaseClass {
	
	@Test
	public void createProduct() throws Exception
	{
		
		String PRODUCT=eUtile.readDataFromExcel("Product", 4, 2)+jUtile.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.clickProduct();
		
		ProductPage pp=new ProductPage(driver);
		pp.clickCreateProductBTN();
		
		
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.CreateProduct(PRODUCT);
		
		ProductInfoPage pip=new ProductInfoPage(driver);
		String PRODUCTHEADER=pip.getProductHeaderText();
		Assert.assertTrue(PRODUCTHEADER.contains(PRODUCT));
	}

}
