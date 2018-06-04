package functions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class List {

	public void list() {

		try
		{
			//FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
			FileInputStream file = new FileInputStream(new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\Users\\Users.xlsx"));
			
			
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
					}
				}
				System.out.println("");
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public String[][] listUserPass() {

		try
		{
			//FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
			FileInputStream file = new FileInputStream(new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\Users\\Users.xlsx"));
			
			
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			int fila=0;
			int col=0;
			String[][] userPass = new String[100][4];
			
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							//System.out.print(cell.getNumericCellValue() + "\t");
							//userPass[fila][col] = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							userPass[fila][col] = cell.getStringCellValue();
							//System.out.println(userPass[fila][col]);
							col++;
							break;
					}
					
				}
				fila++;
				col=0;
			}
			file.close();
			/*for(int i=0;i<fila;i++) {
				for(int o=0;o<2;o++) {
					System.out.println(userPass[i][o]);
				}
			}*/
			return userPass;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;		
	}
	
	public String[][] listPayRec() {

		try
		{
			//FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
			FileInputStream file = new FileInputStream(new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\Users\\Users.xlsx"));
			
			
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			int fila=0;
			int col=0;
			String[][] userPass = new String[100][5];
			
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case Cell.CELL_TYPE_NUMERIC:
							//System.out.print(cell.getNumericCellValue() + "\t");
							//userPass[fila][col] = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							userPass[fila][col] = cell.getStringCellValue();
							//System.out.println(userPass[fila][col]);
							col++;
							break;
					}
					
				}
				fila++;
				col=0;
			}
			file.close();
			/*for(int i=0;i<fila;i++) {
				for(int o=0;o<2;o++) {
					System.out.println(userPass[i][o]);
				}
			}*/
			return userPass;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;		
	}	
	
	

}
