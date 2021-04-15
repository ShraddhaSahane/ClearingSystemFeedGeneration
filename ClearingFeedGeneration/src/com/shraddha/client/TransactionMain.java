package com.shraddha.client;
import java.util.Scanner;
import com.shraddha.presentation.*;

public class TransactionMain 
{
	public static void main(String[] args) {
		TransactionPresentation transactionPresentation=new TransactionPresentationImpl();
	
		Scanner scanner=new Scanner(System.in);
		while(true) {
			transactionPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			transactionPresentation.performMenu(choice);
			
		}

	}
}
