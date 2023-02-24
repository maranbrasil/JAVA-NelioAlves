package com.example.nelioalvesjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NelioAlvesJavaApplication {
	//memórias, arrays e listas

	// memória: Stack/Heap
	// Stack: é uma região de memória do computador que é usada para armazenar dados temporários, como variáveis
	// locais, endereços de retorno e outros dados relacionados à execução de uma função ou sub-rotina em um programa.
	// Heap: é usada para armazenar dados que precisam ser alocados dinamicamente durante a execução do programa, como
	// estruturas de dados complexas, arrays e objetos.

	// tipos referência vs tipo valor //
	// variaveis do tipo classe são ponteiros, ou seja ela aponta para o endereço na mem heap.
	// tipo refencia aceitam valor null, ou seja, não aponta pra nenhum endereco em heaps

	// tipos primitivos são valor e nao apontam para um outro endereco. Dentro das variaveis tem o valor mesmo.
	public static void main(String[] args) {
		int p; // é uma variavel que criou uma caixinha na mem. stack.
		System.out.println(p); // a variável nao foi inicializado com algum valor e por isso dá erro

		// para nao dar erro deve-se inicializar q.
		int q;
		q = 2; // é uma variavel que criou uma caixinha na mem. stack.
		System.out.println(q); // a variável nao foi inicializado com algum valor e por isso dá erro

	}

}
