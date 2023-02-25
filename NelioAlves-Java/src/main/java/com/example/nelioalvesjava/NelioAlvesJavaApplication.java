package com.example.nelioalvesjava;

import java.util.Locale;
import java.util.Scanner;

//	Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois N números inteiros
//	e armazene-os em um vetor. Em seguida, mostrar na tela todos os números negativos lidos.
public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);

		System.out.println("Quantos números vc vai digitar? ");
		int n = sc.nextInt();
		int vect[] = new int[n]; // para inicializar um vetor, eu coloco [] depois do nome do vetor e inicializo new int[quantidade de itens do vetor]

		for (int i=0; i<n; i++) {
			System.out.printf("Digite um número: ");
			int number = sc.nextInt();
			vect[i] = number;
		}

		System.out.println("NUMEROS NEGATIVOS: ");
		for (int i=0; i<n; i++) {
			if (vect[i] < 0) {
				System.out.println(vect[i]);
			}
		}
		sc.close();
	}
}
//System.out.println("Enter with the number of products: ");
//		int n = sc.nextInt();
//
//		Product[] vect = new Product[n];
//
//		for (int i=0; i<n; i++) {
//		sc.nextLine();
//		String name = sc.nextLine();
//		double price = sc.nextDouble();
//		vect[i] = new Product(name, price); // aqui eu utilizo o construtor com 2 elementos.
//		}
//
//		double sum = 0.0;
//
//		for (int i=0; i<n; i++) {
//		sum = vect[i].getPrice();
//		}
//
//		double avg = sum / n;
//		System.out.printf("The average price is: %.2f%n", avg);