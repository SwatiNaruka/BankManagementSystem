package com.Files;

import java.io.FileOutputStream;
import java.util.List;

import com.Bean.StatementBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfClass {

	public static int PdfMethod(List<StatementBean> list) {
		 Document document = new Document();
		    try
		    {
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\PDF_Folder\\table.pdf"));
		        document.open();
		 
		        PdfPTable table = new PdfPTable(5); // 3 columns.
		        table.setWidthPercentage(110); //Width 100%
		        table.setSpacingBefore(10f); //Space before table
		        table.setSpacingAfter(10f); //Space after table
		 
		        //Set Column widths
		        float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
		        table.setWidths(columnWidths);
		 
		        PdfPCell cell1 = new PdfPCell(new Paragraph("Transction Date"));
		        cell1.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell1.setPadding(8);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell2 = new PdfPCell(new Paragraph("Transction Id"));
		        cell2.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell2.setPadding(8);
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell3 = new PdfPCell(new Paragraph("Deposit Amount"));
		        cell3.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell3.setPadding(8);
		        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell4 = new PdfPCell(new Paragraph("withdraw Amoount"));
		        cell4.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell4.setPadding(8);
		        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell5 = new PdfPCell(new Paragraph("Account Balance"));
		        cell5.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell5.setPadding(8);
		        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        table.addCell(cell1);
		        table.addCell(cell2);
		        table.addCell(cell3);
		        table.addCell(cell4);
		        table.addCell(cell5);
		        
		        
		      //  List<StatementBean>	list =	StatementDao.statementTable(stmt);			 
				for(StatementBean x : list) { 
				
					PdfPCell data = new PdfPCell(new Paragraph(( x.getTransactionDate())));
					cell1.setBorderColor(BaseColor.BLACK);
					cell1.setPadding(8);
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        
			    	PdfPCell data1 = new PdfPCell(new Paragraph(Integer.toString(x.getTransctionId())));
			    	cell2.setBorderColor(BaseColor.BLACK);
			    	cell2.setPadding(8);
			    	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			    	PdfPCell data2 = new PdfPCell(new Paragraph(Integer.toString(x.getDepositBal())));
			    	
			    	cell3.setBorderColor(BaseColor.BLACK);
			    	cell3.setPadding(8);
			    	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
					
			    	PdfPCell data3 = new PdfPCell(new Paragraph(Integer.toString(x.getWithdrawbal())));
			    	cell4.setBorderColor(BaseColor.BLACK);
			    	cell4.setPadding(8);
			    	cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    	
			    	PdfPCell data4 = new PdfPCell(new Paragraph(Integer.toString(x.getAccountBal())));
			    	cell5.setBorderColor(BaseColor.BLACK);
			    	cell5.setPadding(8);
			    	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			    	cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			    	
					
					  table.addCell(data); 
					  table.addCell(data1); 
					  table.addCell(data2);
					  table.addCell(data3); 
					  table.addCell(data4);
					  
				}			        
		        document.add(table);
		 
		        document.close();
		        writer.close();
		        
		        return 1;
			    } catch (Exception e1)
		    {
		        e1.printStackTrace();
		        return 0;
		    }
	}
	
	
}
