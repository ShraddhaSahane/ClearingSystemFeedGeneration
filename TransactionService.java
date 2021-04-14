package com.shraddha.service;
import java.sql.SQLException;
	import java.util.ArrayList;

	import com.shraddha.bean.*;

public interface TransactionService {
ArrayList<Transaction> getAllTransactionRecords() throws ClassNotFoundException ,SQLException;
		
}
