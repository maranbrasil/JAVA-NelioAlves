package com.example.nelioalvesjava;

import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);

		System.out.println("Quantos números você vai digitar? ");
		int n = sc.nextInt();
		double vect[] = new double[n]; // para inicializar um vetor, eu coloco [] depois do nome do vetor e inicializo new int[quantidade de itens do vetor]

		for (int i=0; i<n; i++) {
			System.out.printf("Digite um número: ");
			double number = sc.nextDouble();
			vect[i] = number;
		}

		double sum = 0;

		for (int i=0; i<n; i++) {
			sum += vect[i];
		}
		double average = sum / n;

		System.out.printf("SOMA = %.2f%n",sum);
		System.out.printf("MÉDIA = %.2f",average);
		sc.close();
	}
}