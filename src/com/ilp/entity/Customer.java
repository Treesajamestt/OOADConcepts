package com.ilp.entity;

import java.util.ArrayList;

public class Customer {
	
	private String customercode;
	private String customername;
	private ArrayList<Account> accountList;
	
//	public Customer(String accountNo, String accounttype, double accountbal, Product product) {
//		super(accountNo, accounttype, accountbal, product);
//		// TODO Auto-generated constructor stub
//		this.customercode=customercode;
//		this.customername=customername;
//		this.accountList=accountList;
//	}
	
	


	public String getCustomercode() {
		return customercode;
	}
	
	@Override
	public String toString() {
		return "Customer [customercode=" + customercode + ", customername=" + customername + ", accountList="
				+ accountList + "]";
	}

	public Customer(String customercode, String customername, ArrayList<Account> accountList) {
	super();
	this.customercode = customercode;
	this.customername = customername;
	this.accountList = accountList;
}

	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	

}
