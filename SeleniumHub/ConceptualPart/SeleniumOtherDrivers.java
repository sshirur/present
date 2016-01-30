import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SeleniumOtherDrivers {

	public static void main(String[] args) throws InterruptedException {
		
//		Launching webDriver
//		1. Firefox driver is part of jar files
//		2. Chrome driver needs to download form Selenium website & set the property in .java file as
//		System.setProperty("webdriver.chrome.driver", "E:\\OneDrive\\Institute\\SoftwareDump\\chromedriver.exe")
//
//		3. Internet Explorer driver needs to download, 
//			1. set the Zoom to 100%
//			2. Settings>Internet options>Security
//				Set all 4 Zones to same Enable Protected mode checked/unchecked
//			    Security level ; High/Medium/Low same for all 4 zones	
		
		
		//Create Firefox driver object and launch the browser
		//WebDriver wd=new FirefoxDriver();
		
		//Chrome Driver
		//System.setProperty("webdriver.chrome.driver", "E:\\OneDrive\\Institute\\SoftwareDump\\chromedriver.exe");
		//WebDriver wd=new ChromeDriver();
		
	//	System.setProperty("webdriver.chrome.driver", "E:\OneDrive\Institute\Selenium\Seleinum_Course\Selenium-Dump\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", "E:\\OneDrive\\Institute\\SoftwareDump\\IEDriverServer.exe");
		WebDriver wd=new InternetExplorerDriver();
		
		//Wait for 2sec
		Thread.sleep(2000);
		
		//Navigate to indeed.co.in
		wd.get("http://www.indeed.co.in/");
		
		//Wait for 2sec
		Thread.sleep(2000);
				
		wd.findElement(By.xpath(".//*[@id='what']")).sendKeys("Selenium jobs");;
		
		//Select location as Bangalore
			//Clear the default text
		wd.findElement(By.xpath(".//*[@id='where']")).clear();
		//Wait for 1sec
				Thread.sleep(1000);

		//Now type Bangalore
		wd.findElement(By.xpath(".//*[@id='where']")).sendKeys("Bangalore");
		
		//Wait for 2sec
		Thread.sleep(2000);

		//Click on the find Job Button
		wd. findElement(By.xpath(".//*[@id='fj']")).click();
		
		//Wait for 2sec
		Thread.sleep(2000);

		
		//Get title of the site
		System.out.println(wd.getTitle());
		
		//Wait for 2sec
		Thread.sleep(2000);

	    //Get the number of Jobs available 
		System.out.println(wd.findElement(By.xpath(".//*[@id='searchCount']")).getText());
	
		//Wait for 2sec
		Thread.sleep(2000);

		//Close the browser
		wd.close();
	}
}
