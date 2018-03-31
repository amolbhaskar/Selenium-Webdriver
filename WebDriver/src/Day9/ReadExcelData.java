package Day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {

	@Test
	public void readXL() throws IOException {

		// This constructor creates a new File instance by converting the given
		// pathname string into an abstract pathname.
		File file = new File("C:\\Users\\abhaskar\\Desktop\\TestData.xlsx");

		// Creates a FileInputStream by opening a connection to an actual file,
		// the file named by the File object file in the file system.
		FileInputStream fis = new FileInputStream(file);

		// Constructs a XSSFWorkbook object, by buffering the whole stream into
		// memory
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Get sheet with the given name
		XSSFSheet sheet = wb.getSheet("sheet1");

		int Rows = sheet.getLastRowNum()+1;
		System.out.println(Rows);
		
		int Cols = sheet.getRow(0).getLastCellNum();
		System.out.println(Cols);

		String value1 = sheet.getRow(5).getCell(1).getStringCellValue();
		System.out.println(value1);

		for (int i = 0; i < Rows; i++) {
			String value = sheet.getRow(i).getCell(0).getStringCellValue();

			System.out.println(value);

			/*
			 * String value1 =sheet.getRow(i).getCell(1).getStringCellValue();
			 * System.out.println(value1);
			 */
		}

		// write back to the excel sheet
		sheet.getRow(0).getCell(2).setCellValue("pass");
		sheet.getRow(1).getCell(2).setCellValue("fail");

		FileOutputStream fout = new FileOutputStream(file);

		wb.write(fout);
		fout.close();

	}

}
