package com.shraddha.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.shraddha.bean.Transaction;
import com.shraddha.presentation.TransactionPresentation;
import com.shraddha.service.*;


public class TransactionPresentationImpl implements TransactionPresentation {

	private TransactionService transactionService = new TransactionServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("1. List All Transaction");
		System.out.println("2. Adding New Transaction");
		System.out.println("3. Search Transaction By ID");
		System.out.println("4. Validations for transaction");
		System.out.println("0. Exit");
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1:
			ArrayList<Transaction> t2=null;
			try {
				t2 = transactionService.getAllTransactions();
			} catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace();
			}
			for (Transaction t : t2) {
				System.out.println(t);
			}
			break;
		case 2:
			Transaction t=new Transaction();
			
			System.out.println("Enter Transaction Id : ");
			t.setTransactionId(scanner.nextLong());
			System.out.println("Enter Value date : ");
			t.setValDate(scanner.nextInt());
			System.out.println("Enter Payer Name : ");
			t.setPayerName(scanner.next());
			System.out.println("Enter payer accountno. : ");
			t.setPayerAccount(scanner.nextLong());
			System.out.println("Enter Payee Name : ");
			t.setPayeeName(scanner.next());
			System.out.println("Enter payee accountno : ");
			t.setPayeeAccount(scanner.nextLong());
			System.out.println("Enter Amount : ");
			t.setAmount(scanner.nextFloat());
			
			try {
				if(transactionService.addTransaction(t))
					System.out.println("Transaction Insertion Successful!");
				else
					System.out.println("Transaction Insertion Failed!");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Enter TRansaction ID whoes Record you want to search for : ");
			long tId=scanner.nextLong();
	        Transaction sh=null;
			try {
				sh = transactionService.searchTransactionRecordById(tId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sh!=null) {
				System.out.println(sh);
			}
			else {
				System.out.println("Transaction with id "+tId+" does not exist");
			}
			break;
		case 4:
			try {
				transactionService.validtransaction();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 0:
			System.out.println("Thanks for Using our system, Have a Nice Day!");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");

		}

	}

}

