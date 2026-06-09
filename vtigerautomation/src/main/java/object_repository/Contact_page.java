package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_page {

	public Contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement clickplusicon;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement viewlastname;
		
	public WebElement getviewlastname() {
		return viewlastname;		
		}
	
	public void createContact(String lastname) {
		clickplusicon.click();
	}

	public WebElement getClickplusicon() {
		return clickplusicon;
	}

	public void setClickplusicon(WebElement clickplusicon) {
		this.clickplusicon = clickplusicon;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public void setLastname(WebElement lastname) {
		this.lastname = lastname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}
}
