package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlReading {
	
	
		public  Object[][] getXLSXFile(String fileName) {
			Workbook workbook = null;
			Object[][] data = null;
			try {
				File file = new File(fileName);
				FileInputStream fis = new FileInputStream(file);
				workbook = new XSSFWorkbook(fis);
				Sheet sheet1 = workbook.getSheet("Sheet1");
				int totalRows = (sheet1.getLastRowNum() - sheet1.getFirstRowNum()) + 1;
				List<String[]> lines = new ArrayList<String[]>();
				for (int i = 0; i < totalRows; i++) {
					Row row = sheet1.getRow(i);
					int totalCols = row.getLastCellNum() - row.getFirstCellNum();
					String[] line = new String[totalCols];
					for (int j = 0; j < totalCols; j++) {
						Cell cell = row.getCell(j);
						line[j] = cell.getStringCellValue();
					}
					lines.add(line);
				}
				String[][] sdata = new String[lines.size()][0];
				data = lines.toArray(sdata);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return data;

		}
	
}
