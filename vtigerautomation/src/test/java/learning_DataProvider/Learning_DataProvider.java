package learning_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_DataProvider {
	@Test(dataProvider="getData")
	
	public void dummyLogin(String un, String pwd) {
//		String un="admin";
//		String pwd="manager";	
	System.out.println(un);
	System.out.println(pwd);
	}
	@DataProvider
	
	public Object[][] getData(){
		Object[][] obj=new Object[5][2];
	
		obj[0][0]="sorry";
		obj[0][1]="yad_nahi_hai";
		
		obj[1][0]="mk125";
		obj[1][1]="aksj23";
		
		obj[2][0]="akash123";
		obj[2][1]="pata hai";
		
		obj[3][0]="priti";
		obj[3][1]="preeti123";
		
		obj[4][0]=" not sorry";
		obj[4][1]="nhi btana";
		
		return obj;	
	}
}
