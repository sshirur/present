import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumConfigTest {

	public static void main(String[] args) throws InterruptedException {
		
		//Firefox driver is part of selenium jar file
		//Create Firefox driver object and launch the browser
		WebDriver wd=new FirefoxDriver();
		
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
