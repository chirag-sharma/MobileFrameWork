package rough;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	//public static XSSFWorkbook wb;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("./src/test/resources/readExcel.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheet("Sheet1");
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
			HashSet hs = new HashSet();
			
			
			for(int i=1; i<=rowCount;i++) {
				ArrayList<String> ls = new ArrayList<String>();
				for(int j=0; j<colCount; j++) {
					
					Cell cell = sheet.getRow(i).getCell(j);
					if(cell.getCellType()== CellType.STRING) {
						ls.add(cell.getStringCellValue());
					}
					else if(cell.getCellType()== CellType.NUMERIC) {
						ls.add(String.valueOf(cell.getNumericCellValue()));
					}
					
				}
				al.add(ls);
			}
			System.out.println(al);
			System.out.println(hs);
			
			DAO.executeStoredProc(al.get(0));
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
