package Day11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DDF_MortgageCalc {
	
	public static WebDriver driver;
	String vURL;
	String TDID, vhomevalue,vloanamt,vintrate,vloanterm,vproptax,vexpectedpmi,vactualpmi,result;
	String xlData[][];
	String xl_path, xl_pathresult;
	String sheetname;
	int xRows,xCols,xRowCount,i;
	
	@BeforeTest
	public void inti() throws Exception{
		
		vURL = "http://www.mortgagecalculator.org/";
		
		xl_path= "C:\\Java_Luna_Projects\\WebDriver\\data.xls";
		xl_pathresult="C:\\Java_Luna_Projects\\WebDriver\\calcwrite.xls";
		sheetname = "data";
		xlData = readXL(xl_path, sheetname);
		xRowCount = xlData.length;
	}
	
	@Test
	public void calc() throws InterruptedException{
		
		for (i=1; i<xRowCount; i++){
		
			 TDID = xlData[i][0];
			 vhomevalue = xlData[i][1];
			 vloanamt = xlData[i][2];
			 vintrate = xlData[i][3];
			 vloanterm = xlData[i][4];
			 vproptax = xlData[i][5];
			 vexpectedpmi = xlData[i][6];
		
		
		driver = new FirefoxDriver();
		driver.navigate().to(vURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='param[homevalue]']")).clear();
		
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@name='param[homevalue]']")).sendKeys(vhomevalue);
		
		
		driver.findElement(By.xpath("//*[@id='loanamt']")).clear();
		driver.findElement(By.xpath("//*[@id='loanamt']")).sendKeys(vloanamt);
		
		driver.findElement(By.xpath("//*[@id='intrstsrate']")).clear();
		driver.findElement(By.xpath("//*[@id='intrstsrate']")).sendKeys(vintrate);
		
		driver.findElement(By.xpath("//*[@id='loanterm']")).clear();
		driver.findElement(By.xpath("//*[@id='loanterm']")).sendKeys(vloanterm);
		
		driver.findElement(By.xpath("//*[@id='pptytax']")).clear();
		driver.findElement(By.xpath("//*[@id='pptytax']")).sendKeys(vproptax);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		vactualpmi = driver.findElement(By.xpath("//*[@id='calc']/form/section/section[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/h3")).getText();
		
		System.out.println("actual monthly value is: "+vactualpmi);
		
		
		xlData[i][7] = vactualpmi;
		
		if(vactualpmi.contentEquals(vexpectedpmi)){
			System.out.println("pass");
			xlData[i][8] = "pass";
		}else{
			System.out.println("fail");
			xlData[i][8] = "fail";
		}
		
		
	}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		writeXL(xl_pathresult,"write",xlData);
		System.out.println("close the browser");
		driver.close();
		
	}
	
	
	//indpendent functions
	
	// Method to write into an XL
	public void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{

	    	File outFile = new File(fPath);
	        HSSFWorkbook wb = new HSSFWorkbook();
	        HSSFSheet osheet = wb.createSheet(fSheet);
	        int xR_TS = xData.length;
	        int xC_TS = xData[0].length;
	    	for (int myrow = 0; myrow < xR_TS; myrow++) {
		        HSSFRow row = osheet.createRow(myrow);
		        for (int mycol = 0; mycol < xC_TS; mycol++) {
		        	HSSFCell cell = row.createCell(mycol);
		        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        	cell.setCellValue(xData[myrow][mycol]);
		        }
		        FileOutputStream fOut = new FileOutputStream(outFile);
		        wb.write(fOut);
		        fOut.flush();
		        fOut.close();
	    	}
		}
	

	public String[][] readXL(String fPath, String fSheet) throws Exception{
		// Inputs : XL Path and XL Sheet name
		// Output : cell value
		
			String[][] xData; 
			//xData = new String[xRows][xCols];

			File myxl = new File(fPath);                                
			FileInputStream myStream = new FileInputStream(myxl);                                
			HSSFWorkbook myWB = new HSSFWorkbook(myStream);                                
			HSSFSheet mySheet = myWB.getSheet(fSheet);                                 
			xRows = mySheet.getLastRowNum()+1;                                
			xCols = mySheet.getRow(0).getLastCellNum();   
			System.out.println("Total Rows in Excel are " + xRows);
			System.out.println("Total Cols in Excel are " + xCols);
			xData = new String[xRows][xCols];
			
			for (int i = 0; i < xRows; i++) {    // rows                        
					HSSFRow row = mySheet.getRow(i);
					for (int j = 0; j < xCols; j++) {   // cols                            
						HSSFCell cell = row.getCell(j);
						String value = "-";
						if (cell!=null){
							value = cellToString(cell);
						}
						xData[i][j] = value;      
						System.out.print(value);
						System.out.print("----");
						}        
					System.out.println("");
					}    
			myxl = null; // Memory gets released
			return xData;
	}

	//Change cell type
	public static String cellToString(HSSFCell cell) { 
		// This function will convert an object of type excel cell to a string value
		int type = cell.getCellType();                        
		Object result;                        
		switch (type) {                            
			case HSSFCell.CELL_TYPE_NUMERIC: //0                                
				result = cell.getNumericCellValue();                                
				break;                            
			case HSSFCell.CELL_TYPE_STRING: //1                                
				result = cell.getStringCellValue();                                
				break;                            
			case HSSFCell.CELL_TYPE_FORMULA: //2                                
				throw new RuntimeException("We can't evaluate formulas in Java");  
			case HSSFCell.CELL_TYPE_BLANK: //3                                
				result = "%";                                
				break;                            
			case HSSFCell.CELL_TYPE_BOOLEAN: //4     
				result = cell.getBooleanCellValue();       
				break;                            
			case HSSFCell.CELL_TYPE_ERROR: //5       
				throw new RuntimeException ("This cell has an error");    
			default:                  
				throw new RuntimeException("We don't support this cell type: " + type); 
				}                        
		return result.toString();      
		}

}
