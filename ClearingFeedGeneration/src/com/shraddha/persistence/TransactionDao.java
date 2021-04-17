package com.shraddha.persistence;
import com.shraddha.bean.*;
import java.sql.SQLException;
import java.util.ArrayList;
public interface TransactionDao {


	public ArrayList<Transaction> getAllTransactionRecords() throws ClassNotFoundException ,SQLException;
	public boolean insertTransactionRecord(Transaction t)throws ClassNotFoundException ,SQLException;
	Transaction searchTransactionById(long transactionId)throws ClassNotFoundException ,SQLException;
	public void validateTransaction() throws ClassNotFoundException ,SQLException;
}
