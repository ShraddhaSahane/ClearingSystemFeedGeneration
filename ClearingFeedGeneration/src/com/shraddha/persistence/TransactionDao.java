package com.shraddha.persistence;
import com.shraddha.bean.*;
import java.sql.SQLException;
import java.util.ArrayList;
public interface TransactionDao {


	public ArrayList<Transaction> getAllTransactionRecords() throws ClassNotFoundException ,SQLException;
	public boolean insertTransactionRecord(Transaction t)throws ClassNotFoundException ,SQLException;
	Transaction searchTransactionById(int transactionId)throws ClassNotFoundException ,SQLException;

}

