package com.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Bean.StatementBean;

public class ExcelClass {

	public static int ExcelMethon(List<StatementBean> list) {
		  XSSFWorkbook workbook = new XSSFWorkbook();
			 XSSFSheet sheet = workbook.createSheet("Statement");
	 
			 writeHeaderLine( sheet);
			  writeDataLine( list, workbook, sheet);
			
			
	 FileOutputStream out;
	try {
		out = new FileOutputStream(new File("D:\\ExcelFile\\Excel1.xlsx"));
		workbook.write(out);
		 out.close();
		 return 1;
	} catch ( IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return 0;
	
		}
	
	
	}
	private static void writeHeaderLine(XSSFSheet sheet) {
		// TODO Auto-generated method stub
	Row header =sheet.createRow(0);
		
		Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Transction_Date");
 
        headerCell = header.createCell(1);
        headerCell.setCellValue("Transction_Id");
 
        headerCell = header.createCell(2);
        headerCell.setCellValue("Deposit_Amount");
 
        headerCell = header.createCell(3);
        headerCell.setCellValue("Withdraw_Amount");
 
        headerCell = header.createCell(4);
        headerCell.setCellValue("Account_Balance");
	}
	
	
private static void writeDataLine(List<StatementBean> list, XSSFWorkbook workbook, XSSFSheet sheet) {
		
		int count =1;
		
		  for(StatementBean x :list) { 
			  Row row = sheet.createRow(count++);
				int colCount =0;
				
				 Cell cell = row.createCell(colCount++);		
				 cell.setCellValue(x.getTransactionDate());
				 
				 cell = row.createCell(1);
			     cell.setCellValue(x.getTransctionId());
			     
			     cell = row.createCell(2);
			     cell.setCellValue(x.getDepositBal());
			     
			     cell = row.createCell(3);
			     cell.setCellValue(x.getWithdrawbal());
			     
			     cell = row.createCell(4);
			     cell.setCellValue(x.getAccountBal());
		  }
		 	
		
	}
	
	
}
