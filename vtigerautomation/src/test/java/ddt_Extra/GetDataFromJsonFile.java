package ddt_Extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJsonFile {
public static void main(String[] args) throws IOException, ParseException {
//	1>Create the java represention of the physical file

	FileReader fr=new FileReader("./src/main/resources/CommonData.json");
// 2>Parser java represention object 
	JSONParser parser=new JSONParser();
	Object obj =parser.parse(fr);
//	3> DownCaste (explicit)to JSONObject because it will work
	JSONObject jobj=(JSONObject)obj;
//	4> Fetch value by passing key in get(key) and convert to String 
	String BROWSER =jobj.get("Bro").toString();
	System.out.println(BROWSER);

}

}
