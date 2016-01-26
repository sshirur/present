package com.fedu.java.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/***
 * 
 * @author sunil shirur 
 * Date: 26th Jan 2016
 *
 *Note:
 * 1: Make sure that all cells of the sheet are formatted as Number>Text
 * 2: Make sure you link/import/add external xlsx library POS  
 * 3: Constructors 
 * 	 I : public XLSExtractor(String xPath,int sheetNum) ; xPath: Path of the xlsx/xls workbook ; sheetNum: Sheet Number (Index 0 is first sheet in the xlsx) 
 *  II : public XLSExtractor(String xPath,String sheetName) ; Sheet Name
 * 4: Public functions
 * 			public int getRowCount() ; will return total number of active rows
 *			public int getColumnCount() ; will return total number of active columns
 *          public int getColNum(String colName) ; will return the column number if you pass column name
 *          public String getColumnData(String columnName,int index) ; will give the column data by providing column name and row number/index
 *          public void setColomnData(String columnName,int index, String value) ; will set the cell data by providing column name, row number/index and value 	
		  
 */
public class XLSExtractor {
	
	String path,shtName;
	int shtNo,rowCount,colCount,sheetIndex;
	XSSFRow row;
	XSSFSheet sheet;
	XSSFWorkbook workbook ;
	FileInputStream fis =null;
	private XSSFCell cell = null;
	String columnName;
	
	public  FileOutputStream fos =null;
	
	//Constructor I 
	//Constructor to initialize the xlsx path, & Sheet Number (Index 0 is first sheet in the xlsx)
	
	public XLSExtractor(String xPath,int sheetNum){
	
		path=xPath;
		shtNo=sheetNum;
			
			try {
                    //Get the Stream to xlsx  			
					fis=new FileInputStream(path);
					
					//get the workbook object
					workbook = new XSSFWorkbook(fis);
					
					//Get the sheet Object
					sheet=workbook.getSheetAt(shtNo);
					
				
					
					//close the stream
					fis.close();
					
		
			} catch (IOException e) {
			
					e.printStackTrace();
				}
		
	   }
	
	//Constructor II
	//Constructor to initialize the xlsx path, & Sheet Name
	
	public XLSExtractor(String xPath,String sheetName){
	
		path=xPath;
	    shtName=sheetName;
	  		
		try {
			
			 //Get the Stream to xlsx  			
			fis=new FileInputStream(path);
			
			//get the workbook object
			workbook = new XSSFWorkbook(fis);
			
			//get the sheet index by sheet name
			sheetIndex=workbook.getSheetIndex(shtName);
			//Get the sheet Object
			sheet=workbook.getSheetAt(sheetIndex);

			
			//close the stream
			fis.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
     
		   }
		
   	}
	
		
	//function to get the number of rows in xls's specified worksheet
	
