package com.example.nelioalvesjava;

import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String[] vect = new String[] {"Maria", "Bob", "Alex"};

		for (int i= 0; i < vect.length; i++) {
			System.out.println(vect[i]);
		}

		System.out.println("------------------------");
		// essa é uma forma de usar um for.
		// abro o for, informo o tipo que será retornado na iteracao, obj (é cada uma das linhas do vetor) , e ":" o vetor que queremos percorrer
		// forma de ler "for (String obj : vect)": para cada objeto obj contido no vetor vect, faça:
		for (String obj : vect) {
			System.out.println(obj);
		}
	}
}
