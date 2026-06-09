package cRm_Contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Creating_ContTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Succesfully login");
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys("chaurasiya");
		System.out.println("Enter last name");
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		WebElement actualLastName = driver.findElement(By.id("dtlview_Last Name"));
		String actLastName = actualLastName.getText();
		String Expt = "chaurasiya";
		if (actLastName.equals(Expt)) {
			System.out.println("Correct last name");
		} else {
			System.out.println("Not correct last name");

			driver.quit();

		}
	}
}



