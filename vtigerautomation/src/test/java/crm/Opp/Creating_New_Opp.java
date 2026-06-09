package crm.Opp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Creating_New_Opp {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		WebElement username=driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement pass=driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Login Successfull");
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.sendKeys("chaurasiya");
	
		driver.findElement(By.id("mobile")).sendKeys("6358755545");
		String actuallastname=driver.findElement(By.id("dtlview_Last Name")).getText();		
		
		
//		driver.quit();
		
	}

}


