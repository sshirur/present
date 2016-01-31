import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SkipTheTestDemo {

	@BeforeMethod
public boolean browserLaunched()
	{
		return true;
	}
	
	@Test
	public void skipTestCase()
	{
		if(browserLaunched())
		{
		throw new SkipException("Skipping becuase browser not launched");	
		}
		System.out.println("Skipped ");
	}

}
