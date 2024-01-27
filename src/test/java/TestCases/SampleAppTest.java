package TestCases;



import org.testng.annotations.Test;


import BrowserFactory.BaseClass;
import PageObject.HomePage;


public class SampleAppTest extends BaseClass {



	@Test
	public void verifyAutomobile() throws Exception {
		
		HomePage page=new HomePage(driver);
		
		page.clickAutomobile();
		
	}
}
