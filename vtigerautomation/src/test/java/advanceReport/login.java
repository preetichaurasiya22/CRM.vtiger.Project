package advanceReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class login {
	@Test
	public void loginTest() throws InterruptedException{
//		Report Config
		ExtentSparkReporter spark= new ExtentSparkReporter("./Advance_reports/rep1.html");
		spark.config().setDocumentTitle("fb_dummy");
		spark.config().setReportName("dummy_01");
		spark.config().setTheme(Theme.DARK);
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
		report.setSystemInfo("key4", "value4");
		Thread.sleep(3000);
				
		ExtentTest test = report.createTest("loginTest");
		test.log(Status.PASS, "passed.....");
		test.log(Status.FAIL, "Failed.....");
		test.log(Status.SKIP, "skipped.....");
		test.log(Status.WARNING, "warning.....");
		test.log(Status.INFO,"Information.....");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.quit();
//		report backup
		report.flush();
		}

	}
