package pomExtra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
