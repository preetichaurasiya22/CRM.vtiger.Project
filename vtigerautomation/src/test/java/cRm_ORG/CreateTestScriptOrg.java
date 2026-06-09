
/**
	 * Test Script Name : Create Organization and Verify Organization Name
	 *
	 * Objective:
	 * To automate the creation of a new Organization in Vtiger CRM and
	 * verify whether the Organization is created successfully by validating
	 * the Organization Name displayed on the Organization Information page.
	 *
	 * Pre-Conditions:
	 * 1. Vtiger CRM application should be accessible.
	 * 2. Valid login credentials should be available.
	 * 3. Chrome Browser and ChromeDriver should be configured.
	 * 4. User should have permission to create Organizations.
	 *
	 * Test Steps:
	 * 1. Launch Chrome Browser.
	 * 2. Navigate to Vtiger CRM application.
	 * 3. Login using valid credentials.
	 * 4. Navigate to Organizations module.
	 * 5. Click on Create Organization icon.
	 * 6. Generate a unique Organization Name.
	 * 7. Enter Organization Name.
	 * 8. Save the Organization.
	 * 9. Capture Organization Name from Organization Information page.
	 * 10. Compare Actual and Expected Organization Name.
	 * 11. Logout from the application.
	 * 12. Close the browser.
	 *
	 * Expected Result:
	 * Organization should be created successfully and the displayed
	 * Organization Name should match the entered Organization Name.
	 *
	 * Author : Preeti Chaurasiya
	 * Role : Automation Test Engineer
	 * Framework : Selenium WebDriver with Java

	 */
package cRm_ORG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateTestScriptOrg {
	public static void main(String[] args) throws InterruptedException {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to Vtiger CRM Application
		driver.get("http://localhost:8888/");

		// Login to Application
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successful");

		// Navigate to Organizations Module
		driver.findElement(By.linkText("Organizations")).click();

		// Click on Create Organization Icon
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		// Generate Unique Organization Name
		int randomNum = (int) (Math.random() * 1000);
		String expectedOrgName = "AutomationwithPiyush" + randomNum;

		// Enter Organization Name
		WebElement orgNameTextField = driver.findElement(By.name("accountname"));
		orgNameTextField.sendKeys(expectedOrgName);

		// Save Organization
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		System.out.println("Organization Created Successfully");

		// Capture Actual Organization Name
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		// Validate Organization Creation
		if (actualOrgName.equals(expectedOrgName)) {

			System.out.println("PASS : Organization Created Successfully");
			System.out.println("Expected Organization Name : " + expectedOrgName);
			System.out.println("Actual Organization Name   : " + actualOrgName);

		} else {

			System.out.println("FAIL : Organization Creation Failed");
			System.out.println("Expected Organization Name : " + expectedOrgName);
			System.out.println("Actual Organization Name   : " + actualOrgName);
		}

		// Logout from Application
		WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions actions = new Actions(driver);
		actions.moveToElement(profileIcon).perform();

		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successful");

		// Close Browser
		Thread.sleep(3000);
		driver.quit();
	}
}
