package autoAmazon.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autoAmazon.pages.ProductPage;

public class ReadExcel {
	
	public String readSheet(int row, int column) throws IOException {
        //Excel File Related
        File file = new File("D:\\Softwares\\eclipse-workspace\\automateTasks_POM\\testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet= wb.getSheetAt(0);
        String value = sheet.getRow(row).getCell(column).getStringCellValue();
        return value;
	}
	
}
