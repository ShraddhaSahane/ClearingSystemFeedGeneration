package com.shraddha.service;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shraddha.bean.*;
import com.shraddha.persistence.TransactionDao;
import com.shrddha.persistence.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService {

	private TransactioneDao transactiondao=new TransactionDaoImpl();
	
	@Override
	public ArrayList<Share> getAllTransactionRecords() throws ClassNotFoundException, SQLException {
		return shareDao.getAllTransactionRecords();
	}
