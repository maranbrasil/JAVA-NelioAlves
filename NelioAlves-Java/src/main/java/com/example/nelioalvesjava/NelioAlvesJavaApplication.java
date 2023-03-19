package com.example.nelioalvesjava;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		LocalDate d04 = LocalDate.parse("2023-03-11");
		LocalDateTime d05 = LocalDateTime.parse("2023-03-11T01:26:15");
		Instant d06 = Instant.parse("2023-03-11T01:26:15Z");

		// operações com dateTime
		LocalDate weekBeforeLocalDate = d04.minusDays(7);
		System.out.println("weekBefore = " + weekBeforeLocalDate);

		LocalDate weekAheadLocalDate = d04.plusDays(7);
		System.out.println("weekAhead = " + weekAheadLocalDate);

		LocalDateTime anHourBefore = d05.minusHours(2);
		System.out.println(anHourBefore);

		LocalDateTime test1 = d05.minusDays(4);
		System.out.println(test1);
		LocalDateTime test2 = d05.minusMinutes(30);
		System.out.println(test2);

		Duration t1 = Duration.between(test1, d05);
		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t1 hours = " + t1.toHours());



	}
}
