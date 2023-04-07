package com.example.nelioalvesjava;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> taxPayersList = new ArrayList<TaxPayer>();

		System.out.print("Enter with number of tax payers: ");
		int N = sc.nextInt();
		System.out.println();

		for (int j=1; j<=N; j++) {
			System.out.printf("Tax payer #%d", j);
			System.out.println();

			System.out.print("Individual or Company? (i/c) ");
			char taxPayerType = sc.next().charAt(0);

			System.out.print("Name: ");
			String name = sc.next();

			System.out.print("Annual Income: ");
			Double annualIncome = sc.nextDouble();

			if (taxPayerType == 'c') {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				Company comp = new Company(name, annualIncome, numberOfEmployees);
				taxPayersList.add(comp);
			} else {
				System.out.print("Health expenses: ");
				Double healthExpenses = sc.nextDouble();
				Individual ind = new Individual(name, annualIncome, healthExpenses);
				taxPayersList.add(ind);
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		double sum = 0;
		for (TaxPayer taxPayer : taxPayersList) {
			sum += taxPayer.taxToPay();
			System.out.printf("%s - %.2f", taxPayer.getName(), taxPayer.taxToPay());
			System.out.println();
		}
		sc.close();
	}
}
