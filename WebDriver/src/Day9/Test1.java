package Day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void readXL() throws Exception{
		
		File file = new File("C:\\Users\\abhaskar\\Desktop\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		String data = sheet.getRow(0).getCell(0).getStringCellValue();
		
		int rows = sheet.getLastRowNum()+1;
		int cols = sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<rows; i++){
			
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		
		sheet.getRow(0).getCell(0).setCellValue("ab");
		
		FileOutputStream fout = new FileOutputStream(file);
		wb.write(fout);
		fout.close();
	}

}
