package com.shraddha.service;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shraddha.bean.Transaction;
import com.shraddha.persistence.*;
public class TransactionServiceImpl implements TransactionService 
{	
	private TransactionDao transactionDao=new TransactionDaoImpl();
	
	@Override
	public ArrayList<Transaction> getAllTransactions() throws ClassNotFoundException, SQLException {
		return transactionDao.getAllTransactionRecords();
	}

	@Override
	public boolean addTransaction(Transaction t) throws ClassNotFoundException, SQLException {
		return transactionDao.insertTransactionRecord(t);
	}

	@Override
	public Transaction searchTransactionRecordById(int transactionId) throws ClassNotFoundException, SQLException {
		Transaction t=transactionDao.searchTransactionById(transactionId);
		if(t!=null)
			t=convertUpperCase(t);
		return t;
	}

	//Bussiness Logic
	@Override
	public Transaction convertUpperCase(Transaction t) {
		Transaction t1=new Transaction();
		t1.setTransactionId(t.getTransactionId());
		t1.setValDate(t.getValDate());
		t1.setPayerName(t.getPayerName().toUpperCase());
		t1.setPayerAccount(t.getPayerAccount());
		t1.setPayeeName(t.getPayeeName().toUpperCase());
		t1.setPayeeAccount(t.getPayeeAccount());
		t1.setAmount(t.getAmount());
		return t1;
	}


}
