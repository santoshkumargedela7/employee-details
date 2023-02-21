package com.siva.EmployeeDetails.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.siva.EmployeeDetails.entity.Employee;

public class ExcelGenerator {
		
	private List<Employee>empList;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	public ExcelGenerator(List<Employee> empList) {
		
		this.empList = empList;
		workbook = new XSSFWorkbook();
	}
	 private void writeHeader() {
	        sheet = workbook.createSheet("Student");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        createCell(row, 0, "ID", style);
	        createCell(row, 1, "FirstName", style);
	        createCell(row, 2, "LastName", style);
	        createCell(row, 3, "Age", style);
	        createCell(row, 4, "Address", style);
	        createCell(row, 5, "IsActive", style);
	 }      
	  
	 private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
		 sheet.autoSizeColumn(columnCount);
		 Cell cell = row.createCell(columnCount);
		 if (valueOfCell instanceof Integer) {
	            cell.setCellValue((Integer) valueOfCell);
	        } else if (valueOfCell instanceof Long) {
	            cell.setCellValue((Long) valueOfCell);
	        } else if (valueOfCell instanceof String) {
	            cell.setCellValue((String) valueOfCell);
	        } else {
	            cell.setCellValue((Boolean) valueOfCell);
	        }
	        cell.setCellStyle(style);
	 }
	 private void write() {
	        int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (Employee employee : empList) {
	        	 Row row = sheet.createRow(rowCount++);
		            int columnCount = 0;
		            createCell(row, columnCount++, employee.getId(), style);
		            createCell(row, columnCount++, employee.getFirstName(), style);
		            createCell(row, columnCount++, employee.getLastName(), style);
		            createCell(row, columnCount++, employee.getAddress(), style);
		            createCell(row, columnCount++, employee.getAge(), style);
		            createCell(row, columnCount++, employee.getIsActive(), style);
			} 
	 }   
	        public void generateExcelFile(HttpServletResponse response) throws IOException {
	            writeHeader();
	            write();
	            ServletOutputStream outputStream = response.getOutputStream();
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	        }
	        
	        
	        
	        
	        

}