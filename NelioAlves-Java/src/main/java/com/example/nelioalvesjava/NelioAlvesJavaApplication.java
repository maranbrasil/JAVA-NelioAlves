package com.example.nelioalvesjava;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(50.0);
		System.out.printf("acc1 = %.2f", acc1.getBalance());

		System.out.println();

		Account acc2 = new SavingAccount(1002, "Maria", 1000.0, 0.01);
		acc2.withdraw(50.0);
		System.out.printf("acc2 = %.2f",acc2.getBalance());
	}
}
