package com.example.nelioalvesjava;

import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// aula 95 boxing, unboxing e wrapper classes
		// boxing é um processo de conversao de um objeto tipo valor em um objeto tipo referência.
		int x = 20;

		Object obj = x;
		System.out.println(obj);

		// obj é uma referência pq Object é uma classe. Então o valor 20 não foi passado diretamente para obj,
		// e sim obj agora aponta para o valor 20 na memoria HEAP.


		// UNBOXING
		// é o processo contrario, ou seja, transforma o objeto do tipo referencia para um objeto do tipo valor.
		// int y = obj; // se eu fizer dessa forma, os tipo nao sao compativeis e dá erro, por isso preciso fazer o casting como na linha abaixo
		int y = (int) obj;
		System.out.println(y);

		// ao atribuirmos o valor de obj para a variavel y, fazemos o unboxing, pois é criado uma caixa valendo 20 na memória Stack

		// WRAPPER classes
		// sao classes equivalentes aos tipos primitivos
		// na wrapper classa aceita valor nulo
		// no tipo primitivo nao pode haver valor nulo
	}
}
