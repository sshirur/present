import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

/***
 * 
 * @author sunils
 * Program to get the list of hyperlinks headings and displaying the same
 * 
 */
public class ListWebElements {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "E:\\OneDrive\\Institute\\Selenium\\Seleinum_Course\\Selenium-Dump\\chromedriver.exe");
		//ChromeDriver wd=new ChromeDriver();
		
		FirefoxDriver wd=new FirefoxDriver();
		wd.get("http://www.spicejet.com/");
		
		//		Regexp to get all the hyperlinks in footer section "//*[@id='footer']//a[not(@target='_blank')]"
	
		List<WebElement> links=wd.findElements(By.xpath("//*[@id='footer']//a[not(@target='_blank')]"));
		System.out.println("# of List Items: " + links.size());
		for(int i=0;i<links.size();i++)
			System.out.println(links.get(i).getText());
	}

}
