package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Validation extends ClearingSystem
{
		private  long transactionId;
		private int valDate;
		private String payerName;
		private long payerAccount;
		private String payeeName;
		private long payeeAccount;
		private float amount;
		public Validation() {
			
		}
	     
		public Validation(long transactionId, int valDate, String payerName, long payerAccount, String payeeName,
				long payeeAccount, float amount) {
			super();
			this.transactionId = transactionId;
			this.valDate = valDate;
			this.payerName = payerName;
			this.payerAccount = payerAccount;
			this.payeeName = payeeName;
			this.payeeAccount = payeeAccount;
			this.amount = amount;
		}

		public long getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(long transactionId) {
			this.transactionId = transactionId;
		}
		public int getValDate() {
			return valDate;
		}
		public void setValDate(int valDate) {
			this.valDate = valDate;
		}
		public String getPayerName() {
			return payerName;
		}
		public void setPayerName(String payerName) {
			this.payerName = payerName;
		}
		public long getPayerAccount() {
			return payerAccount;
		}
		public void setPayerAccount(long payerAccount) {
			this.payerAccount = payerAccount;
		}
		public String getPayeeName() {
			return payeeName;
		}
		public void setPayeeName(String payeeName) {
			this.payeeName = payeeName;
		}
		public long getPayeeAccount() {
			return payeeAccount;
		}
		public void setPayeeAccount(long payeeAccount) {
			this.payeeAccount = payeeAccount;
		}
		public float getAmount() {
			return amount;
		}
		public void setAmount(float amount) {
			this.amount = amount;
		}
		
		@Override
		public String toString() {
			return "Transaction [transactionId=" + transactionId + ", valDate=" + valDate + ", payerName=" + payerName
					+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
					+ ", amount=" + amount + "]";
		}
		public void validateTransaction() throws SQLException,ClassNotFoundException, IOException
		{
			boolean valid =false;
			String excelFilePath = "C:\\Users\\SHRADDHA\\eclipse-workspace\\newworkspace\\ClearingSystem\\data\\Textdata.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();
//for each row in the table
			while(iterator.hasNext()) 
			{
				 Row nextRow = iterator.next();
			     Iterator<Cell> cellIterator = nextRow.cellIterator();     
			     while (cellIterator.hasNext()) 
			     {
			           Cell cell =(Cell) cellIterator.next();
			           switch (cell.getCellType())
			           {
			                case STRING:
			                	String s=cell.getStringCellValue();
			                	valid=ValidateAlphaNumeric(s);
			                	if(valid)
			                	{
			                		System.out.print(cell.getStringCellValue());
			                	}
			                    break;
			                case BOOLEAN:
			                    System.out.print(cell.getBooleanCellValue());
			                    break;
			                case NUMERIC:
			                	long data=(long) cell.getNumericCellValue();
								valid=ValidateNumber(data);
								if(valid)
								{
									System.out.print(cell.getNumericCellValue());
								}
			                    break;
			            }
			            System.out.print(" - ");
			        }
			        System.out.println();
			        if(valid) {
						System.out.println("Success");
					}
					else {
						System.out.println("Failure");
					}
			}
		}
		 public static  boolean ValidateAlphaNumeric(String s)
	     {
			 return s != null && s.matches("^[a-zA-Z0-9]*$");

	         //return (Regex.IsMatch(text, "^[a-zA-Z0-9]*$"));
	     }
		public static  boolean ValidateNumber(long s)
	     {
			 return true;
	     }
		public static boolean ValidateAmount(String amount)
	     {
			 boolean num =true;
	         String[] amountSplit=amount.split(".");
	         if(amountSplit[0].length() > 10)
	         {
	             num = false;   
	         }
	         if(num)
	         {
	             if (amountSplit[1].length() > 2)
	             {
	                 num = false;
	             }
	         }
	         if (num)
	         {
	        	 int i=Integer.parseInt(amount);
	             if (i<0)
	             {
	                 num = false;
	             }
	         }
	         return num;
	     }
		/*public void validateTransaction() throws SQLException,ClassNotFoundException, IOException
		{
			try
			{
			boolean valid =false;
			String excelFilePath = "C:\\Users\\SHRADDHA\\eclipse-workspace\\newworkspace\\ClearingSystem\\data\\Textdata.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet firstSheet = workbook.getSheet("Transaction Referance");
			int rowCount=firstSheet.getLastRowNum()-firstSheet.getFirstRowNum();
			for(int i=0;i<=rowCount;i++){
	            
	            //get cell count in a row
	            int cellcount=firstSheet.getRow(i).getLastCellNum();
	            
	            //iterate over each cell to print its value
	            System.out.println("Row"+ i+" data is :");
	            
	            for(int j=0;j<cellcount;j++){
	                System.out.print(firstSheet.getRow(i).getCell(j).getStringCellValue() +",");
	            }
	            System.out.println();
	        }
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
	    }
		public void addCell() throws FileNotFoundException, IOException
		{
			String excelFilePath = "C:\\Users\\SHRADDHA\\eclipse-workspace\\newworkspace\\ClearingSystem\\data\\Textdata.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(0);
		//	XSSFWorkbook workbook = new XSSFWorkbook();
			//Workbook wb = new XSSFWorkbook();
			CreationHelper createHelper = workbook.getCreationHelper();
			//Sheet sheet = workbook.createSheet("new sheet");
			// Create a row and put some cells in it. Rows are 0 based.
			Row row = firstSheet.getRow(0);
			// Create a cell and put a value in it.
			Cell cell = row.createCell(7);
			cell.setCellValue("Success/Fail");
			System.out.println("hello everybody");
			try (OutputStream fileOut = new FileOutputStream("Textdata.xls")) {
			    workbook.write(fileOut);
			}
			
		 		}*/
		public void update()
		{
			try {
				String excelFilePath = "C:\\Users\\SHRADDHA\\eclipse-workspace\\newworkspace\\ClearingSystem\\data\\Textdata.xlsx";
		        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		        Workbook workbook = new XSSFWorkbook(inputStream);
		        Sheet firstSheet = workbook.getSheetAt(0);

	          
	            Cell cell = null;

	       
	            Row row = firstSheet.getRow(0);
	            row.createCell(7).setCellValue("Success/fail");

	            inputStream.close();

	            FileOutputStream outFile =new FileOutputStream(new File("C:\\update.xls"));
	            workbook.write(outFile);
	            outFile.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		public static void main(String []args) throws IOException, ClassNotFoundException, SQLException 
		{
			Validation v=new Validation();
			v.read();
			//v.update();
			//v.addCell();
			//v.read();
			v.validateTransaction();
		}
}

