package testing_Extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test (groups="reg")
public class Demo_Test {
	public void case1() {
//		System.out.println("hey there!!!!!!");
		Reporter.log("hey there!!!!!!!!");
	}
	@Test(groups="smoke")
	public void case2() {
		Reporter.log("Case 2 Executed");		
	}
	@Test(groups="reg")
	public void case3() {
		Reporter.log("Case 3 Executed");
	}
		public static void main(String[]args){
		System.out.println("hey there!!!!!!!");
	}
}
