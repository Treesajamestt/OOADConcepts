package com.ilp.entity;

public class Account {
	private String accountNo;
	private String accounttype;
	private double accountbal;
	private Product product;
	
	
	
	public Account(String accountNo, String accounttype, double accountbal, Product product) {
		super();
		this.accountNo = accountNo;
		this.accounttype = accounttype;
		this.accountbal = accountbal;
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accounttype=" + accounttype + ", accountbal=" + accountbal
				+ ", product=" + product + "]";
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getAccountbal() {
		return accountbal;
	}
	public void setAccountbal(double accountbal) {
		this.accountbal = accountbal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
