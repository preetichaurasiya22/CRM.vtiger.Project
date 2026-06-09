package type_of_Execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactTest {
	WebDriver driver;

	@Test
	public void createContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(2000);
		System.out.println("MY Browser open successfully Contact created");
		driver.quit();
	}

	@Test
	public void modifyContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(2000);
		System.out.println("Contact modified modify successfully");
		driver.quit();
	}

	@Test
	public void deleteContactTest() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(2000);
		System.out.println("Contact deleted successfully");
		driver.quit();
	}
}
