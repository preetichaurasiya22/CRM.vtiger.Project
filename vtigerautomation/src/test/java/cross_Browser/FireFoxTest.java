package cross_Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FireFoxTest {
	WebDriver driver;
@Parameters("bro")
	@Test
	public void createLeadTest(String browser) throws InterruptedException {
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("edge")) {
				driver=new EdgeDriver();	
		}else if (browser.equals("firefox")) {
					driver= new FirefoxDriver();
				}else 
					driver =new FirefoxDriver();
		Thread.sleep(2000);
		System.out.println("FireFox open succcessfully");
		driver.quit();
	}
	
}
