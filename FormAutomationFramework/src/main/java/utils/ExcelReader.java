package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private Workbook workbook;

    public ExcelReader(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellValue(String sheetName, int rowNum, int colNum) {
        try {
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            return cell.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public int getRowCount(String sheetName) {
        try {
            return workbook.getSheet(sheetName).getLastRowNum();
        } catch (Exception e) {
            return 0;
        }
    }
}
