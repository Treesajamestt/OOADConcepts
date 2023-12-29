package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class BankServices {



	public static Service createService() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter service code: ");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter service Name: ");
		String serviceName = scanner.nextLine();
		System.out.println("Enter service rate: ");
		int rate = scanner.nextInt();
		Service service=new Service(serviceCode,serviceName,rate);
		return service;
	}

	
	public static Product createProduct(ArrayList<Product> productList, ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
         Product product = null;
 		 ArrayList<Service> productServiceList = new ArrayList<Service>();
Scanner scanner = new Scanner(System.in);
 
		
		System.out.println("Enter Product Code :");
		String productCode = scanner.nextLine();
		
		System.out.println("Enter Product Name :");
		String productName = scanner.nextLine();
		char serviceChoice;
		
		
		do {
			
		
		System.out.println("Enter Service you want to attach? :");
		
		
			
		
		
		for (Service service : serviceList) {
            System.out.println("Service Code: " + service.getServiceCode());
        }
        
        System.out.println("Enter the service needed for product from service list above");
        
        String serviceCode = scanner.nextLine();
        
    	for(Service service:serviceList)
    	{
    		if(service.getServiceCode().equals(serviceCode))
    		{
    			productServiceList.add(service);
    		}
    		
    	}
    	
        System.out.println("Enter the Product you want to attach the service to : ");
        System.out.println();
        System.out.println("Products Available : ");
        System.out.println();
        System.out.println("1.Savings Max Account , 2.Current Account , 3.Loan Account");
        System.out.println();
        
        int productChoice = scanner.nextInt();
        
        switch(productChoice) {
        
        case 1 :
        	
	    	product = new SavingsMaxAccount(productCode,productName,productServiceList);
	    	productList.add(product);
	    	break;
	    
        case 2 :
        	
        	product = new CurrentAccount(productCode, productName, productServiceList);
	    	productList.add(product);
        	break;
        	
        case 3 :
        	
        	product = new LoanAccount(productCode, productName, productServiceList);
	    	productList.add(product);
        	break;
        	
        default :
        	
        	System.out.println("Product not identified");
        	break;
        	
        	
		}
        
        System.out.println("Do you want to attach another service? ('y/n)");
        serviceChoice = scanner.next().charAt(0);				
		
	}while(serviceChoice == 'y'||serviceChoice=='Y');
		return product;
 
}


	public static Customer createCustomer(Customer customer, ArrayList<Product> productList,
			ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accountList1=new ArrayList<Account>();
		System.out.println("Enter customer code: ");
		String customercode = scanner.nextLine();
		System.out.println("Customer Id not available.Create a new Account");
		char accountChoice;
		do {
		System.out.println("Which type of account do you want");
		for(Product product:productList) {
			System.out.println(product.getProductName());
		}
		System.out.println("Enter the Choice for Product:\n 1.Current \n2.Savings \n3.Loan");
		int productChoice = scanner.nextInt();
		System.out.println("Enter account number");
		scanner.nextLine();
		String accountNo = scanner.nextLine();
//		System.out.println("Enter account type");
//		scanner.nextLine();
//		String accountType = scanner.nextLine();
		System.out.println("Enter account balance");
		double balance = scanner.nextDouble();
		Account account;
		switch(productChoice) {
		case 1:
			
			account = new Account(accountNo, productList.get(0).getProductName(),balance,productList.get(0));
			accountList.add(account);
			System.out.println("CURRENT Account Created");
			break;
			
		case 2:
			
			account = new Account(accountNo, productList.get(1).getProductName(),balance,productList.get(1));
			accountList.add(account);
			System.out.println("SAVINGS Account Created");
			break;
			
        case 3:
			
			account = new Account(accountNo, productList.get(2).getProductName(),balance,productList.get(2));
			accountList.add(account);
			System.out.println("LOAN Account Created");
			break;
		
		}System.out.println("Do you want to create another Account?(y/n)");
		accountChoice = scanner.next().charAt(0);
		}while(accountChoice == 'y');
		
		System.out.println("Customer Code");
		scanner.nextLine();
		String customerCode = scanner.nextLine();
		System.out.println("Customer Name");
		String customerName = scanner.nextLine();
		customer = new Customer(customerCode,customerName,accountList);
		
		return customer;
	}


	public static void manageAccount(Customer customer, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		ArrayList<Account> accountList1=customer.getAccountList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer code: ");
		String customercode = scanner.nextLine();
	    System.out.println(customer.getCustomername()+ " has following accounts");
	    
	    	for(Account account:accountList1) {
	    		//System.out.println("?????");
	    		System.out.println(account.getAccounttype());
	    	}
	    	System.out.println("Enter your Choice:" );
	    	String accountChoice=scanner.nextLine();
	    	for(Account account:accountList1) {
	    		if(account.getAccountNo().equals(accountChoice)) {
	    		 manageCustomerAccount(account);	
	    		}
	    		
	    	}
	   
	    
		
	}


	private static void manageCustomerAccount(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    if(account.getProduct() instanceof SavingsMaxAccount||account.getProduct() instanceof CurrentAccount) {
	    	System.out.println();
	    	System.out.println("Enter the choice from \n 1.Deposit \n 2.Withdraw \n 3.Display");
			int manageChoice=scanner.nextInt();
			switch(manageChoice) {
			case 1:depositMoney(account);
			break;
			case 2:withdrawMoney(account);
			break;
			case 3:displayBalance(account);
			}
	    }
	    else if(account.getProduct() instanceof LoanAccount){
	    	System.out.println();
	    	System.out.println("Enter the choice from \n 2.Withdraw \n 3.Display");
			int manageChoice=scanner.nextInt();
			switch(manageChoice) {
			case 1:depositMoney(account);
			break;
			case 2:displayBalance(account);
			break;
			}
	    }
	}


	private static void displayBalance(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Balance is"+account.getAccountbal());
	}


	private static void withdrawMoney(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to be withdrawed");
		int withdrawMoney=scanner.nextInt();
		account.setAccountbal(account.getAccountbal()-withdrawMoney);
		if(account.getProduct() instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsmaxaccount=(SavingsMaxAccount)account.getProduct();
			if((account.getAccountbal())>1000) {
				System.out.println("minimum balance should be maintained");
				return;
			}
			
				System.out.println("Your Balance is"+(account.getAccountbal()));
	
			
		}
		System.out.println("Balance is "+ (account.getAccountbal()));
	}


	private static void depositMoney(Account account) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		if(account.getProduct() instanceof LoanAccount) {
			LoanAccount loanaccount=(LoanAccount)account.getProduct();
			System.out.println("Enter the amount to be deposit");
			int depositMoney=scanner.nextInt();
			System.out.println("Enter Type of Deposit \n 1.Cash Deposit \n2.Cheque Deposit");
			int depositChoice=scanner.nextInt();
			account.setAccountbal(account.getAccountbal()+depositMoney);
			switch(depositChoice) {
			case 1:System.out.println("Balance is "+ (account.getAccountbal()));
			break;
			case 2:System.out.println("Balance is "+ (account.getAccountbal()+(depositMoney-=loanaccount.getChequeDeposit())));
			break;
			}
			
		}
		System.out.println("Enter the amount to be deposit");
		int depositMoney=scanner.nextInt();
		System.out.println("Balance is "+ (account.getAccountbal()+depositMoney));
	}


	public static void displayCustomer(Customer customer, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accountList1=customer.getAccountList();
		System.out.println("Enter customer code: ");
		String customercode = scanner.nextLine();
		if(customer.getCustomercode().equals(customercode)) {
			System.out.println("*************************Customer-Account Details****************");
			System.out.println("CustomerId \t\t\t\tCustomerName \t\t\t\tAccountType \t\t\t\tBalance");
			System.out.println("***************************************************************");
//			System.out.println(customer.getCustomercode()+" \t\t\t\t"+customer.getCustomername()+" \t\t\t\t");
			for(Account account:accountList) {
				System.out.println(customer.getCustomercode()+" \t\t\t"+customer.getCustomername()+" \t\t\t"+
				account.getAccounttype()+"\t\t\t"+account.getAccountbal());
			}
			
			
		}
	}

	}

