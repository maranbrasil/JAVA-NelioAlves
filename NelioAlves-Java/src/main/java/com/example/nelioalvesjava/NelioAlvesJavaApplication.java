package com.example.nelioalvesjava;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		LocalDate d01 = LocalDate.now();
		System.out.println("d01 = " + d01);

		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("d02 = " + d02);

		Instant d03 = Instant.now();
		System.out.println("hora global d03 = " + d03);

		LocalDate d04 = LocalDate.parse("2023-03-11");
		System.out.println("Parseado d04 = " + d04);

		LocalDateTime d05 = LocalDateTime.parse("2023-03-11T01:26:15");
		System.out.println("Parseado d05 = " + d05);

		Instant d06 = Instant.parse("2023-03-11T01:26:15Z");
		System.out.println("Parseado d06 = " + d06);

		Instant d07 = Instant.parse("2023-03-11T01:26:15-03:00");
		System.out.println("Parseado d07 = " + d07);

		// texto no formato customizado
		DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt01); // Para transformar datas que tenham algum padrao em datas com padrao UTC basta usar o DateTimeFormatter. AI faço um parse, mas pegando do formato específico que eu indiquei.
		System.out.println("Parseado d08 = " + d08);

		DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt02);
		System.out.println("Parseado d09 = " + d09);

		LocalDate d10 = LocalDate.of(2023, 10, 05);
		System.out.println("Parseado d09 = " + d10);
		sc.close();
	}
}
