package com.example.nelioalvesjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class NelioAlvesJavaApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter with the number of products: ");
		int n = sc.nextInt();

		Product[] vect = new Product[n];

		for (int i=0; i<n; i++) {
			sc.nextLine();
			String name = sc.nextLine();
			double price = sc.nextDouble();
			vect[i] = new Product(name, price); // aqui eu utilizo o construtor com 2 elementos.
		}

		double sum = 0.0;

		for (int i=0; i<n; i++) {
			sum = vect[i].getPrice();
		}

		double avg = sum / n;
		System.out.printf("The average price is: %.2f%n", avg);

		sc.close();
	}

}
