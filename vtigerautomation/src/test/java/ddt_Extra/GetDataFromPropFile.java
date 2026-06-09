package ddt_Extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropFile {
		public static void main(String[] args) throws IOException {
//			Step1> create java represention object of the physical file
			FileInputStream fis=new FileInputStream("./src/main/resources/CommonData.properties");
//			Step2> load all the key by using load(fis)
			Properties PObj= new Properties();
			PObj.load(fis);
//			Get the value by passing key
			String Browser=PObj.getProperty("Bro");
			System.out.println(Browser);
			fis.close();
		
		}

}
