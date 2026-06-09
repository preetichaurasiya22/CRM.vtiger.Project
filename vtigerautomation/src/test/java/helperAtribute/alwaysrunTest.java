package helperAtribute;

import org.junit.Assert;
import org.testng.annotations.Test;

public class alwaysrunTest {
	
	@Test
	public static void test1() {
		System.out.println("created successfully");
//	forfully failing test1
	Assert.fail("test1");
	}
	@Test(dependsOnMethods = "test1",alwaysRun = true)
	public static void test2() {
		System.out.println("create test fail but test 2 run ");
		
	}
}