package pomExtra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import generic_utility.WebDriverUtility;

public class SauceDemoTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		driver.get("https://www.saucedemo.com/");

		LoginPage lp = new LoginPage(driver);

		WebElement un = lp.getUn();
		WebElement pwd = lp.getpwd();
		WebElement loginBtn = lp.getLoginBtn();

		// First Login
		wdUtil.passInput(un, "standard_user");
		wdUtil.passInput(pwd, "secret_sauce");
		loginBtn.click();

		Thread.sleep(1000);

		// Verification
		boolean header = driver.findElement(By.id("header_container")).isDisplayed();
		if (header) {
			System.out.println("Logged in successfully !!!");
		}

		// Logout

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("logout_sidebar_link")).click();

		Thread.sleep(1000);
		driver.quit();

	}
}