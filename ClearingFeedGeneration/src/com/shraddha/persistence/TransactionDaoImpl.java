package com.shraddha.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.shraddha.bean.*;
public class TransactionDaoImpl implements TransactionDao 
{
	@Override
	public ArrayList<Transaction> getAllTransactionRecords() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/clearingsystem", "root", "2001");
		PreparedStatement preparedStatement=connection.prepareStatement("select * from Transaction");
		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
		while(resultSet.next())
		{
			Transaction t=new Transaction();
			t.setTransactionId(resultSet.getInt("transactionId"));
			t.setValDate(resultSet.getInt("valDate"));
			t.setPayerName(resultSet.getString("payerName"));
			t.setPayerAccount(resultSet.getInt("payerAccount"));
			t.setPayeeName(resultSet.getString("payeeName"));
			t.setPayeeAccount(resultSet.getInt("payeeAccount"));
			t.setAmount(resultSet.getFloat("amount"));
			transactionList.add(t);
		}
		connection.close();
		return transactionList;
	}
	@Override
	public boolean insertTransactionRecord(Transaction t) throws ClassNotFoundException, SQLException {
				//JDBC Code
				//1 Connect
				//1.1 Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//1.2 Connect to DB
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/clearingsystem", "root", "2001");
				
				//2. Query
				PreparedStatement preparedStatement=connection.prepareStatement("insert into transaction values(?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, t.getTransactionId());
				preparedStatement.setInt(2, t.getValDate());
				preparedStatement.setString(3, t.getPayerName());
				preparedStatement.setInt(4, t.getPayerAccount());
				preparedStatement.setString(5, t.getPayeeName());
				preparedStatement.setInt(6, t.getPayeeAccount());
				preparedStatement.setInt(7, t.getPayeeAccount());
				//executeUpdate() is used to execute DML Query : Data Manipulation Language (Insert, delete, update)
				int rows=preparedStatement.executeUpdate();
				
				connection.close();
				
				if(rows>0)
					return true;
				
				return false;
	}
	public Transaction searchTransactionById(int transactionId) throws ClassNotFoundException, SQLException {
		//JDBC Code
				//1 Connect
				//1.1 Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//1.2 Connect to DB
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/clearingsystem", "root", "2001");
				
				//2. Query
				PreparedStatement preparedStatement=connection.prepareStatement("select * from transaction where transactionId=?");
				preparedStatement.setInt(1,transactionId);
				
				//executeQuery() is used to execute DQL Query : select
				ResultSet resultSet=preparedStatement.executeQuery();
				
				Transaction t=null;
				
				if(resultSet.next()) {
					t=new Transaction();
					t.setTransactionId(resultSet.getInt("transactionId"));
					t.setValDate(resultSet.getInt("valDate"));
					t.setPayerName(resultSet.getString("payerName"));
					t.setPayerAccount(resultSet.getInt("payerAccount"));
					t.setPayeeName(resultSet.getString("payeeName"));
					t.setPayeeAccount(resultSet.getInt("payeeAccount"));
					t.setAmount(resultSet.getFloat("amount"));
				}
					
		return t;
	}

}
