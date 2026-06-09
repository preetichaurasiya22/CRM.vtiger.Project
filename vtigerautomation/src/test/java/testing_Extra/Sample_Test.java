package testing_Extra;

import org.testng.Reporter;

import org.testng.annotations.Test;

public class Sample_Test {
		
@Test (groups="reg")
	public void case1() {
		Reporter.log("Hey there!!! This is TestNG demo test", true);
	}
	@Test(groups="smoke")
	public void case2() {
		Reporter.log("Hey there!!!! This is TestNG demo test2",true);
	}
	@Test(groups="system")
	public void case3() {
		Reporter.log("hey there!!!!", true);
	}
}
