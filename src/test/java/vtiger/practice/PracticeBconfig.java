package vtiger.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeBconfig {
	
	@BeforeSuite
	public static void bsconfig() {
		System.out.println("Before suite");
	}
	
	@BeforeMethod
	public static void bmconfig()
	{
		System.out.println("befor method");
	}
	
	
	@BeforeClass
	public static void bcconfig()
	{
		System.out.println("Befor class");
	}
	
	@BeforeTest
	public static void btconfig()
	{
		System.out.println("Before Test");
	}
	
	@AfterClass()
	public static void acconfig()
	{
		System.out.println("after class");
	}
	
	@AfterSuite()
	public static void asconfig()
	{
		System.out.println("After suite");
	}
	
	@AfterMethod()
	public static void amconfig()
	{
		System.out.println("After method");
	}
	 
	@AfterTest()
	public static void atconfig()
	{
		System.out.println("Afetr test");
	}
	
	@Test
	public static void test()
	{
		System.out.println("@test");
	}
}
