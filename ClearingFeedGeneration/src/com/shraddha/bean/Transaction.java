package com.shraddha.bean;

public class Transaction 
{
	private  long transactionId;
	private int valDate;
	private String payerName;
	private long payerAccount;
	private String payeeName;
	private long payeeAccount;
	private float amount;
     
	public Transaction() {
		
	}
	
	public Transaction(long transactionId, int valDate, String payerName, long payerAccount, String payeeName,
			long payeeAccount, float amount) {
		super();
		this.transactionId = transactionId;
		this.valDate = valDate;
		this.payerName = payerName;
		this.payerAccount = payerAccount;
		this.payeeName = payeeName;
		this.payeeAccount = payeeAccount;
		this.amount = amount;
	}

	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
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
	public long getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(long payerAccount) {
		this.payerAccount = payerAccount;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public long getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(long payeeAccount) {
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
