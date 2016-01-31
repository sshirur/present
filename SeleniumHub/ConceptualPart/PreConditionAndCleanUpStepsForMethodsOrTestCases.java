import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//Before and After method annotations will execute for each and every test case or method

public class PreConditionAndCleanUpStepsForMethodsOrTestCases {
	
	@BeforeMethod
	public void openBrowser()
	{
		System.out.println("Opened the Browser...");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Closed the Browser...");
	}
	
	@Test //annotation represents Test case
	public void testLogin3()
	{
		System.out.println("Test login...");
	}
	
	@Test
	public void testRegister3()
	{
		System.out.println("Validate Registery");
	}
}
