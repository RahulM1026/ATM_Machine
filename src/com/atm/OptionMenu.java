package com.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {

	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	int Selection;

	// Validate Login
	public void getLogin() throws IOException {
		int x = 1;

		while (x <= 2) {
			try {

				data.put(1234567, 1111);
				data.put(9876543, 2561);

				System.out.println("Welcome to the ATM Machine");

				System.out.println("Enter Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				if (!(data.containsKey(getCustomerNumber()))) {
					System.out.println("Please Enter Valid Customer Number");
					setCustomerNumber(menuInput.nextInt());
					break;
				}

				System.out.println("Enter Pin Number: ");
				setPinNumber(menuInput.nextInt());
				if (!(data.containsValue(GetPinNumber()))) {
					System.out.println("Please Enter Valid PIN");
					setPinNumber(menuInput.nextInt());
				}
			} catch (Exception e) {
				System.out.println("\n" + "Invalid Characters. Only Numbers" + "\n");
				x++;
			}

			for (Entry<Integer, Integer> entry : data.entrySet()) {
				if (entry.getKey() == getCustomerNumber() && entry.getValue() == GetPinNumber()) {
					getAccountType();
					break;
				} else {
					System.out.println("\n" + "Wrong customer Number or Pin number. " + "\n");
					break;
				}
			}
			x++;
		}
	System.out.println("Maximum Limit reached for Customer Number/PIN");
	}

	// Display Account Type with Selection Menu
	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Current Account: ");
		System.out.println("Type 2 - Saving Account: ");
		System.out.println("Type 3 - Exit ");
		System.out.println("Choice: ");

		Selection = menuInput.nextInt();

		switch (Selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank You for Using ATM Machine, Bye.\nPlease Visit Again");
			break;
		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getAccountType();
		}
	}

	// Display Checking Account Menu with Selection
	public void getChecking() {
		System.out.println("Current Account: ");
		System.out.println("Type 1 - View Balance: ");
		System.out.println("Type 2 - Withdraw Funds: ");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit ");
		System.out.println("Choice: ");

		Selection = menuInput.nextInt();

		switch (Selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckBalance()));
			getAccountType();
			break;

		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thank You for Using ATM Machine, Bye.\nPlease Visit Again");
			break;
		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getChecking();
		}
	}

	// Display Saving Amount Menu
	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance: ");
		System.out.println("Type 2 - Withdraw Funds: ");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit ");
		System.out.println("Choice: ");

		Selection = menuInput.nextInt();

		switch (Selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You for Using ATM Machine, Bye.\n Please Visit Again");
			break;
		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getSaving();
		}
	}

}
