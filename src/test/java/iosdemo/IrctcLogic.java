package iosdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcLogic {


	public static void readExcelandexecute() throws IOException, InterruptedException {

		//From excelfile
		String excelFilePath = "/Users/smartpoint/Documents/TestData.xlsx";
		FileInputStream fileInputStream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		int testcasescount = workbook.getNumberOfSheets()-1;

		//System.out.println("Total test cases :"+testcasescount);


		for (int testcase=0;testcase<testcasescount;testcase++){
			//System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
			//driver = new ChromeDriver();

			XSSFSheet worksheet = workbook.getSheetAt(testcase);

			//System.out.println("worksheet Number "+testcase+":"+worksheet.getSheetName());

			int row = worksheet.getLastRowNum();
			int column = worksheet.getRow(1).getLastCellNum();

			for(int i=1;i<=row;i++){

				LinkedList<String> Testexecution = new LinkedList<>();

				//System.out.println('Row value :"+i+"It has first cell value as : "+worksheet.getRow(i).getCell(0));
				for(int j=0;j<column-1;j++){
					//System.out.println("Column index :"+j);
					Cell Criteria = worksheet.getRow(i).getCell(j);

					String CriteriaText;
					if(Criteria==null){
						CriteriaText = null;
					}else{
						CriteriaText = Criteria.getStringCellValue();
					}
					Testexecution.add(CriteriaText);
				}
				//System.out.println("List :"+Testexecution);

				//System.out.println("Result:"+Testexecution.get(0));


			}
		}

	}

}
