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
	final static String USER_PASSWORD = "user";
	final static String OWNER_PASSWORD = "owner";
	private List<Employee> listEmployees;

	public PdfGenerator(List<Employee> listEmployees) {
		this.listEmployees = listEmployees;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		String[] headers = { "emp-Id", "First-Name", "Last-Name", "Address", "is_Active", "Age" };
		for (int i = 0; i < headers.length; i++) {
			cell.setPhrase(new Phrase(headers[i], font));
			table.addCell(cell);
		}
	}

	private void writeTableData(PdfPTable table) {
		for (Employee emp : listEmployees) {
			table.addCell(String.valueOf(emp.getId()));
			table.addCell(emp.getFirstName());
			table.addCell(emp.getLastName());
			table.addCell(emp.getAddress());
			table.addCell(String.valueOf(emp.getIsActive()));
			table.addCell(String.valueOf(emp.getAge()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
	
		Document document = new Document(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
		pdfWriter.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128);

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Employees", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 2.5f, 3.0f, 3.0f, 1.5f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}

}
