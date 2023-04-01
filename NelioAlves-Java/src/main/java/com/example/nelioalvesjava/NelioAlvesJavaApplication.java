package com.example.nelioalvesjava;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

		//UPCASTING é eu pegar uma variavel do tipo BusinessAccount e atribuir como uma variável do tipo Account;
		Account acc1 = bacc; // nao da erro pq a BusinessAccount é uma account
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingAccount(1004, "Anna", 0.0, 0.01);

		// DOWNCASTING é eu pegar uma variavel do tipo Account e atribuir para uma variavel do tipo BusinessAccount

		// BusinessAccount acc4 = acc2; // nao posso fazer isso, pois sao tipos diferentes
		BusinessAccount acc4 = (BusinessAccount) acc2; // mas se eu puser que o acc2 é do tipo BusinessAccount, eu forço ele a ser do tipo businessAccount e eu consigo usar os metodos dele
		acc4.loan(100.0);

		// BusinessAccount acc5 = (BusinessAccount) acc3; // nao dá erro em tempo de execuçao, mas se eu tentar atribuir uma classe do tipo businessAccount em uma classe savingAccount dará erro.
		// para eu testar antes e evitar problemas de atibuiçao eu posso usar o metodo instanceOf
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.00);
			System.out.println("LOAN!");
		}

		if (acc3 instanceof SavingAccount) {
			SavingAccount acc5 = (SavingAccount) acc3;
			acc5.updateBalance();
			System.out.println("Updated");
		}


	}
}
