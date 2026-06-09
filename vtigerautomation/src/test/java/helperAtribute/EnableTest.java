package helperAtribute;

import org.testng.annotations.Test;

public class EnableTest {
	@Test
	public void test1() {
		System.out.println("Account Created Successfully");
	}
	// by default true   false se skip
	@Test(enabled= false)
	public void test2() {
		System.out.println("Account modify successfully");
}
	@Test
	public void test3() {
		System.out.println("Account deleted successfully");
	}
}