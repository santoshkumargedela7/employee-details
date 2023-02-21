package com.siva.EmployeeDetails.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.siva.EmployeeDetails.entity.Employee;

public class PdfGenerator {
	
	private List<Employee> listEmployees;
	
	public PdfGenerator (List<Employee> listEmployees) {
		this.listEmployees=listEmployees;
	}
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Emp-ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("First-Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Last-Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("is_Active", font));
        table.addCell(cell);       
        
        cell.setPhrase(new Phrase("Age",font));
        table.addCell(cell);
    }
	private void writeTableData(PdfPTable table) {
        for (Employee emp : listEmployees) {
            table.addCell(String.valueOf(emp.getId()));
            table.addCell(emp.getFirstName());
            table.addCell(emp.getLastName());
            table.addCell(emp.getAddress());
          //  table.addCell(String.valueOf(emp.getEmployeeData()));
            table.addCell(String.valueOf(emp.getIsActive()));
            table.addCell(String.valueOf(emp.getAge()));
          //  table.addCell(String.valueOf(emp.getEmployeeData()));
        }
    }
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Employees", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 2.5f, 3.0f, 3.0f, 1.5f,1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
