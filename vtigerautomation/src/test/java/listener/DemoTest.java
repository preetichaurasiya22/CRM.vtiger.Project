package listener;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import BaseUtility.BaseClass;

@Listeners(generic_utility.List_Imp.class)
public class DemoTest extends BaseClass {

	@BeforeSuite
	public void repConfig() {

		System.out.println("this is before suite");
	}

	@Test
	public void createCity() {
		System.out.println("city created");
	}

	@Test
	public void modifyCity() {
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "modifyCity")
	public void deleteCity() {
		System.out.println("new city deleted");
	}

	@AfterSuite
	public void repBackup() {
//			report.flush();
		System.out.println("this is after suite");
	}

}
