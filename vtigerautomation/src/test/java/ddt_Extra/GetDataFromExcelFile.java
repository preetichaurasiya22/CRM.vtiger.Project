package ddt_Extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
//	0>create the java represention object of the physical file
	FileInputStream fis=new FileInputStream("./src/main/resources/CommonData.xlsc.xlsx");
//	1>get the access of workbook
	Workbook wb=WorkbookFactory.create(fis);
//	2>get the access of sheet
	Sheet sh=wb.getSheet("Org");
//	3>get the access of row
	Row row=sh.getRow(6);
//	4>get the access of cell
	Cell cell=row.getCell(0);
//	5>get the access of value
	String value=cell.getStringCellValue();
	System.out.println("=====Company name====");
	System.out.println(value);
//	cell.getBooleanCellValue();
//	doble num=cell.getNumericCellValue();
	wb.close();
	fis.close();
}
}
