package com.example.nelioalvesjava;

import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] mat = new int[n][n]; //para inicializar matrizes indico o tipo e coloco dois colchetes e inicializo com o new

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		int[] diagonal = new int[n]; //para pegar os dados da diagonal, a coluna e a linha terao o mesmo indice e portanto ao pegarmos linha e coluna iguais de cada iteracao, teremos os valores da diagonal

		System.out.println("Main Diagonal: ");
		for (int i=0; i<n; i++) {
			System.out.println(mat[i][i]); // nao preciso fazer uma iteracao de dois fors, afinal já que sei que na diagonal o indice de linha é sempre igual ao indice de coluna, posso usar um idice de linha igual. e acesso cada elemento da diagonal
		}

		int count = 0;
		for (int i=0; i<mat.length; i++) { //ao usar o mat.length conseguirei saber o total de linhas tem a matriz.
			for (int j=0; j<mat[i].length; j++) { //para saber o total de colunas basta colocar mat[i].length
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}
		System.out.print("Negative numbers:");
		System.out.println(count);
		sc.close();
	}
}
