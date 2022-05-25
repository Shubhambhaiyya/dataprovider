package utilitypack;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlpack {
         
	public FileInputStream filein;
	public FileOutputStream fileout;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path=null;
	
	public Xlpack(String path){
		this.path=path;
	}
	
	public int GetRowCount(String sheetname) throws IOException {
		filein=new FileInputStream(path);
		workbook= new XSSFWorkbook(filein);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		filein.close();
		return rowcount;
		
		}
	
	public int GetCellCount(String sheetname,int rownum) throws IOException{
		
		filein=new FileInputStream(path);
		workbook=new XSSFWorkbook(filein);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		filein.close();
		return cellcount;
		
	   }
	
	public String GetCellData(String sheetname,int rownum,int column) throws IOException {
		
		filein=new FileInputStream(path);
		workbook=new XSSFWorkbook(filein);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(column);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		
		try {
			data=formatter.formatCellValue(cell);
			}
		catch(Exception e) 
		{
			data="";
		}
		workbook.close();
		filein.close();
		return data;
		
		}
	
	   public void SetCellData(String sheetname,int rownum,int cloumn,String data) throws IOException {
		   
		   filein=new FileInputStream(path);
		   workbook=new XSSFWorkbook(filein);
		   sheet=workbook.getSheet(sheetname);
		   
		   row=sheet.getRow(rownum);
		   cell=row.getCell(cloumn);
		   cell.setCellValue(data);
		   
		   fileout=new FileOutputStream(path);
		   workbook.write(fileout);
		   workbook.close();
		   filein.close();
		   fileout.close();
		   
		  }
	   
	    public void FillColour(String sheetname,int rownum,int column) throws IOException {
	    	
	    	 filein=new FileInputStream(path);
			   workbook=new XSSFWorkbook(filein);
			   sheet=workbook.getSheet(sheetname);
			   
			   row=sheet.getRow(rownum);
			   cell=row.getCell(column);
			   
			   style=workbook.createCellStyle();
			   style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN1.getIndex());
			   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			   
			   cell.setCellStyle(style);
			   workbook.write(fileout);
			   workbook.close();
			   filein.close();
			   fileout.close();
	    	
	    }
	
	   
}
