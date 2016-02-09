import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListenerDemo.class)


public class ListenerTest {

	@Test
	public void tes1Success()
	{
		Assert.assertTrue("I am asserting true LLLLLLLLLLLLLL", true);
		
	}
	
	@Test
	public void tes2Fail()
	{
		Assert.assertTrue("I failed becuase I am asserting flase...",false);
		
	}
	
	@Test(dependsOnMethods="tes2Fail")
	public void tes3Skip()
	{
		
	}
	
	
}
