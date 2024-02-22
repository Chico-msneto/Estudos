package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		LocalDateTime time = LocalDateTime.now();
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (YYYY-MM-DD): ");
		String date = sc.next();
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthDate = LocalDate.parse(date, fmt);
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String stat = sc.next();
		
		Order order = new Order(time, OrderStatus.valueOf(stat));
		OrderItem subOrder;
		order.addClient(client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter #"+ i +" item data: ");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product p = new Product(productName, productPrice);
			subOrder = new OrderItem(quantity, productPrice);
			subOrder.addProduct(p);
			order.addItem(subOrder);
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);		
		
		sc.close();
	}

}
