package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[src='test/logo/vtiger-crm-logo.gif']")
	private WebElement profiletittle;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement conLink;

	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement profiletitle;

	@FindBy(linkText = "Opportunities")
	private WebElement oppLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getprofiletittle() {
		return profiletitle;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getConLink() {
		return conLink;
	}

	public WebElement getOppLink() {
		return oppLink;
	}

	public WebElement getProfileIcon() {
		return getProfileIcon();
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
}
