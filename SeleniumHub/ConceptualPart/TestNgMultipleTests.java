import org.testng.annotations.Test;


public class TestNgMultipleTests {

	@Test //annotation represents Test case
	public void testLogin2()
	{
		System.out.println("Test login...");
	}
	
	@Test
	public void testRegister2()
	{
		System.out.println("Validate Registery");
	}
}
