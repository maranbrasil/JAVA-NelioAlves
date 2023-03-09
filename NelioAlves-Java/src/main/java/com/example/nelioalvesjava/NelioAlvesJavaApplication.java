package com.example.nelioalvesjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// Lists
		// Lista é um tipo no java
		// Dentro de uma lista posso guardar dados do mesmo tipo
		// os elementos sao ordenados por meio de posicoes
		// inicia vazia e seus elementos sao alocadas sob demanda
		// cada elemento ocupa um nodo da lista. NODO é uma caixa que tem um valor e um indicador para o outro nodo da lista.
		// o tipo lista nao é instanciavel com new list();
		// Lista nao aceita tipos primitivos

		// Vantagens: tamanho pode ser variavel, diferente do vetor.
		// facil de realizar insercoes e delecoes

		// desvantagem: acesso sequencial dos elementos.

		// Comando de listas
		// size() - saber a quantidade de elementos da lista.
		// add(obj)/add(int,obj) - inserir elementos na lista.
		// remove(obj), remove(int), removeIf(Predicate) - remover elementos da lista.
		// indexOf(obj), lastIndexOf(obj) - saber posiçao de elementos da lista.
		// List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toLIst()) - filtrar lista.
		// Integer result = list.stream()..filter(x -> x > 4).findFirst().orElse(null) - encontrar primira ocorrencia

		List<String> list = new ArrayList<>(); // nao posso instanciar uma list, e por isso uso o ArrayLIst (que pegas as melhroes caracterisiticas de um vetor e uma lista)

		list.add("Maran");
		list.add("Vivian");
		list.add("Olivia");
		list.add(2,"Wandinha");
		list.add("yoshi");
		list.add("Victoria");

		for (String name : list) {
			System.out.println(name);
		}

		list.remove("yoshi");

		for (String name : list) {
			System.out.println(name);
		}

		System.out.println(list.size());

		System.out.println("----------------");
		list.removeIf(name -> name.charAt(0) == 'M');

		for (String name : list) {
			System.out.println(name);
		}

		System.out.println("Index Of Vivian is: " + list.indexOf("Vivian"));
		System.out.println("Index Of ROMEO is: " + list.indexOf("Romeo"));  // quando nao encontra o retorno é -1

		System.out.println("-----------------------");
		List<String> result = (List<String>) list.stream().filter(name -> name.charAt(0) == 'V').collect(Collectors.toList()); // como o stream nao é compativel com list tenho que colocat collector no final
		System.out.println(result);
		for (String name : result) {
			System.out.println(name);
		}

		System.out.println("-----------------------");
		String name1 = list.stream().filter(x -> x.charAt(0) == 'V').findFirst().orElse(null);  // usando findFirst eu encontro somente o primeiro resultado
		System.out.println(name1);

		System.out.println("-----------------------");
		String name2 = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name2);
	}
}
