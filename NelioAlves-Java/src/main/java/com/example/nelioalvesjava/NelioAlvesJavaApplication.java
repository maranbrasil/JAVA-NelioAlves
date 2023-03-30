package com.example.nelioalvesjava;

import Entities.Post;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import Entities.Comment;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("That's awesome!");

		Post post1 = new Post(
				sdf.parse("21/06/2022 18:35:54"),
				"Traveling to New Zealand!!",
				"Visiting this country will be terrific",
				12);
		post1.addComment(c1);
		post1.addComment(c2);

		System.out.println(post1);

		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the force be with you");

		Post post2 = new Post(
				sdf.parse("28/07/2018 13:14:54"),
				"Good night guys",
				"See you tommorow",
				5);

		post2.addComment(c3);
		post2.addComment(c4);

		System.out.println(post2);
	}


}
