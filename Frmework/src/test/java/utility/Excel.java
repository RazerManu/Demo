package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//this class file is for reading excel data. So we will be only calling the method from here to main
public class Excel 
{
	
	XSSFWorkbook file;//this is class that is external which is added as dependency in pom.xml for reading excel
	XSSFSheet s;
	public String read(String path, int sheetn, int row, int col) throws IOException
	{
		FileInputStream fin=new FileInputStream(path);
	 
		//below line error log4j, to resolve added 2 dependencies in pom.xml for log4j
		file=new XSSFWorkbook(fin);//getting excel file
		//s=file.getSheet("Sheet1"); //in this we will be passing the sheet name
		s=file.getSheetAt(sheetn);//sheet number,  its index starts from 0
		String data=s.getRow(row).getCell(col).getStringCellValue();//cell value by passing row & column, its index also starts from 0
		
		//this will return the last row and can put it in forloop for reading all data
		//int rnum=s.getLastRowNum();
		//System.out.println(rnum);
		file.close();
		return data;
		
	}
	
	public void write(String path, String sheet, int row, int col, String result) throws IOException 
	{
		//for opening the file we need to use input stream
		FileInputStream fin= new FileInputStream(path);
		file=new XSSFWorkbook(fin);
		s=file.getSheet(sheet);
		s.getRow(row).createCell(col).setCellValue(result);//setting the value to particular cell
		FileOutputStream fout= new FileOutputStream(path);// for actual writing we need output stream
		file.write(fout);
		fout.flush();//after writing flush is required
		file.close();
	}
public static void main(String arg[]) throws IOException
{
	Excel ex=new Excel();
	//to read the file
	String u=ex.read("X:\\mphasis\\Selenium Training- 2023\\login data.xlsx", 0, 0, 0);
    System.out.println(u);
	
    //to write in the file
    //to write an row, that row must me having some value else it gives null error even for write operation as well
    ex.write("X:\\mphasis\\Selenium Training- 2023\\login data.xlsx", "Sheet1", 0, 7,"Passed");
	
	}
}
