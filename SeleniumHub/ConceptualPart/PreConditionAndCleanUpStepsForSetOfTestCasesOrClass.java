import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Before and after test will execute to one time for all test cases present in this class

public class PreConditionAndCleanUpStepsForSetOfTestCasesOrClass {
	
	@BeforeTest
public void openConnection()
{
		System.out.println("Connected to db...");
}
	@AfterTest
	
	public void closeConnection()
	{
		System.out.println("Connection closed...");
	}
	@Test //annotation represents Test case
	public void testLogin4()
	{
		System.out.println("Test login...");
	}
	
	@Test
	public void testRegister4()
	{
		System.out.println("Validate Registery");
	}
}
