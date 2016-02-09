import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumConfig {

	public static void main(String[] args) {
		
		
		FirefoxDriver wd=new FirefoxDriver();
		wd.get("http://www.google.com");

	}

}
