package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ClearingSystem 
{     
    public static void main(String[] args) throws IOException 
    {
        String excelFilePath = "C:\\Users\\SHRADDHA\\eclipse-workspace\\newworkspace\\ClearingSystem\\data\\Textdata.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext())
        {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();     
            while (cellIterator.hasNext()) 
            {
                Cell cell =(Cell) cellIterator.next();
                switch (cell.getCellType())
                {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }
 
}
