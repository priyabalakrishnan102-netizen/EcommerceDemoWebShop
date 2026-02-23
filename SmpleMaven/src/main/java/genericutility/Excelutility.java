package genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String readExcelData(String sheetname,int rowIndex, int cellIndex) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}
	public void writeDataIntoExcel(String sheetName,int rowIndex,int cellIndex,String value) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("./testdata/testscript.xlsx");
		wb.write(fos);
		wb.close();
	}


}
