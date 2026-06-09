package helperAtribute;

import org.testng.annotations.Test;

public class dependsOnMethodTest {
	@Test
	public void test1() {
		System.out.println("Account created Successfully");
	}
	@Test(dependsOnMethods = "test1")
	 public void test2() {
		System.out.println("Account modify successfully");
	}
	@Test(dependsOnMethods = "test2")
	public void test3() {
		System.out.println("Account deleted Successfully");
	}
}
