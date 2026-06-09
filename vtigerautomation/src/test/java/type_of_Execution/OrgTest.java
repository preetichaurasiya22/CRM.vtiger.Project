package type_of_Execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrgTest {
	WebDriver driver;
	@Test
	
	public void createOrgTest() throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Create Org Successfully");
		driver.quit();	
	}
	@Test
	public void modifyOrgTest() throws InterruptedException  {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("modify OrgTest");
		driver.quit();
	}
	@Test
	public void deleteOrgTest() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("deleteOrgTest");
		driver.quit();
	}
	
}
