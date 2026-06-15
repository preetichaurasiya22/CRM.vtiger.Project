package annotationType;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.Home_Page;
import object_repository.Login_Page;

public class BaseClassDummy {

	public WebDriver driver;

	@BeforeClass
	public void setup() throws FileNotFoundException, IOException, ParseException {
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromJsonfile("bro");

		if (BROWSER.equals("ChromeBrowser")) {
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

		WebDriverUtility WUtil = new WebDriverUtility(driver);
		WUtil.maximizeWindow();
		WUtil.implicitilyWait();
	}

	@BeforeMethod
	public void login() throws FileNotFoundException, IOException, ParseException {
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromJsonfile("bro");
		String URL = fUtil.getDataFromJsonfile("url");

		driver.get(URL);

		Login_Page lp = new Login_Page(driver);
		lp.login("admin", "manager");

		System.out.println("INFO : Login Successful");
	}

	@AfterMethod
	public void logout() {

		Home_Page hp = new Home_Page(driver);
		hp.getConLink().click();
		WebElement profileIcon = hp.getProfileIcon();

		new Actions(driver).moveToElement(profileIcon).perform();
		hp.getSignOutLink().click();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("INFO : Browser Closed Successfully");
	}

}
