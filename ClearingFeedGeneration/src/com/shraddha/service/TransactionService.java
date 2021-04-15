package com.shraddha.service;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shraddha.bean.Transaction;
public interface TransactionService 
{
	ArrayList<Transaction> getAllTransactions() throws ClassNotFoundException ,SQLException;
	Transaction searchTransactionRecordById(int transactionId)throws ClassNotFoundException ,SQLException;
	Transaction convertUpperCase(Transaction t);
	boolean addTransaction(Transaction t) throws ClassNotFoundException, SQLException;
}
