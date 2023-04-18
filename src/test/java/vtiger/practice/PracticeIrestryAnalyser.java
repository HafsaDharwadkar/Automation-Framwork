package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeIrestryAnalyser {

	
	
	@Test(retryAnalyzer = vtigerUtitlity.IRetryAnalyserImplementation.class)
	public void parctice()
	{
		Assert.fail();
		System.out.println("hi");
	}
}
