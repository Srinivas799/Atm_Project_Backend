package com.srini.services;

import java.util.Scanner;

import com.srini.model.Atm;

public class AtmServicesImpl implements AtmServices {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public boolean DepositeMoney() {
		return dao.Deposite();
	}

	@Override
	public boolean Withdraw() {
		return dao.Withdraw();
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean OpenAccount() {
		return dao.OpenAccount();
	}

	@Override
	public boolean MiniStatement() {
		return dao.MiniStatement();
	}

	@Override
	public boolean BalanceEnquery() {
		return dao.BalanceEnquery();
	}

	@Override
	public void menu() {
		while(true)
		{
			System.out.println("Enter 0 for Exit");
			System.out.println("Enter 1 for Withdraw");
			System.out.println("Enter 2 for Deposite");
			System.out.println("Enter 3 for Open Account");
			System.out.println("Enter 4 for Mini Statement");
			System.out.println("Enter 5 for Balance Enquery");
			System.out.println("Please Enter Your Choice");
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) {
			case 0 : System.exit(choice);
			case 1 : Withdraw();break;
			case 2 : DepositeMoney();break;
			case 3 : OpenAccount();break;
			case 4 : MiniStatement();break;
			case 5 : BalanceEnquery();break;
			default : System.out.println("Sorry...!!! You have entered a wrong choice...");
			}
		}
	}

}
