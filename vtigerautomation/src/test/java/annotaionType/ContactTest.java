package annotaionType;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseUtility.BaseClass;
import generic_utility.FileUtility;
import object_repository.Home_Page;

public class ContactTest extends BaseClass {
	@Test
	public void CreateContactTest() throws EncryptedDocumentException, FileNotFoundException, IOException {
		ExtentTest test = report.createTest("CreateContactTest");

		FileUtility fUtil = new FileUtility();
		String expectedLastName = fUtil.getDataFromExcelFile("contacts", 1, 0);
		Home_Page hp = new Home_Page(driver);
		hp.getConLink().click();
		driver.findElement(By.cssSelector("img[tittle='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(expectedLastName);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		System.out.println("Contact creation from summited");

		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actualLastName.equals(expectedLastName)) {
			System.out.println("Pass: contact created ");
			test.log(Status.PASS, "PASS : Contact Created Successfully");
			System.out.println("Created Contact Last Name : " + actualLastName);

		} else {
			System.out.println("FAIL : Contact Creation Failed");
			test.log(Status.FAIL, "FAIL : Contact Creation Failed");

			System.out.println("Expected : " + expectedLastName);
			System.out.println("Actual   : " + actualLastName);
		}
	}

}
