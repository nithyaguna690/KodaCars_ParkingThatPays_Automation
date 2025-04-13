package com.kodacars.qa.uilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	private Workbook workbook;

	public ExcelFileReader(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(Paths.get(filePath).toFile());
		workbook = new XSSFWorkbook(fis);
	}

	public String getCellData(String sheetName, int rowNumber, int cellNumber) {
		Sheet sheet = workbook.getSheet(sheetName);

		if (sheet == null) {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
		}

		Row row = sheet.getRow(rowNumber);
		if (row == null) {
			throw new IllegalArgumentException("Row " + rowNumber + " does not exist in the sheet.");
		}

		Cell cell = row.getCell(cellNumber);
		if (cell == null) {
			throw new IllegalArgumentException(
					"Cell at row " + rowNumber + ", column " + cellNumber + " does not exist.");
		}

		// Handle different cell types
		switch (cell.getCellType()) {
	    case STRING:
	        return cell.getStringCellValue();
	    case NUMERIC:
	        if (DateUtil.isCellDateFormatted(cell)) {
	            Date date = cell.getDateCellValue();
	            return new SimpleDateFormat("M/d").format(date); 
	        } else {
	            double value = cell.getNumericCellValue();
	            if (value == (long) value) {
	                return String.valueOf((long) value); // Show as integer if there's no decimal part 78960.0
	            } else {
	                return String.valueOf(value); // Keep decimal if needed   78956.2365
	            }
	        }
	    case BLANK:
	        return "";
	    default:
	        return "Unsupported Cell Type";
	}

	}

	public void close() throws IOException {
		workbook.close();
	}
	
	// Method to get the total number of rows in a sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        return sheet.getLastRowNum(); // Returns the zero-based index of the last row
    }
    
    // Method to get the total number of columns in the first row of the sheet
    public int getColumnCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        
        // Get the first row (usually contains headers)
        Row firstRow = sheet.getRow(0); // The first row is at index 0
        if (firstRow == null) {
            return 0; // No columns if there is no row
        }
        
        // Returns the number of cells in the first row
        return firstRow.getPhysicalNumberOfCells();
    }

    
}
