package com.example.nelioalvesjava;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		method1();
	}

	public static void method1(){
		System.out.println("***** Metodo 1 start****");
		method2();
		System.out.println("***** Metodo 1 finish****");
	}
	public static void method2() {
		System.out.println("***** Metodo 2 start****");
		Scanner sc = new Scanner(System.in);
		try { // uso o try-catch caso bloco de código que eu quero usar retorne uma excecao Ex: colocar uma letra ao inves de numero para posicao do vetor a ser digitado. Ou entao digitar uma posicao maior do que o número de posições existente
			String[] vect = sc.nextLine().split(" ");  // um vetor de Strings chamado vect que pega da frase digitada vai dividi-la a cada espaço dado.
			int position = sc.nextInt(); // seleciono a posiçao
			System.out.println(vect[position]); // mostro o vetor na posicao especifica. Obs: o vetor é como se fosse um array.
			System.out.println("***** Metodo 2 finish****");
		} catch (ArrayIndexOutOfBoundsException e) { // caso de erro de posiçao invalida ele dá esse erro.
			System.out.println("Error: Invalid position");
			e.printStackTrace(); // printa a chamada de metodos que acarretou na excecao
			sc.next();
		} catch (InputMismatchException e) { // caso digite uma letra ao inves de um numero dá esse erro.
			System.out.println("Error: this character needs to be a number");
		}
	}
}