	public int getRowCount()
	{
		int rowCount=0;
		rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	//function to get the number of columns in xls's specified worksheet
	
	public int getColumnCount()
	{
		
		int columnCount=0;
		
			//Get the Stream to xlsx  			
			try {
				fis=new FileInputStream(path);
				//get the workbook object
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//Get the sheet Object
		sheet=workbook.getSheetAt(shtNo);
		
		//get information from the first row
		row=sheet.getRow(0);
	
		//get last column index
		columnCount=row.getLastCellNum();
	
		return columnCount;
		
	}
		
	//get the column number by passing column name, 1 is first column 
	
	public int getColNum(String colName)
	{
		int colIndex=0;
		String cellData=null;
		
		//Store the column name as local variable
		columnName=colName;
		
				//Get the Stream to xlsx  			
						try {
							fis=new FileInputStream(path);
							//get the workbook object
							workbook = new XSSFWorkbook(fis);
							
							//Get the sheet Object
							sheet=workbook.getSheetAt(shtNo);
		
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
		//get complete info of 1st row
		row=sheet.getRow(0);
		
		//scan through the 1st row  
			for(int k=0;k<=getColumnCount();k++)
			{
				//Increase the index so that you can get the column number
				colIndex=colIndex+1;
					cellData=row.getCell(k).toString();
		        
				//Break the loop once you find the column name
				if(cellData.equalsIgnoreCase(columnName))
				break;
			}
			
		return colIndex;
	}
	
	
	//get the cell data by passing column name and index
	
	public String getColumnData(String columnName,int index)
	{
		//Wait is set avoid multi process to run in parallel
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		//declaration
		
		String colName,colData=null,cellData=null;
		int indexVal,colNum;
	    double numCellData;	    
		//Initialization
		
		colName=columnName;
		indexVal=index;

		//Get the Stream to xlsx  			
		try {
			fis=new FileInputStream(path);
			//get the workbook object
			workbook = new XSSFWorkbook(fis);
			
			//Get the sheet Object
			sheet=workbook.getSheetAt(shtNo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//get information from the first row
				row=sheet.getRow(0);
			
        //get the column number of the specified cell
				colNum=getColNum(colName);
	               
		//scan through the 1st row to get the specified column name		
				for(int i=0;i<getColumnCount();i++)
				{
					//get the cell content from 1st to last column 
					cell = row.getCell(i);
	                
					//If cell content type is string,blank or numeric then enter the loop
					if(cell.getCellType()==Cell.CELL_TYPE_STRING || cell.getCellType()==Cell.CELL_TYPE_BLANK || cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_ERROR)
	                	{
	                		
						       //convert the cell content to string
	                			colData=cell.getStringCellValue();
	
	                			// compare it with provided column name
	                				if(colData.equalsIgnoreCase(colName))
	                				{
	                					
	                					//if column found then scan the all the rows
	                					for(int j=1;j<getRowCount();j++)
	                							{
	                							//get the data of all the rows
	                							row=sheet.getRow(j);
	                							
	                							//get the data of a specified column name							
	                							cell = row.getCell(colNum-1);
	                							
                                                    if(j==indexVal)
                                                    	{
                                                    	if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
                                                    		numCellData=cell.getNumericCellValue();
                                                    		cellData=String.valueOf(numCellData);
                                                    	}
                                                    	
                                                    	else
                                                    	cellData=cell.getStringCellValue();
                                                    	
                                                    	
                                                    	}
	                                            }
				       				 }
	                			}
				}
		       
				return cellData;
	}
	
	//Update the column cell by providing column name index (index will start with 1) & Value
	
	public void setColomnData(String columnName,int index, String value) 
	{
		System.out.println("XLSExtractor.setColomnData()");
		//declaration
		String colName,colData=null,dataValue=null;
		int indexVal,colNum;
				    	    
		//Initialization
			colName=columnName;
			indexVal=index;
			dataValue=value;

			//get information from the first row
			row=sheet.getRow(0);
					
	   //get the column number of the specified cell
			colNum=getColNum(colName);
			             System.out.println("ColNum "+ colNum);  
	//scan through the 1st row to get the specified column name		
			
			for(int i=0;i<getColumnCount();i++) {
			
   //get the cell content from 1st to last column 
					cell = row.getCell(i);
			               
					//If cell content type is string,blank or numeric then enter the loop
							if(cell.getCellType()==Cell.CELL_TYPE_STRING || cell.getCellType()==Cell.CELL_TYPE_BLANK || cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
					              		
								       //convert the cell content to string
			                			colData=cell.getStringCellValue();
			
			                			// compare it with provided column name
			                				if(colData.equalsIgnoreCase(colName)) {
			                					                		System.out
																				.println("Found coloumn as "+colData);			
			                					//if column found then scan the all the rows
			                					for(int j=1;j<getRowCount();j++) {
			                		
			                						
			                						//compare the index value
			                							if(j==indexVal) {
			                					     		//get the data of all the rows
				                							row=sheet.getRow(j);
//			                								System.out
//																	.println("row-----------"+row);
//			                								//get the data of a specified column name							
				                							cell = row.getCell(colNum-1);
			                								System.out
																	.println("j "+j);
			                								System.out
																	.println("cell "+cell);
		                                                   	row.createCell(colNum-1);
		                                                   	System.out
																	.println("value "+dataValue);
		                                                   	cell.setCellValue(dataValue);
		                                                    //Update the xls sheet                                                   	
		                                                  		try {
		                                                  			fos = new FileOutputStream(path);
			                                                  		workbook.write(fos);
			                                                  		
																	fos.close();
																	
																	
																} catch (IOException e) {
																	e.printStackTrace();
																}	
		                                                  		
		                                                    	}
			                                            }
						       				 }
			                			}
						}
				       
	}
	
	
}