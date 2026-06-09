/**
 * Test Script Name : Create Contact and Verify Last Name
 *
 * Objective:
 * To automate the creation of a new Contact in Vtiger CRM and
 * verify whether the Contact is created successfully by validating
 * the Last Name displayed on the Contact Information page.
 *
 * Pre-Conditions:
 * 1. Vtiger CRM application should be up and running.
 * 2. Valid user credentials should be available.
 * 3. Chrome browser and ChromeDriver should be configured.
 *
 * Test Steps:
 * 1. Launch Chrome Browser.
 * 2. Navigate to Vtiger CRM application.
 * 3. Login with valid credentials.
 * 4. Click on Contacts module.
 * 5. Click on Create Contact icon.
 * 6. Enter Last Name.
 * 7. Save the Contact.
 * 8. Capture the Last Name from Contact Information page.
 * 9. Compare Actual and Expected Last Name.
 *
 * Expected Result:
 * The Contact should be created successfully and the displayed
 * Last Name should match the entered Last Name.
 *
 * Author : Preeti Chaurasiya
 * Experience Level : Automation Test Engineer
 */

package cRm_Contact;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import generic_utility.FileUtility;
import object_repository.Contact_page;
import object_repository.Home_Page;
import object_repository.Login_Page;

public class CreateTestScriptContTest {

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
//		get data from json file
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromJsonfile("bro");
		String URL = fUtil.getDataFromJsonfile("url");
		String USERNAME = fUtil.getDataFromJsonfile("un");
		String PASSWORD = fUtil.getDataFromJsonfile("pwd");
//		GET DATA from excel
		String expectedLastName = fUtil.getDataFromExcelFile("contacts", 3, 0);

//		 Browsersetup
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		// Launch Browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		launch application

		driver.get(URL);

		// Login to Vtiger CRM

//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("manager");
//		driver.findElement(By.id("submitButton")).click();
		Login_Page lp = new Login_Page(driver);
		lp.login(USERNAME, PASSWORD);

		System.out.println("Login Successful");

		// Navigate to Contacts Module

//		driver.findElement(By.linkText("Contacts")).click();
		Home_Page hp = new Home_Page(driver);
		hp.getConLink().click();
		Contact_page cp = new Contact_page(driver);
		// Click on Create Contact

//		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		cp.getClickplusicon().click();
		
		// create new contact

//		String expectedLastName = "Sharma" ;

		
		cp.getLastname().sendKeys(expectedLastName);
		
		// Enter Mandatory Field
		// driver.findElement(By.name("lastname")).sendKeys(expectedLastName);

		// Save Contact
//		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		cp.getSaveBtn().click();
		System.out.println("Contact creation form submitted");
		

		// Validation

//		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		String actualLastName = cp.getviewlastname().getText();

		if (actualLastName.equals(expectedLastName)) {
			System.out.println("Contact Created Successfully");
			System.out.println("Last Name Validation Passed");
		} else {
			System.out.println("Last Name Validation Failed");
			System.out.println("Expected : " + expectedLastName);
			System.out.println("Actual   : " + actualLastName);
		}

		// Close Browser
		driver.quit();
		System.out.println("Browser closed successfully");
	}
}