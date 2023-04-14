package com.example.nelioalvesjava;

import Entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int accountNumber = sc.nextInt();
		sc.nextLine();

		System.out.print("Holder: ");
		String holder = sc.nextLine();

		System.out.print("Initial Balance: ");
		Double balance = sc.nextDouble();

		System.out.print("Withdraw Limit: ");
		Double withdrawLim = sc.nextDouble();

		Account account = new Account(accountNumber, holder, balance, withdrawLim);

		System.out.println();
		System.out.print("Enter amount to withdraw: ");
		Double amount = sc.nextDouble();

		if (amount > account.getWithdrawLim()) {
			System.out.println("Withdraw error: the requested amount exceed withdraw limit.");
		} else if (account.getBalance() < amount) {
			System.out.println("Withdraw Error: insufficient amount in your account ");
		} else {
			account.withdraw(amount);
			System.out.printf("New balance: %.2f%n", account.getBalance());
		}
		sc.close();
	}
}
