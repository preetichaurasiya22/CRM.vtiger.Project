package generic_utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverUtility {
		WebDriver driver;

	public WebDriverUtility(WebDriver driver) {

	}

//    login
	public void passInput(WebElement element, String un) {
		element.sendKeys(un);

	}
//	maximize
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	//implicit wait
	public void implicitilyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// hover
	public void hover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}

//		right click
	public void rightClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

//			explicit wait for element to be Clickable
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
		

	public void WaitAndClick(WebElement element) {

	}

	public void waitAndClick(WebElement logout, int i) {
		Select sel = new Select(logout);
		sel.selectByIndex(i);
	}

}
