package com.example.nelioalvesjava;

import Entities2.Department;
import Entities2.HourContract;
import Entities2.Worker;
import Entities2.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		// apos ter todos os dados pra inicializar um worker, a gente pode inicializar com os valores obtidos.

		System.out.print("How many contracts to this worker: ");
		int numberOfContracts = sc.nextInt();

		for (int i=0; i<numberOfContracts; i++) {
			System.out.printf("Enter contract: #%d  data: ", i+1);
			System.out.println();
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			// cada contrato gerado deve ser primeiramente instanciado
			worker.addContract(contract);
		}

		System.out.println();
		System.out.println("Enter Month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.print("income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
	}
}
