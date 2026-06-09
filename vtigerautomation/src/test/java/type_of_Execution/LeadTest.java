package type_of_Execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LeadTest {
	WebDriver driver;
	
	@Test
	
	public void CreateLeadTest() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Create Lead successfully");
		driver.quit();
	}
	@Test
	public void modifyLeadTest() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("modify lead successfully");
		driver.quit();
	}
	@Test
	public void deleteLeadtest() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("deleted successfully");
		driver.quit();
	}
}
