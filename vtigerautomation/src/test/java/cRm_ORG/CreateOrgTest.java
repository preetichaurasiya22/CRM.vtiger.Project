package cRm_ORG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
		public static void main(String[] args) throws InterruptedException {
			// Launch Browser
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			// Open Application
			driver.get("http://localhost:8888/");
			// Login to VTiger CRM
			WebElement username = driver.findElement(By.name("user_name"));
			username.sendKeys("admin");
			WebElement password = driver.findElement(By.name("user_password"));
			password.sendKeys("manager");
			driver.findElement(By.id("submitButton")).click();
			System.out.println("Login Successfully");
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
			// Click on Save Button
			driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
			System.out.println("Organization Created Successfully");
			// Capture Actual Organization Name
			String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
			// Validation
			if (actualOrgName.equals(expectedOrgName)) {
				System.out.println("PASS : Organization Created Successfully");
				System.out.println("Created Organization Name : " + actualOrgName);
			} else {
				System.out.println("FAIL : Organization Creation Failed");
				System.out.println("Expected Organization Name : " + expectedOrgName);
				System.out.println("Actual Organization Name : " + actualOrgName);
			}
			// Logout from Application
			WebElement profileIcon = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(profileIcon).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Logout Successfully");
			// Close Browser
			Thread.sleep(3000);
			driver.quit();
		}
	}

