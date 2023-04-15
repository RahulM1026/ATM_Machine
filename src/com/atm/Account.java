package com.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

	Scanner sc = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	// set Customer ID
	public int setCustomerNumber(int CustomerNumber) {
		this.CustomerNumber = CustomerNumber;
		return CustomerNumber;
	}

	// get Customer Number
	public int getCustomerNumber() {
		return CustomerNumber;
	}

	// set pin Number
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	// get pin Number
	public int GetPinNumber() {
		return pinNumber;
	}

	// get check account balance
	public double getCheckBalance() {
		return CheckBalance;
	}

	// get Saving account balance
	public double getSavingBalance() {
		return SavingBalance;
	}

	// calculate checking Balance withdraw
	public double calCheckingWithdraw(double amt) {
		CheckBalance = (CheckBalance - amt);
		return CheckBalance;
	}

	// calculate checking Balance Deposit
	public double calCheckingDeposit(double amt) {
		CheckBalance = (CheckBalance + amt);
		return CheckBalance;
	}

	// calculate saving balance withdraw
	public double calSavingWithdraw(double amt) {
		SavingBalance = (SavingBalance - amt);
		return SavingBalance;
	}

	// calculate saving balance Deposit
	public double calSavingDeposit(double amt) {
		SavingBalance = (SavingBalance + amt);
		return SavingBalance;
	}

	// customer checking Account Withdraw input
	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(CheckBalance));
		System.out.println("Amount to Withdraw from Checking Account:");
		double amount = sc.nextDouble();
		if ((CheckBalance - amount) >= 0) {
			calCheckingWithdraw(amount);
			System.out.println("New Account Balance: " + moneyFormat.format(CheckBalance));
		} else {
			System.out.println("Balance cannot be Negative." + "\n");
		}

	}
	
	// customer Saving Account Withdraw input
		public void getSavingWithdrawInput() {
			System.out.println("Saving Account Balance: " + moneyFormat.format(SavingBalance));
			System.out.println("Amount to Withdraw from Saving Account:");
			double amount = sc.nextDouble();
			if ((SavingBalance - amount) >= 0) {
				calSavingWithdraw(amount);
				System.out.println("New Account Balance: " + moneyFormat.format(SavingBalance));
			} else {
				System.out.println("Balance cannot be Negative." + "\n");
			}
		}

		// customer Checking account Deposit
		public void getCheckingDepositInput() {
			System.out.println("Checking Account Balance: " + moneyFormat.format(CheckBalance));
			System.out.println("Amount you Deposit to Checking Account: ");
			double amount = sc.nextDouble();

			if ((CheckBalance + amount) >= 0) {
				calCheckingWithdraw(amount);
				System.out.println("New Account Balance: " + moneyFormat.format(CheckBalance));
			} else {
				System.out.println("Balance cannot be Negative." + "\n");
			}
		}

	
	// customer saving account Deposit
	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(SavingBalance));
		System.out.println("Amount you Deposit to Saving Account: ");
		double amount = sc.nextDouble();

		if ((SavingBalance + amount) >= 0) {
			calSavingWithdraw(amount);
			System.out.println("New Account Balance: " + moneyFormat.format(SavingBalance));
		} else {
			System.out.println("Balance cannot be Negative." + "\n");
		}
	}

	private int CustomerNumber;
	private int pinNumber;
	private double CheckBalance = 0;
	private double SavingBalance = 0;

}
