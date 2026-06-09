/**
 * Test Script Name : Create Contact with Mobile Number
 *
 * Objective:
 * To automate the creation of a new Contact in Vtiger CRM by
 * entering Last Name and Mobile Number and verify whether
 * the Contact is created successfully.
 *
 * Pre-Conditions:
 * 1. Vtiger CRM application should be available and accessible.
 * 2. Valid user credentials should be available.
 * 3. Chrome Browser and ChromeDriver should be configured.
 * 4. User should have permission to create Contacts.
 *
 * Test Steps:
 * 1. Launch Chrome Browser.
 * 2. Navigate to Vtiger CRM application.
 * 3. Login using valid credentials.
 * 4. Navigate to Contacts Module.
 * 5. Click on Create Contact icon.
 * 6. Enter Last Name.
 * 7. Enter Mobile Number.
 * 8. Click on Save button.
 * 9. Capture Last Name from Contact Information page.
 * 10. Validate Actual and Expected Last Name.
 *
 * Expected Result:
 * Contact should be created successfully and the displayed
 * Last Name should match the entered Last Name.
 *
 * Author : Preeti Chaurasiya
 * Role : Automation Test Engineer
 * Framework : Selenium WebDriver with Java
 */
package crm.Opp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateTestScript_Opp {

	public static void main(String[] args) {

		// Test Data
		String expectedLastName = "chaurasiya";
		String mobileNumber = "6358755545";

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Navigate to Application
		driver.get("http://localhost:8888/");

		// Login to Vtiger CRM
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		System.out.println("Login Successful");

		// Navigate to Contacts Module
		driver.findElement(By.linkText("Contacts")).click();

		// Click Create Contact
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		// Enter Contact Details
		driver.findElement(By.name("lastname")).sendKeys(expectedLastName);
		driver.findElement(By.id("mobile")).sendKeys(mobileNumber);

		// Save Contact
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// Capture Actual Last Name
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// Validation
		if (actualLastName.equals(expectedLastName)) {
			System.out.println("PASS : Contact Created Successfully");
			System.out.println("Last Name Validation Passed");
		} else {
			System.out.println("FAIL : Contact Creation Failed");
			System.out.println("Expected : " + expectedLastName);
			System.out.println("Actual   : " + actualLastName);
		}

		// Close Browser
		driver.quit();
	}
}