package com.example.nelioalvesjava;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		LocalDate d04 = LocalDate.parse("2023-03-11");
		LocalDateTime d05 = LocalDateTime.parse("2023-03-11T01:26:15");
		Instant d06 = Instant.parse("2023-03-11T01:26:15Z");

		DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt03= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(
				ZoneId.systemDefault()); // system default pega o horario que o usuario tem no computador dele
		DateTimeFormatter fmt04 = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter fmt05 = DateTimeFormatter.ISO_INSTANT;


		System.out.println("d04 = " + d04.format(fmt01));
		System.out.println("d04 = " + fmt01.format(d04)); // são duas formas de formatar uma data.

		System.out.println("d05 = " + fmt02.format(d05));
		System.out.println("d05 = " + fmt04.format(d05));

		System.out.println("d06 = " + fmt03.format(d06)); // como o instant tem o horario de greenwich, quando uso o formato pra pegar a hora do usuario ele faz a conversao da data. portanto 11/03/2023 01:26 vira 10/03/2023 22h26.
		System.out.println("d06 = " + fmt05.format(d06));

//		for (String s : ZoneId.getAvailableZoneIds()) {
//			System.out.println(s);
//		} // mostra o nome de todos os Zone Ids

		System.out.println("*************class 112***************");
		// Converter date-time global para local
		Instant d07 = Instant.parse("2023-03-11T01:26:15Z"); // tenho o instant instanciado
		LocalDate r1 = LocalDate.ofInstant(d07, ZoneId.systemDefault()); // e agora convertido para LocalDate no time zone da minha máquina, por isso o resultado é 10/03/2023
		System.out.println("r1 = "+ r1);

		LocalDate r2 = LocalDate.ofInstant(d07, ZoneId.of("Portugal")); // e agora convertido para LocalDate no time zone de Portugal, por isso o resultado é 11/03/2023
		System.out.println(r2);

		LocalDateTime r3 = LocalDateTime.ofInstant(d07, ZoneId.systemDefault()); // conversao horario minha maquina 22:26
		System.out.println(r3);
		LocalDateTime r4 = LocalDateTime.ofInstant(d07, ZoneId.of("Portugal")); // conversao horario Portugal 01:26
		System.out.println(r4);

		LocalDate d08 = LocalDate.parse("2023-03-11");
		LocalDateTime d09 = LocalDateTime.parse("2023-03-11T01:26:15");

		System.out.println("d08 dayOfYear = " + d08.getDayOfYear());
		System.out.println("d08 dayOfMonth = " + d08.getDayOfMonth());
		System.out.println("d08 dayOfWeek = " + d08.getDayOfWeek());

		System.out.println("d08 dayOfMonth = " + d08.getDayOfMonth());
		System.out.println("d08 month = " + d08.getMonth());
		System.out.println("d08 Year = " + d08.getYear());

		System.out.println("d09 hour = " + d09.getHour());
		System.out.println("d09 minutes = " + d09.getMinute());

		sc.close();
	}
}
