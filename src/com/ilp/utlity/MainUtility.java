package com.ilp.utlity;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.BankServices;

public class MainUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   mainMenu();

	}

	private static void mainMenu() {
		// TODO Auto-generated method stub
		ArrayList<Service> serviceList=new ArrayList<Service>();
		ArrayList<Product> productList=new ArrayList<Product>();
		ArrayList<Account> accountList=new ArrayList<Account>();
		Customer customer=null;
		System.out.println("******Welcome To Bank************");
		char mainChoice='y';
		do {
			
		System.out.println("1.Create Service"
				+ "\n"
				+ "2.Create Product"
				+ "\n"
				+ "3.Create Customer"+"4.Manage Accounts"+"\n"

                +"5.Display Customer"+"\n"

                +"6.Exit");
		Scanner scanner = new Scanner(System.in);
		int choice;
		choice= scanner.nextInt();
		
	
	    
		switch(choice) {
		case 1: serviceList.add( BankServices.createService());
		      // System.out.println(serviceList);
		       
		        break;
		case 2:productList.add(BankServices.createProduct(productList, serviceList));
		//System.out.println(productList);
		     break;
		case 3:customer=BankServices.createCustomer(customer,productList,accountList);
		System.out.println(customer);
		break;
		case 4:BankServices.manageAccount(customer,accountList);
		break;
		case 5:BankServices.displayCustomer(customer,accountList);
		break;
		
			
		}
		System.out.println("Do you want to contiune:");
		mainChoice=scanner.next().charAt(0);
		
		}while(mainChoice=='y'||mainChoice=='Y');
	}

}
