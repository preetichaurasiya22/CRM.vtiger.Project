package ddt_Extra;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetDataFromXmlFile {
			
	@Parameters({"un","pwd"}) 
	@Test 
	public void loginDemo(String username, String password) {
//		String username = "admin";
//		String password = "manager";
		System.out.println(username +" "+ password);
	}
}
