package com.example.nelioalvesjava;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;

public class NelioAlvesJavaApplication {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
//		Product p = new Product("TV", 1000.0);
//		OrderItem oi1 = new OrderItem(1, 1000.0, p);
//
//		System.out.println(oi1.getProduct().getName());
//		System.out.println(oi1);

//		Client client = new Client("Maran", "maran@gmail", sdf.parse("11/03/1988"));
//		System.out.println(client);
		System.out.println("Enter client data:");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth Date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());

  	Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.println("How many items to this order? ");
		int N = sc.nextInt();
		sc.nextLine();
		for (int i=1; i <= N; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();

			Product product = new Product(productName, productPrice);

			OrderItem it = new OrderItem(quantity, productPrice, product);

			order.addItem(it);
		}

		System.out.println(order);

		sc.close();
	}
}
