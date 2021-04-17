package com.shraddha.service;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shraddha.bean.Transaction;
public interface TransactionService 
{
	ArrayList<Transaction> getAllTransactions() throws ClassNotFoundException ,SQLException;
	Transaction searchTransactionRecordById(Long transactionId)throws ClassNotFoundException ,SQLException;
	Transaction convertUpperCase(Transaction t);
	boolean addTransaction(Transaction t) throws ClassNotFoundException, SQLException;
	void  validtransaction() throws ClassNotFoundException ,SQLException;
}
