package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AddUser {

	public void add(String user, String password) {
		try {
			// Load Workbook
			FileInputStream file = new FileInputStream(
					new File("C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\Users\\Users.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first sheet
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				i++;
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					}
				}
				System.out.println("");
				file.close();
			}
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(user);
			cell = row.createCell(1);
			cell.setCellValue(password);

			try {
				// Write the workbook in file system
				FileOutputStream out = new FileOutputStream(
						"C:\\Users\\usuario.usuario-PC\\Desktop\\Assistant\\Users\\Users.xlsx");
				workbook.write(out);
				out.close();
				System.out.println("User correctly added.");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
