package helperAtribute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class invocationCountTest {

	WebDriver driver;
	@Test
	public void createNoidaCity() throws InterruptedException {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		 System.out.println("created Noida city Successfully");
		 driver.quit();
	}
	@Test (invocationCount = 2)
	public void modifyNoidaCity() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("modify Noida city and make greater noida ");
		driver.quit();
}
	@Test(invocationCount = 3)
	public void deleteNoidaCity() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("delete greaterNoida");
		driver.quit();
	}
}


