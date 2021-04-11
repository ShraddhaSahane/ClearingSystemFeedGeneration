package com.shraddha.bean;

public class Transaction 
{
	private int transactionId;
	private int valDate;
	private String payerName;
	private int payerAccount;
	private String payeeName;
	private int payeeAccount;
	private float amount;
     
	public Transaction() {
		
	}
	
	public Transaction(int transactionId, int valDate, String payerName, int payerAccount, String payeeName,
			int payeeAccount, float amount) {
		super();
		this.transactionId = transactionId;
		this.valDate = valDate;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getValDate() {
		return valDate;
	}
	public void setValDate(int valDate) {
		this.valDate = valDate;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public int getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(int payerAccount) {
		this.payerAccount = payerAccount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(int payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", valDate=" + valDate + ", payerName=" + payerName
				+ ", payerAccount=" + payerAccount + ", payeeName=" + payeeName + ", payeeAccount=" + payeeAccount
				+ ", amount=" + amount + "]";
	}
}
