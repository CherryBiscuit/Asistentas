package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CRQ {

	public String[][] list() {

		try {
			// FileInputStream file = new FileInputStream(new
			// File("howtodoinjava_demo.xlsx"));
			FileInputStream file = new FileInputStream(
					new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\CRQs\\CRQs.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			int fila = 0;
			int col = 0;
			String[][] crq = new String[100][6];
			String[][] crqReturn = new String[100][6];

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();
				if (fila == 0) {
					row = rowIterator.next();
				}
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// Check the cell type and format accordingly
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						// System.out.print(cell.getNumericCellValue() + "\t");
						crq[fila][col] = Double.toString(cell.getNumericCellValue());
						System.out.println("alguno es numero");
						col++;
						break;
					case Cell.CELL_TYPE_STRING:
						// System.out.print(cell.getStringCellValue() + "\t");
						crq[fila][col] = cell.getStringCellValue().trim();
						if (crq[fila][col].isEmpty()) {
							//System.out.print(cell.getStringCellValue() + "\t");
						}
						// System.out.println(userPass[fila][col]);
						col++;

					}

				}
				fila++;
				col = 0;
			}
			file.close();
			int i = 0;
			int h = 0;
			while (crq[i][0] != null) {
				i++;
			}
			i--;
			for (int j = i; j >= 0; j--) {
				for (int o = 0; o <= 5; o++) {
					crqReturn[h][o] = crq[j][o];
				}
				h++;
			}
			return crqReturn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addCRQ(String date, String crq, String status, String observations, String pid) {
		try
		{
			int ID =0;
			//FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
			FileInputStream file = new FileInputStream(new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\CRQs\\CRQs.xlsx"));
			
			
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			
			CreationHelper createHelper = workbook.getCreationHelper();
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			Row row= sheet.getRow(0);
										
			while (rowIterator.hasNext()) {

				row = rowIterator.next();
			
			}
					
			
		    //Sheet sheet2 = workbook.createSheet("new sheet");
			ID=(int) row.getCell(0).getNumericCellValue();
			
		    // Create a row and put some cells in it. Rows are 0 based.
		    Row newRow = sheet.createRow(row.getRowNum()+1);
		    // Create a cell and put a value in it.
		    newRow.createCell(0).setCellValue(ID+1);
		    newRow.createCell(1).setCellValue(date);
		    newRow.createCell(2).setCellValue(crq);
		    newRow.createCell(3).setCellValue(status);
		    newRow.createCell(4).setCellValue(observations);
		    newRow.createCell(5).setCellValue(pid);
		    // Or do it on one line.
		    /*row.createCell(1).setCellValue(1.2);
		    row.createCell(2).setCellValue(
		         createHelper.createRichTextString("This is a string"));
		    row.createCell(3).setCellValue(true);*/

		    // Write the output to a file
		    file.close();
		    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\CRQs\\CRQs.xlsx");
		    workbook.write(fileOut);
		    fileOut.close();
			

			}catch(Exception e) {
					e.printStackTrace();
			}

		}
}